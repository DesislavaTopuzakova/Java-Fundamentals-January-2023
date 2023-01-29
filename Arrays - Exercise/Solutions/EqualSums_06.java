package Arrays;


import java.util.Arrays;
import java.util.Scanner;

public class EqualSums_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int [] numbers = Arrays.stream(scanner.nextLine().split(" "))
                                .mapToInt(Integer::parseInt).toArray();

        for (int index = 0; index <= numbers.length - 1; index++) {
            int currentElement = numbers[index];

            int leftSum = 0; //сума от елементите в ляво
            int rightSum = 0; //сума от елементите в дясно

            //1. да си намеря сумата на елементите в ляво от моето число
            //[3, 6, 9, 23, 12, 5, 6]
            //лява сума: всички елементи от първия индекс(0) до моя (не вкл)
            //leftIndex -> всички индекси на числа, които са от ляво на моето
            for (int leftIndex = 0; leftIndex < index; leftIndex++) {
                leftSum += numbers[leftIndex];
            }

            //2. да си намеря сумата от елементите в дясно от моето число
            //[3, 6, 9, 23, 12, 5, 6]
            //дясна сума: всички елементи след моя до последния (дължина - 1)
            for (int rightIndex = index + 1; rightIndex <= numbers.length - 1; rightIndex++) {
                rightSum += numbers[rightIndex];
            }

            //3. проверка дали са равни двете суми
            if (leftSum == rightSum) {
                System.out.println(index);
                return; //прекъсвам цялата програма
            }
        }

        //обходила всички числа в масива и за никое не ми е било вярно условието
        System.out.println("no");
    }
}
