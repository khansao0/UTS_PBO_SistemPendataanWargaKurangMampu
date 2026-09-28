/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PendataanWarga;

import java.util.ArrayList;

/**
 *
 * @author qonitah
 */
public class DataPusatWarga {
    // atribut
    private String idData;
    private String tanggalPendataan;
    private boolean statusValidasi;
    
    // array list nya
    private ArrayList<Warga> daftarWargaKurangMampu;
    
    // constructor
    public DataPusatWarga(String idData, String tanggalPendataan, boolean statusValidasi) {
        this.idData = idData;
        this.tanggalPendataan = tanggalPendataan;
        this.statusValidasi = statusValidasi;
        this.daftarWargaKurangMampu = new ArrayList<>();
        
        isiDataAwal();
    }

    // data awal
    private void isiDataAwal() {
        KriteriaKemiskinan k1 = new KriteriaKemiskinan("K01", "Buruh Harian", 500000, "Numpang");
        KriteriaKemiskinan k2 = new KriteriaKemiskinan("K02", "Pedagang Keliling", 750000, "Sewa");

        daftarWargaKurangMampu.add(new WargaLansia("6472010101500001", "Mbah Maimunah", "Jl. Gerilya No. 12", 1, k1, 68, "Hipertensi"));
        daftarWargaKurangMampu.add(new WargaDisabilitas("6472010203950002", "Rahmat Hidayat", "Jl. Siradj Salman No. 04", 3, k2, "Tunawicara", "Kursi Roda"));
    }
    
    // Method tambah data (create)
    public void tambahWarga(Warga warga) {
        this.daftarWargaKurangMampu.add(warga);
        System.out.println("Yeyy Data Berhasil ditambahkan");
    }
    
    // overloading tambah warga dengan catatan tambahan
    public void tambahWarga(Warga warga, String catatan) {
        this.daftarWargaKurangMampu.add(warga);
        System.out.println("Yeyy Data Berhasil ditambahkan!");
        System.out.println("Catatan: " + catatan);
    }
    
    // Method tampil data (read)
    public void tampilkanSemuaWarga() {
        if (this.daftarWargaKurangMampu.isEmpty()) {
            System.out.println("Belum ada data warga.");
        } else {
            System.out.println("------------------------------------------");
            for (int i = 0; i < daftarWargaKurangMampu.size(); i++) {
                System.out.println("Data ke-" + (i + 1));
                // Dynamic Polymorphism
                daftarWargaKurangMampu.get(i).tampilkanInfo();
                System.out.println("------------------------------------------");
            }
        }    
    }

    // overloading buat tampilkan data berdasarkan jumlah minimal tanggungan
    public void tampilkanSemuaWarga(int minTanggungan) {
        if (this.daftarWargaKurangMampu.isEmpty()) {
            System.out.println("Belum ada data warga.");
        } else {
            System.out.println("--- DAFTAR WARGA DENGAN TANGGUNGAN >= " + minTanggungan + " ---");
            System.out.println("------------------------------------------");
            for (int i = 0; i < daftarWargaKurangMampu.size(); i++) {
                if (daftarWargaKurangMampu.get(i).getJumlahTanggungan() >= minTanggungan) {
                    System.out.println("Data ke-" + (i + 1));
                    daftarWargaKurangMampu.get(i).tampilkanInfo();
                    System.out.println("------------------------------------------");
                }
            }
        }
    }
    
    // Method untuk Mengubah Data (Update)
    public boolean ubahWarga(int index, String namaBaru, String alamatBaru, int tanggunganBaru, double pendapatanBaru, String statusRumahBaru) {
        if (index >= 0 && index < daftarWargaKurangMampu.size()) {
            Warga w = daftarWargaKurangMampu.get(index);
            w.setNama(namaBaru);
            w.setAlamat(alamatBaru);
            w.setJumlahTanggungan(tanggunganBaru);
            if (w.getKriteria() != null) {
                w.getKriteria().setPendapatanBulanan(pendapatanBaru);
                w.getKriteria().setStatusRumah(statusRumahBaru);
            } else {
                w.setKriteria(new KriteriaKemiskinan("K-NEW", "Umum", pendapatanBaru, statusRumahBaru));
            }
            return true;
        }
        return false;
    }

    // Method untuk Menghapus Data (Delete)
    public boolean hapusWarga(int index) {
        if (index >= 0 && index < daftarWargaKurangMampu.size()) {
            daftarWargaKurangMampu.remove(index);
            return true;
        }
        return false;
    }

    public int jumlahData() {
        return daftarWargaKurangMampu.size();
    }

    // getter setter
    public String getIdData() { return idData; }
    public String getTanggalPendataan() { return tanggalPendataan; }
    public boolean getStatusValidasi() { return statusValidasi; }
}