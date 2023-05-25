// BottigliaConTappo.java
public class BottigliaConTappo extends Bottiglia {
    /*
     * NUOVO attributo privato per memorizzare lo stato della bottiglia
     * (true = bottiglia aperta, false = bottiglia chiusa)
     */
    private boolean aperta;

    /*
     * NUOVO costruttore. Spesso dobbiamo definire un costruttore per le
     * classi estese: raramente il costruttore di default fornito da Java per
     * una estensione e' sensato
     */
    public BottigliaConTappo(int capacita) {
        /*
         * invochiamo il costruttore della classe superiore per fare le
         * inizializzazioni della capacita'
         */
        super(capacita);
        // supponiamo che la bottiglia sia inizialmente chiusa
        aperta = false;
    }
    /*
     * La chiamata al costruttore della classe superiore deve essere la
     * prima istruzione del costruttore della sottoclasse. Il costruttore
     * della classe superiore può essere richiamato solo dal costruttore della
     * sottoclasse. Se il costruttore della sottoclasse non richiama
     * esplicitamente un costruttore della classe superiore, per prima cosa
     * viene chiamato automaticamente il costruttore predefinito della classe
     * superiore, quello senza parametri (super()); se la classe superiore
     * non ha un costruttore senza parametri il compilatore genera un errore.
     */

    // NUOVO metodo get per sapere se la bottiglia e` aperta o chiusa
    public boolean aperta() {
        return aperta;
    }

    // NUOVO metodo per aprire la bottiglia
    public void apri() {
        aperta = true;
    }

    // NUOVO metodo per chiudere la bottiglia
    public void chiudi() {
        aperta = false;
    }

    // Ereditiamo i metodi get, set (ma non toString()) da Bottiglia
    /*
     * OVERRIDE del metodo "aggiungi" per versare liquido nella bottiglia:
     * richiediamo che la bottiglia sia aperta. Dal momento che "aggiungi"
     * deve restituire la quantita` di liquido aggiunto anche nel caso in cui
     * la bottiglia sia chiusa, dobbiamo restituire un valore sensato (0 in
     * questo caso)
     */
    public int aggiungi(int quantita) {
        if (aperta)
            return super.aggiungi(quantita); /*
                                              * super.aggiungi() indica il metodo
                                              * "aggiungi" nella classe Bottiglia che stiamo estendendo
                                              */
        else
            return 0;
    }

    /*
     * OVERRIDE del metodo "rimuovi" per versare liquido dalla bottiglia:
     * stesse osservazioni
     */
    public int rimuovi(int quantita) {
        if (aperta)
            return super.rimuovi(quantita); /*
                                             * super.rimuovi() indica il metodo
                                             * "rimuovi" nella classe Bottiglia che stiamo estendendo
                                             */
        else
            return 0;
    }

    /*
     * OVERRIDE del metodo "toString()". Alla stringa che descrive una
     * bottiglia aggiungiamo l’informazione aperta/chiusa
     */
    public String toString() {
        return super.toString() + " (aperta = " + aperta + ")";
    }
}