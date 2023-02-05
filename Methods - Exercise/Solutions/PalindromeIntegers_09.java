package Methods;

import java.util.Scanner;

public class PalindromeIntegers_09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine(); //"323"

        //входни данни -> число под формата на текст или "END"
        while (!command.equals("END")) {
            //проверка дали е палиндром
            if (isPalindrome(command)) {
                System.out.println("true");
            } else {
                System.out.println("false");
            }

            //System.out.println(isPalindrome(command));


            command = scanner.nextLine();
        }
    }

    //метод, който проверява дали даден тескт е палиндром
    //true -> ако текстът е палиндром
    //false -> ако текстът не е палиндром

    public static boolean isPalindrome (String text) {
        //text = "Desi"
        //reversedText = "iseD"
        //палиндром е текст, който е еднакъв с обърнатия си на обратно
        String reversedText = ""; //текстът, обърнат на обратно
        for (int index = text.length() - 1; index >= 0 ; index--) {
            reversedText += text.charAt(index);
        }

        return text.equals(reversedText);

    }
}
