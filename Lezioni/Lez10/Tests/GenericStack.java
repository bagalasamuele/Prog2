public class GenericStack<T> {
    private GenericNode<T> first;

    public GenericStack() {
        first = null;
    }
public void push(GenericNode<T> newNode){
    GenericNode<T> aux;
    aux = first;
    first = newNode;
    first.setNext(aux);
    //first = new GenericNode<>(newNode, first); short command if you want to add only elem
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