package Methods;

import java.util.Scanner;

public class TopNumber_10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        for (int number = 1; number <= n; number++) {
            //проверка дали е топ число
            //1. сумата от цифрите да се дели на 8
            //2. съдържа поне една нечетна цифра
            boolean isSum = isSumOfDigitsIsDivisibleBy8(number);
            boolean isContains = isContainsOddDigit(number);
            if (isSum && isContains) {
                //отпечатваме числото
                System.out.println(number);
            }


        }
    }

    //метод, който да проверява дали сумата от цифрите на числото се дели на 8
    //true -> ако сумата се дели на 8
    //false -> ако сумата не се дели на 8
    public static boolean isSumOfDigitsIsDivisibleBy8 (int number) {
        //1. сума от цифирите на числото
        int sum = 0; //сума от цифрите
        while (number > 0) {
            int lastDigit = number % 10; //последната цифра
            sum += lastDigit; //сумираме последната цифра
            number = number / 10; //премахваме последната цифра
        }
        //2. проверка дали сумата от цифрите се дели на 8
        return sum % 8 == 0;

        /*if (sum % 8 == 0) {
            return true;
        } else {
            return false;
        }*/
    }

    //метод, който проверява дали имаме поне една нечетна цифра в числото
    //true -> ако имаме поне една нечетна цифра
    //false -> ако нямаме нито една нечетна цифра
    public static boolean isContainsOddDigit (int number) {
        //6382
        while (number > 0) {
            int lastDigit = number % 10; //взимаме последната цифра
            //проверявам дали цифрата е нечетна
            if (lastDigit % 2 != 0) {
                //нечетна цифра -> поне една нечетна
                return true;
            } else {
                //четна цифра -> премахваме
                number /= 10;
            }
        }
        //проверили всички цифри и никоя не е била нечетна
        return false;
    }
}
