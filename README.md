# Aplikasi GUI Rating Skin CS2

Project ini adalah aplikasi Java Swing yang dirancang untuk menampilkan dan memungkinkan pengguna menilai skin senjata CS2 (Counter-Strike 2). Fitur aplikasi ini mencakup antarmuka pengguna bertema gelap dengan bar judul, bilah samping untuk navigasi (misalnya, berdasarkan jenis senjata), area konten utama yang menampilkan gambar dan nama skin dalam tata letak kartu, dan panel bawah untuk tindakan seperti memberi rating atau menyimpan.

## Showcase

![Screenshot Aplikasi](img/showcase/Screenshot.png)

## Konsep Pemrograman Berorientasi Objek (OOP) yang Digunakan

Project ini, yang sekarang terstruktur dalam beberapa file Java (terletak di direktori `src`: `src/CS2SkinRating.java`, `src/TopBarPanel.java`, `src/SidebarPanel.java`, `src/Button.java`, `src/CardDisplayPanel.java`, `src/SkinCard.java`, `src/BottomBarPanel.java`), mendemonstrasikan beberapa konsep OOP kunci:

### 1. Class dan Object

*   **Class:** Blueprint untuk membuat objek.
    *   `src/CS2SkinRating.java`: Kelas jendela aplikasi utama.
    *   `src/TopBarPanel.java`, `src/SidebarPanel.java`, `src/Button.java`, `src/CardDisplayPanel.java`, `src/SkinCard.java`, `src/BottomBarPanel.java`: Kelas kustom yang mewakili berbagai bagian atau komponen UI. Masing-masing mengenkapsulasi struktur dan perilaku spesifiknya.
    *   Kelas Swing seperti `JFrame`, `JPanel`, `JButton`, `JLabel`, dll., digunakan secara ekstensif.
*   **Object:** Instance dari sebuah kelas.
    *   `new CS2SkinRating()`: Membuat instance dari jendela aplikasi utama.
    *   `TopBarPanel topBarPanel = new TopBarPanel()`: Membuat instance dari `TopBarPanel`.
    *   `SkinCard card = new SkinCard(...)`: Membuat instance dari `SkinCard`.

### 2. Pewarisan (Relasi IS-A)

*   **Konsep:** Mekanisme di mana kelas baru (subclass atau kelas turunan) mewarisi properti dan metode dari kelas yang sudah ada (superclass atau kelas dasar).
*   **Contoh:**
    *   `public class CS2SkinRating extends JFrame`
        *   Kelas `CS2SkinRating` *adalah* `JFrame`.
    *   `public class TopBarPanel extends JPanel` (dan serupa untuk `CardDisplayPanel`, `SkinCard`, `BottomBarPanel`)
        *   Kelas panel kustom ini *adalah* `JPanel`, mewarisi fungsionalitas JPanel dan menambahkan konten dan perilaku khusus.
    *   `public class SidebarPanel extends Button`
        *   Kelas `SidebarPanel` *adalah* `Button`.
    *   `public class Button extends JPanel`
        *   Kelas `Button` *adalah* `JPanel`.

### 3. Enkapsulasi

*   **Konsep:** Menggabungkan data (atribut) dan metode (fungsi) yang beroperasi pada data di dalam satu unit (sebuah kelas). Ini juga melibatkan pembatasan akses langsung ke beberapa komponen objek.
*   **Contoh:**
    *   Kelas `CS2SkinRating` mengenkapsulasi instance dari `TopBarPanel`, `SidebarPanel`, `JScrollPane` (yang berisi `CardDisplayPanel`), dan `BottomBarPanel`.
    *   Setiap kelas panel khusus (misalnya, `TopBarPanel`) mengenkapsulasi komponen UI-nya sendiri (seperti `JLabel` untuk judul, `JButton` untuk Discord/Ko-Fi) dan logika untuk pengaturan dan tata letaknya. Misalnya, pembuatan dan styling tombol "Join Discord" sepenuhnya ditangani dalam `TopBarPanel`.
    *   Kelas `SkinCard` mengenkapsulasi label gambar dan label nama untuk satu skin, beserta logika untuk memuat dan menampilkan gambar.

### 4. Abstraksi

*   **Konsep:** Menyembunyikan detail implementasi yang kompleks dan hanya menunjukkan fitur-fitur penting dari sebuah objek. Ini membantu dalam mengelola kompleksitas dengan menyediakan tampilan yang disederhanakan.
*   **Contoh:**
    *   Ketika Anda menggunakan `JButton button = new JButton("Click Me");`, Anda berinteraksi dengan sebuah abstraksi. Anda tidak perlu tahu bagaimana tombol digambar di layar, bagaimana tombol menangani klik mouse pada level rendah, atau bagaimana teksnya dirender. Anda hanya menggunakan metode-metodenya seperti `setBackground()`, `setForeground()`, `addActionListener()`.
    *   Kelas `JFrame` sendiri mengabstraksi sistem jendela dasar dari sistem operasi.
    *   Kelas `CS2SkinRating`, secara keseluruhan, menyediakan abstraksi untuk "jendela aplikasi rating skin."

