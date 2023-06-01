/* MiniIterator.java - Classe che consente di traversare una volta
sola una lista con un numero "size" di applicazioni di getNext()
senza rendere pubblici gli indirizzi dei nodi. */

import Ex1.Node;

public class MiniIterator {
    private Node next; // next = prossimo nodo da "visitare"

    public MiniIterator(Node first) {
        next = first;
    }

    public boolean hasNext() {
        return next != null;
    }

    /*
     * next() restituisce l’elemento nel nodo corrente e muove il
     * puntatore next al nodo dopo. Si noti che next() cancella il valore
     * originale di next: la visita della lista l viene fatta una volta
     * sola. Per fare un’altra visita dovrò creare nel codice client un
     * altro oggetto it = l.iterator().
     */
    public int next() {
        assert hasNext();
        int x = next.getElem();
        next = next.getNext();
        return x;
    }
}