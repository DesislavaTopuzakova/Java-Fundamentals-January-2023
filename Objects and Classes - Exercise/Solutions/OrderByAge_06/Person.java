package OrderByAge_06;

public class Person {
    //полета -> характеристики (name, id, age)
    private String name;
    private String id;
    private int age;

    //constructor
    public Person(String name, String id, int age) {
        //нов празен обект
        this.name = name;
        this.id = id;
        this.age = age;
    }

    //getters
    public String getName() {
        return this.name;
    }

    public String getId() {
        return this.id;
    }

    public int getAge() {
        return this.age;
    }
}
