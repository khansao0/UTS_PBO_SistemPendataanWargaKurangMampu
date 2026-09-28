/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PendataanWarga;

/**
 *
 * @author qonitah
 */
public class Warga {
    // Atribut
    private String nik;
    private String nama;
    private String alamat;
    private int jumlahTanggungan;
    private KriteriaKemiskinan kriteria;

    // Constructor
    public Warga(String nik, String nama, String alamat, int jumlahTanggungan, KriteriaKemiskinan kriteria) {
        this.nik = nik;
        this.nama = nama;
        this.alamat = alamat;
        setJumlahTanggungan(jumlahTanggungan);
        this.kriteria = kriteria;
    }

    // getter dan setter
    public String getNik() {
        return nik;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public int getJumlahTanggungan() {
        return jumlahTanggungan;
    }

    public void setJumlahTanggungan(int jumlahTanggungan) {
        if (jumlahTanggungan >= 0) {
            this.jumlahTanggungan = jumlahTanggungan;
        } else {
            System.out.println("Jumlah tanggungan tidak boleh negatif! Diset ke 0.");
            this.jumlahTanggungan = 0;
        }
    }

    public KriteriaKemiskinan getKriteria() {
        return kriteria;
    }

    public void setKriteria(KriteriaKemiskinan kriteria) {
        this.kriteria = kriteria;
    }

    public void tampilkanInfo() {
        System.out.println("NIK             : " + nik);
        System.out.println("Nama            : " + nama);
        System.out.println("Alamat          : " + alamat);
        System.out.println("Jml Tanggungan  : " + jumlahTanggungan);
        if (kriteria != null) {
            System.out.println("Pekerjaan       : " + kriteria.getJenisPekerjaan());
            System.out.println("Pendapatan/Bln  : Rp " + kriteria.getPendapatanBulanan());
            System.out.println("Status Rumah    : " + kriteria.getStatusRumah());
        }
    }
}