### 5. Polimorfisme (Banyak Bentuk)

*   **Konsep:** Kemampuan sebuah objek untuk mengambil banyak bentuk. Penggunaan polimorfisme yang paling umum dalam OOP terjadi ketika referensi kelas induk digunakan untuk merujuk ke objek kelas anak.
*   **Contoh:**
    *   **Method Overriding:** Meskipun tidak secara eksplisit meng-override metode dari `JFrame` dalam cuplikan constructor yang diberikan (selain secara implisit melalui siklus hidupnya), jika `CS2SkinRating` akan meng-override metode seperti `paintComponent` (lebih umum untuk `JPanel`), itu akan menjadi polimorfisme.
    *   Metode `run()` dalam kelas anonymous `Runnable`:
        ```java
        SwingUtilities.invokeLater(new Runnable() {
            @Override // Anotasi ini menunjukkan overriding
            public void run() {
                new CS2SkinRating().setVisible(true);
            }
        });
        ```
        Metode `run()` didefinisikan dalam interface `Runnable`, dan kelas anonymous memberikan implementasi spesifik untuknya.
    *   **Penambahan Komponen:** Metode seperti `mainPanel.add(component, constraint)` dapat menerima objek apa pun yang *adalah* `Component` (mis., `JPanel`, `JLabel`, `JButton`). Metode `add` berperilaku secara polimorfik berdasarkan tipe sebenarnya dari komponen yang ditambahkan.

### 6. Komposisi (Relasi HAS-A)

*   **Konsep:** Membangun objek yang kompleks dengan menggabungkan objek-objek yang lebih sederhana. Satu objek "memiliki" instance dari objek lain.
*   **Contoh:**
    *   `CS2SkinRating` (yang merupakan `JFrame`) *memiliki* `TopBarPanel`, `SidebarPanel`, `JScrollPane` (yang pada gilirannya *memiliki* `CardDisplayPanel`), dan `BottomBarPanel`.
        *   `mainPanel.add(topBarPanel, BorderLayout.NORTH);`
        *   `mainPanel.add(sidebarPanel, BorderLayout.WEST);`
    *   `CardDisplayPanel` *memiliki beberapa* objek `SkinCard`.
        *   `add(card);` (dalam loop `CardDisplayPanel`)
    *   `TopBarPanel` *memiliki* `JLabel` (`titleLabel`) dan `JPanel` lain (`topRightButtonsPanel`).
    *   Ini menunjukkan bagaimana jendela aplikasi utama terdiri dari beberapa objek panel UI yang berbeda, masing-masing bertanggung jawab atas bagian dari antarmuka secara keseluruhan.

Aplikasi ini secara efektif menggunakan prinsip-prinsip OOP ini untuk membuat struktur GUI yang modular, dapat dipelihara, dan dapat diperluas.

## Struktur Komponen UI

Berikut adalah representasi hierarki komponen UI utama dalam aplikasi:

```
CS2SkinRating (extends JFrame)
├── TopBarPanel (extends JPanel)
├── SidebarPanel (extends custom Button)
├── CardDisplayPanel (extends JPanel)
│   └── SkinCard[] (extends JPanel)
├── BottomBarPanel (extends JPanel)
└── Button (utility class)
```

## Kompilasi dan Menjalankan dari Command Line

Untuk mengompilasi dan menjalankan Project ini dari Command Line atau Terminal:

1.  **Navigasi ke Root Project:**
    Buka terminal atau command prompt dan navigasikan ke direktori root Project (mis., `c:\Users\rifk\Desktop\OOP\SwingGui\`).

2.  **Kompilasi File Java:**
    Semua file sumber Java terletak di direktori `src`. Gunakan perintah berikut untuk mengompilasinya. File `.class` yang terkompilasi juga akan ditempatkan di direktori `src`.
    ```bash
    javac src/*.java
    ```
    (Di Windows, Anda mungkin juga menggunakan `javac src\*.java`)

3.  **Jalankan Aplikasi:**
    Setelah kompilasi berhasil, jalankan kelas aplikasi utama (`CS2SkinRating`). Anda perlu menentukan direktori `src` dalam classpath agar Java dapat menemukan file `.class` yang terkompilasi.
    ```bash
    java -cp src CS2SkinRating
    ```

Pastikan Anda memiliki Java Development Kit (JDK) yang terinstal dan dikonfigurasi dengan benar di sistem Anda agar perintah-perintah ini berfungsi.

