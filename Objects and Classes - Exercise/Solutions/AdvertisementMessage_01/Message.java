package AdvertisementMessage_01;

import java.util.Random;

public class Message {

    private Random random = new Random();

    private String[] phrases = {"Excellent product.", "Such a great product.",
            "I always use that product.", "Best product of its category."
            , "Exceptional product.", "I can’t live without this product."};
    private String[] events = {"Now I feel good.", "I have succeeded with this product.",
            "Makes miracles. I am happy of the results!",
            "I cannot believe but now I feel awesome.",
            "Try it yourself, I am very satisfied.", "I feel great!"};
    private String[] author = {"Diana", "Petya", "Stella", "Elena", "Katya", "Iva", "Annie", "Eva"};
    private String[] town = {"Burgas", "Sofia", "Plovdiv", "Varna", "Ruse"};

    public String randomMessage() {

        return String.format("%s %s %s - %s",
                phrases[random.nextInt(phrases.length)],
                events[random.nextInt(events.length)],
                author[random.nextInt(author.length)],
                town[random.nextInt(town.length)]);
    }
}
