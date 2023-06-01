//main di prova con l’albero t citato nel testo dell’esercizio
public class Esercizio1 {
    public static void main(String[] args) {
        Tree<Integer> leaf = new Leaf<>(),
                t = new Branch<>(2,
                        leaf,
                        new Branch<>(-3,
                                new Branch<>(1, leaf, leaf),
                                leaf)),
                u = new Branch<>(null,
                        leaf,
                        new Branch<>(-3,
                                new Branch<>(1, leaf, leaf),
                                leaf)),
                v = new Branch<>(null,
                        leaf,
                        new Branch<>(-3,
                                new Branch<>(1, leaf, leaf),
                                leaf));
        System.out.println("\n t = " + t);
        System.out.println("   t.detach(-3) = " + t.detach(-3));
        System.out.println("\n u = " + u);
        System.out.println("   u.detach( 1) = " + u.detach(1));
        System.out.println("\n v = " + v);
        System.out.println("   v.detach(10) = " + v.detach(10));
    }
}

abstract class Tree<T> {
    public abstract Tree<T> detach(T x);
}

class Leaf<T> extends Tree<T> {
    public Tree<T> detach(T x) {
        return this;
    }
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

    }
}
