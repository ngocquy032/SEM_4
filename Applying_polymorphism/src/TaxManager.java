// class quản lý danh sách các đối tượng
public class TaxManager {
    private  static  final int MAX = 100;

    // mảng list chứa các đối tượng Taxpayer
    private  Taxpayer [] list = new Taxpayer[MAX];
    private  int count = 0;

    // phương thức thêm 1 đối tượng vào danh sách
    public  boolean addTaxpayer(Taxpayer taxpayer){
        if(count >= MAX){
            return false;
        }
        list[count++] = taxpayer;
        return true;
    }
    // pt tonhs tổng s tiền các đối tượng trong danh sách
    public  double getTax (){
        double sum = 0;
        for ( int i = 0; i < count; i++){
            sum += list[i].pay();
        }
        return sum;
    }
}
