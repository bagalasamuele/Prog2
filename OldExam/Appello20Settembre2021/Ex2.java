
/*
Esercizio 2
1.Completate il metodo void f() in List, in modo che f() elimini dalla lista il primo elemento maggiore di zero, se la somma della lista è maggiore di zero (in questo caso siamo certi che esiste almeno un maggiore di zero). Altrimenti f() lascia la lista invariata. Non modificate altro che il metodo. Avete a disposizione un metodo int sum() in List per sommare gli elementi di una lista: non dovete definirlo voi. Ricordatevi: per "eliminare" un nodo p diverso dal primo, usate setNext far puntare il nodo precedente al nodo p al nodo successivo al nodo p.
2.Fate verificare la risposta a Moodle. Non definite il vostro metodo per casi sui test. Se la risposta passa il controllo inviate tutto e terminate, altrimenti correggete gli errori. Normalmente i test devono essere tutti giusti perché la soluzione abbia valore.
*/

import java.util.Random;
public class Ex2{
  public static void main(String[] args){
   test(5);
  }
   
  public static Random r = new Random();
    
  public static int val() {
   return  r.nextInt(11)-5;
  }
  
  public static int pos() {
   int v = val(); if (v > 0) return  v; else return pos();
  }
  
  public static int neg() {
   int v = val(); if (v <= 0) return  v; else return neg();
  }
  
  public static void listNeg(int length, List a, List b) {
   int n; 
   while (length>0) 
      {n=neg(); a.insertFirst(n); b.insertFirst(n);--length;}
  }
  
  
  public static void testNeg(int length){
      List a=new List(), b=new List();
      listNeg(length,a,b);
      check(a,b.toString());
    }

  public static void testPos(int length){
      List a=new List(), b=new List();
      listNeg(length,a,b); int i = r.nextInt(length+1); a.insert(i,25*pos());
      check(a,b.toString());
    }
     
 public static void test(int n)
 {for(int i=0;i<n;++i){testNeg(i);testPos(i);}}
    
 public static void check(List l, String atteso){
  System.out.println("lista    : " + l + "\nsum()    : " + l.sum());
  l.f();
  System.out.println("ottenuto : " + l);
  System.out.println("atteso   : " + atteso);
  System.out.println(l.toString().equals(atteso) ? "=== OK" : "=== *ERRORE*");
  System.out.println();
     }
}


class List {
  private Node first;

  public List(){
   first = null;
    }

  public void f(){
//INSERT CODE HERE
 }
 
  public void insertFirst(int elem){
   first = new Node(elem, first);
  }
  
  public int sum(){
      int ris=0; Node curr=first;
      while (curr!=null)
       {ris=ris + curr.getElem(); curr=curr.getNext();}
      return ris;
  }

   public void insert(int i, int elem){
   if (i==0) 
      insertFirst(elem);
   else
   {--i;
    Node p=first; 
    while(i>0)
       {p=p.getNext();--i;}
    p.setNext(new Node(elem,p.getNext()));}
  }
  
  public String toString(){
   String s = "";
   for (Node p = first; p != null; p = p.getNext()) {
    if (p != first) s += ", ";
    s += p.getElem();
   }
   return s;
  }
     
}

class Node {
 private int elem;
 private Node next;

 Node(int elem, Node next){
  this.elem = elem;
  this.next = next;
 }

 int getElem(){
  return elem;
 }

 void setElem(int elem){
  this.elem = elem;
 }

 Node getNext(){
  return next;
 }

 void setNext(Node next){
  this.next = next;
 }
}

