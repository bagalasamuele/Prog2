// Un esempio di classe astratta: List
// Liste ordinate di interi per rappresentare insiemi
// INVARIANTE della classe: 
//   in ogni lista gli elementi sono in ordine
// Le sottoclassi Nil, Cons realizzano queste operazioni nei vari casi:
//   Nil: nel caso di una lista con zero elementi (vuota)
//   Cons: nel caso di una lista con almeno un elemento
public abstract class List {
    // Ritorna true se la lista è vuota
    public abstract boolean empty();

    // Ritorna il numero di elementi nella lista.
    public abstract int size();

    // Ritorna true se @x e' contenuto nella lista, false altrimenti.
    public abstract boolean contains(int x);

    // Aggiunge @x alla lista, mantenendo l'ordine.
    // Ritorna una nuova lista opportunamente modificata.
    public abstract List insert(int x);

    // Aggiungi alla lista tutti gli elementi di @l, e ritorna la nuova lista creata.
    public abstract List append(List l);
    public abstract int sum();
    public abstract int get(int i);
    public abstract List succ();
    public abstract List filter_le(int x);
    public abstract List filter_gt(int x);
    public abstract List intersect(List l);
}
