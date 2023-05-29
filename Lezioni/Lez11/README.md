# Lezione 11 Ereditarietà e assert

Lezione 11. Parte 1. Un primo esempio di estensione di una classe: la classe BottigliaConTappo. Vediamo come definire una nuova classe D da una classe data C, aggiungendo nuovi attributi/metodi e riscrivendo una parte dei metodi già esistenti, ma per il resto riutilizzando i metodi di C per quanto è possibile. Questo sia allo scopo di ridurre il lavoro, sia allo scopo di evitare la moltiplicazione degli errori, quasi inevitabile quando si moltiplica del codice simile. Inoltre riutilizzando il codice di C lo ricontrolliamo e lo correggiamo, e ci troviamo ad utilizzare codice più sicuro. D viene detta estensione o sottoclasse di C. Come esempio, riprendiamo la classe Bottiglia della Lezione 05 e aggiungiamo alla bottiglia due stati, aperto/chiuso, con la regola che una bottiglia per dare o ricevere acqua deve essere aperta. Di conseguenza, alcuni metodi devono venir modificati. Chiamiamo la classe così ottenuta BottigliaConTappo.

Per cominciare, rivediamo rapidamente la definizione della classe Bottiglia. Una bottiglia ha una capacità (non modificabile) e un livello (modificabile). Oltre ai metodi get e set, aggiungiamo metodi per aggiungere e rimuovere una quantità a una bottiglia (nei limiti del possibile). Per evitare modifiche alla capacità non forniamo un metodo get per la capacità.

```java
// Bottiglia.java
public class Bottiglia{
    // quantita' intere espresse in litri
    private int capacita; // 0 <= capacita
    private int livello;  // 0 <= livello <= capacita

    public Bottiglia(int capacita){
        this.capacita = capacita;
        livello = 0;
        assert (0<=livello) && (livello <= capacita);
    }

    /* Aggiungiamo tutta la parte di una quantita' data che trova posto
    nella bottiglia e restituiamo la quantita effettivamente aggiunta. */
    public int aggiungi(int quantita){
        assert quantita >= 0;
        int aggiunta = Math.min(quantita, capacita-livello);
        livello = livello + aggiunta;
        assert (0<=livello) && (livello <= capacita);
        return aggiunta;
    }

    /* Rimuoviamo la quantita' richiesta se c'e', altrimenti togliamo
    tutto, restituiamo la quantita' effettivamente rimossa. */
    public int rimuovi(int quantita){
        int rimossa = Math.min(quantita, livello);
        livello = livello - rimossa;
        assert (0<=livello) && (livello <= capacita);
        return rimossa;
    }

    public int getCapacita(){ 
        return this.capacita; 
    }

    public int getLivello() { 
        return this.livello; 
    }

    public void setLivello(int livello){
        this.livello = livello;
        assert (0<=livello) && (livello <= capacita);
    }

    public String toString.
