public class Bottiglia {
    private int capacita; // 0 <= capacita
    private int livello; // 0 <= livello <= capacita
    // IllegalArgumentException e' una eccezione non controllata,
    // dunque se la sollevo NON sono obbligato ad aggiungere
    // "throws IllegalArgumentException" alla segnatura di
    // Bottiglia(int capacita), e non sono obbligato a catturarla

    public Bottiglia(int capacita) {
      if (capacita < 0)
       throw new IllegalArgumentException("capacita negativa:"+capacita);
      this.capacita = capacita; this.livello = 0;
     }

    public int getCapacita() {
        return this.capacita;
    }

    public int getLivello() {
        return this.livello;
    }

    public void aggiungi(int quantita) {
        if (quantita < 0)
            throw new IllegalArgumentException("aggiungi: quantita negativa");
        livello = Math.min(livello + quantita, capacita);
    }

    public int rimuovi(int quantita) {
        if (quantita < 0)
            throw new IllegalArgumentException("rimuovi: quantita negativa");
        int rimossa = Math.min(quantita, livello);
        this.livello -= rimossa;
        return rimossa;
    }
}
