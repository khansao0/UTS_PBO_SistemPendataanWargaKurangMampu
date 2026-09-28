/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PendataanWarga;

/**
 *
 * @author qonitah
 */
public class WargaLansia extends Warga{
    // atribut
    private int umur;
    private String kondisiKesehatan;

    // constructor subclass
    public WargaLansia(String nik, String nama, String alamat, int jumlahTanggungan, KriteriaKemiskinan kriteria, int umur, String kondisiKesehatan) {
        // inheritance
        super(nik, nama, alamat, jumlahTanggungan, kriteria);
        setUmur(umur);
        setKondisiKesehatan(kondisiKesehatan);
    }

    public int getUmur() {
        return umur;
    }

    public void setUmur(int umur) {
        if (umur >= 60) {
            this.umur = umur;
        } else {
            System.out.println("Umur lansia minimal 60 tahun! Otomatis diset 60.");
            this.umur = 60;
        }
    }

    public String getKondisiKesehatan() {
        return kondisiKesehatan;
    }

    public void setKondisiKesehatan(String kondisiKesehatan) {
        this.kondisiKesehatan = kondisiKesehatan;
    }

    // Overriding
    
    @Override
    public void tampilkanInfo() {
        System.out.println("[KATEGORI: WARGA LANSIA]");
        super.tampilkanInfo();
        System.out.println("Umur            : " + umur + " tahun");
        System.out.println("Kondisi Kesehatan: " + kondisiKesehatan);
    }
}
