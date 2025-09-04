## 🧠 **Pre-Test Backend Engineer (Java, OOP, Spring Boot)**

---

### 🔸 **A. Pilihan Ganda (5 Soal)**

1. Apa yang menjadi tanggung jawab utama seorang Backend Engineer?

   - A. Mendesain UI
   - **B. Mengelola logika aplikasi dan komunikasi data dengan database**
   - C. Membuat animasi
   - D. Membuat desain grafis

2. Dalam OOP Java, konsep **encapsulation** berarti:

   - **A. Menyembunyikan detail implementasi dan menyediakan akses lewat method**
   - B. Mewarisi method dari class lain
   - C. Menambahkan method ke dalam class
   - D. Menghubungkan dua class yang berbeda

3. `@Autowired` pada Spring Boot digunakan untuk:

   - A. Menjalankan program utama
   - B. Menyimpan konfigurasi properties
   - **C. Meng-inject dependency otomatis ke dalam bean**
   - D. Mendaftarkan endpoint baru

4. Mengapa sebaiknya logika bisnis diletakkan di service layer?

   - **A. Agar controller lebih ringan dan fokus pada request/response**
   - B. Agar lebih cepat dalam compile
   - C. Karena controller tidak mendukung operasi logika
   - D. Agar dapat digunakan langsung tanpa testing

5. Di bawah ini adalah cara yang benar membuat endpoint di Spring Boot:

   - A. `@Route("/api")`
   - B. `@Mapping("/api")`
   - **C. `@GetMapping("/api")`**
   - D. `@WebRoute("/api")`

---

### 🔸 **B. True / False (5 Soal)**

6. Dalam arsitektur backend, service biasanya dipanggil langsung dari frontend. **FALSE**
7. Constructor Injection adalah cara yang direkomendasikan untuk dependency injection di Spring. **TRUE**
8. `@Service` digunakan untuk menandai sebuah class sebagai penyedia logika bisnis. **TRUE**
9. Semua logika bisa ditaruh dalam controller agar tidak perlu membuat banyak file. **FALSE**
10. Spring Boot memerlukan `main()` method untuk menjalankan aplikasinya. **TRUE**

---

### 🔸 **C. Jawaban Singkat Penjelasan (10 Soal)**

11. Jelaskan apa itu Backend dan bagaimana perannya dalam aplikasi.
    Jawaban: Backend adalah salah satu bagian dari penyusun aplikasi yang bertugas untuk memproses data, menjalankan bisnis logic, dan berinteraksi dengan database
13. Apa perbedaan antara class dan object dalam Java?
    Jawaban: Class lebih seperti template/blueprint. Object adalah hasil dari template/blueprint yang telah dibuat.
15. Sebutkan dan jelaskan 2 prinsip OOP lainnya selain encapsulation.
    Jawaban: Inheritance -> prinsip untuk menurunkan properti dan method dari parent ke child
             Polymorphism -> prinsip di mana class memiliki banyak bentuk.
17. Mengapa kita menggunakan annotation `@RestController`?
    Jawaban: Agar kita dapat menandai bahwa class yang ditandai adalah controller yang handle http request dan bukan bertugas sebagai view
19. Apa keuntungan menggunakan Spring Boot dibanding membuat server dari nol di Java?
    Jawaban: Spring Boot dapat mempercepat pengerjaan aplikasi karena sudah berupa template
21. Jelaskan cara kerja dependency injection di Spring Boot secara sederhana.
    Jawaban: di dalam class, kita tandai class yang kita ingin tandai dengan @Component, @Service, dll. kemudian, jika suatu class membutuhkan objek lain, maka spring boot akan otomatis membantu menginject kebutuhan dependency berikut.
23. Apa manfaat memisahkan controller dan service dalam arsitektur aplikasi?
    Jawaban: memisahkan fokus tanggung jawab antar keduanya dan reusable.
25. Jelaskan apa yang terjadi jika Anda tidak menambahkan `@Service` pada class yang berisi logika.
    Jawaban: Springboot tidak akan mengetahui apakah class tersebut merupakan bagian dari program sehingga dapat menyebabkan class tidak terdeteksi
27. Apa itu `@RequestParam` dan kapan digunakan?
    Jawaban: Dipergunakan untuk mengambil data parameter query saat terdapat request http
29. Bagaimana cara menghubungkan controller ke service menggunakan constructor?
    Jawaban: tandai class sebagai service, panggil class tersebut di dalam constructor controller. 

---

### 🔸 **D. Koreksi Kode (5 Soal)**

> Jelaskan kesalahan dan berikan versi yang benar.

21.

```java
@RestController
public class HelloController {

   public helloService helloService; //tambahan

   public HelloController(helloService helloService){ //tambahan
      this.helloService = helloService;
   }

    @GetMapping("/hello")
    public String hello() {
        return helloService.sayHello(); // error
    }
}
```
perlu memanggil helloServicenya terlebih dahulu agar berfungsi.

22.

```java
public class Person {
    public String name;

    public Person(String name) { // void perlu dihapus
        this.name = name;
    }
}
```
tidak perlu ada void untuk membuat constructor.

23.

```java
@RestController
public class GreetController {
    @PostMapping("/greet")
    public String greet(@RequestBody String name) { // menambahkan datatype String untuk parameter name
        return "Hello, " + name;
    }
}
```
perlu menentukan tipe data dari parameter name

24.

```java
@Service
public class InfoService {
    public String getInfo() {
        return "Info OK";
    }
}

// controller
@RestController
public class InfoController {

   public InfoService info; //tambahan

   public InfoController(InfoService infoService){ //tambahan
      this.info = infoService
   }

    @GetMapping("/info")
    public String get() {
        return info.getInfo();
    }
}
```
perlu declare constructor InfoService terlebih dahulu agar didetect oleh springboot, bukan di dalam method declarenya.


25.

```java
@RestController
public class MathController {
    @GetMapping("/add")
    public int addNumbers(@RequestParam int a, @RequestParam int b) { // penambahan @RequestParam
        return a + b;
    }
}
```
ini berasal dari param sehigga perlu declare @RequestParam



