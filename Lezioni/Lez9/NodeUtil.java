// void scriviOutput(Node p). Stampa una lista concatenata partendo
// dal nodo in cima alla lista andando indietro (quindi in ordine
// inverso). Adattate il metodo per stampare una pila della Lezione
// 08. scriviOutput(q) scrive: 10 20 30 40 andando a capo dopo ogni
// elemento.

// 1. int length(Node p). Calcola la lunghezza di una lista. Traversiamo
// la lista con un ciclo, aggiungendo uno ogni volta che troviamo un
// nodo non nullo. length(q) vale 4.

// 2. int sum(Node p). Somma degli elementi di una lista. Traversiamo
// la lista con un ciclo, sommando tutti gli elementi che incontriamo
// e mantenendo il risultato in una variabile s. Finita la lista, s
// è la somma di tutti gli elementi della lista. sum(q) vale
// 10+20+30+40=100.

// 3. int max(Node p). Massimo degli elementi di una lista non nulla
// (non definito per la lista vuota). Traversiamo la lista con un
// ciclo, mantendo in una variabile m il più grande degli elementi
// trovati. Alla fine della lista m è il massimo. max(q) vale 40.

// 4. boolean member(Node p, int x). Controlla se x dato compare in una
// lista p. Traversiamo la lista con un ciclo, e non appena troviamo
// x usciamo con risposta true. Se arriviamo alla fine della lista
// senza trovare x, restituiamo false. member(q,30) vale true e
// member(q,50) vale false.

// 5. String toString(Node p). Restituisce una stringa con i nodi di p
// separati da uno spazio. toString(q) vale "10 20 30 40".

// 6. boolean sorted(Node p). Verifica se una lista concatenata è
// ordinata in modo debolmente crescente. sorted(q) vale true, se p
// = {10,20,30,40,30,20,10} allora sorted(p) vale false.

// 7. boolean equals(Node p, Node q). Verifica se due liste concatenate
// sono uguali: hanno gli stessi elementi nello stesso ordine.
// equals(q,q) vale true, se p = {10,20,30,40,30,20,10} allora
// equals(p,q) vale false.

import org.w3c.dom.Node;

public class NodeUtil {

    public static void scriviOutput(Node q) {
        Node aux = q;
        // Importante controllare che l'elemento attuale sia nullo, non il successivo
        while (aux != null) {
            System.out.println(aux.getElem());
            aux = aux.getNext();
        }
    }

    public static int length(Node q) {
        Node aux = q;
        int numberOfElem = 0;
        while (aux != null) {
            numberOfElem++;
            aux = aux.getNext();
        }
        return numberOfElem;
    }

    public static int length_rec(Node p) {
        if (p == null)
            return 0;
        else
            return 1 + length_rec(p.getNext());
    }

    public static int sum(Node p) {
        Node aux = p;
        int sumElement = 0;
        while (aux != null) {
            sumElement = sumElement + aux.getElem();
            aux = aux.getNext();
        }
        return sumElement;
    }

    public static int sum_rec(Node p) {
        if (p == null)
            return 0;
        else
            return p.getElem() + sum_rec(p.getNext());
    }

    public static int max(Node p) {
        Node aux = p;
        int max = 0;
        while (aux != null) {
            if (aux.getElem() > max) {
                max = aux.getElem();
            }
            aux = aux.getNext();
        }
        return max;
    }

    public static int max_rec(Node p) {
        if (p == null)
            return 0;
        else
            return Math.max(p.getElem(), max_rec(p.getNext()));
    }

    public static boolean member(Node p, int n) {
        Node aux = p;
        while (aux != null) {
            if (aux.getElem() == n)
                return true;
            aux = aux.getNext();
        }
        return false;
    }

    public static boolean member_rec(Node p, int n) {
        if (p == null)
            return false;
        else if (p.getElem() == n)
            return true;
        else
            return member_rec(p.getNext(), n);
    }

    public static String toString(Node p) {
        Node aux = p;
        String s = "";
        while (aux != null) {
            s = s + aux.getElem() + " ";
            aux = aux.getNext();
        }
        return s;
    }

    public static class Node {
        private int elem;
        private Node next;

        public Node(int elem, Node next) {
            this.elem = elem;
            this.next = next;
        }

        public int getElem() {
            return elem;
        }

        public Node getNext() {
            return next;
        }

        public void setElem(int elem) {
            this.elem = elem;
        }

        public void setNext(Node next) {
            this.next = next;
        }

    }

    public static void main(String[] args) {
        System.out.println("Main di prova per gli esercizi 0-7");
        System.out.println("---------------------");
        // aggiungo i nodi di q={10,20,30,40} a sinistra, dunque parto da 40
        Node q = new Node(40, null);
        q = new Node(30, q);
        q = new Node(20, q);
        q = new Node(10, q);
        System.out.println("Lista q:");
        scriviOutput(q);
        System.out.println("---------------------");
        // aggiungo i nodi di p={10,20,30,40,30,20,10} a sinistra
        Node p = new Node(10, null);
        p = new Node(20, p);
        p = new Node(30, p);
        p = new Node(40, p);
        p = new Node(30, p);
        p = new Node(20, p);
        p = new Node(10, p);
        System.out.println("Lista p:");
        scriviOutput(p);
        System.out.println("---------------------");
        System.out.println("1. length(p) = " + length(p));
        System.out.println("1. length_rec(p) = " + length_rec(p));
        System.out.println("---------------------");
        System.out.println("2. sum(p) = " + sum(p));
        System.out.println("2. sum_rec(p) = " + sum_rec(p));
        System.out.println("---------------------");
        System.out.println("3. max(p) = " + max(p));
        System.out.println("3. max_rec(p) = " + max_rec(p));
        System.out.println("---------------------");
        System.out.println("4. member(p,30) = " + member(p, 30));
        System.out.println("4. member(p,50) = " + member(p, 50));
        System.out.println("4. member_rec(p,30) = " + member_rec(p, 30));
        System.out.println("4. member_rec(p,50) = " + member_rec(p, 50));
        System.out.println("---------------------");
        System.out.println("5. toString(q) = " + toString(q));
        System.out.println("5. toString(p) = " + toString(p));
        System.out.println("---------------------");
        // System.out.println("6. sorted(q) = " + sorted(q));
        // System.out.println("6. sorted(p) = " + sorted(p));
        // System.out.println("---------------------");
        // System.out.println("7. equals(p,q) = " + equals(p, q));
        // System.out.println("7. equals(p,p) = " + equals(p, p));
        // System.out.println("7. equals(q,q) = " + equals(q, q));
        // System.out.println("7. equals(q,p) = " + equals(q, p));
    }
}
// Qui deve esserci la parentesi di chiusura della classe NodeUtil