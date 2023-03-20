package RegEx;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
public class NetherRealms_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> namesList = Arrays.stream(scanner.nextLine().split("\\s*,\\s*")).collect(Collectors.toList());
        String regexHealth = "[^0-9+*-\\/.]";
        Pattern patternHealth = Pattern.compile(regexHealth);
        String regexDamage = "\\+?\\-?\\d+\\.?\\d*";
        Pattern patternDamage = Pattern.compile(regexDamage);

        for (String name : namesList) {
            Matcher matcherHealth = patternHealth.matcher(name);
            int health = 0;
            while (matcherHealth.find()) {
                char symbol = matcherHealth.group().charAt(0);
                health += symbol;
            }

            Matcher matcherDamage = patternDamage.matcher(name);
            double damage = 0;
            while (matcherDamage.find()) {
                double currentDamage = Double.parseDouble(matcherDamage.group());
                damage += currentDamage;
            }
            for (Character symbol : name.toCharArray()) {
                if (symbol == '/') {
                    damage /= 2;
                } else if (symbol == '*') {
                    damage *= 2;
                }
            }

            System.out.printf("%s - %d health, %.2f damage%n", name, health, damage);

        }

    }
}
