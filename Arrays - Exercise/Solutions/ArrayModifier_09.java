package Arrays;

import java.util.Scanner;
import java.util.Arrays;

public class ArrayModifier_09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int [] numbers = Arrays.stream(scanner.nextLine() //"23 -2 321 87 42 90 -123"
                        .split(" "))  //["23", "-2", "321", "87", "42", "90", "-123"]
                .mapToInt(Integer::parseInt)  //[23, -2, 321, 87, 42, 90, -123]
                .toArray();

        String command = scanner.nextLine();
        //"swap {index1} {index2}".split(" ") ->
        //"multiply {index1} {index2}".split(" ") -> ["multiply", "3", "4"]
        //"decrease".split(" ") -> ["decrease"]

        while (!command.equals("end")) {
            String[] commandParts = command.split(" ");
            String commandType = commandParts[0]; //"swap", "multiply", "decrease"
            switch (commandType) {
                case "swap":
                    //commandParts: ["swap", "3", "4"]
                    int index1 = Integer.parseInt(commandParts[1]);
                    int element1 = numbers[index1];
                    int index2 = Integer.parseInt(commandParts[2]);
                    int element2 = numbers[index2];

                    //swap
                    numbers[index1] = element2;
                    numbers[index2] = element1;
                    break;
                case "multiply":
                    //изпълнявам командата multiply
                    int multiplyElementIndex1 = Integer.parseInt(commandParts[1]);
                    int multiplyElement1 = numbers[multiplyElementIndex1];
                    int multiplyElementIndex2 = Integer.parseInt(commandParts[2]);
                    int multiplyElement2 = numbers[multiplyElementIndex2];

                    int product = multiplyElement1 * multiplyElement2;
                    numbers[multiplyElementIndex1] = product;
                    break;
                case "decrease":
                    //всички елементи в масива -1
                    for (int index = 0; index <= numbers.length - 1; index++) {
                        numbers[index] = numbers[index] - 1;
                    }
                    break;
            }
            command = scanner.nextLine();
        }

        //отпечатваме масива (", ")
        /*for (int index = 0; index <= numbers.length - 1; index++) {
            if (index != numbers.length - 1) {
                System.out.print(numbers[index] + ", ");
            } else {
                System.out.print(numbers[index]);
            }
        }*/

        System.out.println(Arrays.toString(numbers).replace("[", "").replace("]", ""));
    }
}
