package RegEx;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StarEnigma_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int countMessages = Integer.parseInt(scanner.nextLine());
        String regex = "@(?<planetName>[A-Za-z]+)[^@!:>-]*:(?<population>[0-9]+)[^@!:>-]*!(?<attackType>[AD])![^@!:>-]*->(?<soldiersCount>[0-9]+)";
        Pattern pattern = Pattern.compile(regex);

        List<String> attackersPlanets = new ArrayList<>(); //атакуващи планети (attackType е "А")
        List<String> destroyedPlanets = new ArrayList<>(); //унищожени планети (attackType е "D")

        for (int messageCount = 1; messageCount <= countMessages; messageCount++) {
            String encryptedMessage = scanner.nextLine(); //криптираното съобщение
            String decryptedMessage = getDecryptedMessage(encryptedMessage); //декриптирано съобщение
            //декриптирано: "PQ@Alderaa1:30000!A!->20000"
            Matcher matcher = pattern.matcher(decryptedMessage);
            //matcher: "@(?<planetName>Alderaa)[^@!:>-]*:(?<population>30000)[^@!:>-]*!(?<attackType>A)![^@!:>-]*->(?<soldiersCount>20000)";
            if (matcher.find()) {
                String planetName = matcher.group("planetName");
                //int population = Integer.parseInt(matcher.group("population"));
                String attackType = matcher.group("attackType");
                //int soldiersCount = Integer.parseInt(matcher.group("soldiersCount"));

                if (attackType.equals("A")) {
                    //атакуваща планета
                    attackersPlanets.add(planetName);
                } else if (attackType.equals("D")) {
                    //унищожена планета
                    destroyedPlanets.add(planetName);
                }
            }
        }

        System.out.println("Attacked planets: " + attackersPlanets.size());
        Collections.sort(attackersPlanets); //сортирам планетите по име
        attackersPlanets.forEach(planet -> System.out.println("-> " + planet));

        System.out.println("Destroyed planets: " + destroyedPlanets.size());
        Collections.sort(destroyedPlanets); //сортирам планетите по име
        destroyedPlanets.forEach(planet -> System.out.println("-> " + planet));
    }

    //върне декриптираното съобщение
    private static String getDecryptedMessage(String encryptedMessage) {
        //1. брой на символите [s, t, a, r, S, T, A, R]
        //криптирано съобщение: STCDoghudd4=63333$D$0A53333 -> 3 специални букви
        int countLetters = getSpecialLettersCount(encryptedMessage);

        //декриптиране -> контруираме ново съобщение
        StringBuilder decryptedMessage = new StringBuilder();
        //1. всеки символ от критпираното съобщение
        //2. нов символ -> ascii на нов символ = ascii на текущия символ - countLetters
        //3. добавяме нов символ
        for (char symbol  : encryptedMessage.toCharArray()) {
            char newSymbol = (char)(symbol - countLetters);
            decryptedMessage.append(newSymbol);
        }

        return decryptedMessage.toString();
    }

    //върне общия брой на буквите: [s, t, a, r, S, T, A, R]
    private static int getSpecialLettersCount(String encryptedMessage) {
        //криптирано съобщение: STCDoghudd4=63333$D$0A53333 -> 3 специални букви
        int count = 0;
        for (char symbol : encryptedMessage.toCharArray()) {
            switch (symbol) {
                case 's':
                case 't':
                case 'a':
                case 'r':
                case 'S':
                case 'T':
                case 'A':
                case 'R':
                    count++;
                    break;
            }
        }

        return count;
    }
}
