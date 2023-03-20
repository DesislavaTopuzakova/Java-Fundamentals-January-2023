package RegEx;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Race_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String names = scanner.nextLine(); //"George, Peter, Bill, Tom"
        List<String> racersNames = Arrays.stream(names.split(", ")) //["George", "Peter", "Bill", "Tom"]
                .collect(Collectors.toList());  //{"George", "Peter", "Bill", "Tom"} -> списък с имената на състезателите в състезанието

        Map<String, Integer> racersDistances = new LinkedHashMap<>();
        //име на състезател -> дистанция
        racersNames.forEach(racer -> racersDistances.put(racer, 0));

        //Regex
        String lettersRegex = "[A-Za-z]";
        Pattern patternLetter = Pattern.compile(lettersRegex);

        String digitsRegex = "[0-9]";
        Pattern patternDigit = Pattern.compile(digitsRegex);

        String input = scanner.nextLine();
        while (!input.equals("end of race")) {
            //input = "G!32e%o7r#32g$235@!2e"

            //име на състезателя -> само буквите
            StringBuilder nameBuilder = new StringBuilder(); //конструираме името на състезателя
            Matcher matcherLetter = patternLetter.matcher(input); //всички букви -> ["G", "e", "o", "r", "g", "e"]
            while (matcherLetter.find()) {
                nameBuilder.append(matcherLetter.group());
            }

            //дистанция на състезателя -> сума от цифрите
            int distance = 0; //сумирам всички цифри
            Matcher matcherDigit = patternDigit.matcher(input); //всички цифри -> ["3", "2", "7", "3", "2", "2", "3", "5"]
            while (matcherDigit.find()) {
                distance += Integer.parseInt(matcherDigit.group());
            }

            //? има ли такъв състезател -> добавя дистанцията към съответния състезател
            String racerName = nameBuilder.toString(); //име на състезателя
            if (racersNames.contains(racerName)) {
                //име на състезател -> дистанция
                int currentDistance = racersDistances.get(racerName);
                racersDistances.put(racerName, currentDistance + distance);
            }


            input = scanner.nextLine();
        }

        //{"George", "Peter", "Bill", "Tom"}
        for (int index = 0; index <= 2; index++) {
            String racer = racersNames.get(index);
            if (index == 0) {
                System.out.println("1st place: " + racer);
            } else if (index == 1) {
                System.out.println("2nd place: " + racer);
            } else if (index == 2) {
                System.out.println("3rd place: " + racer);
            }
        }

    }
}
