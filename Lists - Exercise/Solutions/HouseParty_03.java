package Lists_Exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HouseParty_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int countCommands = Integer.parseInt(scanner.nextLine()); //брой на команди

        List<String> guests = new ArrayList<>(); //списък с имена на гости

        for (int countCommand = 1; countCommand <= countCommands; countCommand++) {
            String command = scanner.nextLine();
            String name = command.split("\\s+")[0];

            if (command.contains("is going!")) {
                //command = "Desi is going!".split(" ") -> ["Desi", "is", "going!"][0] -> "Desi"
                //1. да го има вече в списъка
                if (guests.contains(name)) {
                    System.out.println(name + " is already in the list!");
                }
                //2. да го няма в списъка
                else {
                    guests.add(name);
                }
            } else if (command.contains("is not going!")){
                //command = "Ivan is not going!".split(" ") -> ["Ivan", "is", "not", "going!"]
                //1. ако го има в списъка -> премахвам
                if (guests.contains(name)) {
                    guests.remove(name);
                }
                //2. ако го няма в списъка
                else {
                    System.out.println(name + " is not in the list!");
                }
            }
        }

        //пълния списък с гостите
        for (String name : guests) {
            System.out.println(name);
        }
    }
}
