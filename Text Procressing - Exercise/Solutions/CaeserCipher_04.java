package TextProcessing;

import java.util.Scanner;

public class CaeserCipher_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine(); //първоначалния текст: "Programming is cool!"
        StringBuilder encryptedText = new StringBuilder(); //криптирания текст = ""

        for (char symbol : text.toCharArray()) {
            //'A' -> 'D'
            char encryptSymbol = (char)(symbol + 3); //криптирания символ
            encryptedText.append(encryptSymbol);
        }

        System.out.println(encryptedText);
    }
}
