package TextProcessing;

import java.util.Scanner;

public class LettersChangeNumbers_08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //код: {буква}{число}{буква}
        String input = scanner.nextLine(); //"A12b s17G"
        String [] codes = input.split("\\s+");

        double totalSum = 0; //сума от модифицираните числа на всички кодове
        for (String code : codes) {
            //code: "{буква}{число}{буква}" => "A23C"
            //модификация на нашето число в кода -> сумираме
            double modifiedNumber = getModifiedNumber(code);
            totalSum += modifiedNumber;
        }

        System.out.printf("%.2f", totalSum);
    }
    //метод, който приема кода и връща модифицираното число
    private static double getModifiedNumber (String code) {
        //код: {буква}{число}{буква} => "A12b"
        char letterBefore = code.charAt(0); //'A'
        char letterAfter = code.charAt(code.length() - 1); // 'b'

        double number = Double.parseDouble(code.replace(letterBefore, ' ') //" 12b"
                         .replace(letterAfter, ' ') //" 12 "
                         .trim()); //"12" -> 12

        number = modifyByLetterBefore(letterBefore, number); //модифицира спрямо буквата преди числото
        number = modifyByLetterAfter(letterAfter, number);  //модифицира спрямо буквата след числото
        return number;
    }

    private static double modifyByLetterAfter(char letterAfter, double number) {
        //проверка за буквата след -> letterAfter
        if (Character.isUpperCase(letterAfter)) {
            //главна буква -> [65;90]
            int positionUpperLetter = (int) letterAfter - 64;
            number = number - positionUpperLetter;
            //number -= positionUpperLetter;
        } else {
            //малка буква -> [97, 122]
            int positionLowerLetter = (int) letterAfter - 96;
            number = number + positionLowerLetter;
            //number += positionLowerLetter;
        }
        return number;
    }

    private static double modifyByLetterBefore(char letterBefore, double number) {
        //проверка за буквата преди -> letterBefore
        if (Character.isUpperCase(letterBefore)) {
            //главна буква -> [65; 90]
            int positionUpperLetter = (int) letterBefore - 64;
            number = number / positionUpperLetter;
            //number /= positionUpperLetter;
        } else {
            //малка буква -> [97, 122]
            int positionLowerCase = (int) letterBefore - 96;
            number = number * positionLowerCase;
            //number *= positionLowerCase;
        }
        return number;
    }
}
