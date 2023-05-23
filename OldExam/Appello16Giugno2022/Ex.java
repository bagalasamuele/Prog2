// Il codice è stato anche formattato in modo leggibile
// Se la traccia esce fuori schermo usa il word wrapping (option + z su macOS)

import java.util.*;

class Ex {
    public static void main(String[] args) {
        test();
    }

    public static Random r = new Random();

    public static int r() {
        return r.nextInt(11) - 5;
    }

    public static int prop() {
        int i = r();
        if (i >= 0)
            return i;
        else
            return prop();
    }

    public static int noProp() {
        int i = r();
        if ((i >= 0) == false)
            return i;
        else
            return noProp();
    }

    public static int coin() {
        if (r.nextInt(2) == 0)
            return prop();
        else
            return noProp();
    }

    public static void test() {
        for (int i = 0; i < 10; ++i)
            test(i);
    }

    public static void test(int n) {
        List l = new List(), ris = new List();
        int a = 0, prop = 0, noProp = 0;
        for (int i = 0; i < n; ++i) {
            a = coin();
            l.insertFirst(a);
            ris.insertFirst(a);
            if (a >= 0)
                ++prop;
            else
                ++noProp;
        }
        ris.f();
        check(l, ris, prop, noProp);
    }

    public static int countElem(String s) {
        if (s.equals(""))
            return 0;
        int countElem = 1, i = 0, len = s.length();
        while (i < len) {
            if (s.charAt(i) == ',')
                ++countElem;
            ++i;
        }
        return countElem;
    }

    public static void check(List l, List ris, int prop, int noProp) {
        int extra = ((prop % 2 == 0) == true) ? 1 : 0;
        int len = extra + prop + noProp;
        String l_string = l.toString(), ris_string = ris.toString();
        System.out.println("lista     : " + l_string);
        System.out.println("risultato : " + ris_string);
        if (countElem(ris_string) != len)
            System.out.println("*ERRORE*  : lunghezza sbagliata");
        else if (check(ris, extra, true) == false)
            System.out.println("*ERRORE*  : il primo elemento di risultato deve essere maggiori o uguali a 0");
        else if (ris_string.endsWith(l_string) == false)
            System.out.println("*ERRORE*  : risultato deve terminare con lista");
        else
            System.out.println("   ========OK========");
    }

    // Controllo se per gli elementi di ris di indice <extra
    // la proprieta': essere maggiori o uguali a 0
    // vale: truthValue
    public static boolean check(List ris, int extra, boolean truthValue) {
        Node p = ris.getFirst();
        if (extra > 0)
            return (p.getElem() >= 0);
        else
            return true;
    }

}

class List {
    private Node first;

    public List() {
        first = null;
    }

    public void insertFirst(int elem) {
        first = new Node(elem, first);
    }

    /*
     * 
     * Completate il metodo List f() nella classe List come segue. f() conta gli
     * elementi della lista che sono maggiori o uguali a 0. Supponiamo che gli
     * elementi che sono maggiori o uguali a 0 siano in numero pari. Allora f()
     * restituisce la lista aggiungendo all'inizio un elemento (scelto come volete),
     * in modo che che gli elementi che sono maggiori o uguali a 0 diventino in
     * numero dispari. Altrimenti f() restituisce la lista immutata. Non modificate
     * altro che il metodo.
     */

    public List f() {
        Node pointer = first;
        int numberOfUpZero = 0;
        while (pointer != null) {
          
            pointer = pointer.getNext();
        }
        if (numberOfUpZero % 2 == 0) {
            insertFirst(1);
            return this;
        } else {
            return this;
        }

    }

    public Node getFirst() {
        return first;
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
