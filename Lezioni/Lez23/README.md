# Lezione 23 
## Esempio di compito di esame 
 
 ### Lezione 23. Esercizio 1 (30 minuti). 
 
 Siano date le classi (incomplete): 

```java
 abstract class Tree<T> {public abstract Tree<T> detach(T x);}

class Leaf<T> extends Tree<T> { 
  public Tree<T> detach(T x) { /* COMPLETARE */ } 
 } 

class Branch<T> extends Tree<T> { 
   private T elem;  
   private Tree<T> left;  
    private Tree<T> right; 
   public Branch(T elem, Tree<T> left, Tree<T> right)  
     {this.elem = elem;this.left = left;this.right = right;} 
   public Tree<T> detach(T x) { /* COMPLETARE */ } 
 } 

```
 Fornire le implementazioni (obbligatoriamente ricorsive) del metodo 
detach in Leaf e Branch in modo tale che t.detach(x) restituisca una 
versione modificata di t in cui ogni sottoalbero avente radice x è 
stato sostituito con l’albero vuoto leaf. detach(x) deve funzionare 
anche quando x=null. Se x non è presente, il metodo deve restituire 
l’albero invariato. Esempio. Sia t un albero di radice 2, figlio 
sinistro una foglia e figlio destro di radice -3. 
 
 t.detach(-3) deve restituire l’albero che contiene il solo elemento 
2. Realizzare il metodo detach in modo da minimizzare il numero di  
nuovi oggetti creati. Non è consentito aggiungere metodi, né usare cast 
o metodi della libreria standard di Java. Ricordatevi che per 
confrontare x con y=elem in T dovete usare “equals” controllando prima 
che x¹null, e “==” se x=null. 
254 
 
### Lezione 23. Esercizio 2 (30 minuti). 

```java
 interface I {public void m1(J obj);} 

 interface J {public void m2();} 

 abstract class C implements I {public abstract void m1(J obj);} 

class D extends C implements J { 
 public void m1(J obj)  
  {if (this != obj) obj.m2(); System.out.println("D.m1");} 
 public void m2()  
  {System.out.println("D.m2");m1(this);} 
 } 

```
Rispondere alle seguenti domande: 
1. Se si eliminasse il metodo m1 dalla classe C, il codice sarebbe 
comunque corretto? Perché? 
2. Il seguente codice è corretto? Se no, spiegare perché. Se sì, 
determinare cosa stampa. 

```java
I obj2 = new D(); 
((D) obj2).m2(); 
```

3. Il seguente codice è corretto? Se no, spiegare perché. Se sì, 
determinare cosa stampa.

```java
J obj3 = new D(); 
C x = (C) obj3; 
x.m1(new D()); 
```

4. Il seguente codice è corretto? Se no, spiegare perché. Se sì, 
determinare cosa stampa. 

```java
C obj4 = new D(); 
obj4.m1(obj4); 
```
 
 
### Lezione 23. Esercizio 3 (30 minuti). Sia dato il seguente metodo: 

```java
class Node<T> {public T elem; public Node<T> next; 
 public Node(T elem, Node<T> next){this.elem=elem;this.next=next;} 
 public T       getElem()             {return elem;}  
 public Node<T> getNext()             {return next;} 
 public void    setElem(T elem)       {this.elem=elem;}  
  public void    setNext(Node<T> next) {this.next=next;}} 
public class Esercizio3{ 
 public static <T extends Comparable<T>> void metodo(Node<T> p, T x) 
 { 
   while (x.compareTo(p.getElem()) < 0) // x < p.getElem() (in T) 
      p = p.getNext(); 
   p.setNext(null); 
 } 
  } 

```
1. Determinare sotto quali condizioni il metodo viene eseguito 
correttamente (cioè senza lanciare alcuna eccezione) e scrivere una 
corrispondente asserzione da aggiungere come precondizione per il 
metodo. Nello scrivere l’asserzione è possibile fare uso di eventuali 
metodi statici ausiliari che vanno comunque definiti anche se visti a 
 lezione. 
2. Descrivere in modo conciso e chiaro, in non più di 2 righe di testo, 
l’effetto del metodo. 
 
 