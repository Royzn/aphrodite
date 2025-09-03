import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Masukkan Nama Siswa: ");
        String name = sc.nextLine();

        System.out.println("Masukkan Nilai Siswa: ");
        while (!sc.hasNextInt()) {
            System.out.println("Input tidak valid! Masukkan angka.");
            sc.next();
        }
        int score = sc.nextInt();

        char grade;

        if (score < 0 || score > 100) {
            System.out.println("Nilai tidak valid. Harus antara 0 sampai 100.");
            return;
        }

        if (score >=90){
            grade = 'A';
        }else if (score >= 80){
            grade = 'B';
        }else if (score >= 70){
            grade = 'C';
        }else if(score >= 60){
            grade = 'D';
        } else grade = 'E';

        System.out.println("\n===== Hasil Penilaian =====");
        System.out.println("Nama Siswa : " + name);
        System.out.println("Nilai      : " + score);
        System.out.println("Grade      : " + grade);
    }
}