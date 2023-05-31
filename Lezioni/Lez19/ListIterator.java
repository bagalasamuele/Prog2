
//ListIterator.java Questa classe deve implementare Iterator<Integer>
import java.util.*;

// un oggetto di ListIterator e' un semplice indirizzo di un nodo
public class ListIterator implements Iterator<Integer> {
    private Node next; // All’inizio = inizio lista

    public ListIterator(Node next) {
        this.next = next;
    }

    /*
     * per implementare Iterator<Integer> occorre fornire:
     * 1. un metodo boolean hasNext() che ci dica se esiste un prossimo
     * oggetto della lista da visitare
     * 2. un metodo Integer next() che sposti next sul prossimo oggetto da
     * visitare nella collezione e ne restituisca il valore, un intero.
     * Notiamo che il valore originario di next viene perso, quindi la
     * visita si fa una volta sola, per una seconda visita bisogna
     * ricalcolare l.iterator()
     */
    public boolean hasNext() {
        return next != null;
    }

    public Integer next() {
        int x = next.getElem(); // contenuto del prossimo nodo
        next = next.getNext(); // indirizzo del nodo dopo ancora
        return x;
        // x viene automaticamente trasformato da int a Integer
        // (via auto-boxing)
    }
} // end class ListIterator
  