/**
 * List.java
 * Liste crescenti di interi per rappresentare insiemi.
 * INVARIANTE della classe: ogni lista in List e' crescente
 * (non ci sono quindi ripetizioni di elementi).
 * La classe astratta "Lista" elenca i metodi che voglio
 * definire.
 * Le sottoclassi Nil, Cons realizzano questi metodi nei vari casi:
 * Nil: nel caso di una lista con zero elementi (vuota);
 * Cons: nel caso di una lista con almeno un elemento.
 */
public abstract class List {
    // Zero costruttori per List. Tutti i metodi di List sono astratti.
    // Elenco dei metodi astratti di List da sovrascrivere in Nil, Cons
    public abstract boolean empty(); // controllo se this=vuota

    public abstract int size(); // numero elementi di this

    public abstract boolean contains(int x); // controllo se x in this

    public abstract List insert(int x); // nuova lista=this unione {x}

    public abstract List append(List l); // nuova lista=this unione l
    // Tutti i metodi di tipo List costruiscono una nuova lista,
    // senza modificare this e la lista in input.
    // In Nil e Cons sovrascrivo anche il metodo "toString"
    // per descrivere una lista con una stringa.
}