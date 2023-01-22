package DataTypes;

import java.util.Scanner;

public class SumOfChars_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine()); //брой на символите
        int sum = 0; //сума на аски кодовете

        for (int count = 1; count <= n; count++) {
            char symbol = scanner.nextLine().charAt(0);
            int asciiCode = (int) symbol;
            sum += asciiCode; //sum = sum + asciiCode;
        }

        System.out.println("The sum equals: " + sum);
    }
}
