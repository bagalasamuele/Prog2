//Branch.java
//alberi di ricerca generici e non vuoti
public class Branch<T extends Comparable<T>> extends Tree<T> {
    private T elem;
    Tree<T> left;
    Tree<T> right;

    public Branch(T elem, Tree<T> left, Tree<T> right) {
        this.elem = elem;
        this.left = left;
        this.right = right;
    }

    public Tree<T> detach(T x) {
        if (elem == x) {
            return new Leaf<>();
        }
        this.left = left.detach(x);
        this.right = right.detach(x);
        return this;
    }

    public boolean empty() {
        return false;
    }


    /*
     * Per fare i confronti usiamo il metodo compareTo(), in modo da avere un
     * confronto generale per tutti i T che implementano l'interfaccia Comparable<T>
     * e che quindi hanno un metodo compareTo().
     */
    public boolean contains(T x) {

        int c = x.compareTo(elem);
        if (c == 0) // x=elem
            return true;
        else if (c < 0) // x<elem
            return left.contains(x);
        else // c>0, x>elem
            return right.contains(x);
    }

    public T max() {
        if (right.empty())
            return elem;
        else // right non vuoto
            return right.max();
    }

    // insert e remove restituiscono l’indirizzo dell’albero modificato
    public Tree<T> insert(T x) {
        int c = x.compareTo(elem);
        if (c < 0) // x<elem
        {
            left = left.insert(x);
        } else if (c > 0) // x>elem
        {
            right = right.insert(x);
        }
        // se c=0 allora x=elem e non inserisco x
        return this;
        // restituisco l’indirizzo dell’albero modificato
    }

    public Tree<T> remove(T x) {
        int c = x.compareTo(elem);
        if (c < 0) // x<elem
        {
            left = left.remove(x);
            return this;
        } else if (c > 0) // x>elem
        {
            right = right.remove(x);
            return this;
        } else /* x=elem */
        if (left.empty())
            return right;
        // cancello elem, se left=leaf resta right
        else if (right.empty())
            return left;
        // cancello elem, se right=leaf resta left
        else {
            // cancello elem, left e right non sono vuoti:

        }
        elem = left.max(); // sost. elem con il max a sx
        left.remove(elem); // per evitare ripetizioni
        return this;
        // restituisco l’albero modificato
    }

    // Metodo che gestisce la parte NON pubblica della stampa.
    // Non forniamo spiegazioni sul suo funzionamento, non e'
    // essenziale.
    protected String toStringAux(String prefix, String root, String left, String right) {
        return this.left.toStringAux(prefix + left, "   /", "   ", "  ¦")
                + "\n" + prefix + root + "[" + elem + "]" + "\n" +
                this.right.toStringAux(prefix + right, "   \\", "  ¦", "   ");
    }
}
// end class Branch