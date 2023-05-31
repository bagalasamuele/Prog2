
public class Node<T> {
    private T elem;
    private Node<T> next;

    public Node(T elem, Node<T> next) {
        this.elem = elem;
        this.next = next;
    }

    public void setElem(T elem) {
        this.elem = elem;
    }

    public void setNode(Node<T> next) {
        this.next = next;
    }

    public T getElem() {
        return elem;
    }

    public Node<T> getNext() {
        return next;
    }
}