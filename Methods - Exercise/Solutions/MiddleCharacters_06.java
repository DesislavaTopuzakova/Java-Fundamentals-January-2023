package Methods;

import java.util.Scanner;

public class MiddleCharacters_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        printMiddleCharacters(text); //text -> аргумент

    }

    //метод, който принтира средния символ на даден текст
    public static void printMiddleCharacters (String text) { //String text e параметър
        //нечетна дължина -> 1 среден символ
        //"aString" -> ['a', 'S', 't', 'r', 'i', 'n', 'g']
        if (text.length() % 2 != 0) {
            int indexOfMiddleCharacter = text.length() / 2;
            System.out.println(text.charAt(indexOfMiddleCharacter));
        }
        //четна дължина -> 2 средни символа
        //"someText" -> 8 символа (index: 3 и 4)
        //"dogs" -> 4 символа (index: 1 и 2)
        //['s', 'o', 'm', 'e', 'T', 'e', 'x', 't'] -> eT
        else {
            int indexOfFirstMiddleCharacter = text.length() / 2 - 1;
            int indexOfSecondMiddleCharacter = text.length() / 2; //indexOfFirstMiddleCharacter + 1

            System.out.print(text.charAt(indexOfFirstMiddleCharacter));
            System.out.print(text.charAt(indexOfSecondMiddleCharacter));
        }
    }
}
