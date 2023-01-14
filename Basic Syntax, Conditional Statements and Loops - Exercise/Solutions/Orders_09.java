package BasicSyntax;

import java.util.Scanner;

public class Orders_09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int orders = Integer.parseInt(scanner.nextLine());
        double allMoney = 0;
        for (int order = 1; order <= orders; order++) {
            double pricePerCapsule = Double.parseDouble(scanner.nextLine());
            int daysInMonth = Integer.parseInt(scanner.nextLine());
            int capsulesCount = Integer.parseInt(scanner.nextLine());
            double moneyForOrder = ((daysInMonth * capsulesCount) * pricePerCapsule);
            System.out.printf("The price for the coffee is: $%.2f%n", moneyForOrder);
            allMoney += moneyForOrder;
        }
        System.out.printf("Total: $%.2f", allMoney);
    }
}
