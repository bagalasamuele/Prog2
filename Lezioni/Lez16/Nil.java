//Nil.java - LISTE VUOTE
/**
 * Sottoclasse concreta (= non astratta) di List: sovrascriviamo
 * tutti i metodi astratti di List. Nil contiene oggetti new Nil() che
 * rappresentano la lista vuota, e null che invece rappresenta un
 * elemento indefinito. In questa classe: this = oggetto istanziato =
 * lista vuota.
 */
/*
 * NOTA. Questa classe non si puo' compilare prima di aver
 * sovrascritto tutti i metodi astratti di List, ne' senza la classe
 * Cons, perche' usa il il costruttore di Cons.
 */
public class Nil extends List {
    /**
     * Costruttore di default new Nil()
     * Riscriviamo i metodi astratti di List e il metodo toString nel
     * caso della lista vuota.
     */
    public boolean empty() {
        return true;
    }

    /**
     * empty() e' costante = true sulla sottoclasse Nil, e' costante =
     * false sulla sottoclasse Cons, dunque NON e' costante su List
     */
    public int size() {
        return 0;
    }

    /**
     * size() e' costante = 0 sulla sottoclasse Cons, NON e'
     * costante sulla sottoclasse Cons, dunque NON e' costante su List
     */
    public boolean contains(int x) {
        return false;
    }

    /**
     * contains(x) e' costante = false sulla sottoclasse Nil, NON e'
     * costante sulla sottoclasse Cons, dunque NON e' costante su List
     */
    /**
     * insert. Metodo che aggiunge x a una lista
     * Quando aggiungo un elemento costruisco una nuova lista non vuota,
     * dunque nella sottoclasse concreta Cons. Devo quindi usare new e il
     * costruttore Cons per descrivere il risultato, e non posso compilare
     * Nil prima di compilare Cons.
     */

    public List insert(int x) {
        return new Cons(x, this);
    }

    /*
     * NOTA: qui this indica un elemento della classe Nil, la lista
     * vuota. Evitando di scrivere new Nil() riutilizzo la precedente lista
     * vuota, ovvero quella su cui ho chiamato il metodo.
     */
    /**
     * toString. Sovrascrivo il metodo toString() (che fa parte di
     * ogni classe) per definire una stringa (vuota) che rappresenta la
     * lista vuota.
     */
    public String toString() {
        return "";
    }

    public List append(List l) {
        return l;
    }
    /*
     * L’unione di una lista vuota e di l e' l. Restituendo l stessa
     * evito di definire un clone di l e risparmio memoria.
     */
} // end class Nil
