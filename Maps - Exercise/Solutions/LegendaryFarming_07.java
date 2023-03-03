package Maps;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class LegendaryFarming_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Shards -> количество
        //Fragments -> количество
        //Motes -> количество

        //запис: материал -> количество
        Map<String, Integer> materials = new LinkedHashMap<>(); //нужни материали
        materials.put("shards", 0);
        materials.put("fragments", 0);
        materials.put("motes", 0);

        //запис: боклук -> количество
        Map<String, Integer> junks = new LinkedHashMap<>(); //боклуци


        boolean isWin = false;
        //true -> ако сме спечелили
        //false -> ако не сме спечелили

        //стоп: ако спечелим
        //продължаваме: ако не сме спечелили
        while (!isWin) {
            String input = scanner.nextLine();
            //input = "6 leathers 255 fragments 7 Shards"
            String [] inputData = input.split("\\s+");
            //inputData = ["6", "leathers", "255", "fragments", "7", "Shards", ...]

            for (int index = 0; index <= inputData.length - 1; index += 2) {
                int quantity = Integer.parseInt(inputData[index]); //количество
                String material = inputData[index + 1].toLowerCase(); //вид на събрания материал с малки букви

                //проверка какъв материал сме събрали -> събираме
                if (material.equals("shards") || material.equals("fragments") || material.equals("motes")) {
                    //валиден материал
                    int currentQuantity = materials.get(material);
                    materials.put(material, currentQuantity + quantity);
                } else {
                    //материалът е боклук
                    if(!junks.containsKey(material)) {
                        junks.put(material, quantity);
                    } else {
                        int currentQuantity = junks.get(material);
                        junks.put(material, currentQuantity + quantity);
                    }
                }

                //проверка дали сме спечелили легендарния предмет
                if (materials.get("shards") >= 250) {
                    System.out.println("Shadowmourne obtained!");
                    materials.put("shards", materials.get("shards") - 250);
                    isWin = true;
                    break;
                } else if (materials.get("fragments") >= 250) {
                    System.out.println("Valanyr obtained!");
                    materials.put("fragments", materials.get("fragments") - 250);
                    isWin = true;
                    break;
                } else if (materials.get("motes") >= 250) {
                    System.out.println("Dragonwrath obtained!");
                    materials.put("motes", materials.get("motes") - 250);
                    isWin = true;
                    break;
                }

            }

            if (isWin) {
                break;
            }
        }

        //всички валидни материали -> materials
        //entry: материал (key): количество (value)
        materials.entrySet().forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));

        //всички боклуци -> junks
        //entry: материал (key): количество (value)
        junks.entrySet().forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));
    }
}
