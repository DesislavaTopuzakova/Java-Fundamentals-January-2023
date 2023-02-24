package OpinionPoll_03;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Person> peopleList = new ArrayList<>();

        int n = Integer.parseInt(scanner.nextLine()); //брой на хората
        for (int p = 1; p <= n; p++) {
            String data = scanner.nextLine(); //"Peter 12".split(" ") -> ["Peter", "12"]
            String name = data.split("\\s+")[0]; //име на човека
            int age = Integer.parseInt(data.split("\\s+")[1]); //възраст на човека

            if (age > 30) {
                Person person = new Person(name, age); //човек
                peopleList.add(person);
            }
        }

        for (Person person : peopleList) {
            //човек
            //име на човека (name) - възраст на човека (age)
            System.out.println(person.getName() + " - " + person.getAge());
        }

    }
}
