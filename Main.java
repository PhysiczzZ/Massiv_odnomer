import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] products = {"Хлеб", "Молоко", "Гречневая крупа"};
        int[] price = {14, 50, 80};
        int[] cart = new int[products.length];
        int sumProducts = 0;

        System.out.println("Список возможных товаров для покупки:");
        for (int i = 0; i < products.length; i++) {
            System.out.printf("%d. %s - %d руб/шт \n", i + 1, products[i], price[i]);
        }

        while (true) {
            System.out.println("Выберите товар и количество или введите `end`");
            String input = sc.nextLine();
            if ("end".equals(input)) {
                break;
            }
            String[] userSelect = input.split(" ");
            int productNumber = Integer.parseInt(userSelect[0]) - 1;
            int productCount = Integer.parseInt(userSelect[1]);
            cart[productNumber] += productCount;
            System.out.printf("Добавлено: %s %d шт%n", products[productNumber], productCount);
        }
        System.out.println("\nВаша корзина:");
        for (int i = 0; i < cart.length; i++) {
            if (cart[i] > 0) {
                int sum = cart[i] * price[i];
                sumProducts += sum;
                System.out.printf("%s %d шт %d руб/шт %d руб в сумме%n", products[i], cart[i], price[i], sum);
            }
        }
        System.out.printf("Итого %d руб%n", sumProducts);
    }
}
