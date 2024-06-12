package org.modul3.strukdat.Codelab2;

import java.util.LinkedList;
import java.util.Queue;

public class ContohQueue {
    public static void main(String[] args) {
        Queue q = new LinkedList();

        q.add("Bebek");
        q.add("Angsa");
        q.add("Kuda");
        q.add("Buaya");
        q.add("Tikus");

        System.out.println("Peek : " + q.peek());
        System.out.println("Animals : " + q);

        q.poll();
        q.poll();

        System.out.println("Animals : " + q);
    }
}
