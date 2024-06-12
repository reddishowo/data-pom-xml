package org.modul3.strukdat.Tugas2_New;

class QueueNode {
    String namaPemesan;
    int jumlahTiket;
    int nomorPemesanan;
    QueueNode next;

    public QueueNode(String namaPemesan, int jumlahTiket, int nomorPemesanan) {
        this.namaPemesan = namaPemesan;
        this.jumlahTiket = jumlahTiket;
        this.nomorPemesanan = nomorPemesanan;
        this.next = null;
    }
}