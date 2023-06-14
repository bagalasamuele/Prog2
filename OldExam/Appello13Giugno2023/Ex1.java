package OldExam.Appello13Giugno2023;
// Traccia: Completate il metodo boolean m() in List, in modo che m() restituisca vero se la lista non è vuota, il primo elemento della lista è uguale a 21, e la lista è ordinata rispetto a <=. m restituisce falso in qualunque altro caso. Non modificate altro che il metodo.
// Fate verificare la risposta a Moodle. Non definite il vostro metodo per casi sui test. Se la risposta passa il controllo inviate tutto e terminate, altrimenti correggete gli errori. Normalmente i test devono essere tutti giusti perché la soluzione abbia valore.

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

class List {
    private Node first;

    public List() {
        first = null;
    }

    public boolean m() {
        return false;
    }

    // Soluzione,
    // public boolean m(){

    // Node aux = first;
    // int prevElem = 0;

    // if(first != null){
    // if(first.getElem() == 21){
    // prevElem = first.getElem();
    // while(aux != null){
    // if( aux.getElem() < prevElem ){
    // return false;
    // }
    // prevElem = aux.getElem();
    // aux = aux.getNext();
    // }
    // return true;
    // }

    // }

    // return false;

    // }

    public void insertFirst(int elem) {
        first = new Node(elem, first);
    }

    public String toString() {
        String s = "";
        for (Node p = first; p != null; p = p.getNext()) {
            if (p != first)
                s += ", ";
            s += p.getElem();
        }
        return s;
    }

}

class Node {
    private int elem;
    private Node next;

    Node(int elem, Node next) {
        this.elem = elem;
        this.next = next;
    }

    int getElem() {
        return elem;
    }

    void setElem(int elem) {
        this.elem = elem;
    }

    Node getNext() {
        return next;
    }

    void setNext(Node next) {
        this.next = next;
    }
}

public class Ex1 {
    public static void main(String[] args) {
        test();
    }

    public static Random r = new Random();

    public static int pos() {
        int i = ThreadLocalRandom.current().nextInt(-100, 100 + 1);
        // int i=r.nextInt(10)-5;
        if (i == 21)
            return i;
        else
            return pos();
    }

    public static int neg() {
        int i = ThreadLocalRandom.current().nextInt(-100, 100 + 1);
        // int i=r.nextInt(10)-5;
        if ((i == 21) == false)
            return i;
        else
            return neg();
    }

    public static void test() {
        int n = pos();
        int m = neg();
        msg();
        check(crea(), false);
        check(crea(n), true);
        check(crea(m), false);
        m = neg();
        check(crea(m, m), false);
        m = neg();
        check(crea(m, m + 1), false);
        m = neg();
        check(crea(m, m - 1), false);
        m = neg();

        check(crea(n, n + 1, n + 1), 1 == 1 ? true : false);
        n = pos();
        check(crea(n, n + 1, n + 2), 1 == 1 || 1 == 2 ? true : false);
        n = pos();
        check(crea(n, n + 1, n), false);
        n = pos();
        check(crea(n, n, n - 2), 1 == 3 ? true : false);
        n = pos();
        check(crea(n, n - 1, n - 2), 1 == 3 || 1 == 4 ? true : false);
        n = pos();
        check(crea(n, n - 1, n), false);
        n = pos();

        check(crea(n, n + 1, n + 2, n + 3, n + 4, n + 5, n + 5), 1 == 1 ? true : false);
        n = pos();
        check(crea(n, n + 1, n + 2, n + 3, n + 4, n + 5, n + 6), 1 == 1 || 1 == 2 ? true : false);
        n = pos();
        check(crea(n, n + 1, n + 2, n + 3, n + 4, n + 5, n + 4), false);
        n = pos();
        check(crea(n, n - 1, n - 2, n - 3, n - 4, n - 5, n - 5), 1 == 3 ? true : false);
        n = pos();
        check(crea(n, n - 1, n - 2, n - 3, n - 4, n - 5, n - 6), 1 == 3 || 1 == 4 ? true : false);
        n = pos();
        check(crea(n, n - 1, n - 2, n - 3, n - 4, n - 5, n - 4), false);
        n = pos();
    }

    public static void msg() {
        System.out.println("m() controlla:"
                + "\n - se il primo elemento della lista è uguale a 21"
                + "\n - e se la lista è ordinata rispetto a: <=");
    }

    public static void check(List l, boolean atteso) {
        System.out.print("lista : " + l);
        boolean ottenuto = l.m();
        System.out.print("    ottenuto : " + ottenuto);
        System.out.println("  atteso : " + atteso);
        System.out.println(ottenuto == atteso ? "=== OK" : "=== *ERRORE*");
        System.out.println();
    }

    public static List crea(Integer... v) {
        List l = new List();
        for (int i = v.length - 1; i >= 0; i--)
            l.insertFirst(v[i]);
        return l;
    }
}
