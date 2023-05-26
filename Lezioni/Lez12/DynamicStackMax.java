

// DynamicStackMax.java
public class DynamicStackMax extends DynamicStack {
    // Manteniamo il campo top di tipo Node e aggiungiamo
    private int max;
    /*
     * INVARIANTE di classe di DynamicStack: top punta alla cima della
     * pila. Aggiungiamo: SE lo stack non e` vuoto, allora max contiene il
     * massimo valore dello stack, se lo stack e' vuoto il valore di max e'
     * arbitrario
     */

    /*
     * COSTRUTTORE. Dobbiamo spesso fornire un costruttore per le classi
     * estese: raramente il costruttore di default fornito da Java per una
     * estensione e' sensato
     */
    public DynamicStackMax() {
        super();
        // Invoco il costruttore della classe superiore con 0 argomenti
        max = 0;
        // inizializziamo il nuovo attributo, max, anche se il suo valore
        // non ha senso quando lo stack e' vuoto. Quando lo stack e' vuoto
        // non consentiremo l'uso di max.
    }

    // NUOVO metodo get per il nuovo campo max
    public int getMax() {
        assert !empty(); // se pila vuota: non corretto chiedere il massimo
        return max;
    }

    // OVERRIDE del metodo push(int n): inseriamo di un elemento in cima
    // alla pila aggiornando il valore del massimo
    public void push(int n) {
        if (empty())
            max = n;
        // se la pila e' vuota il massimo e' l'elemento n appena inserito
        else
            // altrimenti e' il massimo tra elemento inserito e il max. precedente
            max = Math.max(max, n);
        super.push(n); // invoco il push della classe superiore
    }

    // NUOVO metodo per ricalcolare max, se abbiamo motivo per
    // dubitare che max sia davvero il massimo della pila
    // Nota: possiamo usare il nodo "top" della pila perche' abbiamo
    // dichiarato top "protected" e quindi accessibile nelle classi che
    // estendono DynamicStack oppure si trovano nella stessa cartella.
    private void resetMax() {
        if (!empty()) { // se la pila e' vuota ogni valore di max va bene
            // altrimenti ricalcolo il massimo della pila

            max = top.getElem();
            // calcolo il max tra il primo elemento della pila e gli altri;
            // per evitare di modificare l’indirizzo top della pila introduco
            // una nuova variabile p di tipo nodo con valore subito dopo top
            for (Node p = top.getNext(); p != null; p = p.getNext())
                max = Math.max(max, p.getElem());
        }
    }

    // OVERRIDE di pop(): rimozione di un elemento dalla cima della pila
    // Attenzione: puo' richiedere il ricalcolo del massimo
    public int pop() {
        assert !empty();
        int n = super.pop(); // invoco il pop() della classe superiore
        // Se l'elemento tolto e' il massimo allora il massimo puo' cambiare
        // e quindi va ricalcolato.
        if (n == max)
            resetMax();
        return n;
    }

    // EREDITA' - Il metodo top() e' ereditato, non deve essere riscritto:
    // leggere l'elemento in cima alla pila non cambia il max della pila
    // OVERRIDE del metodo di conversione in stringa
    public String toString() {
        return super.toString() + " || max= " + max + "\n";
    }
}
