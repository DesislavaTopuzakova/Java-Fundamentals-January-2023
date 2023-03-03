package Maps;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountCharsInAString_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        //символ -> бр. срещания
        Map<Character, Integer> characterCounts = new LinkedHashMap<>();
        //HashMap - нямаме конкретна подредба на записите
        //LinkedHashMap - записите се подреждат спрямо реда на добавяне
        //TreeMap - записите се сортират по ключ

        //"Desislava" -> ['D', 'e', 's', 'i', 's', 'l', 'a', 'v', 'a']
        for (char symbol : text.toCharArray()) {
            if (symbol == ' ') {
                continue;
            }
            //да сме го срещали
            if (characterCounts.containsKey(symbol)) {
                int currentCount = characterCounts.get(symbol);
                characterCounts.put(symbol, currentCount + 1);
            }
            //да не сме го срещали
            else {
                characterCounts.put(symbol, 1);
            }
        }

        //map: символ(key) -> бр. срещания(value)
        //entry (key: char -> value: int)
       // characterCounts.forEach((key, value)-> System.out.println(key + " -> " + value));

        for(Map.Entry<Character, Integer> entry : characterCounts.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }


    }
}
