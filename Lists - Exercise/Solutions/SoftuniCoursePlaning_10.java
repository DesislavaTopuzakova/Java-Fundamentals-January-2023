package Lists_Exercise;
import java.util.*;
import java.util.stream.Collectors;
public class SoftuniCoursePlaning_10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> schedule = Arrays.stream(scanner.nextLine().split(", ")).collect(Collectors.toList());

        String input = scanner.nextLine();

        while(!input.equals("course start")) {
            String [] tokens = input.split(":");
            String command = tokens[0];
            String lessonTitle = tokens[1];
            switch(command) {
                case "Add":
                    //"Add:Databases" -> ["Add", "Databases"]
                    if(!schedule.contains(lessonTitle)) {
                        schedule.add(lessonTitle);
                    }
                    break;
                case "Insert":
                    //Insert:Arrays:0 -> ["Insert", "Arrays", "0"]
                    int index = Integer.parseInt(tokens[2]);
                    if(!schedule.contains(lessonTitle)) {
                        schedule.add(index, lessonTitle);
                    }
                    break;
                case "Remove":
                    if(schedule.contains(lessonTitle)) {
                        schedule.remove(lessonTitle);
                    }
                    int indexLesson = schedule.indexOf(lessonTitle);
                    if(schedule.get(indexLesson + 1).equals(lessonTitle+"-Exercise")) {
                        schedule.remove(indexLesson + 1);
                    }
                    break;
                case "Swap":
                    //Arrays, Lists, Methods, Databases, Databases-Exercise
                    //Swap:Lists:Databases
                    String lessonTitle2 = input.split(":")[2];
                    if (schedule.contains(lessonTitle) && schedule.contains(lessonTitle2)) {
                        int lesson1Index = schedule.indexOf(lessonTitle);
                        int lesson2Index = schedule.indexOf(lessonTitle2);
                        schedule.set(lesson1Index, lessonTitle2);
                        schedule.set(lesson2Index, lessonTitle);

                        String exOne = lessonTitle + "-Exercise";
                        String exTwo = lessonTitle2 + "-Exercise";
                        if (schedule.contains(exOne)) {
                            schedule.remove(schedule.indexOf(exOne));
                            schedule.add(schedule.indexOf(lessonTitle + 1), exOne);
                        }
                        if (schedule.contains(exTwo)) {
                            schedule.remove(schedule.indexOf(exTwo));
                            schedule.add(schedule.indexOf(lessonTitle2) + 1, exTwo);
                        }
                    }
                    break;
                case "Exercise":
                    //упражнение -> Objects-Exercise
                    //[Data Types, Objects, Lists]
                    String exercise = lessonTitle + "-Exercise";
                    //слагаме упражнение ако има лекция и го няма
                    int indexLessonTitle = schedule.indexOf(lessonTitle);
                    if(schedule.contains(lessonTitle)) {
                        //има ли упражнение
                        if(indexLessonTitle == schedule.size() - 1) {
                            schedule.add(indexLessonTitle + 1, exercise);
                        } else  if(!schedule.get(indexLessonTitle + 1).equals(exercise)) {
                            schedule.add(indexLessonTitle + 1, exercise);
                        }
                    } else {
                        schedule.add(lessonTitle);
                        schedule.add(exercise);
                    }
                    break;
            }





            input = scanner.nextLine();
        }

        printList(schedule);
    }



    private static void printList(List<String> elements) {
        int count = 1;
        for (String element : elements) {
            System.out.println(count + "." + element);
            count++;

        }
    }

}
