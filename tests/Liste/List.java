import java.awt.*;

public class List {
    private Node first;

    public List() {
        first = null;
    }

    public void push(int elem) {
        first = new Node(elem, first);
    }

    public Node pop() {
        Node p = first;
        Node oldFirst = first;
        first = p.getNext();
        // Cerca comando per cancellare Nodi orfani
        return oldFirst;
    }

    public void g() {
        Node pointer = first;
        int elem = 0;
        while (pointer != null) {
            elem = elem +1;
            pointer = pointer.getNext();
        }
        System.out.println(elem);
    }

    public Node getFirst() {
        return first;
    }

    public String toString() {
        String s = "";
        // for (Node p = first; p != null; p = p.getNext()) {
        // if (p != first)
        // s += ", ";
        // s += p.getElem();
        // }
        for (Node p = first; p != null; p = p.getNext()) {
            s = s + p.getElem() + " | ";
        }
        return s;
    }
}
