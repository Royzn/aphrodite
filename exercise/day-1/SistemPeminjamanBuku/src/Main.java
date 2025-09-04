import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Masukkan nama anggota: ");
        String name = sc.nextLine();

        System.out.println("Masukkan jenis anggota (Mahasiswa/Dosen/Umum): ");
        String category = sc.nextLine();

        System.out.println("Masukkan jumlah hari sejak peminjaman: ");
        while (!sc.hasNextInt()) {
            System.out.println("Input tidak valid! Masukkan angka.");
            sc.next();
        }
        int days = sc.nextInt();

        int dayMax = 0;
        double penaltyPerDay = 0;

        switch (category.toLowerCase()){
            case "mahasiswa":
                dayMax = 14;
                penaltyPerDay = 1000;
                break;
            case "dosen":
                dayMax = 21;
                penaltyPerDay = 2000;
                break;
            case "umum":
                dayMax = 7;
                penaltyPerDay = 500;
                break;
            default:
                System.out.println("Jenis keanggotaan tidak diketahui.");
                return;
        }

        int lateDay = days - dayMax;
        double penaltyVal = 0;
        String status = "";

        if(lateDay > 30){
            penaltyVal = penaltyPerDay * lateDay;
            status = "Suspensi";
        } else if(lateDay > 0){
            penaltyVal = penaltyPerDay * lateDay;
            status = "Terlambat";
        } else status = "Tepat Waktu";

        System.out.println("\n===== Informasi Peminjaman =====");
        System.out.println("Nama Anggota            : " + name);
        System.out.println("Status                  : " + status);
        if (penaltyVal > 0) {
            System.out.println("Total Denda             : Rp " + penaltyVal);
        } else {
            System.out.println("Total Denda             : Rp 0");
        }
    }
}
