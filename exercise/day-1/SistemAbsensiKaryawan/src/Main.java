import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Masukkan nama karyawan: ");
        String namaKaryawan = sc.nextLine();

        System.out.println("Masukkan jam masuk: ");
        while (!sc.hasNextInt()) {
            System.out.println("Input tidak valid! Masukkan angka.");
            sc.next();
        }
        int jamMasuk = sc.nextInt();

        System.out.println("Masukkan gaji harian karyawan: ");
        while (!sc.hasNextDouble()) {
            System.out.println("Input tidak valid! Masukkan angka.");
            sc.next();
        }
        double gaji = sc.nextDouble();

        String statusKehadiran = "";
        double potonganGaji = 0;
        if(jamMasuk <= 800){
            statusKehadiran = "Tepat Waktu";
        }else if (jamMasuk >= 801 && jamMasuk <= 815){
            statusKehadiran = "Terlambat Ringan";
            potonganGaji = gaji*0.01;
        }else if (jamMasuk >= 816 && jamMasuk <= 830){
            statusKehadiran = "Terlambat Sedang";
            potonganGaji = gaji*0.03;
        }else if (jamMasuk > 830){
            statusKehadiran = "Terlambat Berat";
            potonganGaji = gaji*0.05;
        }

        gaji-=potonganGaji;

        System.out.println("\n===== Laporan Kehadiran =====");
        System.out.println("Nama Karyawan   : " + namaKaryawan);
        System.out.println("Status Kehadiran: " + statusKehadiran);
        System.out.println("Potongan Gaji   : Rp " + potonganGaji);
        System.out.println("Gaji Setelah Potong: Rp " + gaji);
    }
}
