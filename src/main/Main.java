/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;

import java.util.Scanner;
import PendataanWarga.DataPusatWarga;
import PendataanWarga.KriteriaKemiskinan;
import PendataanWarga.WargaDisabilitas;
import PendataanWarga.WargaLansia;

/**
 *
 * @author qonitah
 */
public class Main {
    private static Scanner input = new Scanner(System.in);

    // validasi angka
    private static int inputAngka(String pesan) {
        while (true) {
            System.out.print(pesan);
            if (input.hasNextInt()) {
                int val = input.nextInt();
                input.nextLine();
                return val;
            } else {
                System.out.println("Input harus angka!");
                input.next();
            }
        }
    }

    // validasi desimal
    private static double inputDesimal(String pesan) {
        while (true) {
            System.out.print(pesan);
            if (input.hasNextDouble()) {
                double val = input.nextDouble();
                input.nextLine();
                return val;
            } else {
                System.out.println("Input harus berupa angka!");
                input.next();
            }
        }
    }

    public static void main(String[] args) {
        DataPusatWarga pusatData = new DataPusatWarga("data01", "08 September 2026", true);
        int pilihan = 0;

        // Perulangan
        do {
            System.out.println("\n--------------------------------------------");
            System.out.println("  PENDATAAN WARGA KURANG MAMPU");
            System.out.println("--------------------------------------------");
            System.out.println("1. Tambah Data Warga (Create)");
            System.out.println("2. Tampilkan Data Warga (Read)");
            System.out.println("3. Ubah Data Warga (Update)");
            System.out.println("4. Hapus Data Warga (Delete)");
            System.out.println("5. Keluar");
            
            pilihan = inputAngka("Pilih menu (1-5): ");

            switch (pilihan) {
                case 1:
                    System.out.println("\n--- TAMBAH DATA WARGA ---");
                    System.out.println("Pilih Kategori Warga:");
                    System.out.println("1. Warga Lansia");
                    System.out.println("2. Warga Disabilitas");
                    int kat = inputAngka("Pilih Kategori (1-2): ");

                    System.out.print("Masukkan NIK            : ");
                    String nik = input.nextLine();
                    System.out.print("Masukkan Nama           : ");
                    String nama = input.nextLine();
                    System.out.print("Masukkan Alamat         : ");
                    String alamat = input.nextLine();
                    
                    int tanggungan = -1;
                    while (tanggungan < 0) {
                        tanggungan = inputAngka("Masukkan Jml Tanggungan : ");
                        if (tanggungan < 0) System.out.println("Jumlah tanggungan tidak boleh minus!");
                    }

                    double pendapatan = -1;
                    while (pendapatan < 0) {
                        pendapatan = inputDesimal("Masukkan Pendapatan/Bln : ");
                        if (pendapatan < 0) System.out.println("Pendapatan tidak boleh minus!");
                    }

                    System.out.print("Masukkan Status Rumah   : ");
                    String statusRumah = input.nextLine();

                    System.out.print("Masukkan ID Kriteria    : ");
                    String idKriteria = input.nextLine();
                    System.out.print("Masukkan Jenis Pekerjaan: ");
                    String jenisPekerjaan = input.nextLine();

                    KriteriaKemiskinan kriteria = new KriteriaKemiskinan(idKriteria, jenisPekerjaan, pendapatan, statusRumah);

                    if (kat == 1) {
                        int umur = -1;
                        while (umur < 60) {
                            umur = inputAngka("Masukkan Umur (Min 60)  : ");
                            if (umur < 60) System.out.println("Kategori lansia minimal berumur 60 tahun!");
                        }
                        System.out.print("Masukkan Kondisi Kesehatan: ");
                        String kesehatan = input.nextLine();

                        pusatData.tambahWarga(new WargaLansia(nik, nama, alamat, tanggungan, kriteria, umur, kesehatan));
                    } else if (kat == 2) {
                        System.out.print("Masukkan Jenis Disabilitas : ");
                        String disabilitas = input.nextLine();
                        System.out.print("Kebutuhan Alat Bantu       : ");
                        String alatBantu = input.nextLine();

                        pusatData.tambahWarga(new WargaDisabilitas(nik, nama, alamat, tanggungan, kriteria, disabilitas, alatBantu));
                    } else {
                        System.out.println("Pilihan kategori salah, pendaftaran batal.");
                    }
                    break;

                case 2:
                    System.out.println("\n--- DAFTAR WARGA KURANG MAMPU ---");
                    pusatData.tampilkanSemuaWarga();
                    break;

                case 3:
                    pusatData.tampilkanSemuaWarga();
                    if (pusatData.jumlahData() > 0) {
                        int nomorData = inputAngka("Masukkan nomor data yang ingin diubah: ");
                        int idxUpdate = nomorData - 1;

                        if (idxUpdate >= 0 && idxUpdate < pusatData.jumlahData()) {
                            System.out.print("Nama Baru             : ");
                            String namaBaru = input.nextLine();
                            System.out.print("Alamat Baru           : ");
                            String alamatBaru = input.nextLine();
                            
                            int tanggunganBaru = -1;
                            while (tanggunganBaru < 0) {
                                tanggunganBaru = inputAngka("Jml Tanggungan Baru   : ");
                                if (tanggunganBaru < 0) System.out.println("Jumlah tanggungan tidak boleh minus!");
                            }

                            double pendapatanBaru = -1;
                            while (pendapatanBaru < 0) {
                                pendapatanBaru = inputDesimal("Pendapatan Baru/Bln   : ");
                                if (pendapatanBaru < 0) System.out.println("Pendapatan tidak boleh minus!");
                            }

                            System.out.print("Status Rumah Baru     : ");
                            String statusRumahBaru = input.nextLine();

                            boolean sukses = pusatData.ubahWarga(idxUpdate, namaBaru, alamatBaru, tanggunganBaru, pendapatanBaru, statusRumahBaru);
                            if (sukses) {
                                System.out.println("Data warga berhasil diperbarui!");
                            } else {
                                System.out.println("Nomor data tidak valid.");
                            }
                        } else {
                            System.out.println("Nomor data tidak valid.");
                        }
                    }
                    break;

                case 4:
                    pusatData.tampilkanSemuaWarga();
                    if (pusatData.jumlahData() > 0) {
                        int nomorHapus = inputAngka("Masukkan nomor data yang ingin dihapus: ");
                        int idxHapus = nomorHapus - 1;

                        boolean suksesHapus = pusatData.hapusWarga(idxHapus);
                        if (suksesHapus) {
                            System.out.println("Data warga berhasil dihapus!");
                        } else {
                            System.out.println("Nomor data tidak valid.");
                        }
                    }
                    break;

                case 5:
                    System.out.println("Terima kasih telah menggunakan program ini!");
                    break;

                default:
                    System.out.println("Pilihan tidak valid! Masukkan angka 1 sampai 5.");
            }

        } while (pilihan != 5);

        input.close();
    }
}
