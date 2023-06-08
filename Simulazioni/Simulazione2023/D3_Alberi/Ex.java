//SALVATE TUTTO IN UN SOLO FILE Ex
// Salvate tutto in un solo file Ex.
// Completate il metodo int height() in Leaf, Branch in modo che conti il numero di livelli che contengono elementi (che non contengono soltanto foglie) in un albero generico con elementi di tipo T.  Non modificate altro.
// Eseguite il main di Ex come test per la risposta.
// Ricopiate nel Quiz e fate verificare di nuovo le risposte dal Quiz, se passano il secondo controllo inviate tutto e terminate, altrimenti correggete gli errori.
class Ex {
    static Tree<Integer> l = new Leaf<>();
    static Tree<Integer> t = new Branch<>(1,
            new Branch<>(2, new Branch<>(0, l, l), l),
            new Branch<>(2, l, new Branch<>(3, l, l)));

    public static void check(String s, int a, int b) {
        if (a == b)
            System.out.println(s + a + " OK");
        else
            System.out.println(s + a + " EXPECTED " + b);
    }

    public static void main(String[] args) {
        check("l.height()=", l.height(), 0);
        check("t.height()=", t.height(), 3);
    }

}

abstract class Tree<T extends Comparable<T>> {
    public abstract int height();
}

class Leaf<T extends Comparable<T>> extends Tree<T> {
    public int height() {
        return 0;
    }

}

class Branch<T extends Comparable<T>> extends Tree<T> {
    private T elem;
    private Tree<T> left, right;

    public Branch(T elem, Tree<T> left, Tree<T> right) {
        this.elem = elem;
        this.left = left;
        this.right = right;
    }

    public int height() {
        int leftHeight = left.height();
        int rightHeight = right.height();
        return 1 + Math.max(leftHeight, rightHeight);
    }

}
