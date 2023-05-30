public abstract class Tree<T extends Comparable<T>> {
    // alberi di ricerca su T con relazione di ordine x.compareTo(y)
    public abstract boolean empty();

    public abstract boolean contains(T x);

    public abstract T max();

    // insert e remove restituiscono l’indirizzo dell’albero modificato
    public abstract Tree<T> insert(T x);

    public abstract Tree<T> remove(T x);

    protected abstract String toStringAux(String prefix, String root, String left, String right);

    // Metodo che gestisce la parte NON pubblica della stampa.
    // Non forniamo spiegazioni sul suo funzionamento, non e' essenziale
    public String toString() {
        return toStringAux("", "___", "   ", "   ");
    }
    /*
     * Trascrizione albero --> stringa. Ogni albero viene trascritto in
     * stringa dall’alto verso il basso, con i sottoalberi disegnati piu' a
     * destra dell’albero di cui fan parte
     */

}
// end class Tree