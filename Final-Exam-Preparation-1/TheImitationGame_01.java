package ExamPreparation1;

import java.util.Scanner;

public class TheImitationGame_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String encryptedMessage = scanner.nextLine(); //криптирано съобщение
        StringBuilder modifyMessage = new StringBuilder(encryptedMessage); //модифицирам криптираното съобщение

        String input = scanner.nextLine();

        while (!input.equals("Decode")){

            if (input.contains("Move")) {
                //input = "Move|5".split("|") -> ["Move", "5"]
                int lettersCount = Integer.parseInt(input.split("\\|")[1]);
                //"owyouh" -> първите 5 букви "owyou" -> "howyou"
                String firstLetters = modifyMessage.substring(0, lettersCount); //буквите за местене ("owyou")
                modifyMessage.replace(0, lettersCount, ""); //заместваме с нищо
                //modifyMessage.delete(0, lettersCount); //изтриваме буквите
                modifyMessage.append(firstLetters);
            } else if (input.contains("Insert")) {
                //input = "Insert|2|abc".split("|") -> ["Insert", "2", "abc"]
                int index = Integer.parseInt(input.split("\\|")[1]); //индекс, на който ще вмъкваме
                String textToInsert = input.split("\\|")[2]; //текста, който трябва да вмъкнем
                modifyMessage.insert(index, textToInsert);
            } else if (input.contains("ChangeAll")) {
                //input = "ChangeAll|abc|wqe".split("|") -> ["ChangeAll", "abc", "wqa"]
                String textForChange = input.split("\\|")[1]; //текст, който трябва да се променя
                String replacement = input.split("\\|")[2];  //текст, който ще замества

                String currentMessage = modifyMessage.toString(); //моментното съобщение
                currentMessage = currentMessage.replace(textForChange, replacement);
                modifyMessage = new StringBuilder(currentMessage);
            }
            input = scanner.nextLine();
        }

        System.out.println("The decrypted message is: " + modifyMessage);


    }
}
