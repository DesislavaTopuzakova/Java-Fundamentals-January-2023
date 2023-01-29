package Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class MagicSum_08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int [] numbers = Arrays.stream(scanner.nextLine() //"1 7 6 2 19 23"
                        .split(" ")) //["1", "7", "6", "2", "19", "23"]
                        .mapToInt(e -> Integer.parseInt(e)) //[1, 7, 6, 2, 19, 23]
                        .toArray();

        int targetSum = Integer.parseInt(scanner.nextLine());

        //обхождаме всички елементи в масива
        for (int index = 0; index < numbers.length - 1; index++) {
            int currentNumber = numbers[index]; //числото от масива на текущия индекс
            //обходя всички числа след моето
            for (int i = index + 1; i <= numbers.length - 1; i++) {
                int nextNumber = numbers[i]; //число, което е след моето

                if (currentNumber + nextNumber == targetSum) {
                    System.out.println(currentNumber + " " + nextNumber);
                }
            }
        }
    }
}
