package Students_04;

public class Student {
    //полета -> характеристики (firstName, lastName, grade)
    private String firstName;
    private String lastName;
    private double grade;

    //конструктор -> метод, чрез който създаваме обекти от класа
    public Student (String fn, String ln, double grade) {
        //нов празен обект
        this.firstName = fn;
        this.lastName = ln;
        this.grade = grade;
    }

    //getters
    public double getGrade() {
        return this.grade;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }
}
