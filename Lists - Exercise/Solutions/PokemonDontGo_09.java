package Lists_Exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PokemonDontGo_09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers =  Arrays.stream(scanner.nextLine()
                        .split("\\s+"))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList()); // {4, 5, 3}

        //повтаряме: въвеждаме индекс
        //стоп: нямаме елементи в списъка (size <= 0)
        //продължаваме: имаме елементи в списъка (size > 0)

        int sum = 0; //сума на премахнатите елементи

        while (numbers.size() > 0) {
            int index = Integer.parseInt(scanner.nextLine());
            //1. index < 0
            if (index < 0) {
                // {8, 5, 3, 6, 7, 8}
                //1. взимам кой ми е първия елемент в списъка
                int firstElement = numbers.get(0);
                //2. премахваме елемента от първото място -> сумиране
                numbers.remove(0);
                sum += firstElement;
                //3. взимам кой ми е последния елемент в списъка
                int lastElement = numbers.get(numbers.size() - 1);
                //4. сложим последния елемент на първо място
                numbers.add(0, lastElement);
                //5. модифицирам списъка спрямо премахнатия елемент
                modifyList(numbers, firstElement);
            }
            //2. index > последния индекс в списъка
            else if (index > numbers.size() - 1) {
                //1. взимаме последния елемент
                int lastElement = numbers.get(numbers.size() - 1);
                //2. премахваме последния елемент
                numbers.remove(numbers.size() - 1);
                sum += lastElement;
                //3. взимаме първия елемент
                int firstElement = numbers.get(0);
                //4. вмъкнем първия елемент на последно място
                numbers.add(firstElement);
                //5. модифицираме списъка спрямо премахнатия елемент
                modifyList(numbers, lastElement);
            }
            //3. index да е валиден -> index >= 0 и index <= последния
            else if (index >= 0 && index <= numbers.size() - 1) {
                //1. взимам кой е елемента на дадения индекс
                int removedNumber = numbers.get(index);
                sum += removedNumber;
                //2. премахваме елемента на дадения индекс
                numbers.remove(index);
                //3. модифицирам списъка спрямо премахнатото число
                modifyList(numbers, removedNumber);
            }
        }

        System.out.println(sum);
    }

    public static void modifyList(List<Integer> numbers, int removedNumber) {
        for (int index = 0; index <= numbers.size() - 1; index++) {
            int currentElement = numbers.get(index); //текущ елемент
            if (currentElement <= removedNumber) {
                currentElement += removedNumber;
            } else {
                currentElement -= removedNumber;
            }

            numbers.set(index, currentElement);
        }
    }
}
