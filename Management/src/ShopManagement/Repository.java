package ShopManagement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Repository {
    List<Product> listProduct = new ArrayList<>();
    public Repository() {
        listProduct.add (new Product("01","Bánh Doraemon 3 vị", Category.FOOD, 100,3500, 57));
        listProduct.add(new Product("02","Xúc xích sườn non" , Category.FOOD,150,3500, 12));
        listProduct.add(new Product("03","Thanh cua", Category. FOOD,100,5000, 85));
        listProduct.add(new Product("04","Bánh khoai môn", Category.FOOD,200,42000, 78));
        listProduct.add(new Product("05","Thìa ăn cơm inox mạ vàng", Category. HOUSEWARE,50,8000,4));
        listProduct.add(new Product("06","Bát đựng gia vị", Category.HOUSEWARE,65,4000,44));
        listProduct.add(new Product("07","Nước Hoa Hồng Soothing Facial Toner Simple", Category .COSMETICS,140,92000,88)) ;
        listProduct.add(new Product("08","Combo gội xả HAIRBURST.", Category.COSMETICS,100, 639000,79));
        listProduct.add(new Product("09","Tinh chất dưỡng ẩm sâu Klains Rich Moist Soothing Serum", Category. COSMETICS,50,249000,24));
        listProduct.add(new Product("10","Kem dưỡng thể Paula's Choice RESIST WEIGHTLESS BODY TREATMENT", Category.COSMETICS,80,715000, 63));
        listProduct.add(new Product("11","Ao thun ISUN", Category.FASHION,250,320000,146));
    }
    // hiển thị
    public void show(){

        listProduct.forEach( product -> System.out.println(product));
    }
    // tìm kiếm sp theo giá tiền trên 10000
    public void filterProductByPrice(){
        System.out.println("Các sản phẩm có giá trị trên 1000: ");
        listProduct.stream().filter(product -> product.getPrice() > 10000)
                .forEach(product -> System.out.println(product));
    }
    // tìm kiếm sản phẩm dc bán nhiều nhất
    public  void filterProductByAmountSale(){
      Product p = listProduct.stream().max(Comparator.comparing(Product::getAmountSale)).get();
      System.out.println("Sản phẩm bán được nhiều nhất là: ");
      System.out.println(p);
    }


    // sắp xêếp sản phẩm theo số lươợng bán dc
    public void sortProductByAmountSale(){
        listProduct.sort(((p1, p2) -> Long.compare(p2.getAmountSale(), p1.getAmountSale())));
        System.out.println("Danh sách sản phẩm bán được nhiều nhất theo thứ tự là: ");
    }

    // sắp xếp sp theo thứ tự
    public  void  sortProductByName(){
        System.out.println("Sản phẩm sau khi sắp xếp theo tên: ");
        listProduct.sort((o1, o2) -> o1.getName().compareTo(o2.getName()));
    }
    // đếm số sản phẩm bán dc trên 50
    public void countProductByAmountSale(){
        long count = listProduct.stream().filter(product -> product.getAmountSale() >= 50).count();
        System.out.println(" số lượng sản phẩm bán được từ 50 trở lên là: " + count);
    }

}
