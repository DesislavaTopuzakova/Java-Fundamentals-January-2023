package ExamPreparation2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MirrorWords_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        //"@mix#tix3dj#poOl##loOp#wl@@bong&song%4very$long@thong#Part##traP##@@leveL@@Level@##car#rac##tu@pack@@ckap@#rr#sAw##wAs#r#@w1r"
        //1. намираме двойките думи
        String regex = "(#|@)(?<first>[A-Za-z]{3,})\\1\\1(?<second>[A-Za-z]{3,})\\1";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        //matcher -> съвкупност от всички двойки думи, които отговарят на условието
        //matcher = ["#poOl##loOp#", "#Part##traP#", "@leveL@@Level@"]


        List<String> validPairs = new ArrayList<>(); //списък с валидни двойки
        int countAllPairs = 0; //брой на всички двойки

        //2. проверка коя двойка думи е валидна
        while (matcher.find()) {
            //matcher.find -> "#(?<first>poOl)##(?<second>loOp)#"
            String firstWord = matcher.group("first");
            String secondWord = matcher.group("second");
            countAllPairs++; //броя всяка намерена двойка думи

            //първата дума = втората дума обърната на обратно
            String secondWordReversed = new StringBuilder(secondWord).reverse().toString();
            if (firstWord.equals(secondWordReversed)) {
                //валидна двойка: {първа дума} <=> {втора дума}
                validPairs.add(firstWord + " <=> " + secondWord);

            }

        }

        //ако нямаме намерени двойки думи
        if (countAllPairs == 0) {
            System.out.println("No word pairs found!");
        } else {
            //намерили сме двойки думи
            System.out.println(countAllPairs + " word pairs found!");
        }

        //отпечатваме само ВАЛИДНИТЕ ДВОЙКИ
        if (validPairs.size() == 0) {
            //нямаме валидни двойки
            System.out.println("No mirror words!");
        } else {
            //имаме валидни двойки
            System.out.println("The mirror words are:");
            System.out.println(String.join(", ", validPairs));
        }

    }
}
