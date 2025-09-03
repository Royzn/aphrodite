import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Masukkan nama pembeli: ");
        String namaPembeli = sc.nextLine();

        System.out.println("Masukkan total belanja: ");
        double totalBelanja = sc.nextDouble();
        sc.nextLine();

        System.out.println("Masukkan status membership (Reguler/Premium/Non-member): ");
        String memberStatus = sc.nextLine();

        int discountPerc = 0;
        double discountVal = 0;
        double totalBayar = 0;

        switch (memberStatus.toLowerCase()){
            case "reguler":
                if (totalBelanja >= 500_000){
                    discountPerc = 10;
                    discountVal = totalBelanja * 0.1;
                } else if (totalBelanja >= 100_000) {
                    discountPerc = 5;
                    discountVal = totalBelanja * 0.05;
                }
                break;
            case "premium":
                if (totalBelanja >= 500_000){
                    discountPerc = 20;
                    discountVal = totalBelanja * 0.2;
                } else if (totalBelanja >= 300_000) {
                    discountPerc = 15;
                    discountVal = totalBelanja * 0.15;
                } else if (totalBelanja >= 100_000){
                    discountPerc = 10;
                    discountVal = totalBelanja * 0.1;
                }
                break;
            case "non-member":
                //no discount
                break;
            default:
                System.out.println("Membership tidak dikenali.");
                break;
        }

        totalBayar = totalBelanja - discountVal;

        System.out.println("\n===== Struk Belanja =====");
        System.out.println("Nama Pembeli   : " + namaPembeli);
        System.out.println("Total Belanja  : Rp " + totalBelanja);
        System.out.println("Membership     : " + memberStatus);
        System.out.println("Diskon         : " + discountPerc + "% (Rp " + discountVal + ")");
        System.out.println("Total Bayar    : Rp " + totalBayar);
    }
}