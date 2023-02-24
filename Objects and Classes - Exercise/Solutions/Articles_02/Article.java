package Articles_02;

public class Article {
    //полета -> характеристики
    private String title; //заглавие
    private String content; //съдържание
    private String author; //автор

    //конструктор -> създава нови обекти
    //alt + insert -> Constructor
    public Article(String title, String content, String author) {
        //нов обект
        this.title = title;
        this.content = content;
        this.author = author;
    }

    //методи -> поведение
    public void edit (String newContent){
        this.content = newContent;
    }

    public void changeAuthor (String newAuthor) {
        this.author = newAuthor;
    }

    public void rename (String newTitle) {
        this.title = newTitle;
    }

    //вграден метод toString -> превърне обекта в текст -> "{packageName}.{className}@{address}"
    @Override // пренаписва default method
    public String toString() {
        //{title} - {съдържание}: {автора}
        //return this.title + " - " + this.content + ": " + this.author;
        return String.format("%s - %s: %s", this.title, this.content, this.author);
        //вграден метод toString -> превърне обекта в текст -> "{title} - {съдържание}: {автора}"
    }
}
