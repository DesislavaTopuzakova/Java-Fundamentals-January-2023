package Maps;
import java.util.*;

public class MinerTask_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> resourcesQuantity = new LinkedHashMap<>();
        //ресурс -> сума от количество
        String resource = scanner.nextLine(); //ресурс или "stop"
        while(!resource.equals("stop")) {
            //ресурс
            int quantity = Integer.parseInt(scanner.nextLine());
            //проверка имам ли такъв ресурс
            //ако нямам такъв ресурс
            if(!resourcesQuantity.containsKey(resource)) {
                resourcesQuantity.put(resource, quantity);
            }
            //ако имам такъв ресурс
            else {
                int currentQuantity = resourcesQuantity.get(resource);
                resourcesQuantity.put(resource, currentQuantity + quantity);
            }
            resource = scanner.nextLine();
        }

        //resourcesQuantity.forEach((key, value) -> System.out.println(key + " -> " + value));
        resourcesQuantity.entrySet().forEach(entry -> System.out.println(entry.getKey() + " -> " + entry.getValue()));
    }
}
