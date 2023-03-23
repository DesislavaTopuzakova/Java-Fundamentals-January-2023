package ExamPreparation1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmojiDetector_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine(); //първоначален текст

        long coolThreshold = 1; //праг на готиност = стойност, която трябва да постигнем
        //умножим всички цифри в първоначалния текст

        for (char symbol : input.toCharArray()) {
            if (Character.isDigit(symbol)) {
                //'1'-> "1" -> 1
                int number = Integer.parseInt(symbol + "");
                coolThreshold *= number;
            }
        }
        System.out.println("Cool threshold: " + coolThreshold);

        String regex = "([:]{2}|[*]{2})(?<emoji>[A-Z][a-z]{2,})(\\1)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        //съвкупност от текстовете, които отговарят на шаблон = валидните емоджита
        //matcher = ["::Smiley::", "**Tigers**", "::Mooning::"]

        int countValidEmojis = 0; //брой на въведените валидни емоджита
        List<String> coolEmojis = new ArrayList<>(); //най-готини емоджита

        while (matcher.find()) { //true -> намерено валидно емоджи
            //1. емоджи -> валидно -> броим
            countValidEmojis++;
            //2. намирам колко е готино
            int coolLevelCurrentEmoji = 0; //ниво на готиност на текущото емоджи
            String emoji = matcher.group("emoji");
            for (char symbol : emoji.toCharArray()) {
                coolLevelCurrentEmoji += (int) symbol;
            }
            //3. поверявам дали е достатъчно готино (coolest >= coolThreshold)
            if (coolLevelCurrentEmoji >= coolThreshold) {
                coolEmojis.add(matcher.group());
            }
        }

        System.out.printf("%d emojis found in the text. The cool ones are:%n", countValidEmojis);
        coolEmojis.forEach(System.out::println);




    }
}
