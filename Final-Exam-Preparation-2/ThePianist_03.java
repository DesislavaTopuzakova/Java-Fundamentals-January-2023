package ExamPreparation2;

import java.util.*;

public class ThePianist_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //СЪХРАНИМ ИНФОРМАЦИЯТА ЗА ПИЕСИТЕ
        int countPieces = Integer.parseInt(scanner.nextLine()); //брой на пиеси

        //запис: пиеса -> списък с информация {композитор, тоналност}
        Map<String, List<String>> piecesMap = new LinkedHashMap<>();

        for (int piece = 1; piece <= countPieces; piece++) {
            String []pieceData = scanner.nextLine().split("\\|");
            //"{piece}|{composer}|{key}".split("|") -> ["{piece}", "{composer}", "{key}"]

            String pieceName = pieceData[0]; //име на пиесата
            String composer = pieceData[1]; //композитора на пиесата
            String tone = pieceData[2];     //тоналност на пиесата

            //създаваме списък с информация
            List<String> piecesInfo = new ArrayList<>(); //празен списък -> {}
            piecesInfo.add(composer); //[0] - първо място
            piecesInfo.add(tone); //[1] - второ място

            piecesMap.put(pieceName, piecesInfo);
        }

        //МОДИФИЦИРАМЕ ИНФОРМАЦИЯТА ЗА ПИЕСИТЕ СПРЯМО КОМАНДИ
        String command = scanner.nextLine();
        while (!command.equals("Stop")) {
            //валидна команда
            if (command.contains("Add")) {
                //command = "Add|{piece}|{composer}|{key}".split("|") -> ["Add", "{piece}", "{composer}", "{key}"]
                String pieceName = command.split("\\|")[1]; //име на пиесата за добавяне
                String composer = command.split("\\|")[2];; //име на композитора на пиесата за доабвяне
                String tone = command.split("\\|")[3];; //тоналност на пиесата за добавяне

                //имаме такава пиеса
                if (piecesMap.containsKey(pieceName)) {
                    System.out.println(pieceName +" is already in the collection!");
                } else {
                    //нямаме такава пиеса -> добавяме
                    List<String> piecesInfo = new ArrayList<>(); //празен списък -> {}
                    piecesInfo.add(composer); //[0] - първо място
                    piecesInfo.add(tone); //[1] - второ място
                    piecesMap.put(pieceName, piecesInfo);
                    System.out.printf("%s by %s in %s added to the collection!%n", pieceName, composer, tone);
                }
            } else if (command.contains("Remove")) {
                //command = "Remove|{piece}".split("|") -> ["Remove", "{piece}"]
                String pieceToRemove = command.split("\\|")[1]; //пиеса, която трябва да премахнем
                //имаме такава пиеса
                if (piecesMap.containsKey(pieceToRemove)) {
                    piecesMap.remove(pieceToRemove);
                    System.out.printf("Successfully removed %s!%n", pieceToRemove);
                } else {
                    //нямаме такава пиеса
                    System.out.printf("Invalid operation! %s does not exist in the collection.%n", pieceToRemove);
                }

            } else if (command.contains("ChangeKey")) {
                //command = "ChangeKey|{piece}|{new key}".split("|") -> ["ChangeKey", "{piece}", "{newTone}"]
                String pieceName = command.split("\\|")[1]; //пиеса, на която ще променим тоналността
                String newTone = command.split("\\|")[2]; //новата тоналност

                //нямаме такава пиеса
                if (!piecesMap.containsKey(pieceName)) {
                    System.out.printf("Invalid operation! %s does not exist in the collection.%n", pieceName);
                } else {
                    //имаме такава пиеса
                    List<String> pieceInfo = piecesMap.get(pieceName); //списък: {композитора, тоналността}
                    pieceInfo.set(1, newTone); //променяме текущата тоналност
                    piecesMap.put(pieceName, pieceInfo);
                    System.out.printf("Changed the key of %s to %s!%n", pieceName, newTone);
                }
            }

            command = scanner.nextLine();
        }

        //"{Piece} -> Composer: {composer}, Key: {key}"
        //entry: пиеса -> списък с информация {[0] -> композитора, [1] -> тоналност}
        //entry.getKey() -> име на пиесата
        //entry.getValue() -> {[0] -> композитора, [1] -> тоналност}
        //entry.getValue().get(0) -> композитора
        //entry.getValue().get(1) -> тоналност

        piecesMap.entrySet() //всички записи
                .forEach(entry ->
                    System.out.printf("%s -> Composer: %s, Key: %s%n",
                                entry.getKey(), entry.getValue().get(0), entry.getValue().get(1)));


    }
}
