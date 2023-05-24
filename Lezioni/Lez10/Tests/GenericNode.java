public class GenericNode<T> {
    private T elem;
    private GenericNode<T> next;

    public GenericNode(T elem, GenericNode<T> next) {
        this.elem = elem;
        this.next = next;
    }

    public T getElem() {
        return elem;
    }

    public GenericNode<T> getNext() {
        return next;
    }

    public void setNext(GenericNode<T> next){
        this.next = next;
    }

    public void setElem(T elem){
        this.elem = elem;
    }
}