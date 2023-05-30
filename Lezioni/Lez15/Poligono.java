/**
 * Poligono.java. Sottoclasse astratta di Figura:
 * anche se classe figlia di Figura, non ha dei metodi implementati per
 * calcolare area e perimetro, ha degli attributi e un metodo di lettura
 * per il numero dei lati. Possiede sottoclassi non astratte: PolReg,
 * Triangolo, ...
 */
public abstract class Poligono extends Figura {
    protected int lati; // INVARIANTE: lati>=3
    /*
     * "protected" consente di modificare "lati" in una sottoclasse di
     * Poligono (ci serve per i poligoni regolari)
     */

    public Poligono(int lati) {
        // Non e' necessario invocare il costruttore della classe superiore
        // quando e' il costruttore di default, quindi possiamo omettere:
        // super();
        assert lati >= 3; // per mantenere l’invariante
        this.lati = lati;
    }

    public int getLati() {
        return lati;
    }

    // In alcune sottoclassi il numero dei lati puo' cambiare
    // ma in altre no, quindi per ora niente metodo set
    // ESEMPIO di cosa viene accettato da Java.
    // Posso dichiarare variabili di tipo Poligono:
    public static void main(String[] args) {
        Poligono P;
        // Poligono triangolo = new Poligono(3); //NON corretto:
        // triangolo non può essere creato nella classe astratta Poligono
    }
}
/**
 * Però NON posso creare oggetti di tipo Poligono con new
 * Poligono(), ma posso assegnare a P il valore null oppure un oggetto
 * di una sottoclasse concreta di Figura. ATTENZIONE: il valore di
 * default di P non è null. Infatti se si prova a stampare P con una
 * println subito dopo la sua dichiarazione il compilatore ci dice che
 * la variabile P non è stata inizializzata.
 */