package DataTypes;

import java.util.Scanner;

public class TriplesLatinLetters_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        //тройки от символи: {буква1}{буква2}{буква3}

        for (char letter1 = 'a'; letter1 < 'a' + n ; letter1++) {
            for (char letter2 = 'a'; letter2 < 'a' + n; letter2++) {
                for (char letter3 = 'a'; letter3 < 'a' + n; letter3++) {
                    System.out.printf("%c%c%c%n", letter1, letter2, letter3);
                }
            }
        }
    }
}
