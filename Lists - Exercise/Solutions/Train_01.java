package Lists_Exercise;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
public class Train_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //"32 54 21 12 4 0 23" -> ["32", "54", "21", "12", "4", "0", "23"]
        List<Integer> wagons = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        int maxCapacity = Integer.parseInt(scanner.nextLine()); //макс брой пасажери във всеки един вагон

        String command = scanner.nextLine();
        while(!command.equals("end")) {
            //"Add {passengers}" -> ["Add", "5"]
            //"{passengers}" -> ["45"]
            String[] commandData = command.split(" ");//["Add", "5"] или ["45"]
            if (commandData[0].equals("Add")) {
                //команда Add
                int passengers = Integer.parseInt(commandData[1]);
                wagons.add(passengers);
            } else {
                //команда -> число
                int passengersToAdd = Integer.parseInt(commandData[0]);
                for(int index = 0; index < wagons.size(); index++) {
                    int currentWagon = wagons.get(index);
                    if(currentWagon + passengersToAdd <= maxCapacity) {
                        wagons.set(index, currentWagon + passengersToAdd);
                        break;
                    }
                }
            }

            command = scanner.nextLine();
        }

        for (int wagon : wagons) {
            System.out.print(wagon + " ");
        }

        //wagons.forEach(wagon -> System.out.print(wagon + " "));

    }
}
