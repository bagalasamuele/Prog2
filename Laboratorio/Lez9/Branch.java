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

    public boolean balanced() {
        return Math.max(left.depth(), right.depth()) <= 1 ? true : false;
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

    public Tree remove(int x){
    
        return this;
    }

    public int get(int i) {
        int l = left.size();
        if (i < l) return left.get(i);
        else if (i == l) return elem;
        else return right.get(i - l - 1);
    }
        

 
    // public boolean contains(T x) {
    // return x.compareTo(elem) == 0 || (right != null && right.contains(x));
    // }

}
