public class Ex {

    public static void main(String Args[]) {

    }
}

abstract class Tree<T> {
    public abstract Tree<T> detach(T x);
}

class Leaf<T> extends Tree<T> {
    public Tree<T> detach(T x) {
        /* COMPLETARE */ }
}

class Branch<T> extends Tree<T> {
    private T elem;
    private Tree<T> left;
    private Tree<T> right;

    public Branch(T elem, Tree<T> left, Tree<T> right) {
        this.elem = elem;
        this.left = left;
        this.right = right;
    }

    public Tree<T> detach(T x) {
        /* COMPLETARE */ }
}
