package Arrays;

import java.util.Scanner;

public class ZigZagArrays_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); //sc

        int n = Integer.parseInt(scanner.nextLine()); //брой редове
        int [] firstArray = new int[n];
        int [] secondArray = new int[n];

        for (int row = 1; row <= n; row++) {
            String numbers = scanner.nextLine(); //"1 5".split(" ") -> ["1", "5"]
            int firstNumber = Integer.parseInt(numbers.split(" ")[0]); //"1" -> 1
            int secondNumber = Integer.parseInt(numbers.split(" ")[1]); //"5" -> 5

            if (row % 2 == 0) {
                //четен ред -> първото число (втори масив); второто число (първи масив)
                firstArray[row - 1] = secondNumber;
                secondArray[row - 1] = firstNumber;
            } else {
                //нечетен ред -> първото число (първи масив); второто число (втори масив)
                firstArray[row - 1] = firstNumber;
                secondArray[row - 1] = secondNumber;
            }
        }

        //отпечатваме елементите на първия масив
        for (int number : firstArray) {
            System.out.print(number + " ");
        }

        System.out.println();

        //отпечатваме елементите на втория масив
        for (int number : secondArray) {
            System.out.print(number + " ");
        }
    }
}
