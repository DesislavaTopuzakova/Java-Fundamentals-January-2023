package TextProcessing;

import java.util.Scanner;

public class CharacterMultiplier_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine(); //"George Peter"
        String [] names = input.split("\\s+"); //["George", "Peter"]

        String firstText = names[0]; //"George" -> 6
        String secondText = names[1]; //"Peter" -> 5

        int minLength = Math.min(firstText.length(), secondText.length()); //дължина на по-късия текст -> 5
        int maxLength = Math.max(firstText.length(), secondText.length()); //дължина на по-дългия текст -> 6

        int sum = 0;
        for (int index = 0; index < minLength; index++) {
                sum += (firstText.charAt(index) * secondText.charAt(index));
        }

        //еднакви дължини на текстовете
        if (maxLength == minLength) {
            System.out.println(sum);
            return;
        }

        sum = getLeftSymbols(firstText, secondText, minLength, maxLength, sum);

        System.out.println(sum);

    }

    private static int getLeftSymbols(String firstText, String secondText, int minLength, int maxLength, int sum) {
        //кой е по-дългия текст -> останалите букви, които не са участвали в умножението
        if (maxLength == firstText.length()) {
            //първия текст ми е по-дълъг -> взимам останалите символи
            for (int index = minLength; index < firstText.length(); index++) {
                sum += firstText.charAt(index);
            }
        } else {
            //втория текст ми е по-дълъг -> взимам останали символи
            for (int index = minLength; index < secondText.length(); index++) {
                sum += secondText.charAt(index);
            }
        }
        return sum;
    }
}
