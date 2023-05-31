#Lezione 21

##Esempi di esercizi di esame con soluzioni

Lezione 21. Forniamo esempi di esercizi di esami degli anni passati per gli argomenti del corso visti finora. Resta un solo argomento da svolgere, le eccezioni. Rimandiamo quest’ultimo argomento alla lezione successiva.

Lezione 21. Esercizio 1. Supponete sia già data la classe Node<T> di nodi generica. Node<T> rappresenta le liste concatenate su una classe T generica, e null denota la lista vuota. In Node<T> avete i metodi T getElem() e Node<T> getNext(). Come test di eguaglianza in T, vi chiediamo di usare boolean x.equals(T y), che funziona per ogni oggetto x non null di T. Supponete di avere due liste rappresentate da nodi p, q di Node<T>, e che gli elementi di p,q siano tutti non null (dunque potete usare equals). Realizzate un metodo

```java
public static <T> boolean inComune(Node<T> p, Node<T> q)
```

che restituisce true se e solo se esiste un elemento x che occorre in entrambe le liste p e q nella stessa posizione. Ad esempio, nel caso sia T=Integer, inComune(p,q) deve restituire i seguenti valori (nel disegno qui sotto numeriamo le posizioni da 0 e abbreviamo "posizione" con "pos."):

posizioni   di p:  0 1 2   di q:  0 1 2
• true se p è [5,7] e q è [8,7,1] (7 in pos. 1 è in comune)
• true se p è [4,3,2] e q è [1,2,2] (2 in pos. 2 è in comune)
• true se p è [1,2,3] e q è [3,2,1] (2 in pos. 1 è in comune)
• false se p è [1,2] e q è [2,1]
• false se una lista è vuota oppure lo sono entrambe. È obbligatorio definire inComune in modo ricorsivo.

Lezione 21. Esercizio 2. Siano date le classi

```java
abstract class A {
  public abstract void m1();
}

abstract class B extends A {
  public void m1()      {System.out.println("B.m1");}
  public abstract void m2(A obj);
}

class C extends B {
  public void m1()      {System.out.println("C.m1");super.m1();}
  public void m2(A obj) {System.out.println("C.m2");obj.m1();}
}

```

Rispondete alle seguenti domande:

1. Se si eliminasse il metodo m2 dalla classe B, il codice che definisce A,B,C sarebbe comunque corretto? Perché?
2. Il seguente codice è corretto? Se no, spiegare perché. Se sì, determinare cosa stampa.

```java
A obj2 = new B();
obj2.m1();
```

3. Il seguente codice è corretto? Se no, spiegare perché. Se sì, determinare cosa stampa.

```java
A obj3 = new C();
obj3.m1();
```

4. Il seguente codice è corretto? Se no, spiegare perché. Se sì, determinare cosa stampa.

```java
A obj4 = new C();
obj4.m2(obj4);
```




Lezione 21. Esercizio 3. Supponete sia già data la classe Node (concreta e senza uso di generici) per rappresentare nodi di liste concatenate su interi. In Node null denota la lista vuota, e abbiamo gli usuali metodi get e set. Sia dato il codice:


```java
public static void metodo(Node p)
{
 while (p != null)
 {
  if (p.getElem() < 0 && p.getNext().getElem() > 0)
    p.setNext(p.getNext().getNext());
  p = p.getNext();
 }
}
```

1. Scrivete una asserzione che descrive sotto quali condizioni si può eseguire il metodo. Aggiungete l'asserzione nella prima riga del metodo, come precondizione. L'asserzione deve consentire l'esecuzione del metodo se e solo se l'esecuzione non solleva eccezioni. Nello scrivere l'asserzione è possibile fare uso di eventuali metodi statici ausiliari che vanno comunque definiti anche se visti a lezione.

2. Descrivere in modo conciso e chiaro, in non più di 2 righe di testo, l'effetto del metodo.

Lezione 21. Esercizio 4. Date le classi astratte ricorsive:


```java
abstract class Tree {
    public abstract Tree insert(int elem);
}

class Leaf extends Tree {
    public Tree insert(int elem) {
        return new Branch(elem, this, this);
    }
}

class Branch extends Tree {
    private int elem;
    private Tree left;
    private Tree right;

    public Branch(int elem, Tree left, Tree right) {
        this.elem = elem;
        this.left = left;
        this.right = right;
    }

    public Tree insert(int elem) {
        System.out.println("CHECK POINT 2");
        if (elem < this.elem)
            left = left.insert(elem);
        else if (elem > this.elem)
            right = right.insert(elem);
        return this;
    }
}

public class Esercizio4 {
    public static void main(String[] args) {
        Tree t = new Leaf();
        t = t.insert(3);
        t = t.insert(1);
        t = t.insert(4);
        t = t.insert(2);
        System.out.println("CHECK POINT 1");
    }
}
```

si disegni una rappresentazione dello stato della memoria (Stack e Heap):

1. al check point 1;
2. la prima volta che l'esecuzione raggiunge il check point 2.

