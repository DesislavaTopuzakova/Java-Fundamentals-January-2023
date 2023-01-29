package Arrays;

import java.util.Scanner;

public class TreasureHunt_10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String [] loots = scanner.nextLine().split("\\|");
        //"Gold|Silver|Bronze|Medallion|Cup".split("|") -> ["Gold", "Silver", "Bronze", "Medallion", "Cup"]

        String command = scanner.nextLine(); //цялата команда, въведена от конзолата

        while (!command.equals("Yohoho!")) {
            //command = "Loot {item1} {item2}…{itemn}".split -> ["Loot", "itrem1", "item2", ...]

            //command = "Steal 2".split -> ["Steal", "2"]
            String[] commandParts = command.split(" "); //частите на командата
            String commandName = commandParts[0]; //име на команда: Loot, Drop, Steal

            switch (commandName) {
                case "Loot":
                    break;
                case "Drop":
                    //command = "Drop 4".split -> commandParts = ["Drop", "4"]
                    int dropIndex = Integer.parseInt(commandParts[1]); //"4" -> 4
                    //проверка на индекс
                    if(dropIndex < 0 || dropIndex >= loots.length - 1) {
                        //невалиден индекс -> индекс, на който нямаме елемент
                        break;
                    } else{
                        //валиден индекс
                        //1. взимаме елемента за преместване
                        String currentLoot = loots[dropIndex];
                        //2. премествам на ляво всички елементи след моя
                        for (int leftIndex = dropIndex; leftIndex < loots.length - 1; leftIndex++) {
                            loots[leftIndex] = loots[leftIndex + 1];
                        }
                        //3. слагаме накрая елемента за преместване
                        loots[loots.length - 1] = currentLoot;
                    }
                    break;
                case "Steal":
                    break;
            }

            command = scanner.nextLine();
        }
    }
}
