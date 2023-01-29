package Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class Train_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int countWagons = Integer.parseInt(scanner.nextLine());
        //1. съхраним хората, които се качват
        int [] wagons = new int[countWagons];
        for (int wagon = 0; wagon < countWagons; wagon++) {
            int countPeople = Integer.parseInt(scanner.nextLine());
            wagons[wagon] = countPeople;
        }
        //[13, 24, 8]
        //2. отпечатаме
        //2.1. for -> индексите
        /*for (int index = 0; index <= wagons.length - 1; index++) {
            int currentElement = wagons[index];
            System.out.print(currentElement + " ");
        }
        System.out.println();*/

        //2.2. foreach -> елементите
        int sum = 0;
        for (int number : wagons) {
            //кодът, който искаме да повтаряме
            System.out.print(number + " ");
            sum += number;
        }
        System.out.println();
        System.out.println(sum);
        //3. сумираме хората
        //System.out.println(Arrays.stream(wagons).sum());
    }
}
