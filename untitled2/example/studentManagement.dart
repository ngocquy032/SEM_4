import 'dart:convert';
import 'dart:io';

// Định nghĩa lớp Subject và Student
class Subject {
  String name;
  List<int> scores;

  Subject({required this.name, required this.scores});

  factory Subject.fromJson(Map<String, dynamic> json) {
    return Subject(
      name: json['name'],
      scores: List<int>.from(json['scores']),
    );
  }

  Map<String, dynamic> toJson() {
    return {
      'name': name,
      'scores': scores,
    };
  }
}

class Student {
  int id;
  String name;
  List<Subject> subjects;

  Student({required this.id, required this.name, required this.subjects});

  factory Student.fromJson(Map<String, dynamic> json) {
    var subjectsFromJson = json['subjects'] as List;
    List<Subject> subjectList =
    subjectsFromJson.map((i) => Subject.fromJson(i)).toList();

    return Student(
      id: json['id'],
      name: json['name'],
      subjects: subjectList,
    );
  }

  Map<String, dynamic> toJson() {
    return {
      'id': id,
      'name': name,
      'subjects': subjects.map((e) => e.toJson()).toList(),
    };
  }
}

// Hàm đọc dữ liệu từ file JSON
Future<List<Student>> readJsonFile(String filePath) async {
  final file = File(filePath);
  String contents = await file.readAsString();
  final jsonResponse = jsonDecode(contents);
  List<Student> students = (jsonResponse['students'] as List)
      .map((i) => Student.fromJson(i))
      .toList();
  return students;
}

// Hàm ghi dữ liệu vào file JSON
Future<void> writeJsonFile(String filePath, List<Student> students) async {
  final file = File(filePath);
  String jsonData = jsonEncode({'students': students.map((e) => e.toJson()).toList()});
  await file.writeAsString(jsonData);
}

// Hàm hiển thị toàn bộ sinh viên
void displayAllStudents(List<Student> students) {
  for (var student in students) {
    print('ID: ${student.id}, Name: ${student.name}');
    for (var subject in student.subjects) {
      print('  Subject: ${subject.name}, Scores: ${subject.scores}');
    }
  }
}

// Hàm thêm sinh viên mới
Future<void> addStudent(List<Student> students, String filePath) async {
  print('Nhập ID sinh viên:');
  int id = int.parse(stdin.readLineSync()!);
  print('Nhập tên sinh viên:');
  String name = stdin.readLineSync()!;

  List<Subject> subjects = [];
  while (true) {
    print('Nhập tên môn học (hoặc để trống để dừng):');
    String subjectName = stdin.readLineSync()!;
    if (subjectName.isEmpty) break;
    print('Nhập điểm cho môn học (cách nhau bằng dấu phẩy):');
    List<int> scores = stdin.readLineSync()!
        .split(',')
        .map((score) => int.parse(score.trim()))
        .toList();
    subjects.add(Subject(name: subjectName, scores: scores));
  }

  var newStudent = Student(id: id, name: name, subjects: subjects);
  students.add(newStudent);
  await writeJsonFile(filePath, students);
}

