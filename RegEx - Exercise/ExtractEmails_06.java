package RegEx;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractEmails_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String regex = "[0-9A-Za-z]+[.\\-_]?[0-9A-Za-z]+@[A-Za-z]+-?[A-Za-z]+(\\.[A-Za-z]+-?[A-Za-z]+)+";
        Pattern pattern = Pattern.compile(regex);

        String text = scanner.nextLine();
        Matcher matcher = pattern.matcher(text);
        //text = "Just send email to s.miller@mit.edu and j.hopking@york.ac.uk for more information."
        //matcher = ["s.miller@mit.edu", "j.hopking@york.ac.uk"]

        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
