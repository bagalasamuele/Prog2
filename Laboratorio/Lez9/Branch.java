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
        if(right.empty() == true)
            return elem;
        else 
            return right.max(); 
    }

    public boolean contains(int x) {
        if (elem == x)
            return true;
        if ( x < elem )
            return left.contains(x);
        else 
            return right.contains(x);
    }

    public boolean contains(int x, int n){
        return false;
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
        return (left.size() + right.size())+1;
    }

    public int sum() {
        return (left.sum() + right.sum())+ elem;
    }

    // public boolean contains(T x) {
    // return x.compareTo(elem) == 0 || (right != null && right.contains(x));
    // }

}
