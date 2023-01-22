package DataTypes;

import java.util.Scanner;

public class PrintPart_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int startCode = Integer.parseInt(scanner.nextLine()); //код, от който започвам
        int endCode = Integer.parseInt(scanner.nextLine()); // код, в който трябва да приключа

        //повтаряме: печатам кой е символа срещу съответния код
        //начало: startCode
        //край: endCode
        //промяна: +1 (преминавам към следващия код)

        for (int code = startCode; code <= endCode; code++) {
            System.out.print((char) code + " ");
        }
    }
}
