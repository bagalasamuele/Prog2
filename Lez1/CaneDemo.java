/** Questo file contiene il programma CaneDemo presente
 nella Lezione 1 delle dispense, con spiegazione aggiuntiva sul 'this' e commenti e esempi in più sul metodo toString(), MA senza gli altri commenti.
 */

import java.util.Scanner;

class Cane { // Classe come generatore/blueprint di oggetti
  // Stato: campi dell'oggetto (a loro volta possono essere di
  // tipo oggetto)
  /** Ogni classe induce un tipo oggetto che corrisponde alla classe   stessa. Per esempio, la classe Cane induce il tipo Cane, che può   essere usato come qualsiasi altro tipo predefinito Java.
   */
  public String nome; 
  public String razza; 
  public int anni;
 
 Scanner tastiera = new Scanner(System.in); 

 // Operazioni: metodi dinamici
 public void leggiInput() {
  /** La variabile 'this' è una variabile riservata di Java presente 
   in *ogni metodo dinamico* e che serve per contenere l'indirizzo dell'oggetto su cui è stato invocato il metodo stesso (per esempio nel main() o in altro metodo). Tramite 'this', posso accedere a tutti i campi (e a tutti i metodi) dell'oggetto. Per esempio, se nel main() scrivo:
         Cane fido = new Cane();
         ...
         fido.leggiInput();
   il 'this' in leggiInput() per questa chiamata assumerà il valore
   della variabile 'fido' (di tipo Cane) e quindi tramite essa potrò accedere ai campi dell'oggetto puntato (anche) da 'fido'. Possiamo quindi dire che 'this' è un alias di 'fido' durante l'esecuzione del metodo leggiInput().
   Se poi nel main() scriviamo:
         Cane cipria = new Cane();
         ...
         cipria.leggiInput();
   nell'esecuzione di leggiInput() che corrisponde a questa chiamata il 'this' diventerà l'alias dell'oggetto puntato dalla variabile 'cipria'.
   La variabile 'this' si usa per referenziare i campi dell'oggetto,
   per esempio:
        this.nome = "bobi";
   Il 'this' può essere lasciato sintatticamente implicito, se non ci sono variabili locali o parametri con lo stesso nome. Si può quindi scrivere:
        nome = "bobi";
   "Sintatticamente implicito" vuol dire che il 'this' è comunque presente anche se non è scritto esplicitamente.
   */
     
  System.out.println( " nome = " );
  this.nome = tastiera.nextLine(); 
  System.out.println( " razza = " );
  this.razza = tastiera.nextLine(); 
  System.out.println( " anni = " );
  this.anni = tastiera.nextInt();
  tastiera.nextLine();
 }

/** Metodo toString(). È un metodo dinamico, ovvero viene invocato su un oggetto e quindi contiene la variabile implicita 'this', come spiegato sopra. Restituisce una stringa composta a piacere dal progrmmatore. Di solito si usa per avere una "pretty printing" del valore dei campi di un oggetto, ma come la stringa viene costruita dipende dal programmatore. Il metodo toString() con tipo di ritorno String e nessun parametro esplicito (i parametri tra parentesi) appartiene allo standard Java e in particolare è presente nella classe 'Object', classe "parent" di tutte le classi Java. Parleremo della gerarchia di classi più avanti (e delle nozioni collegate di "ereditarietà" e override/sovrascrittura dei metodi) più avanti.

IMPORTANTE: LA toString() NON STAMPA! Restituisce una stringa che può essere utilizzata da un metodo che stampa (che è bene non sia scelto a priori, per lasciare libertà ai progettisti del software), come per esempio il metodo System.out.println(). Infatti, per esempio, nel codice di System.out.println() quando le si passa un oggetto, come in:
        System.out.println(fido);
 viene proprio richiamato il metodo 'toString()' (noi non vediamo questa chiamata a toString() perché sta nel codice della 'println'). 
 Se la classe dell'oggetto, in questo caso 'Cane', contiene una sua versione di toString(), allora verrà eseguita questa, altrimenti verrà eseguita la toString() di 'Object', che restituisce una rappresentazione dell'indirizzo di memoria heap dove è memorizzato l'oggetto. La println() stampa la stringa che la toString() le restituisce.
 Per questo, andando a commentare la toString() in Cane, ottenevamo l'indirizzo e invece, andandola a de-commentare, ottenevamo di nuovo una stampa dei campi concatenati con delle stringhe costanti (come implementato nella toString() della classe Cane).
*/
public String toString(){
 // prima versione della toString():
 return " nome  = " + this.nome + "\n razza = " + this.razza + 
      "\n anni = " + this.anni;
 // una seconda versione:
 //String s = " nome  : " + nome;
 //return s;
 
 // una terza versione (abbastanza inutile, ma possibile)
 // return "ciao";

 // una quarta versione:
 // return this.razza;
 
 // una quinta versione - SBAGLIATA!
 // return System.out.println(razza);
 // SI DEVE RESTITUIRE UN RISULTATO DI TIPO String! 
 // INOLTRE NON È COMPITO DI toString() di stampare ma
 // di chi la usa!!!

 // ecc.
}

  public int getEtaInAnniUmani(){
       if (anni <=2) 
        return anni*11; 
       else 
        return 22 + (anni-2)*5;
  }
}

public class CaneDemo { 
//Una classe e' eseguibile se ha un main, come questo:
  public static void main(String[] args) {
    Cane fido = new Cane(); 
    String test =  new String();
/** Il comando C x = new C(); costruisce un nuovo oggetto x di tipo C con valori di default per gli attributi. Nel caso di un cane: null, null, 0 per gli attributi: nome, razza, anni */
    System.out.println(test); 
    System.out.println( "fido prima inserimento dati" );
    // stampo i valori di default: null, null, 0
    // se c'è la toString() in Cane
    System.out.println(fido); 
    System.out.println( "Inserisci dati fido" );
    fido.leggiInput();
    System.out.println( "Dati inseriti fido" );
    // stampo i valori 
    System.out.println(fido); 
    System.out.println( "eta' fido in anni umani  " 
                         + fido.getEtaInAnniUmani());
    
    Cane bobi = new Cane(); 
    /** Questo crea un nuovo oggetto di tipo Cane con valori di default null, null, 0 per gli attributi nome, razza, anni*/
    System.out.println( "Inserisco dati bobi dentro il programma" );
    bobi.nome = "Bobi";
    bobi.razza = "Terrier";
    bobi.anni = 5;
    System.out.println(bobi); 
      
    Cane cipria = new Cane();
    cipria.leggiInput();
 }
}