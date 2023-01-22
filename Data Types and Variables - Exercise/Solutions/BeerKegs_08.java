package DataTypes;

import java.util.Scanner;

public class BeerKegs_08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine()); //брой на кегове с бира

        double maxVolume = Double.MIN_VALUE; //максималния обем = 0
        String maxModel = ""; // модел на кега с най-голям обем
        for (int keg = 1; keg <= n; keg++) {
            //въвеждаме информация
            String model = scanner.nextLine(); //модел / вид на кега
            double radius = Double.parseDouble(scanner.nextLine()); //радиус
            int height = Integer.parseInt(scanner.nextLine()); //височина
            //намираме обем = π * r^2 * h
            double volume = Math.PI * Math.pow(radius, 2) * height;
            //проверка дали обема е максимален
            if (volume > maxVolume) {
                maxVolume = volume;
                maxModel = model;
            }
        }

        System.out.println(maxModel);
    }
}
