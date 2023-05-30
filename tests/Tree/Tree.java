//Struttura base per la creazione dei nostri esercizi
public abstract class Tree {
    public abstract boolean empty();

    public abstract int max();

    public abstract boolean contains(int x);

    public abstract Tree insert(int x);

    public abstract Tree remove(int x);

    protected abstract String toStringAux(String prefix, String root, String left, String right);

    public String toString() {
        return toStringAux("", "___", "   ", "   ");
    }

}
