//Figura.java
/** LA CLASSE ASTRATTA FIGURA */
public abstract class Figura {
    // Cerchi, Poligoni regolari, Trapezi, Rettangoli, ...
    // Non siamo obbligati a fornire attributi e costruttori per Figura
    /**
     * METODI ASTRATTI per area e perimetro: si possono usare solo
     * quando vengono sovrascritti in una sottoclasse
     */
    public abstract double area();

    public abstract double perimetro();

    // Se f e' un cerchio, rettangolo eccetera, assegno a f tipo Figura e
    // ne calcolo l'area scrivendo f.area(), anziche' dover considerare
    // un caso diverso per ogni tipo di figura.
    // ESEMPIO di cosa viene accettato da Java.
    // Posso dichiarare variabili di tipo Figura:
    public static void main(String[] args) {
        Figura P; // OK
    }
    /**
     * Però NON posso creare oggetti di tipo Figura con new Figura(),
     * ma posso assegnare a P il valore null oppure un oggetto di una
     * sottoclasse concreta di Figura. ATTENZIONE: il valore di default di P
     * non è null. Infatti se si prova a stampare P con una println subito
     * dopo la sua dichiarazione il compilatore ci dice che la variabile P
     * non è stata inizializzata.
     */
}
// end class Figura