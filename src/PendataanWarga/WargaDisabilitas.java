/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PendataanWarga;

/**
 *
 * @author qonitah
 */
public class WargaDisabilitas extends Warga {
    // atribut
    private String jenisDisabilitas;
    private String kebutuhanAlatBantu;

    // constructor subclass
    public WargaDisabilitas(String nik, String nama, String alamat, int jumlahTanggungan, KriteriaKemiskinan kriteria, String jenisDisabilitas, String kebutuhanAlatBantu) {
        // inheritance
        super(nik, nama, alamat, jumlahTanggungan, kriteria);
        setJenisDisabilitas(jenisDisabilitas);
        setKebutuhanAlatBantu(kebutuhanAlatBantu);
    }

    public String getJenisDisabilitas() {
        return jenisDisabilitas;
    }

    public void setJenisDisabilitas(String jenisDisabilitas) {
        this.jenisDisabilitas = jenisDisabilitas;
    }

    public String getKebutuhanAlatBantu() {
        return kebutuhanAlatBantu;
    }

    public void setKebutuhanAlatBantu(String kebutuhanAlatBantu) {
        this.kebutuhanAlatBantu = kebutuhanAlatBantu;
    }

    // Overriding
    @Override
    public void tampilkanInfo() {
        System.out.println("[KATEGORI: WARGA DISABILITAS]");
        super.tampilkanInfo();
        System.out.println("Jenis Disabilitas: " + jenisDisabilitas);
        System.out.println("Kebutuhan Alat   : " + kebutuhanAlatBantu);
    }
}
