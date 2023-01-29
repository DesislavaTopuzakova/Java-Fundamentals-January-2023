package Arrays;

import java.util.Scanner;
import java.util.Arrays;

public class TopIntegers_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int [] numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        //"1 4 3 2".split(" ") -> ["1", "4", "3", "2"].map -> [1, 4, 3, 2]

        //за всеки един елемент от масива -> проверка дали е топ
        for (int index = 0; index <= numbers.length - 1; index++) {
            int currentNumber = numbers[index];
            //винаги елементът на последния индекс ни е топ
            if(index == numbers.length - 1) {
                System.out.print(currentNumber + " ");
                break;
            }
            //обхождам всички индекси след моя
            //следващото число -> index + 1
            boolean isTop = false; //
            for (int i = index + 1; i <= numbers.length - 1; i++) { //обходя всички числа след моето
                int nextNumber = numbers[i];
                if (currentNumber > nextNumber) {
                    isTop = true;
                } else {
                    isTop = false;
                    break;
                }
            }
            //проверка дали моето число е топ
            if (isTop) {
                System.out.print(currentNumber + " ");
            }
        }
    }
}
