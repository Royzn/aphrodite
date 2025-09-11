## _Java Spring Boot & Spring Security_

### ✳️ Bagian 1: Pilihan Ganda (Dasar)

1. Apa anotasi yang digunakan untuk mendefinisikan sebuah REST controller?

   - A. `@Service`
   - B. `@Component`
  ** - C. `@RestController`**
   - D. `@Repository`

2. Di Spring, anotasi apa yang digunakan untuk menyuntikkan dependency ke dalam class?

  ** - A. `@Autowired`**
   - B. `@Injectable`
   - C. `@Import`
   - D. `@Mapper`

3. Di lapisan arsitektur Spring, Service berfungsi untuk:

   - A. Menangani permintaan HTTP
   - B. Menyimpan data ke database langsung
   - C. Menyimpan log aplikasi
   **- D. Menyimpan logika bisnis**

4. Class model di Java Spring biasanya digunakan untuk:

   - A. Menyimpan konfigurasi Spring
   - B. Menyimpan logika controller
   **- C. Menyimpan struktur data (seperti data user, produk, dll.)**
   - D. Mengatur pemetaan URL

5. Jika kita ingin membuat method yang bisa diakses oleh endpoint `/hello`, anotasi apa yang digunakan?

   - A. `@RestEndpoint("/hello")`
   - B. `@Path("/hello")`
   **- C. `@GetMapping("/hello")`**
   - D. `@Route("/hello")`

---

### ✳️ Bagian 2: Benar / Salah

6. `@Service` digunakan untuk menandai class sebagai lapisan Controller. (F)
7. Kita bisa membuat class model tanpa anotasi apapun jika hanya digunakan sebagai POJO. (T)
8. `@Autowired` bisa digunakan di constructor maupun field. (T)
9. Spring Boot membutuhkan file `application.yml` agar bisa berjalan. (F)
10. `@GetMapping` hanya bisa digunakan di class dengan anotasi `@Service`. (F)

---

### ✳️ Bagian 3: Isian Singkat

11. Anotasi apa yang digunakan agar method bisa menangani permintaan POST?
    Anotasi yang dapat digunakan adalah `@PostMapping`
12. Apa nama file konfigurasi default di Spring Boot?
    application.attributes atau application.yml
13. Apa yang dimaksud dengan Dependency Injection?
    Dependency injection berarti suatu objek tidak membuat dependency di dalam class itu sendiri melainkan dari eksternal kelas tersebut.
14. Bagaimana cara mendeklarasikan class `UserService` agar dikenali Spring sebagai Service?
    Menambahkan `@Service` saat akan membuat class
15. Apa perbedaan `@RestController` dan `@Controller`?
    `@RestController` menambahkan response body dan membuat controller kita menjadi restful dan dapat mengembalikan JSON. sedangkan `@Controller`
    hanya dapat mengembalikan HTML saja dan perlu specify response body jika ingin mengembalikan JSON.

---

### ✳️ Bagian 4: Perbaiki Kode / Output

16. Perbaiki kode berikut agar dapat dijalankan sebagai Controller:

```java
@RestController //jawaban
public class HelloController {
    @GetMapping("/hello")
    public String hello() {
        return "Hello";
    }
}
```

17. Perbaiki kesalahan pada model berikut:

```java
public class Product {
    private String name;
    private int price;

   //jawaban (agar class Product bisa dibuatkan objectnya)
    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }
}
```

18. Apa output dari method berikut?

```java
@GetMapping("/sum")
public int sum() {
    return 2 + 3;
}

//output = 5
```

19. Kode service berikut error. Apa yang salah?

```java
@Service
public class UserService {
    private UserRepository userRepository;

   //jawaban (perlu ada dependency injection agar repo bisa dipakai)
   public UserService(UserRepository userRepository){
      this.userRepository = userRepository
   }
}
```

20. Apa masalah pada potongan kode berikut?

```java
@RestController
@RequestMapping("/api/book") //perlu ada prefix awal agar getmapping dapat diakses
public class BookController {

    @GetMapping
    public String listBooks() {
        return "books";
    }
}
```

---

### Bagian 5: Spring Security

#### Pilihan Ganda

21. Apa anotasi yang digunakan untuk mengaktifkan Spring Security di aplikasi Spring Boot?

- A. `@EnableSecurity`
- B. `@SpringSecurity`
**- C. `@EnableWebSecurity`**
- D. `@ActivateSecurity`

22. Komponen mana yang bertugas mengatur izin akses berdasarkan role atau otorisasi di Spring Security?

**- A. `SecurityConfig`**
- B. `UserDetailsService`
- C. `AuthenticationManager`
- D. `HttpSecurity`

23. Untuk membuat otentikasi berbasis user login yang dikustomisasi, interface apa yang harus diimplementasi?

- A. `UserRepository`
- B. `UserSecurity`
**- C. `UserDetailsService`**
- D. `SecurityService`

#### Benar / Salah

24. Spring Security hanya bisa digunakan untuk REST API yang menggunakan JWT. (F)
25. `@PreAuthorize("hasRole('ADMIN')")` digunakan untuk membatasi method agar hanya bisa diakses oleh pengguna dengan role ADMIN. (T)
26. `BCryptPasswordEncoder` digunakan untuk mengenkripsi password agar tidak disimpan dalam bentuk plain text. (T)

#### Isian Singkat

27. Apa class konfigurasi yang umum dibuat untuk menyesuaikan aturan login, logout, dan authorization di Spring Security?
    Jawaban: SecurityConfig. di tahap ini kita mengatur bagaimana kita ingin user login, log out, dan tempat untuk konfigurasi path apa saja yang boleh
    diakses oleh role tertentu.
29. Apa anotasi yang digunakan agar method hanya bisa diakses jika pengguna memiliki hak tertentu?
    Jawaban: `@PreAuthorize`. hal ini membuat method hanya bisa dijalankan ketika user memiliki role yang sesuai.

#### Perbaiki Kode / Analisis

29. Perbaiki potongan konfigurasi ini:

```java
@Bean
public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

    //http
    //    .authorizeRequests() // sudah deprecated dan perlu diganti
    //    .antMatchers("/admin").hasRole("ADMIN")
    //    .anyRequest().authenticated()
    //    .and()
    //    .formLogin();
    //return http.build();

   http
        .authorizeHttpRequests(auth -> auth..antMatchers("/admin").hasRole("ADMIN")
        .anyRequest().authenticated())
        .and()
        .formLogin();
    return http.build();
}
```

30. Apa yang salah dengan konfigurasi login berikut?

```java
http
  .authorizeHttpRequests()
  .anyRequest().permitAll()
  .and()
  .formLogin();
```
Konfigurasi ini menyebabkan tiap orang tanpa otentikasi dapat mengakses semua request.
---
