# Minpro-2-PBO-SistemPendataanWargaKurangMampu <br>  

# Judul : Sistem Pendataan Warga Kurang Mampu  

---

## 1. Deskripsi Singkat Program  
Pada program ini saya membuat sistem sederhana berbasis CLI untuk membantu proses pendataan warga yang berhak menerima bantuan sosial. di dalam program ini juga bisa menambah data warga, menampilkan daftar warga yang udah di input, mengubah data kalau ada yang salah, dan menghapus data dari daftar. Program ini lebih berfokus pada pendataan warga kurang mampu dan penyaluran bantuan sosial dari pemerintah. Lalu pada sistem ini dikembangkan lebih baik lagi dengan menerapkan konsep Inheritance atau Pewarisan, untuk membagi kategori warga (Warga Lansia dan Warga Disabilitas), pengintegrasian class KriteriaKemiskinan, validasi input yang lebih ketat, serta penyediaan dummy data awal di dalam ArrayList.

---  

## 2. Penjelasan Class & Atribut  
Pada project ini, strukturnya dibagi ke beberapa class, yaitu:  

Pada Package PendataanWarga disini ada :  

* **Warga (superclass)** 
  * nik
  * nama
  * alamat
  * jumlahTanggungan
 
* **WargaLansia (subclass)**
  * umur
  * kondisiKesehatan
 
* **WargaDisabilitas (subclass)**
  * jenisDisabilitas
  * kebutuhanAlatBantu
 
* **KriteriaKemiskinan**
  * idKriteria
  * jenisPekerjaan
  * pendapatanBulanan
  * statusRumah

* **DataPusatWarga**
  * idData
  * tanggalPendataan
  * statusValidasi
  * daftarWargaKurangMampu (ArrayList)  

Pada Package main disini ada :  
* **Main** (Entry point)

---

## 3. Penjelasan tiap Class 

* **Warga**
  * Penjelasan class: Pada class ini saya pakai untuk menyimpan informasi data diri warga.
  * Pada class ini saya menggunakan atribut ber-access modifier private (encapsulation) yaitu nik, nama, alamat, jumlahTanggungan, serta objek kriteria dari class KriteriaKemiskinan.
  * Saya juga menggunakan constructor, getter, setter, serta validasi di setJumlahTanggungan agar nilainya tidak bisa minus (kalau kurang dari 0 bakal otomatis ke 0 lagi ke set), serta method tampilkanInfo() yang nantinya di-override oleh subclass.

* **WargaLansia**
  * Penjelasan class: Class turunan (subclass) pertama dari class Warga yang khusus menampung data warga kategori lansia.
  * Pada class ini saya menggunakan atribut tambahan umur dan kondisiKesehatan.
  * Saya juga menggunakan super pada constructor untuk memanggil atribut induknya, terdapat validasi pada setUmur agar umur lansia minimal 60 tahun, serta menerapkan method overriding pada tampilkanInfo() untuk mencetak data lansia. Pada setUmur juga jika menginput umur dibawah 60, maka tidak dapat dan melakukan isi ulang umur yang sesuai kriteria.

* **WargaDisabilitas**
  * Penjelasan class: Class turunan (subclass) kedua dari class Warga yang khusus menampung data warga kategori penyandang disabilitas.
  * Pada class ini saya menggunakan atribut tambahan jenisDisabilitas dan kebutuhanAlatBantu.
  * Saya juga menggunakan super pada constructor serta menerapkan method overriding pada tampilkanInfo() untuk menampilkan informasi spesifik kebutuhan alat bantu dan jenis disabilitasnya.  

* **KriteriaKemiskinan**
  * Penjelasan class: Pada class ini saya gunakan untuk menampung atau syarat status ekonomi dan kelayakan warga.
  * Atribut yang dipakai meliputi idKriteria, jenisPekerjaan, pendapatanBulanan, dan statusRumah.
  * Pada class ini saya menggunakan validasi pada setPendapatanBulanan agar nilainya tidak bernilai negatif.

* **DataPusatWarga**
  * Penjelasan Class: dan disini pusat pengolahan data dan penyimpanan sementara.
  * Memiliki atribut idData, tanggalPendataan, statusValidasi, serta daftarWargaKurangMampu yang menggunakan ArrayList untuk menampung data-data warga secara dinamis. Kenapa cuma di class ini yang pakai ArrayList? Karena class ini yang bertugas sebagai pengelola/pusat data yang menampung banyak objek warga sekaligus, sedangkan class Warga atau KriteriaKemiskinan fokus membentuk satu struktur data individunya saja.
  * disini penggunaaan (Create, Read, Update, Delete).

* **Main**
  * Penjelasan Class: disini entry point nya sebagai tempat program.
  * disini saya memasukkan perulangan menu dan Scanner untuk membaca input pilihan.
 
---  

## 4. Penjelasan Penerapan Encapsulation & Inheritance  
* **Encapsulation**
  * Pada program ini, semua atribut pada setiap class (Warga, WargaLansia, WargaDisabilitas, KriteriaKemiskinan, DataPusatWarga) menggunakan access modifier private, agar variabel tidak bisa diakses secara langsung dari luar class.
  * Untuk mengakses dan mengubah nilainya, saya menggunakan method getter dan setter.
  * Terdapat validasi data pada setter, seperti :
  * setJumlahTanggungan: Jika input minus, otomatis di set ke 0.
  * setPendapatanBulanan: Mengembalikan pesan error dan mengatur nilai ke 0 jika input negatif.
  * setUmur pada WargaLansia: Memastikan umur lansia minimal 60 tahun (jika kurang dari 60, otomatis diset ke 60).

