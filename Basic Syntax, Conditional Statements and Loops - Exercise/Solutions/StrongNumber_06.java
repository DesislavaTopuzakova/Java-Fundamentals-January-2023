package BasicSyntax;

import java.util.Scanner;

public class StrongNumber_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //1. входни данни -> цяло число
        int number = Integer.parseInt(scanner.nextLine());
        int startNumber = number; //първоначално въведенета стойност на числото
        //2. проверка дали числото е strong
        //ако е strong -> yes
        //ако не е string -> no

        //за всяка цифра
        //1. цифра - OK
        //2. факториел на цифра
        //3. сумирам факториел

        int sumFact = 0; //сума на факториели
        while (number > 0) { //стоп: number <= 0
            int lastDigit = number % 10;//взимаме последната цифра
            //намирам факториел на lastDigit
            int fact = 1; //факториела на текущата цифра
            for (int i = 1; i <= lastDigit; i++) {
                fact = fact * i;
            }
            //сумирам получения факториел на цифрата
            sumFact += fact;
            //премахвам последната цифра
            number = number / 10;
        }

        //сумата от факториелите на цифрите на числото
        if (sumFact == startNumber) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }

    }
}
