package Methods;

import java.util.Scanner;

public class AddAndSubtract_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //входни данни -> 3 цели числа
        int number1 = Integer.parseInt(scanner.nextLine());
        int number2 = Integer.parseInt(scanner.nextLine());
        int number3 = Integer.parseInt(scanner.nextLine());
        //(number1 + number2) - number3

        int sumOfNumbers = sum(number1, number2);
        int subtractOfNumbers = subtract(sumOfNumbers, number3);

        System.out.println(subtractOfNumbers);
    }

    //метод, който приема 2 цели числа -> получаваме сбора
    public static int sum (int n1, int n2) {
        return n1 + n2;
    }

    //метод, който приема 2 цели числа -> получаваме разлика
    public static int subtract (int n1, int n2) {
        return n1 - n2;
    }
}
