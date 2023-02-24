package Articles_02;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String articleData = scanner.nextLine();
        //"Holy Ghost, content, John Sandford"
        String[] articleParts = articleData.split(", ");
        // ["Holy Ghost", "content", "John Sandford"]
        String title = articleParts[0];
        String content = articleParts[1];
        String author = articleParts[2];

        Article article = new Article(title, content, author);

        int n = Integer.parseInt(scanner.nextLine()); //брой на командите
        for (int commandCount = 1; commandCount <= n; commandCount++) {
            String command = scanner.nextLine();
            //"Edit: {ново съдържание}"
            //"Rename: {ново заглавие}"
            //"ChangeAuthor"
            if (command.contains("Edit")) {
                //променя съдържанието на моята статия с даденото
                //command = "Edit: test is good".split(": ") -> ["Edit", "test is good"]
                String newContent = command.split(": ")[1]; //ново съдържание
                article.edit(newContent);
            } else if (command.contains("Rename")) {
                //променя заглавието на моята статия с даденото
                //command = "Rename: TestTitle".split(": ") -> ["Rename", "TestTitle"]
                String newTitle = command.split(": ")[1]; //ново заглавие
                article.rename(newTitle);
            } else if (command.contains("ChangeAuthor")) {
                //променя автора на моята статия с дадения
                //command = "ChangeAuthor: Test Testov".split(": ") -> ["ChangeAuthor", "Test Testov"]
                String newAuthor = command.split(": ")[1]; //новия автор
                article.changeAuthor(newAuthor);
            }
        }

        //{title} - {съдържание}: {автора}
        System.out.println(article.toString());
    }
}
