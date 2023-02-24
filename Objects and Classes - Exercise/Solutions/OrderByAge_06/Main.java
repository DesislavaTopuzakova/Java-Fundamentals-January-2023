package OrderByAge_06;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Person> peopleList = new ArrayList<>();
        String data = scanner.nextLine();

        while (!data.equals("End")) {
            //data = "{name} {ID} {age}".split("\\s+") -> ["{name}", "{ID}", "{age}"]
            String name = data.split("\\s+")[0]; //име
            String id = data.split("\\s+")[1]; //ID
            int age = Integer.parseInt(data.split("\\s+")[2]); //"10" -> 10

            Person person = new Person(name, id, age);
            peopleList.add(person);

            data = scanner.nextLine();
        }

        //списък с хората
        //1. сортирам по възраст (ascending order)
        peopleList.sort(Comparator.comparing(Person::getAge));

        //2. принтираме данните за всеки човек
        for (Person person : peopleList) {
            //"Stephan with ID: 524244 is 10 years old."
            System.out.println(person.getName() + " with ID: " + person.getId() + " is " + person.getAge() + " years old.");
        }
    }
}
