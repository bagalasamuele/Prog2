// Nodo per realizzare liste concatenate.
public class Node {
    // Elemento intero contenuto in questo nodo.
    private int elem;
    // Nodo successore, o null se e' l'ultimo nodo della lista concatenata.
    private Node next;

    // Crea un nuovo nodo con valore @elem e successore @next.
    public Node(int elem, Node next) {
        this.elem = elem;
        this.next = next;
    }

    // Ritorna l'elemento contenuto in questo nodo.
    public int getElem() {
        return this.elem;
    }

    // Cambia l'intero contenuto nel nodo al nuovo valore @elem.
    public void setElem(int elem) {
        this.elem = elem;
    }

    // Ritorna il riferimento al nodo successore, oppure null se non c'e' un successore.
    public Node getNext() {
        return this.next;
    }

    // Cambia il riferimento al nodo successore con @next.
    public void setNext(Node next) {
        this.next = next;
    }

}
