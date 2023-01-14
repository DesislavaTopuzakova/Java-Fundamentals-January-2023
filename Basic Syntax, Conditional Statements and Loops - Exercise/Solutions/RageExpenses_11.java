package BasicSyntax;

import java.util.Scanner;

public class RageExpenses_11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //1. входни данни
        int lostGames = Integer.parseInt(scanner.nextLine());
        double headsetPrice = Double.parseDouble(scanner.nextLine());
        double mousePrice = Double.parseDouble(scanner.nextLine());
        double keyboardPrice = Double.parseDouble(scanner.nextLine());
        double displayPrice = Double.parseDouble(scanner.nextLine());

        //2. крайна сума = (бр. слушалки * headsetPrice)
        //                  + (бр. мишки * mousePrice)
        //                  + (бр. клавиатури * keyboardPrice)
        //                  + (бр. монитори * displayPrice)

        int countHeadset = lostGames / 2; //бр. слушалки
        int countMouse = lostGames / 3; //бр. мишки
        int countKeyboards = lostGames / 6; //бр. клавиатури
        int countDisplays = lostGames / 12; //бр. монитор

        double finalSum = (countHeadset * headsetPrice)
                + (countMouse * mousePrice)
                + (countKeyboards * keyboardPrice)
                + (countDisplays * displayPrice);

        System.out.printf("Rage expenses: %.2f lv.", finalSum);
    }
}
