package DataTypes;

import java.util.Scanner;

public class SumDigits_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //1. входни данни
        int number = Integer.parseInt(scanner.nextLine());

        //2. намерим сумата от цифрите на числото

        int sumDigits = 0;//сума от цифрите
        //алгоритъм за взимане на цифрите на едно число
        //стоп: число <= 0
        //продължаваме: число > 0
        //повтаряме:
            //1. взимам последната цифра
            //2. сумирам цифрата
            //3. премахвам взетата цифра от числото

        while (number > 0) {
            //1. взимам последната цифра
            int lastDigit = number % 10;
            //2. сумирам цифрата
            sumDigits += lastDigit; //sumDigits = sumDigits + lastDigit;
            //3. премахвам взетата цифра от числото
            number = number / 10;  //number /= 10;
        }

        //сумирали сме всички цифри
        System.out.println(sumDigits);




    }
}
