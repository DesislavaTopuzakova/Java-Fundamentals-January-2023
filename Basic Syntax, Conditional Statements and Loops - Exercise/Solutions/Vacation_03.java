package BasicSyntax;

import java.util.Scanner;

public class Vacation_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countStudents = Integer.parseInt(scanner.nextLine());
        String typeGroup = scanner.nextLine();
        String day = scanner.nextLine();
        double price = 0;

        if (typeGroup.equals("Students")) {
            if (day.equals("Friday")) {
                price = 8.45;

            } else if (day.equals("Saturday")) {
                price = 9.80;
            } else if (day.equals("Sunday")) {
                price = 10.46;
            }

            if (countStudents >= 30) {
                price = price * 0.85;
            }

        } else if (typeGroup.equals("Business")) {
            if (day.equals("Friday")) {
                price = 10.90;
            } else if (day.equals("Saturday")) {
                price = 15.60;
            } else if (day.equals("Sunday")) {
                price = 16;
            }
            if (countStudents >= 100) {
                countStudents = countStudents - 10;
            }

        } else if (typeGroup.equals("Regular")) {

            if (day.equals("Friday")) {
                price = 15;
            } else if (day.equals("Saturday")) {
                price = 20;
            } else if (day.equals("Sunday")) {
                price = 22.50;
            }
            if (countStudents >= 10 && countStudents <= 20) {
                price = price * 0.95;

            }
        }
        double totalPrice = countStudents * price;
        System.out.printf("Total price: %.2f", totalPrice);
    }
}

