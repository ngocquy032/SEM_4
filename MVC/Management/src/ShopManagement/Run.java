package ShopManagement;

import java.util.Scanner;

public class Run {
    public static void main(String[] args) {
        Repository repository = new Repository();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            Menu.mainMenu();
            int choose = scanner.nextInt();

            switch (choose) {
                case 1:
                    System.out.println("DANH SÁCH SẢN PHẨM");
                    repository.show();
                    break;
                case 2:
                    repository.filterProductByPrice();
                    break;
                case 3:
                    repository.countProductByAmountSale();
                    break;
                case 4:
                    Menu.chooseCategory();
                    break;
                case 5:
                    repository.sortProductByAmountSale();
                    repository.show();
                    break;
                case 6:
                    repository.filterProductByAmountSale();
                    break;

                case 7:
                    repository.sortProductByName();
                    repository.show();
                    break;
                case 8:
                    System.out.println("Kết thúc chương trình");
                    System.exit(0);

                    break;
                default:
                    System.out.println("Vui lòng chọn đúng cá chức năng trên =))");
                    break;

            }
        }
    }

}
