package Maps;
import java.util.*;
public class Courses_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        //име на курс -> списък с имената на студенти
        Map<String, List<String>> courses = new LinkedHashMap<>();
        while(!input.equals("end")) {
            //"{име на курс} : {име на човек}" -> split (" : ") -> ["{courseName}", "{personName}"]
            String courseName = input.split(" : ")[0];
            String personName = input.split(" : ")[1];
            //прверка имам ли такъв курс
            //ако нямам такъв курс
            if(!courses.containsKey(courseName)) {
                courses.put(courseName, new ArrayList<>());
            }

            //ако курсът е нов -> връща празен списък
            //ако курсът е стар -> връща моментния списък с хора
            courses.get(courseName).add(personName);

            input = scanner.nextLine();
        }
        //courseName -> List<String>
        courses.entrySet()
                .forEach(entry -> {
                    //key: име на курса
                    //value: списък с хората
                    //име на курса -> бр. хората
                    System.out.println(entry.getKey() + ": " + entry.getValue().size());
                    entry.getValue().forEach(studentName -> System.out.println("-- " + studentName));
                    //ascending order / нарастващ ред
                });
    }
}
