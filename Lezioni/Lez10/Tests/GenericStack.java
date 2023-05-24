public class GenericStack<T> {
    private GenericNode<T> first;

    public GenericStack() {
        first = null;
    }

    public void push(T elem) {
        // If you want to add a Node
        // GenericNode<T> aux;
        // aux = first;
        // first = newNode;
        // first.setNext(aux);
        first = new GenericNode<>(elem, first);
        // only elem
    }

    public String toString() {
        GenericNode<T> aux = first;
        String s = "";
        while (aux != null) {
            s = s + " " + aux.getElem();
            aux = aux.getNext();
        }
        return s;
    }
}