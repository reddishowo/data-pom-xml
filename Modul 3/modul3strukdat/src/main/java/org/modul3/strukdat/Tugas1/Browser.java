package org.modul3.strukdat.Tugas1;

class Browser {
    private String[] history;
    private int current;
    private int size;

    public Browser(int capacity) {
        history = new String[capacity];
        current = -1;
        size = 0;
    }

    public void visitURL(String url) {
        if (current == history.length - 1) {
            for (int i = 0; i < current; i++) {
                history[i] = history[i + 1];
            }
            current--;
            size--;
        }
        history[++current] = url;
        size++;
    }

    public void back() {
        if (current > 0) {
            current--;
        } else {
            System.out.println("Tidak ada URL sebelumnya.");
        }
    }

    public void forward() {
        if (current < size - 1) {
            current++;
        } else {
            System.out.println("Tidak ada URL berikutnya.");
        }
    }

    public String getCurrentURL() {
        if (current >= 0) {
            return history[current];
        }
        return null;
    }

    public void clearHistory() {
        history = new String[history.length];
        current = -1;
        size = 0;
        System.out.println("Riwayat navigasi telah dihapus.");
    }
}
