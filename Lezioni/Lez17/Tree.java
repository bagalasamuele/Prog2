//Tree.java-Classe astratta alberi binari di ricerca
// INVARIANTE DI CLASSE: ogni oggetto e' un albero di ricerca
// Realizziamo gli alberi binari con 2 sottoclassi concrete:
// LEAF: contiene il solo albero vuoto "leaf"
// BRANCH: contiene tutti gli alberi non vuoti
// La classe astratta contiene il nome della classe, "Tree", e il
// minimo di metodi che richiediamo per formare una classe concreta
// di alberi.
// In questa implementazione quando inseriamo cancelliamo: dunque
// il contenuto precedente di un albero NON e' ricostruibile
public abstract class Tree {
    // Test se l'albero e' vuoto
    public abstract boolean empty();

    // Massimo elemento dell'albero, se non vuoto:
    // in un albero binario e' il nodo piu' a destra
    public abstract int max();

    // Test di appartenenza
    public abstract boolean contains(int x);

    // Aggiunta di un elemento a un albero. Modifica l'albero
    // precedente, la cui forma originaria va persa.
    public abstract Tree insert(int x);

    // Si usa con t = t.insert(x), per salvare le modifiche fatte a t
    // Rimozione di un elemento da un albero (se c'e'). Modifica
    // l'albero precedente, che va perso.
    public abstract Tree remove(int x);

    // Si usa con t = t.remove(x), per salvare le modifiche fatte a t
    protected abstract String toStringAux(String prefix, String root, String left, String right);

    // Metodo che gestisce la parte NON pubblica della stampa.2
    public String toString() {
        return toStringAux("", "___", "   ", "   ");
    }
    /*
     * Trascrizione albero --> stringa. Ogni albero viene trascritto in
     * stringa dall’alto verso il basso, un elemento per riga, con i
     * sottoalberi disegnati piu' a destra dell’albero di cui fan parte. Il
     * risultato e’ un disegno bidimensionale fatto con soli caratteri
     * ascii.
     */
}
// end class Tree