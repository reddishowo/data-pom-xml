package org.modul3.strukdat.Tugas2_New;

class TicketQueue {
    private QueueNode front;
    private QueueNode rear;
    private int size;

    public TicketQueue() {
        this.front = null;
        this.rear = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public int size() {
        return size;
    }

    public void enqueue(String namaPemesan, int jumlahTiket, int nomorPemesanan) {
        QueueNode newNode = new QueueNode(namaPemesan, jumlahTiket, nomorPemesanan);
        if (isEmpty()) {
            front = newNode;
        } else {
            rear.next = newNode;
        }
        rear = newNode;
        size++;
        System.out.println("Pemesanan tiket berhasil. Nomor pemesanan: " + nomorPemesanan);
    }

    public void dequeue() {
        if (isEmpty()) {
            System.out.println("Antrian kosong. Tidak ada tiket untuk dihapus.");
            return;
        }
        System.out.println("Pemesanan tiket dengan nomor pemesanan " + front.nomorPemesanan + " dihapus.");
        front = front.next;
        if (front == null) {
            rear = null;
        }
        size--;
    }

    public void displayQueue() {
        if (isEmpty()) {
            System.out.println("Antrian kosong.");
            return;
        }
        System.out.println("Daftar Pemesanan Tiket:");
        QueueNode current = front;
        while (current != null) {
            System.out.println("Nomor Pemesanan: " + current.nomorPemesanan);
            System.out.println("Nama Pemesan: " + current.namaPemesan);
            System.out.println("Jumlah Tiket: " + current.jumlahTiket);
            System.out.println("-----------------------------");
            current = current.next;
        }
    }
}