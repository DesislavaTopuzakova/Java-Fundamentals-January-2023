package groomingSalon;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Initialize the repository
        GroomingSalon salon = new GroomingSalon(20);

// Initialize entity
        Pet dog = new Pet("Ellias", 5, "Tim");

// Print Pet
        System.out.println(dog); // Ellias 5 - (Tim)

// Add Pet
        salon.add(dog);

// Remove Pet
        System.out.println(salon.remove("Ellias")); // true
        System.out.println(salon.remove("Pufa")); // false

        Pet cat = new Pet("Bella", 2, "Mia");
        Pet bunny = new Pet("Zak", 4, "Jon");

        salon.add(cat);
        salon.add(bunny);

// Get Pet
        Pet pet = salon.getPet("Bella", "Mia");
        System.out.println(pet); // Bella 2 - (Mia)

// Count
        System.out.println(salon.getCount()); // 2

// Get Statistics
        System.out.println(salon.getStatistics());
// The grooming salon has the following clients:
//Bella Mia
//Zak Jon

    }
}
