package BasicSyntax;

import java.util.Scanner;

public class VendingMachine_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        double sum = 0;
        //with 0.1, 0.2, 0.5, 1, and 2
        while(!command.equals("Start")) {
            double coin = Double.parseDouble(command);
            if(coin != 0.1 && coin != 0.2 && coin != 0.5 && coin != 1 && coin != 2) {
                System.out.printf("Cannot accept %.2f%n", coin);
            } else {
                sum += coin;
            }

            command = scanner.nextLine();
        }

        String product = scanner.nextLine();

        //"Nuts", "Water", "Crisps", "Soda", "Coke". The prices are: 2.0, 0.7, 1.5, 0.8, 1.0
        while(!product.equals("End")) {
            boolean hasMoney = true;
            switch(product) {
                case "Nuts":
                    if(sum < 2) {
                        System.out.println("Sorry, not enough money");
                        hasMoney = false;
                    } else {
                        sum -= 2;
                    }
                    break;
                case "Water":
                    if(sum < 0.7) {
                        System.out.println("Sorry, not enough money");
                        hasMoney = false;
                    } else {
                        sum -= 0.7;
                    }
                    break;
                case "Crisps":
                    if(sum < 1.5) {
                        System.out.println("Sorry, not enough money");
                        hasMoney = false;
                    } else {
                        sum -= 1.5;
                    }
                    break;
                case "Soda":
                    if(sum < 0.8) {
                        System.out.println("Sorry, not enough money");
                        hasMoney = false;
                    } else {
                        sum -= 0.8;
                    }

                    break;
                case "Coke":
                    if(sum < 1) {
                        System.out.println("Sorry, not enough money");
                        hasMoney = false;
                    } else {
                        sum -= 1;
                    }
                    break;
                default:
                    System.out.println("Invalid product");
                    hasMoney = false;
                    break;
            }
            if(!hasMoney) {
                product = scanner.nextLine();
                continue;
            }
            System.out.printf("Purchased %s%n", product);


            product = scanner.nextLine();
        }

        System.out.printf("Change: %.2f", sum);
    }
}
