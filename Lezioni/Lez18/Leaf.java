public class Leaf<T extends Comparable<T>> extends Tree<T> {
    // contiene albero vuoto e null, qui this = albero vuoto sempre
    public boolean empty() {
        return true;
    }

    public boolean contains(T x) {
        return false;
    }

    public T max() {
        assert false;
        return null;
    }

    // insert e remove restituiscono l’indirizzo dell’albero modificato
    public Tree<T> insert(T x) {
        return new Branch<T>(x, this, this);
    }

    public Tree<T> remove(T x) {
        return this;
    }

    protected String toStringAux(String prefix, String root, String left, String right) {
        return prefix + root + "leaf";
    }
}
// end class Leaf