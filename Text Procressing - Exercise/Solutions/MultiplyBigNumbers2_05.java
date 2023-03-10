package TextProcessing;

import java.util.Scanner;

public class MultiplyBigNumbers2_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String first = scanner.nextLine();
        int second = Integer.parseInt(scanner.nextLine());
        StringBuilder sb = new StringBuilder();
        int remain = 0;
        int printable = 0;
        for (int i = first.length() - 1; i >= 0; i--) {
            int digit = Integer.parseInt(first.substring(i, i + 1));
            int current = digit * second;
            current += remain;
            sb.append((current % 10));
            remain = current / 10;
        }
        if (remain != 0) {
            sb.append(remain);
        }
        boolean zero = true;
        for (int i = 0; i < sb.length(); i++) {
            if (Integer.parseInt(sb.substring(i, i + 1)) != 0) {
                zero = false;
            }
        }
        if (zero) {
            System.out.println(0);
        } else {
            StringBuilder output = new StringBuilder();
            boolean trailing = true;
            for (int i = sb.length() - 1; i >= 0; i--) {
                if (Integer.parseInt(sb.substring(i, i + 1)) == 0 && trailing) {

                } else {
                    trailing = false;
                    output.append(sb.charAt(i));
                }
            }
            System.out.println(output.toString());
        }
    }
}
