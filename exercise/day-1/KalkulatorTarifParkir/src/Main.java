import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Masukkan jenis kendaraan (Mobil/Motor): ");
        String jenisKendaraan = sc.nextLine();

        System.out.println("Lama parkir dalam jam: ");
        while (!sc.hasNextInt()) {
            System.out.println("Input tidak valid! Masukkan angka.");
            sc.next();
        }
        int durasiParkir = sc.nextInt();

        if (durasiParkir <= 0) {
            System.out.println("Durasi parkir tidak valid.");
            return;
        }

        int biayaParkir = 0;

        switch (jenisKendaraan.toLowerCase()){
            case "motor":
                for(int i = 1; i <= durasiParkir ; i++){
                    if (i<=2) biayaParkir+=2000;
                    else biayaParkir+=1000;
                    if(biayaParkir == 10000) break;
                }
                break;
            case "mobil":
                for(int i = 1; i <= durasiParkir ; i++){
                    if (i<=2) biayaParkir+=5000;
                    else biayaParkir+=2000;
                    if(biayaParkir > 25000){
                        biayaParkir = 25000;
                        break;
                    }
                }
                break;
            default:
                System.out.println("Tipe kendaraan tidak diketahui");
                return;
        }

        System.out.println("\n===== Struk Parkir =====");
        System.out.println("Jenis Kendaraan : " + jenisKendaraan);
        System.out.println("Durasi Parkir   : " + durasiParkir + " jam");
        System.out.println("Biaya Parkir    : Rp " + biayaParkir);
    }
}