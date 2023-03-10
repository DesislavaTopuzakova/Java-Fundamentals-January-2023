public class DemoChars {
    public static void main(String[] args) {
        char letter = 'T';
        int number = 66;

        System.out.println((int) letter); //ascii кода на моя символ
        System.out.println((char) number); //символа с дадения ascii код

        System.out.println('a' + 'c'); //int + int = int
        System.out.println("" + 'a' + 'c'); //"" + 'a' = "a" + 'c' = "ac"
    }
}
