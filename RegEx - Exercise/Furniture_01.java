package RegEx;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Furniture_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> furniture = new ArrayList<>(); //списък със закупени мебели
        double totalSum = 0; //общо изхарчена сума за всички закупени мебели

        String regex = ">>(?<furnitureName>[A-Za-z]+)<<(?<price>[0-9]+\\.?[0-9]*)!(?<quantity>[0-9]+)";
        Pattern pattern = Pattern.compile(regex);

        String input = scanner.nextLine();
        //">>{furniture name}<<{price}!{quantity}"
        while(!input.equals("Purchase")) {
            //input = ">>Sofa<<312.23!3"
            Matcher matcher = pattern.matcher(input);
            //matcher = ">>(?<furnitureName>Sofa)<<(?<price>312.23)!(?<quantity>3)"
            //find
            //true -> input отговаря на regex
            //false -> input не отговаря на regex
            if (matcher.find()) {
                //input отговаря на regex -> купуваме мебели
                String furnitureName = matcher.group("furnitureName"); //мебел
                double price = Double.parseDouble(matcher.group("price")); //ед. цена
                int quantity = Integer.parseInt(matcher.group("quantity")); //количество

                furniture.add(furnitureName);
                double currentFurniturePrice = quantity * price; //платено за текушата мебел
                totalSum += currentFurniturePrice;
            }
            input = scanner.nextLine();
        }

        System.out.println("Bought furniture:");
        furniture.forEach(System.out::println);

        System.out.printf("Total money spend: %.2f", totalSum);
    }
}
