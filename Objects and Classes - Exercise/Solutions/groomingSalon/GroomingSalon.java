package groomingSalon;

import java.util.ArrayList;
import java.util.List;

public class GroomingSalon {
    //полета -> характеристики (списък с дом. животни, капацитет)
    private List<Pet> data;
    private int capacity;

    //конструктор
    public GroomingSalon(int capacity) {
        //нов празен обект {capacity = 0, data = null}
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    //методи -> действия

    //Add
    public void add(Pet pet) {
        if (this.data.size() < this.capacity) {
            this.data.add(pet);
        }
    }

    //Remove
    public boolean remove(String name) {
        //true -> ако има такова животно с даденото име и го премахна
        //false -> ако няма такова животно с даденото име

        for (Pet pet : this.data) {
            if (pet.getName().equals(name)) {
                this.data.remove(pet);
                return true;
            }
        }
        //обходила всички животни в списъка
        return false;
    }

    //getPet
    public Pet getPet(String name, String owner) {
        //ако има животно с дадените параметри -> връщаме го
        //няма животно с дадените параметри -> връщаме null
        for (Pet pet : this.data) {
            if (pet.getName().equals(name) && pet.getOwner().equals(owner)) {
                return pet;
            }
        }
        //обходила всички животни в списъка
        return null;
    }

    //getCount
    public int getCount() {
        return this.data.size();
    }

    //getStatistics
    public String getStatistics() {
        String output = "";

        output += "The grooming salon has the following clients:\n";

        for (Pet pet : this.data) {
            output += pet.getName() + " " + pet.getOwner() + "\n";
        }

        return output;
    }
}
