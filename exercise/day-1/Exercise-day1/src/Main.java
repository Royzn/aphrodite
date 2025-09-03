//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

//        1. **Cerita Kue Andi**
//        Andi punya 12 kue. Dia kasih 4 kue ke adiknya. Berapa kue yang tersisa?
//        Operator apa yang bisa dipakai untuk menghitungnya?

        int kueAndi = 12;
        int kueAdik = 0;
        //operator yang digunakan adalah + dan -
        kueAdik += 4;
        kueAndi -=4;
        System.out.println("Kue Andi sekarang: " + kueAndi + " kue adik sekarang: " + kueAdik);

//        2. **Cerita Ongkir Toko Online**
//        Sebuah toko online pasang ongkir Rp 25.000. Saat promo, ongkir dipotong setengah. Berapa ongkir yang harus dibayar?
//        Operator apa yang bisa dipakai untuk menghitungnya?
        int biayaOngkir = 25000;
        // terdapat potongan setengah artiny perlu operator / dengan 2
        biayaOngkir /= 2;
        System.out.println("Biaya ongkir setelah potongan: " + biayaOngkir);

//        3. **Cerita Permen Sinta**
//        Sinta punya 20 permen dan mau dibagi rata ke 6 temannya. Berapa sisa permen yang tidak terbagi?
//        Operator apa yang bisa dipakai untuk menghitung sisa pembagian?

        int permenSinta = 20;
        // dibagi rata ke 6 temannya. sisa permen bisa didapat dengan modulo terhadap 6 (%)

        int sisaPermen = permenSinta % 6;
        System.out.println("Sisa permen Sinta: " + sisaPermen);

//        4. **Cerita Point Game**
//        Seorang pemain game punya 80 point. Setiap naik level, point bertambah 15. Setelah naik level sekali, berapa total point pemain itu?
//        Operator apa yang bisa dipakai untuk menambahkan point dengan cepat?
        int skorPemain = 80;
        // pemain bertambah level sekali. berarti ia mendapatkan 15 poin.

        skorPemain+=15;
        System.out.println("Skor pemain sekarang: " + skorPemain);

//        5. **Cerita Tiket Bioskop**
//        Budi mau nonton film. Syaratnya, hanya boleh masuk kalau umur ≥ 18. Jika umur Budi 16, apakah dia bisa masuk?
//        Operator apa yang digunakan untuk membandingkan umur dengan syarat tersebut?
        int umurBudi = 16;
        int umurSyaratMasuk = 18;
        //kira menggunakan boolean untuk mengetahui apakah umur budi memenuhi syarat atau tidak
        boolean apakahBolehMasuk = (umurBudi >= umurSyaratMasuk);

        System.out.println("Budi " + (apakahBolehMasuk ? "Boleh" : "Tidak Boleh") + " Masuk");
    }
}