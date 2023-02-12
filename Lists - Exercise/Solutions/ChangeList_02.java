package Lists_Exercise;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
public class ChangeList_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //1. списък с числа -> входни данни
        //2. получаваме команди -> "end"
        //"Delete {element}" -> "Delete 3"
        //"Insert {element} {position}" -> "Insert 3 1"

        List<Integer> numbers = Arrays.stream(scanner.nextLine() //"1 2 3 4 5 5 5 6"
                        .split(" "))  //["1", "2", "3", "4", "5", "5", "5", "6"] -> масив от текстове
                .map(Integer::parseInt) //[1, 2, 3, 4, 5, 5, 5, 6] -> масив от цели числа
                .collect(Collectors.toList()); //{1, 2, 3, 4, 5, 5, 5, 6} -> списък от цели числа

        String command = scanner.nextLine(); //команди
        //stop: command == "end"
        //continue: command != "end"
        while (!command.equals("end")) {
            //команда
            //1. command = "Delete 3"
            if (command.contains("Delete")) {
                //"Delete 3".split(" ") -> ["Delete", "3"]
                int numberForRemove = Integer.parseInt(command.split(" ")[1]);
                //премахваме всички стойности от списъка равни на numberForRemove
                numbers.removeAll(Arrays.asList(numberForRemove));
            }
            //2. command = "Insert 3 1"
            else if (command.contains("Insert")) {
                //"Insert 3 1".split(" ") -> ["Insert", "3", "1"]
                //вмъкна element на index
                int element = Integer.parseInt(command.split(" ")[1]);
                int index = Integer.parseInt(command.split(" ")[2]);
                numbers.add(index, element);
            }
            command = scanner.nextLine();
        }

        //списък с числа -> {3, 4, 5, 6}
        for (int number : numbers) {
            System.out.print(number + " ");
        }

    }
}
