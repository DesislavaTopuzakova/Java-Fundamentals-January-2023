package DataTypes;

import java.util.Scanner;

public class Pokemon_10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //1. входни данни
        int power = Integer.parseInt(scanner.nextLine()); //текуща сила
        int distance = Integer.parseInt(scanner.nextLine()); //разстояние между цели за удряне
        int factor = Integer.parseInt(scanner.nextLine()); //фактор на изтощение

        int startPower = power;  //първоначална сила
        //повтаряме:
        //1. power - distance -> стигаме до целта си
        //2. удряме цел
        //stop: power < distance
        //продължавам: power >= distance

        int countTarget = 0; //брой ударени цели
        while (power >= distance) {
            //1. отивам до целта -> намаляме силата с изминатото разстояние
            power -= distance; //power = power - distance;
            //2. удряме цел
            countTarget++;

            //проверка за умора
            if (power == startPower / 2) {
                //сила / фактор
                if (factor != 0) {
                    //позволена аритметична операция (деление)
                    power = power / factor; // power /= factor;
                }
            }
        }

        System.out.println(power);
        System.out.println(countTarget);


    }
}
