package Maps;
import java.util.*;

public class CompanyUsers_08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<String>> listOfEmployees = new LinkedHashMap<>();

        String input = scanner.nextLine();
        while (!input.equals("End")) {
            String[] info = input.split(" -> ");

            List<String> currentCompanyEmployees = listOfEmployees.get(info[0]);
            boolean containsId = currentCompanyEmployees != null && currentCompanyEmployees.contains(info[1]);

            if (!containsId) {
                listOfEmployees.putIfAbsent(info[0], new ArrayList<>());
                listOfEmployees.get(info[0]).add(info[1]);
            }


            input = scanner.nextLine();
        }

        listOfEmployees.entrySet().stream()
                .forEach(c -> {
                    System.out.printf("%s%n", c.getKey());
                    c.getValue().forEach(e -> System.out.printf("-- %s%n", e));
                });


    }
}
