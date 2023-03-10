package TextProcessing;

import java.util.Scanner;

public class ValidUsernames_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //1. входни данни
        String input = scanner.nextLine(); // "sh, too_long_username, !lleg@l ch@rs, jeffbutt"
        String[] usernames = input.split(", "); // ["sh", "too_long_username", "!lleg@l ch@rs", "jeffbutt"]

        //2. обходя usernames -> правя проверка дали е валиден -> принтирам
        for (String username : usernames) {
            //ако username e валиден
            if (isValidUsername(username)) {
                System.out.println(username);
            }
        }
    }
    //метод, който проверява дали username е валиден
    //true -> ако username е валиден
    //false -> ако username не е валиден
    private static boolean isValidUsername (String username) {
        //1. валидна дължина
        // [3; 16] -> валидна
        if (username.length() < 3 || username.length() > 16) {
            //невалидна дължина -> невалиден username
            return false;
        }
        //дължина е [3; 16] => валидна дължина

        //2. валидно съдържание -> букви, цифри, -, _
        //username = "Test№ser".toCharArray() -> ['T', 'e', 's', ....]
        for (char symbol : username.toCharArray()) {
            if (!Character.isLetterOrDigit(symbol) && symbol != '-' && symbol != '_') {
                //невалиден символ -> невалиден username
                return false;
            }
        }
        //валидно съдържание и валидна дължина
        return true;
    }


}
