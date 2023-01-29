package Arrays;

import java.util.Scanner;

public class ArrayRotation_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String [] array = scanner.nextLine().split(" ");
        //"51 47 32 61 21".split(" ") -> ["51", "47", "32", "61", "21"]
        int countRotations = Integer.parseInt(scanner.nextLine());

        for (int rotation = 1; rotation <= countRotations; rotation++) {
            //ротация на масива
            //1. взимам първия елемент
            String firstElement = array[0]; //"51"

            //2. преместваме елементите наляво
            //["51", "47", "32", "61", "21"] -> ["47", "32", "61", "21", "21"]
            for (int index = 0; index < array.length - 1 ; index++) {
                    array[index] = array[index + 1];
            }

            //3. поставям първия елемент на последно място
            //["47", "32", "61", "21", "51"]
            array[array.length - 1] = firstElement;
        }
        
        //приключваме с ротациите -> принтираме всички елементи на масива
        for (String element : array) {
            System.out.print(element + " ");
        }
    }
}
