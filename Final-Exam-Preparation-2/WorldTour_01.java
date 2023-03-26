package ExamPreparation2;

import java.util.Scanner;

public class WorldTour_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String allStops = scanner.nextLine(); //всички спирки: "Hawai::Cyprys-Greece"
        StringBuilder stopsBuilder = new StringBuilder(allStops);

        String command = scanner.nextLine();
        while(!command.equals("Travel")) {
            //команда
            if (command.contains("Add Stop")) {
                //command = "Add Stop:2:Italy".split(":") -> ["Add Stop", "2", "Italy"]
                int index = Integer.parseInt(command.split(":")[1]); //индекс, на който трябва да вмъкнем спирка
                String stopName = command.split(":")[2]; //спирка, която трябва да вмъкнем

                //валидирам индекса
                //първия (0) до последния индекс (дължина - 1)
                if (isValidIndex(index, stopsBuilder)) {
                    stopsBuilder.insert(index, stopName);
                }

            } else if (command.contains("Remove Stop")) {
                //command = "Remove Stop:2:9".split(":") -> ["Remove Stop", "2", "9"]
                int startIndex = Integer.parseInt(command.split(":")[1]);
                int endIndex = Integer.parseInt(command.split(":")[2]);

                //валидираме индексите
                if (isValidIndex(startIndex, stopsBuilder) && isValidIndex(endIndex, stopsBuilder)) {
                    stopsBuilder.delete(startIndex, endIndex + 1);
                }

            } else if (command.contains("Switch")) {
                //command = "Switch:Italy:Spain".split(":") -> ["Switch", "Italy", "Spain"]
                String oldText = command.split(":")[1];
                String newText = command.split(":")[2];

                //!!! правим замяната на стария с новия, само ако стария съществува
                if (stopsBuilder.toString().contains(oldText)) {
                    String updatedText = stopsBuilder.toString().replace(oldText, newText); //текст след заместването
                    stopsBuilder = new StringBuilder(updatedText);
                }
            }

            System.out.println(stopsBuilder);
            command = scanner.nextLine();
        }

        System.out.println("Ready for world tour! Planned stops: " + stopsBuilder);


    }

    //метод, който валидира индекс в текст stopsBuilder
    //true -> ако индексът е валиден
    //false -> ако индексът не е валиден
    public static boolean isValidIndex (int index, StringBuilder builder) {
        //първия (0) до последния индекс (дължина - 1)
        return index >= 0 && index <= builder.length() - 1;
        //return index >= 0 && index < builder.length();
    }
}
