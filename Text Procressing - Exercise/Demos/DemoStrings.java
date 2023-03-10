public class DemoStrings {
    public static void main(String[] args) {
        String name = "Desislava";

        //1. дължина на текст = брой символи
        System.out.println(name.length());

        //2. само главни букви
        System.out.println(name.toUpperCase());

        //3. само с малки букви
        System.out.println(name.toLowerCase());

        //4. в масив от символи: "Desislava" -> ['D', 'e', 's', 'i', 's', 'l', 'a', 'v', 'a']
        char [] symbols = name.toCharArray();

        //5. сравняване на текстове -> true, false
        System.out.println("Desislava".equals(name));
        System.out.println("DeSIslava".equalsIgnoreCase(name)); //не прави разлика между малки и главни букви

        //6. достъпваме символ от текста
        //позиция (индекс) = 0 -> първия символ
        //позиция (индекс) = дължина на текст - 1 -> последния символ
        System.out.println(name.charAt(0));
        System.out.println(name.charAt(name.length() - 1));

        //7. съдържа определен текст -> true (ако се съдържа), false (ако не се съдържа)
        System.out.println(name.contains("Des"));

        //8. започва с опеределен текст -> true (ако започва), false (ако не започва)
        System.out.println(name.startsWith("De"));

        //9. завършва на определен текст -> true (ако завършва), false (ако не завършва)
        System.out.println(name.endsWith("lava"));

        //10. премахва интервалите в началото и края на текста
        System.out.println(" Desislava   ".trim());

        //11. заменя първото срещане на даден текст / символ
        name.replace("va", "ta"); //"Desislava" -> "Desislata"
        name.replace('v', 'r'); //"Desislava" -> "Desislara"

        //12. заменя всички срещания на текста
        name.replaceAll("a", "b"); //"Desislava" -> "Desislbvb"

        //13. повтаряме текста даден брой пъти
        System.out.println(name.repeat(5)); //"DesislavaDesislavaDesislavaDesislavaDesislava"

        //14. текст, който е част от друг текст
        //"Desislava" -> "sislava"
        System.out.println(name.substring(2));
        //"Desislava" -> "esis"
        System.out.println(name.substring(1, 5));

        //EXAMPLE
        String test = "I am enjoying programming";
        System.out.println(test.substring(5, 13));
        String text = "enjoying";
        int index = test.indexOf(text); //индексът на първата буква на текста = 5
        System.out.println(test.substring(index, index + text.length()));







    }
}