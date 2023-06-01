// classe per rappresentare una diramazione

public class Branch extends Tree {
    private int elem;
    private Tree left;
    private Tree right;

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
        // se x == elem x e` gia` presente nell'albero e non lo inseriamo
        return this;
    }

    public Tree remove(int x) {
        if (x == elem) { // trovato elemento da eliminare
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
            // se c'e`, l'elemento da eliminare e` nel sottoalbero
            // sinistro
            left = left.remove(x);
            return this;
        } else {
            // se c'e`, l'elemento da eliminare e` nel sottoalbero
            // destro
            right = right.remove(x);
            return this;
        }
    }

    public int depth() {
        return 1 + Math.max(left.depth(), right.depth());
    }

    public String toString() {
        return "Branch(" + elem + "," + left + "," + right + ")";
    }

    public int size() {
        int size = 1;

        if (right != null) {
            size = size + right.size();
        }

        if (left != null) {
            size = size + left.size();

        }

        return size;
    }

    public int sum() {
        int sum = elem;

        if (right != null) {
            sum += right.sum();
        }

        if (left != null) {
            sum += left.sum();
        }

        return sum;
    }

    // public boolean contains(T x) {
    //     return x.compareTo(elem) == 0 || (right != null && right.contains(x));
    // }

}
