package org.modul1.tugas;

public class Barang<A,B> {
    private A Nama;
    private B Harga;
    private Jenis jenis;

    public Barang(A Nama, B Harga, Jenis jenis) {
        this.Nama = Nama;
        this.Harga = Harga;
        this.jenis = jenis;
    }

    public A getNama() {
        return Nama;
    }

    public void setNama(A nama) {
        Nama = nama;
    }

    public B getHarga() {
        return Harga;
    }

    public void setHarga(B harga) {
        Harga = harga;
    }

    public Jenis getJenis() {
        return jenis;
    }

    public void setJenis(Jenis jenis) {
        this.jenis = jenis;
    }
}

