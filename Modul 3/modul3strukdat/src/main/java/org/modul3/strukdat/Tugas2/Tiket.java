package org.modul3.strukdat.Tugas2;

class Tiket {
    String namaPemesan;
    int jumlahTiket;
    int nomor;

    Tiket(String namaPemesan, int jumlahTiket, int nomor) {
        this.namaPemesan = namaPemesan;
        this.jumlahTiket = jumlahTiket;
        this.nomor = nomor;
    }

    @Override
    public String toString() {
        return "Nomor Tiket: " + nomor + "\nNama Pemesan: " + namaPemesan + "\nJumlah Tiket: " + jumlahTiket + "\n";
    }
}
