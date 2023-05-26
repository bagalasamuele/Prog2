# Lezione 12: Estensioni ripetute di classi

## Introduzione
Nella Lezione 12, esploreremo il concetto di estensione ripetuta di classi in Java. Spesso, il codice di un programma viene scritto attraverso una serie di modifiche successive. Una di queste modifiche può essere l'estensione di una classe esistente. Vedremo cosa accade quando estendiamo una classe più volte in Java.

## Procedura
Inizieremo con la classe `DynamicStack`, che rappresenta una pila dinamica (come descritto nella Lezione 08). Aggiungeremo due nuovi attributi: `max` (valore massimo) e `size` (numero di elementi) alla classe `DynamicStack`.

All'interno del file `DynamicStack.java`, sostituiremo la parola chiave `private` con `protected` davanti all'attributo `top`. Questo modificatore di visibilità consente di utilizzare `top` in tutte le classi nello stesso package (cartella) e in tutte le classi che estendono la classe corrente (in altre cartelle), ma non altrove. Nel nostro caso, dobbiamo accedere alla posizione `top` della pila quando calcoliamo il valore massimo in un'altra classe. L'utilizzo di `protected` ci impedisce di modificare un attributo di una classe importata da un'altra cartella (cosa che di solito è meglio evitare per prevenire la propagazione di errori tra le classi), ma semplifica la definizione di classi nella stessa cartella.

Estendere una classe richiede l'aggiunta di un'invariante di classe con le condizioni che descrivono i valori desiderati per `max` e `size`.

```java
// classi Node.java e DynamicStack.java: copiatele dalla Lezione 08
// Dopo aver copiato, nella definizione di DynamicStack sostituite:
//        "private Node top"       con       "protected Node top"
// Cancellate il costruttore DynamicStack(int n). Otterrete:


public class DynamicStack {
 protected Node top;
 /* Rispetto alla classe Dynamic Stack, cambia la visibilità di top
  da private a protected: visibile a tutte le classi dello stesso
  package, e a tutte le sottoclassi, anche in package diversi. Questo
  perché top dovrà essere accessibile da parte dei metodi delle
  sottoclassi di DynamicStack che definiremo. */
 public DynamicStack(){
  top = null;
}
     
 public boolean empty(){
  return top == null;
}
 public void push(int x) {
  top = new Node(x,top);
}
 public int pop(){
   assert !empty();
   int x = top.getElem();
   top = top.getNext();
   return x;
}
 public int top(){
  assert !empty();
  int x = top.getElem();
  return x;
}
 public String toString(){
  Node temp = top; String s = "";
  while (temp!=null){
   s = s + " || " + temp.getElem() + "\n";
   temp = temp.getNext();
  }
return s; }
}
//DynamicStackMax.java
public class DynamicStackMax extends DynamicStack {
// Manteniamo il campo top di tipo Node e aggiungiamo
private int max;
/* INVARIANTE di classe di DynamicStack: top punta alla cima della
pila. Aggiungiamo: SE lo stack non e` vuoto, allora max contiene il
massimo valore dello stack, se lo stack e' vuoto il valore di max e'
arbitrario */

/* COSTRUTTORE. Dobbiamo spesso fornire un costruttore per le classi
estese: raramente il costruttore di default fornito da Java per una
estensione e' sensato */
public DynamicStackMax(){
  super();
  //Invoco il costruttore della classe superiore con 0 argomenti
max = 0;
  // inizializziamo il nuovo attributo, max, anche se il suo valore
  // non ha senso quando lo stack e' vuoto. Quando lo stack e' vuoto
  // non consentiremo l'uso di max.
}
// NUOVO metodo get per il nuovo campo max
public int getMax(){
  assert !empty(); // se pila vuota: non corretto chiedere il massimo
  return max;
}
// OVERRIDE del metodo push(int n): inseriamo di un elemento in cima
// alla pila aggiornando il valore del massimo
public void push(int n){
 if (empty())
   max=n;
 //se la pila e' vuota il massimo e' l'elemento n appena inserito
else
//altrimenti e' il massimo tra elemento inserito e il max. precedente
   max = Math.max(max, n);
  super.push(n); //invoco il push della classe superiore
}
// NUOVO metodo per ricalcolare max, se abbiamo motivo per
// dubitare che max sia davvero il massimo della pila
// Nota: possiamo usare il nodo "top" della pila perche' abbiamo
// dichiarato top "protected" e quindi accessibile nelle classi che
// estendono DynamicStack oppure si trovano nella stessa cartella.
private void resetMax(){
  if (!empty()){ //se la pila e' vuota ogni valore di max va bene
    // altrimenti ricalcolo il massimo della pila

    max = top.getElem();
    // calcolo il max tra il primo elemento della pila e gli altri;
    // per evitare di modificare l’indirizzo top della pila introduco
    // una nuova variabile p di tipo nodo con valore subito dopo top
  for (Node p = top.getNext(); p != null; p = p.getNext())
     max = Math.max(max, p.getElem());
} }
// OVERRIDE di pop(): rimozione di un elemento dalla cima della pila
// Attenzione: puo' richiedere il ricalcolo del massimo
public int pop(){
 assert !empty();
 int n = super.pop(); //invoco il pop() della classe superiore
 // Se l'elemento tolto e' il massimo allora il massimo puo' cambiare
 // e quindi va ricalcolato.
 if (n == max) resetMax();
 return n;
}
//EREDITA' - Il metodo top() e' ereditato, non deve essere riscritto:
//leggere l'elemento in cima alla pila non cambia il max della pila
 //OVERRIDE del metodo di conversione in stringa
 public String toString(){
  return super.toString() + " || max= " + max + "\n";
} }

//DynamicStackSize.java
public class DynamicStackSize extends DynamicStackMax {
  private int size; // Aggiunta all’INVARIANTE di classe:
  // "size" = numero elementi sullo stack
  //COSTRUTTORE Dobbiamo quasi sempre definire un costruttore per le
  // estensioni il costruttore di default in genere non e' affidabile

public DynamicStackSize(){
   super();
//Invoco il costruttore della classe superiore:0 argomenti
/* Se il costruttore della sottoclasse non richiama esplicitamente un costruttore della classe superiore, per prima cosa viene
chiamato automaticamente il costruttore predefinito della classe superiore, cioe' quello senza parametri (super()); se la classe superiore non ha un costruttore senza parametri il compilatore genera un errore. */
size = 0; }
// NUOVO metodo get per il nuovo campo size
public int getSize() {
  return size;
}
// OVERRIDE del metodo push: inserimento elemento in cima alla pila
public void push(int n) {
  super.push(n); //invoco il metodo push(n) della classe superiore
  size++;        //aggiorno il numero degli elementi
}
// OVERRIDE del metodo pop: rimozione elemento dalla cima della pila
public int pop(){
 assert !empty();
 size--;             //aggiorno il numero degli elementi
 return super.pop(); //invoco il metodo pop() della classe superiore
}
//EREDITA' - top() viene ereditato e non deve essere riscritto:
//leggere l'elemento in cima alla pila non cambia il size della pila
//OVERRIDE del metodo di conversione in stringa
public String toString(){
  return super.toString() + " || size = " + size + "\n";
} }

// Sperimento la classe DynamicStackSize
//DynamicStackSizeDemo.java

public class DynamicStackSizeDemo{
  public static void main(String[] args){
   System.out.println( "Definisco la pila P = {-1}");
   DynamicStackSize P = new DynamicStackSize();
   P.push(-1);