// Hàm sửa thông tin sinh viên
// Hàm sửa thông tin sinh viên
Future<void> editStudent(List<Student> students, String filePath) async {
  print('Nhập ID sinh viên cần sửa:');
  int id = int.parse(stdin.readLineSync()!);

  // Tìm sinh viên cần sửa
  Student? studentToEdit = students.firstWhere(
        (student) => student.id == id,
    orElse: () =>  Student(id: id, name: 'Default Name', subjects: []),
  );

  if (studentToEdit == null) {
    print('Sinh viên với ID $id không tồn tại.');
    return;
  }

  // Nhập tên mới của sinh viên
  print('Nhập tên mới (để trống nếu không muốn thay đổi):');
  String? newName = stdin.readLineSync();
  newName = newName!.isEmpty ? null : newName;

  // Tạo danh sách môn học mới từ danh sách môn học hiện tại của sinh viên
  List<Subject> updatedSubjects = List.from(studentToEdit.subjects);
  print('Có muốn thay đổi môn học không? (y/n)');
  String changeSubjects = stdin.readLineSync()!;

  if (changeSubjects.toLowerCase() == 'y') {
    while (true) {
      print('Nhập tên môn học (hoặc để trống để dừng):');
      String subjectName = stdin.readLineSync()!;
      if (subjectName.isEmpty) break;

      print('Nhập điểm cho môn học (cách nhau bằng dấu phẩy):');
      List<int> scores = stdin.readLineSync()!
          .split(',')
          .map((score) => int.parse(score.trim()))
          .toList();

      bool found = false;
      // Cập nhật điểm cho môn học hiện có
      for (var subject in updatedSubjects) {
        if (subject.name.toLowerCase() == subjectName.toLowerCase()) {
          subject.scores = scores;
          found = true;
          break;
        }
      }

      // Thêm môn học mới nếu không tìm thấy môn học hiện có
      if (!found) {
        updatedSubjects.add(Subject(name: subjectName, scores: scores));
      }
    }
  }

  // Cập nhật tên và môn học của sinh viên
  if (newName != null) studentToEdit.name = newName;
  studentToEdit.subjects = updatedSubjects;

  // Ghi dữ liệu vào file JSON
  await writeJsonFile(filePath, students);
}

// Hàm tìm kiếm sinh viên
List<Student> searchStudent(List<Student> students, String searchTerm) {
  List<Student> results = [];

  for (var student in students) {
    if (student.name.toLowerCase().contains(searchTerm.toLowerCase()) ||
        student.id.toString() == searchTerm) {
      results.add(student);
    }
  }
  return results;
}

// Hàm hiển thị sinh viên có điểm môn cao nhất
List<Student> displayHighestScoreStudents(List<Student> students, String subjectName) {
  int highestScore = -1;
  List<Student> studentsWithHighestScore = [];

  for (var student in students) {
    for (var subject in student.subjects) {
      if (subject.name.toLowerCase() == subjectName.toLowerCase()) {
        int maxScore = subject.scores.reduce((a, b) => a > b ? a : b);
        if (maxScore > highestScore) {
          highestScore = maxScore;
          studentsWithHighestScore = [student];
        } else if (maxScore == highestScore) {
          studentsWithHighestScore.add(student);
        }
        break;
      }
    }
  }

  return studentsWithHighestScore;
}

// Hàm main - xử lý luồng chính của chương trình
void main() async {
  String filePath = 'data/student.json';
  List<Student> students = await readJsonFile(filePath);

  bool running = true;
  while (running) {

    print('1. Hiển thị toàn bộ sinh viên');
    print('2. Thêm sinh viên');
    print('3. Sửa thông tin sinh viên');
    print('4. Tìm kiếm sinh viên theo Tên hoặc ID');
    print('5. Hiển thị các sinh viên có điểm Môn thi cao nhất');
    print('6. Thoát');
    print('Chọn chức năng:');
    String? choice = stdin.readLineSync();

    switch (choice) {
      case '1':
        displayAllStudents(students);
        break;
      case '2':
        await addStudent(students, filePath);
        break;
      case '3':
        await editStudent(students, filePath);
        break;
      case '4':
        print('Nhập tên hoặc ID sinh viên cần tìm:');
        String searchTerm = stdin.readLineSync()!;
        List<Student> results = searchStudent(students, searchTerm);
        displayAllStudents(results);
        break;
      case '5':
        print('Nhập tên môn học:');
        String subjectName = stdin.readLineSync()!;
        List<Student> topStudents = displayHighestScoreStudents(students, subjectName);
        displayAllStudents(topStudents);
        break;
      case '6':
        running = false;
        break;
      default:
        print('Lựa chọn không hợp lệ!');
    }
  }
}
