// lớp trừu tượng abstract class
public abstract class Taxpayer {
    // thuộc tính private
    private  String id;
    public String getId(){
        return id;
    }
    // định nghĩa method cho các lớp con noi theo
    public  abstract  double pay();
}
