public class Branch extends Tree {
    private int elem; // radice
    private Tree left; // nodi a sinistra: piu' piccoli della radice
    private Tree right; // nodi a destra: piu' grandi della radice

    public Branch(int elem, Tree left, Tree right) {
        this.elem = elem;
        this.left = left;
        this.right = right;
    }

    public boolean empty() {
        return false;
    }

    public int max() {
        return right.empty() ? elem : right.max();
    }

    public boolean contains(int x) {
        if (x == elem)
            return true;

        else if (x < elem)
            return left.contains(x);

        else
            return right.contains(x);
    }

    public Tree insert(int x) {

        if (x < elem)
            left = left.insert(x);
        else if (x > elem)
            right = right.insert(x);

        return this;

    }

    public Tree remove(int x) {
        if (x == elem) {
            if (left.empty())
                return right;
            else if (right.empty())
                return left;
            else {
                elem = left.max();
                left = left.remove(elem);
                return this;
            }
        } else if (x < elem) {
            left = left.remove(x);
            return this;
        } else {
            right = right.remove(x);
            return this;
        }
    }

    protected String toStringAux(String prefix, String root, String left, String right) {
        return this.left.toStringAux(prefix + left, "   /", "   ", "  ¦")
                + "\n" + prefix + root + "[" + elem + "]" + "\n" +

                this.right.toStringAux(prefix + right, "   \\", "  ¦", "   ");
    }
}
// end class Branch