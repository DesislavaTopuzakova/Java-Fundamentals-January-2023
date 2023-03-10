package TextProcessing;

import java.math.BigInteger;
import java.util.Scanner;

public class MultiplyBigNumbers_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        BigInteger firstNumber = new BigInteger(scanner.nextLine());//"923847238931983192462832102"
        BigInteger secondNumber =  new BigInteger(scanner.nextLine()); // "2"

        System.out.println(firstNumber.multiply(secondNumber)); //умножение

        //int -> BigInteger
        //int number = 3; //String.valueOf(number) => "3"
        //BigInteger big = new BigInteger(String.valueOf(number));
        //new BigInteger(int + "")

        //Аритметични операции
        //System.out.println(firstNumber.add(secondNumber)); //събиране
        //System.out.println(firstNumber.subtract(secondNumber)); //изваждане
        //System.out.println(firstNumber.divide(secondNumber)); // деление


    }
}
