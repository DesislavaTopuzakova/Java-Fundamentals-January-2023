package Lists_Lab;

import java.util.*;
import java.util.stream.Collectors;

public class RemoveNegativesAndReverse_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //1. прочитаме лист от цели числа
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
                                .map(Integer::parseInt).collect(Collectors.toList());
        //{10 -5 7 9 -33 50} -> {10 7 9 50}

        //numbers.removeIf(number -> number < 0); премахва всички отрицателни числа в списъка

        List<Integer> positiveNumbers = new ArrayList<>(); //списък, в който ще има само положителни числа

        for (int number : numbers ) {
            if (number >= 0) {
                positiveNumbers.add(number);
            }
        }

        Collections.reverse(positiveNumbers);
        if (positiveNumbers.size() == 0) {
            System.out.println("empty");
        } else {
            /*System.out.println(positiveNumbers.toString()
                    .replace("[", "")
                    .replace("]", "")
                    .replaceAll(",", ""));*/
            for (int number : positiveNumbers) {
                System.out.print(number + " ");
            }

        }

    }
}
