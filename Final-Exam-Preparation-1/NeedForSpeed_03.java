package ExamPreparation1;

import java.util.*;

public class NeedForSpeed_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //запис: кола -> {км, гориво}
        Map<String, List<Integer>> carsMap = new LinkedHashMap<>();

        int countCars = Integer.parseInt(scanner.nextLine());
        for (int car = 1; car <= countCars; car++) {
            String [] data = scanner.nextLine().split("\\|");
            //"Skoda|12000|34".split("|")
            //data = ["Skoda", "13", "34"]
            String carModel = data[0]; //модел на колата
            int mileage = Integer.parseInt(data[1]); //изминати км
            int fuel = Integer.parseInt(data[2]); //налично гориво

            carsMap.putIfAbsent(carModel, new ArrayList<>());
            carsMap.get(carModel).add(0, mileage);
            carsMap.get(carModel).add(1, fuel);
        }


        String input = scanner.nextLine();

        while (!input.equals("Stop")) {
            if (input.contains("Drive")) {
                //ШОФИРАНЕ
                //input = "Drive : {car} : {distance} : {fuel}".split(" : ") -> ["Drive", "AudiA6", "230" , "6"]
                String car = input.split(" : ")[1]; //коя кола искаме да караме
                int distance = Integer.parseInt(input.split(" : ")[2]); //колко км искаме да я караме
                int consumedFuel = Integer.parseInt(input.split(" : ")[3]); //колко гориво ще изразходим

                //1. имаме достатъчно гориво за каране
                int currentFuel = carsMap.get(car).get(1); //текущо количество на гориво в колата
                int currentKm = carsMap.get(car).get(0); //текущи км на колата

                if (currentFuel >= consumedFuel) {
                    //отиваме на пътешествие
                    carsMap.get(car).set(1, currentFuel - consumedFuel);
                    carsMap.get(car).set(0, currentKm + distance);
                    System.out.printf("%s driven for %d kilometers. %d liters of fuel consumed.%n", car, distance, consumedFuel);
                } else {
                    //нямаме достатъчно количество за каране currentFuel < consumedFuel
                    System.out.println("Not enough fuel to make that ride");
                }

                //проверка дали я премахваме
                if (carsMap.get(car).get(0) >= 100000) {
                    //колата е стара -> продаваме
                    System.out.println("Time to sell the " + car + "!");
                    carsMap.remove(car);
                }

            } else if (input.contains("Refuel")) {
                //ЗАРЕЖДАНЕ
                //input = "Refuel : AudiA6 : 35".split(" : ") -> ["Refuel", "AudiA6", "35"]
                String carToRefill = input.split(" : ")[1]; //кола за зареждане
                int fuelToRefill = Integer.parseInt(input.split(" : ")[2]); //колко литра зареждаме

                int currentFuel = carsMap.get(carToRefill).get(1);//текущо количество гориво
                if (currentFuel + fuelToRefill > 75) {
                    //max = 75 и го слагаме в колата
                    carsMap.get(carToRefill).set(1, 75);
                    System.out.printf("%s refueled with %d liters%n", carToRefill, 75 - currentFuel);
                } else {
                    //не достигаме 75 литра
                    carsMap.get(carToRefill).set(1, currentFuel + fuelToRefill);
                    System.out.printf("%s refueled with %d liters%n", carToRefill, fuelToRefill);
                }
            } else if (input.contains("Revert")) {
                //ВРЪЩАМЕ КИЛОМЕТРАЖА
                //input = "Revert : Audi A6 : 120000".split(" : ") -> ["Revert", "Audi A6", "120000"]
                String carToRevert = input.split(" : ")[1]; //кола, която ще модифицираме
                int kmRevert = Integer.parseInt(input.split(" : ")[2]); //км за модификация
                int currentKm = carsMap.get(carToRevert).get(0); //текущи км на колата

                int kmAfterRevert = currentKm - kmRevert; //км след връщането

                if (kmAfterRevert < 10000) {
                    kmAfterRevert = 10000;
                } else {
                    System.out.printf("%s mileage decreased by %d kilometers%n", carToRevert, kmRevert);
                }

                carsMap.get(carToRevert).set(0, kmAfterRevert);


            }
            input = scanner.nextLine();
        }

        //entry
        //key: кола
        //value: {км, гориво}
        carsMap.entrySet().forEach(entry -> {
            System.out.printf("%s -> Mileage: %d kms, Fuel in the tank: %d lt.%n", entry.getKey(), entry.getValue().get(0), entry.getValue().get(1));
        });
    }
}
