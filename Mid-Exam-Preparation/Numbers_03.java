package ExamPreparation;

import java.util.*;
import java.util.stream.Collectors;

public class Numbers_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //входни данни
        List<Integer> numbers = Arrays.stream(scanner.nextLine() // "10 20 30 40 50"
                                .split("\\s+")) //["10", "20", "30", "40", "50"]
                                 .map(Integer::parseInt) // [10, 20, 30, 40, 50]
                                 .collect(Collectors.toList()); //{10, 20 , 30, 40, 50}


        int sum = 0; //сума от елементите в списъка
        for (int number : numbers) {
            sum += number;
        }

        //средно аритмечтината стойност в списъка = сума от стойности / бр. стойности
        double average = sum * 1.0 / numbers.size();

        List<Integer> greaterElements = new ArrayList<>(); //числа, по-големи от средното число (average)
        for (int number : numbers) {
            if (number > average) {
                greaterElements.add(number);
            }
        }

        //greaterElements -> всички числа по-големи от средното число в пърчоначалния списък
        Collections.sort(greaterElements); //ascending order
        Collections.reverse(greaterElements); //descending order



        //имаме ВСИЧКИ числа в списъка greaterElements наредени по големина
        if (greaterElements.size() > 0) {
            if (greaterElements.size() <  5) {
                //I начин за отпечатване на всички числа в списъка
                System.out.println(greaterElements.toString() //"[2, 4, 5, 6]"
                        .replace("[", "") //"2, 4, 5, 6]"
                        .replace("]", "") //"2, 4, 5, 6"
                        .replace(",", "") //"2 4 5 6"
                );

                //II начин за отпечатване на всички числа в списъка
                /*for (int number : greaterElements) {
                    System.out.print(number + " ");
                }*/
            } else {
                //greaterElements = {98, 76, 65, 54, 43, 32, 31, 28, 26}
                List<Integer> top5Numbers = greaterElements.subList(0, 5); //първите 5 числа: {98, 76, 65, 54, 43}
                for (int number : top5Numbers) {
                    System.out.print(number + " ");
                }
            }

        } else {
            //нямаме числа в списъка greaterElements
            System.out.println("No");
        }
    }
}
