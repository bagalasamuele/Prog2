public class Leaf extends Tree {
    public Leaf() {
    }

    public boolean empty() {
        return true;
    }

    public int max() {
        assert false;
        return 0;
    }

    public boolean contains(int x) {
        return false;
    }

    public Tree insert(int x) {
        return new Branch(x, this, this);
    }

    public Tree remove(int x) {
        return this;
    }

    protected String toStringAux(String prefix, String root, String left, String right) {
        return prefix + root + "leaf";
    }
}
