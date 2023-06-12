// Nodo per realizzare liste concatenate di elementi generici.
public class Node<T> {
    // Elemento di tipo generico T contenuto in questo nodo.
    private T elem;
    // Nodo successore, o null se e' l'ultimo nodo della lista concatenata.
    private Node<T> next;

    // Crea un nuovo nodo con valore @elem e successore @next.
    public Node(T elem, Node<T> next) {
        this.elem = elem;
        this.next = next;
    }

    // Ritorna l'elemento contenuto in questo nodo.
    public T getElem() {
        return elem;
    }

    // Ritorna il riferimento al nodo successore, oppure null se non c'e' un successore.
    public Node<T> getNext() {
        return next;
    }

    // Cambia il valore generico contenuto nel nodo con il nuovo valore @elem.
    public void setElem(T elem) {
        this.elem = elem;
    }

    // Cambia il riferimento al nodo successore con @next.
    public void setNext(Node<T> next) {
        this.next = next;
    }
	public String toString(){
		return elem.toString();
	}
}