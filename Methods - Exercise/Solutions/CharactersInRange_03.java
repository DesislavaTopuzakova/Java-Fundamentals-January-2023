package Methods;

import java.util.Scanner;

public class CharactersInRange_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //входни данни: 2 символа
        char symbol1 = scanner.nextLine().charAt(0);
        char symbol2 = scanner.nextLine().charAt(0);

        printCharactersInRange(symbol1, symbol2);
    }

    public static void printCharactersInRange(char symbol1, char symbol2) {
        //проверка кой е по-малкия символ -> започвам от по-малкия
        if (symbol1 < symbol2) {
            //започваме от symbol1 -> символите в (symbol1, symbol2)
            for (char symbol = (char)(symbol1 + 1); symbol < symbol2 ; symbol++) {
                System.out.print(symbol + " ");
            }
        } else { //symbol1 >= symbol2
            //започваме от symbol2 -> символите в (symbol2, symbol1)
            for (char symbol = (char)(symbol2 + 1); symbol < symbol1 ; symbol++) {
                System.out.print(symbol + " ");
            }
        }
    }
}
