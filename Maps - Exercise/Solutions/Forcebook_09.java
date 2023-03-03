package Maps;

import java.util.*;

public class Forcebook_09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        //отбор -> списък с играчите
        Map<String, List<String>> teams = new LinkedHashMap<>();

        while (!input.equals("Lumpawaroo")) {
            if (input.contains("|")) {
                //input = "{force_side} | {force_user}" .split -> ["team", "player"]
                String team = input.split(" \\| ")[0]; //отбор
                String player = input.split(" \\| ")[1];// играча

                //нямаме такъв отбор -> създаваме
                if (!teams.containsKey(team)) {
                    teams.put(team, new ArrayList<>());
                }

                //имаме такъв отбор -> добавяме играча към отбора, само ако го няма в НИКОЙ друг отбор
                boolean isExist = false; //играча го има в някой друг отбор
                for (List<String> list : teams.values()) {
                    if (list.contains(player)) {
                        isExist = true;
                    }
                }
                //isExist = true => играчът го има в някой отбор
                //isExist = false => играчът го няма в никой отбор
                if (!isExist) {
                    teams.get(team).add(player);
                }


            }
            else if (input.contains("->")) {
                //input = "{force_user} -> {force_side}".split -> ["player", "team"]
                String player = input.split(" -> ")[0];
                String team = input.split(" -> ")[1];

                //1. премахваме играча от текущия отбор
                teams.entrySet().forEach(entry -> entry.getValue().remove(player));

                //2. отборът, в който отива дали съществува
                if (teams.containsKey(team)) {
                    List<String> currentPlayers = teams.get(team); //текущия списък на играчите
                    currentPlayers.add(player); //добавяме играча към новия му отбор
                } else {
                    //отборът, в който отива да не съществува
                    teams.put(team, new ArrayList<>());
                    teams.get(team).add(player);
                }

                System.out.printf("%s joins the %s side!%n", player, team);

            }
            input = scanner.nextLine();
        }

        //премахваме отборите без играчи
        //entry: team (key) -> list of players (value)
        //filter -> оставя записите, които отговарят на условието
        //премахваме всички, които entry.getValue().size() <= 0
        teams.entrySet() //всички записи: team (key) -> list of players (value)
                .stream().filter(entry -> entry.getValue().size() > 0) //оставяме само отбори с играчи
                .forEach(entry -> {
                    System.out.println("Side: " + entry.getKey() + ", Members: " + entry.getValue().size());
                    entry.getValue().forEach(player -> System.out.println("! " + player));
                });
    }
}
