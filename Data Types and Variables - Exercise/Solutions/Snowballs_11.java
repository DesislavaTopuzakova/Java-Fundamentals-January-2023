package DataTypes;


import java.util.*;

public class Snowballs_11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        double maxValue = Double.MIN_VALUE;
        int snowballSnowBiggest = 0;
        int snowballTTimeBiggest = 0;
        int snowballQualityBiggest = 0;


        for (int snowBall = 1; snowBall <= n; snowBall++) {
            int snowBallSnow = Integer.parseInt(scanner.nextLine());
            int snowBallTime = Integer.parseInt(scanner.nextLine());
            int snowBallQuality = Integer.parseInt(scanner.nextLine());
            double snowBallValue = Math.pow(snowBallSnow / snowBallTime, snowBallQuality);

            if (snowBallValue > maxValue){
                maxValue = snowBallValue;
                snowballSnowBiggest = snowBallSnow;
                snowballTTimeBiggest = snowBallTime;
                snowballQualityBiggest = snowBallQuality;
            }

        }
        System.out.printf("%d : %d = %.0f (%d) ",snowballSnowBiggest, snowballTTimeBiggest, maxValue ,snowballQualityBiggest );


    }
}
