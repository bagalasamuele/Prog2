//Node.java Riutilizziamo la classe Node della Lezione 8.
// un nodo contiene un valore e un riferimento al nodo
// successivo (null se non c’è un nodo successivo)
public class Node {
    private int elem;
    private Node next;

    public Node(int elem, Node next) {
        this.elem = elem;
        this.next = next;
    }

    public void setElem(int elem) {
        this.elem = elem;
    }

    public int getElem() {
        return elem;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node node) {
        next = node;
    }
}
