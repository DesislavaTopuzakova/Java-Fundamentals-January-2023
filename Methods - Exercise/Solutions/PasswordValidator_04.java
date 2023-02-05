package Methods;

import java.util.Scanner;

public class PasswordValidator_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String password = scanner.nextLine();

        //1. проверим дали дължината на паролата е валидна
        boolean isValidLength = isValidLength(password);
        //isValidLength = true -> валидна парола
        //isValidLength = false -> невалидна парола
        if (!isValidLength) {
            //паролата не е валидна
            System.out.println("Password must be between 6 and 10 characters");
        }

        //2. проверим дали съдържанието е валидно
        boolean isValidContent = isValidContent(password);
        //isValidContent = true -> валидно съдържание
        //isValidContent = false -> невалидно съдържание
        if (!isValidContent) {
            System.out.println("Password must consist only of letters and digits");
        }

        //3. проверим дали брой на цифрите е валиден
        boolean isValidCount = isValidCountDigits(password);
        //isValidCount = true -> валиден брой
        //isValidCount = false -> невалиден брой
        if (!isValidCount) {
            System.out.println("Password must have at least 2 digits");
        }

        //4. проверяваме дали цялостно е валидна паролата
        if (isValidLength && isValidContent && isValidCount) {
            System.out.println("Password is valid");
        }

    }

    //метод, който проверява дали ми е валидна дължината на паролата
    //true -> ако дължината на паролата е валидна
    //false -> ако дължината на паролата не е валидна
    public static boolean isValidLength (String password) {
        //валидна дължина: [6; 10]
        //невалидна дължина: < 6 или > 10
        return password.length() >= 6 && password.length() <= 10;
    }

    //метод, който проверява дали ми е валидно съдържанието на паролата
    //true -> ако съдържанието е валидно
    //false -> ако съдържанието не е валидно
    public static boolean isValidContent (String password) {
        //password = "logIn".toCharArray() -> ['l', 'o', 'g', 'I', 'n']
        //валидно съдържание: букви или цифри
        //невалидно съдържание: нещо различно от буква или цифра
        for (char symbol : password.toCharArray()) {
            if (!Character.isLetterOrDigit(symbol)) {
                //isLetterOrDigit
                //true ако символа е буква или цифра
                //false ако символа не е нито буква, нито цифра
                return false;
            }
        }
        //обходили всички символи
        return true;
    }

    //метод, който проверява дали е валиден броя на цифрите в паролата
    //true -> ако броят е валиден >= 2
    //false -> ако броят е невалиден < 2
    public static boolean isValidCountDigits (String password) {
        int countDigits = 0; //брой на цифрите в паролата
        //password = "Pesho123".toCharArray()
        for (char symbol :  password.toCharArray()) {
            if (Character.isDigit(symbol)) {
                //isDigit
                //true -> ако символа е цифра
                //false -> ако символа не е цифра
                countDigits++;
            }
        }
        //true -> брой >= 2
        //false -> брой < 2
       return countDigits >= 2;
    }
}
