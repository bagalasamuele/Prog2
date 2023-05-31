//Bottiglia.java - Riprendiamo la classe Bottiglia della Lezione 5
//aggiungendo un confronto tra bottiglie basato sul solo livello.
public class Bottiglia implements Comparable<Bottiglia> {
    private int capacita, livello; // 0 <= livello <= capacita'!=0

    public Bottiglia(int capacita) {
        this.capacita = capacita;
        livello = 0;
        assert (0 <= livello) && (livello <= capacita) && (capacita != 0);
    }

    // Restituiamo la quantita' effettivamente aggiunta
    public int aggiungi(int quantita) {
        assert quantita >= 0 : "la quantita' doveva essere >=0 invece vale " + quantita;
        int aggiunta = Math.min(quantita, capacita - livello);
        livello = livello + aggiunta;
        assert (0 <= livello) && (livello <= capacita) && (capacita != 0);
        return aggiunta;
    }

    // Restituiamo la quantita' effettivamente rimossa
    public int rimuovi(int quantita) {
        assert quantita >= 0 : "la quantita' doveva essere >=0 invece vale " + quantita;
        int rimossa = Math.min(quantita, livello);
        livello = livello - rimossa;
        assert (0 <= livello) && (livello <= capacita) && (capacita != 0);
        return rimossa;
    }

    public int getCapacita() {
        return this.capacita;
    }

    public int getLivello() {
        return this.livello;
    }

    // Non consentiamo di cambiare la capacita'
    public void setLivello(int livello) {
        this.livello = livello;
        assert (0 <= livello) && (livello <= capacita) && (capacita != 0);
    }

    public String toString() {
        return livello + "/" + capacita;
    }

    /**
     * Siccome Bottiglia implements Comparable<Bottiglia>, dobbiamo
     * fornire un metodo compareTo():
     */
    public int compareTo(Bottiglia b) {
        return this.livello - b.livello;
    }

    // La differenza di livello e' 0 se le bottiglie hanno lo stesso
    // livello, e' >0 se this ha livello maggiore, e' <0 altrimenti
}
// end class Bottiglia