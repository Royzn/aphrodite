# Pre-Test: Spring Data JPA & Spring Web Development

## Bagian A – Pilihan Ganda (10 Soal)

1. Annotation apa yang digunakan untuk menandai sebuah class sebagai **Entity** di JPA?

```
 a) `@Table`
**b) `@Entity`**
 c) `@Column`
 d) `@Repository`

```

2. Untuk membuat **primary key** otomatis bertambah di JPA, annotation yang digunakan adalah:

```
**a) `@GeneratedValue`**
 b) `@Id`
 c) `@PrimaryKey`
 d) `@AutoIncrement`
```

3. Apa fungsi `JpaRepository` di Spring Data JPA?

```
   a) Menyediakan konfigurasi database
**b) Menyediakan implementasi CRUD secara otomatis**
   c) Membuat koneksi HTTP
   d) Mengganti controller
```

4. Annotation apa yang digunakan untuk **REST Controller** di Spring Web?

```
   a) `@Controller`
**b) `@RestController`**
   c) `@Service`
   d) `@Component`
```

5. Untuk membuat mapping endpoint `/api/users` dengan method GET, digunakan:

```
**a) `@GetMapping("/api/users")`**
   b) `@PostMapping("/api/users")`
   c) `@RequestMapping("/api/users", method=POST)`
   d) `@RestMapping("/api/users")`
```

6. Annotation `@Column(nullable = false)` berarti:

```
   a) Kolom boleh kosong
**b) Kolom tidak boleh `null`**
   c) Kolom tidak akan muncul di tabel
   d) Kolom adalah primary key
```

7. Apa kegunaan `@Autowired` dalam Spring?

```
   a) Mengatur database schema
**b) Melakukan dependency injection**
   c) Menambahkan logging
   d) Membuat endpoint REST
```

8. Saat kita menggunakan `findById(id)` pada `JpaRepository`, return type biasanya adalah:

```
 a) `Entity`
 **b) `Optional<Entity>`**
 c) `List<Entity>`
 d) `Map<String, Entity>`
```

9. Annotation `@RequestBody` digunakan untuk:

```
 a) Mengambil query parameter dari URL
**b) Mengambil data JSON dari body request**
 c) Mengambil header request
 d) Mengambil path variable
```

10. Spring Boot secara default menggunakan database apa untuk **in-memory testing**?

```
    a) MySQL
    b) PostgreSQL
  **c) H2**
    d) MongoDB
```

---

## Bagian B – True / False (5 Soal)

1. `@Entity` hanya bisa digunakan sekali di satu aplikasi. (F)
2. `@Repository` digunakan untuk menandai interface JPA repository. (T)
3. `@RestController` sudah termasuk `@ResponseBody` secara default. (T)
4. `JpaRepository` harus selalu diimplementasikan secara manual. (F)
5. `@PathVariable` digunakan untuk mengambil nilai dari URL. (T)

---

## Bagian C – Isian Singkat (5 Soal)

1. Sebutkan perbedaan utama antara `@Controller` dan `@RestController` di Spring Web.
   Jawaban: Terletak di fungsinya. `@Controller` digunakan untuk mengembalikan view html dan perlu declare `@ResponseBody` untuk mengembalikan
   response data. Sedangkan, `@RestController` diperuntukkan untuk membuat Restful API sehingga `@ResponseBody` sudah include.
2. Apa perbedaan `save()` dan `saveAll()` di JPA?
   Jawaban: `save()` digunakan untuk menyimpan 1 entitas saja. `saveall()` digunakan untuk menyimpan banyak entitas sekaligus.
3. Bagaimana cara membuat relasi **OneToMany** antara `User` dan `Order` di JPA?
   Jawaban: Menambahkan `@OneToMany` pada List order di dalam entitas User dan `@ManyToOne` pada Order. 
4. Apa fungsi dari `application.properties` di Spring Boot?
   Jawaban: Untuk konfigurasi aplikasi spring boot.
5. Sebutkan 2 keuntungan menggunakan Spring Data JPA dibanding JDBC manual.
   Jawaban:
   1. Mengurangi kode karena sudah otomatis diatur oleh JPA Spring Data untuk kebutuhan repository.
   2. Dapat membuat query otomatis berdasarkan nama method.

---

## Bagian D – Perbaikan Kode (5 Soal)

**Soal 1**

```java
@Entity
public class User {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY) //jawaban
   private Long id;
   private String name;
}
```

Buat agar id auto increment.

---

**Soal 2**

```java
@RestController
public class UserController {
   @AutoWired //jawaban
   private UserRepository userRepository; //jawaban

   @GetMapping("/users")
   public List<User> getAllUsers() {
       return userRepository.findAll();
   }
}
```

Perbaiki error dependency injection `userRepository`.

---

**Soal 3**

```java
public interface UserRepository extends JpaRepository<User, Long> {
   User findByName(String name);
}
```

Ubah agar bisa menggunakan Spring Data JPA.

---

**Soal 4**

```java
@PostMapping("/users")
public User addUser(@RequestBody User user) { //menambahkan @RequestBody 
   return userRepository.save(user);
}
```

Perbaiki agar data bisa diterima dari request body JSON.

---

**Soal 5**

```java
@Entity
public class Order {
   @Id
   @GeneratedValue
   private Long id;

   @ManyToOne
   private User user;
}

//jawaban
@Entity
public class User {
   @Id
   @GeneratedValue
   private Long id;

   private String name;

   @OneToMany(mappedBy = "user")
   private List<Order> order;
}
```

Tambahkan mapping di sisi `User` agar relasi bidirectional.

---
