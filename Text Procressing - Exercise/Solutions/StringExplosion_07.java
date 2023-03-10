package TextProcessing;
import java.util.Scanner;
public class StringExplosion_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        //"abv>1>1>2>2asdasd"
        StringBuilder text = new StringBuilder(input);

        int totalStrength = 0; //сила
        for (int position = 0; position < text.length() ; position++) {
            char currentSymbol = text.charAt(position);
            if (currentSymbol == '>') {
                //char ('1') -> string ("1") -> int (1)
                //атака
                int attackStrength = Integer.parseInt(text.charAt(position + 1) + ""); //сила на атаката
                totalStrength += attackStrength;
            } else if (currentSymbol != '>' && totalStrength > 0) {
                //премахване
                text.deleteCharAt(position);
                totalStrength--;
                position--;

            }
        }
        System.out.println(text);


    }
}
