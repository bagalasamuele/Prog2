public class Leaf extends Tree {
    public Leaf() {}

    /**
     * Il costruttore new Leaf() non assegna nulla e si puo' anche
     * lasciare implicito. Un albero viene inizializzato da new Leaf() e poi
     * esteso un elemento alla volta. Qui this = oggetto istanziato = albero
     * vuoto (sempre).
     */
    public boolean empty() {
        return true;
    } // l'albero vuoto e' vuoto

    public int max() {
        assert false;
        return 0;
    }

    /**
     * l'albero vuoto non ha
     * massimo, e' sbagliato chiederlo. Java richiede un return se c'e' un
     * tipo di ritorno, per questo scriviamo return 0;
     */
    public boolean contains(int x) {
        return false;
    }

    // l'albero vuoto non contiene nulla
    public Tree insert(int x) {
        return new Branch(x, this, this);
    }

    // se inserisco x ottengo l'albero di radice x e nessun figlio
    // qui this è un oggetto di tipo Leaf: lo riuso, quindi non creo
    // alberi vuoti nuovi.
    // Nella classe Leaf abbiamo sempre: this = albero vuoto
    public Tree remove(int x) {
        return this;
    } // non c'e' nulla da
    // cancellare nell'albero vuoto, quindi non cambia nulla
    // Metodo che gestisce la parte NON pubblica della stampa.
    // Non forniamo spiegazioni sul suo funzionamento.

    protected String toStringAux(String prefix, String root, String left, String right) {
        return prefix + root + "leaf";
    }
}
// end class Leaf