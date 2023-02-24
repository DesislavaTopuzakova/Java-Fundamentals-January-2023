package OpinionPoll_03;

public class Person {
    //полета -> характеристики (име, възраст)
    private String name;
    private int age;

    //конструктор -> метод, чрез който създаваме обекти от клас
    public Person (String name, int age) {
        //нов празен обект
        this.name = name;
        this.age = age;
    }

    //getters -> методи, които ни дават коя е стойността срещу съответното поле
    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }
}
