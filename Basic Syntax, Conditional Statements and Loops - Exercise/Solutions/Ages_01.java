package BasicSyntax;

import java.util.Scanner;

public class Ages_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //1. възраст - цяло число
        //2. проверка на възрастта
        //•	0-2 – baby; - ok
        //•	3-13 – child; - ok
        //•	14-19 – teenager; - ok
        //•	20-65 – adult;
        //•	>=66 – elder;

        int age = Integer.parseInt(scanner.nextLine());
        if (age >= 0 && age <= 2) {
            System.out.println("baby");
        } else if (age >= 3 && age <= 13) {
            System.out.println("child");
        } else if (age >= 14 && age <= 19) {
            System.out.println("teenager");
        } else if (age >= 20 && age <= 65) {
            System.out.println("adult");
        } else if (age >= 66) {
            System.out.println("elder");
        }
    }
}