* **Inheritance**
  * Class Warga bertindak sebagai Superclass yang menyimpan data umum (NIK, Nama, Alamat, Tanggungan, Kriteria).
  * Class WargaLansia dan WargaDisabilitas bertindak sebagai Subclass yang mewarisi (extends) class Warga.
  * Pada Inheritance ini saya menggunakan super pada constructor subclass untuk meneruskan data dasar ke superclass, dan super.tampilkanInfo() untuk memanggil cetakan informasi dari superclass.

---

## 5. Penjelasan Alur Program dan Dokumentasi Output  
Saat program dijalankan, sistem otomatis memanggil method isiDataAwal() di DataPusatWarga untuk mengisikan dummy data awal ke ArrayList, sehingga data warga langsung tampil saat menu Read pertama kali dipilih.  

Pada saat program dijalankan, nanti nya akan menampilkan menu utama di terminal dengan 5 pilihan: <br>  

<img width="500" alt="image" src="https://github.com/user-attachments/assets/531efc68-2e02-4367-a393-c8fef6045e25" />  

1. **Tambah Data Warga (Create):**
Kita bisa memasukkan NIK, nama, alamat, sama jumlah tanggungan. Nanti datanya akan tersimpan otomatis ke sistem. Pada menu ini dilengkapi fungsi validasi input (inputAngka & inputDesimal) jika pengguna salah memasukkan tipe data (seperti menginput teks pada pendapatan/bulan). Di sini juga ada validasi input, misalnya saat salah menginputkan pendapatan pakai tulisan "Rp", sistem bakal nolak dan menampilkan tulisan "Input harus berupa angka!" lalu meminta input ulang sampai benar. Setelah berhasil, nanti ada output "Yeyy Data Berhasil ditambahkan!" <br>

<img width="500" alt="WhatsApp Image 2026-09-21 at 9 00 32 PM" src="https://github.com/user-attachments/assets/58c67b1c-d7e4-4980-b8b2-bf67e574f41e" /> <br>

tampilan saat sudah ditambah <br>
<img width="500" alt="WhatsApp Image 2026-09-21 at 9 01 18 PM" src="https://github.com/user-attachments/assets/a910d990-7c5d-4fe5-88d5-b1247b98e92e" />


2. **Tampilkan Data Warga (Read):**
Menampilkan daftar semua warga yang ada di dalam ArrayList lengkap dengan kategori dan kriteria kemiskinannya. Dipakai buat mengecek dan menampilkan semua daftar warga yang sudah tersimpan di sistem. Di sini langsung tampil data warga lansia (Mbah Maimunah) dan warga disabilitas (Rahmat Hidayat) hasil dari dummy data. <br>

<img width="500" alt="WhatsApp Image 2026-09-21 at 8 55 44 PM" src="https://github.com/user-attachments/assets/c4d071e8-e9e3-4d61-8779-985737f06755" />

3. **Ubah Data Warga (Update):**
Pengguna memasukkan nomor data warga yang ingin diubah. Buat menghapus data warga dari daftar kalau memang sudah tidak diperlukan lagi, cukup ketik nomor data yang mau dihapus (contoh memilih nomor data 3).
Nanti ada pemberitahuan "Data warga berhasil dihapus!" <br>

<img width="500" alt="WhatsApp Image 2026-09-21 at 9 03 18 PM" src="https://github.com/user-attachments/assets/ee2d9bfb-c7bf-4cfb-8282-f6b57f04796a" />

5. **Hapus Data Warga (Delete):**
Buat menghapus data warga dari list kalau memang sudah tidak diperlukan lagi, cukup ketik nomor data yang mau dihapus. <br>

<img width="500" alt="WhatsApp Image 2026-09-21 at 9 04 10 PM" src="https://github.com/user-attachments/assets/f42e8f0a-2382-49c2-bb44-b111031c0b27" />

tampilan pas sudah dihapus <br>  

<img width="500" alt="WhatsApp Image 2026-09-21 at 9 04 54 PM" src="https://github.com/user-attachments/assets/e8e422d0-915d-4324-ac8b-adbd00afeb68" />  

5. **Keluar:**
menutup program, nanti ada output "Terima kasih telah menggunakan program ini" <br>

<img width="500" alt="WhatsApp Image 2026-09-21 at 9 05 25 PM" src="https://github.com/user-attachments/assets/52b41631-3f68-4bd8-9d39-b878940ee0f6" />

---  

## 6. Penerapan Nilai Tambah  
1. Polymorphism menggunakan method overriding, Saya terapkan pada method tampilkanInfo() di subclass WargaLansia dan WargaDisabilitas. Method ini meng override method tampilkanInfo() milik superclass Warga agar bisa mencetak data spesifik tiap kategori (seperti umur dan kondisi kesehatan untuk lansia, serta jenis disabilitas dan kebutuhan alat bantu untuk disabilitas).  

2. konsep Inheritance (mewariskan atribut umum dari class Warga ke class WargaLansia dan WargaDisabilitas) dan Polymorphism (meng-override method tampilkanInfo() agar tampilan tiap kategori warga bisa menyesuaikan secara dinamis).
 
3. Selain itu, seluruh inputan angka dan desimal di menu utama sudah dipasangi fungsi validasi khusus (inputAngka dan inputDesimal) agar saat pengguna tidak sengaja memasukkan teks atau huruf, program tidak langsung crash atau error.

4. Validasi logika bisnis pada setter (seperti umur lansia minimal 60 tahun di setUmur(), serta tanggungan dan pendapatan yang tidak boleh bernilai negatif).

5. Dummy Data Awal, menggunakan pemanggilan method isiDataAwal() pada constructor DataPusatWarga yang langsung mengisikan data WargaLansia dan WargaDisabilitas ke dalam ArrayList saat program pertama kali dijalankan.








