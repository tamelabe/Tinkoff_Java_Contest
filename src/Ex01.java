import java.util.Scanner;

public class Ex01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int gunsAmount = sc.nextInt();
        int balance = sc.nextInt();
        int coolestGun = 0;
        for (; sc.hasNext() && gunsAmount > 1; --gunsAmount) {
            int price = sc.nextInt();
            if (price <= balance && price > coolestGun)
                coolestGun = price;
        }
        sc.close();
        System.out.println(coolestGun);
    }
}