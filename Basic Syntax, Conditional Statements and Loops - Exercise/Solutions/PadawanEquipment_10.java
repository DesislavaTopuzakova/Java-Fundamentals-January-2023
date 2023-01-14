package BasicSyntax;

import java.util.Scanner;

public class PadawanEquipment_10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //обща сума = сума за мечове + сума за одежди + сума за колани
        //1. сума за мечове = бр. мечове(ученици + 10%) * цена за мечовете(вход)
        //2. сума за одежди = бр. одежди = бр. ученици * цена за одеждите(вход)
        //3. сума за колани = бр. коланите (ученици - ученици / 6)  * цена за коланите(вход)
        double budget = Double.parseDouble(scanner.nextLine());
        int studentsCount = Integer.parseInt(scanner.nextLine());
        double priceLight = Double.parseDouble(scanner.nextLine());
        double priceRobe = Double.parseDouble(scanner.nextLine());
        double priceBelt = Double.parseDouble(scanner.nextLine());

        double sumLight = Math.ceil(studentsCount + 0.10 * studentsCount) * priceLight; //1.1 * studentsCount
        double sumRobes = studentsCount * priceRobe;
        double sumBelts = (studentsCount - studentsCount / 6) * priceBelt;

        double totalSum = sumLight + sumRobes + sumBelts; //крайната сума за плащане

        if(totalSum <= budget) {
            System.out.printf("The money is enough - it would cost %.2flv.", totalSum);
        } else {
            double needMoney = totalSum - budget;
            System.out.printf("George Lucas will need %.2flv more.", needMoney);
        }


    }
}