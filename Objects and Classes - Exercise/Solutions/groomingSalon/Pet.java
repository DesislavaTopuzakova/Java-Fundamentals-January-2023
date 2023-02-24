package groomingSalon;

public class Pet {
    //полета -> характеристики (name, age, owner)
    private String name;
    private int age;
    private String owner;

    //конструктор, който създава обект по зададени всички полета
    //alt+insert
    public Pet (String name, int age, String owner) {
        //нов празен обект
        this.name = name;
        this.age = age;
        this.owner = owner;
    }

    //getters and setters

    //field name
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //field age
    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    //field owner
    public String getOwner() {
        return this.owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    //default -> "{package}.{class}@{address}"
    @Override //пренапишем
    public String toString() {
        //"{name} {age} - ({owner})"
        return this.name + " " + this.age + " - (" + this.owner + ")";
    }
}
