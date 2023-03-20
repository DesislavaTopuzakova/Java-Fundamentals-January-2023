package RegEx;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SoftuniBarIncome_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        String regex = "%(?<customerName>[A-Z][a-z]*)%[^|$%.]*<(?<product>\\w+)>[^|$%.]*\\|(?<count>[0-9]+)\\|[^|$%.]*?(?<price>[0-9]+\\.?[0-9]*)\\$";
        Pattern pattern = Pattern.compile(regex);

        double totalIncome = 0; //приход от всички продукти
        while (!input.equals("end of shift")) {
            //input = "%George%<Croissant>|2|10.3$"
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
                //валидна поръчка
                String customer = matcher.group("customerName"); //име на клиента
               String product = matcher.group("product"); //име на продукта
               int count = Integer.parseInt(matcher.group("count")); //брой на продукта
               double price = Double.parseDouble(matcher.group("price")); //ед. цена на продукта

                double totalPrice = count * price; //приход от текущия продукт
                totalIncome += totalPrice;
                System.out.printf("%s: %s - %.2f%n", customer, product, totalPrice);
            }
            input = scanner.nextLine();
        }

        System.out.printf("Total income: %.2f", totalIncome);
    }
}
