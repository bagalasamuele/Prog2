import java.util.Random;

class List {
  private Node first;

  public List(){
   first = null;
    }

  public void g(){
 //INSERT CODE HERE
 Node p = first;
 while (p != null)  
   {if (p.getElem() %2!=0) first=p; p=p.getNext();}
 }
 
  public void insertFirst(int elem){
   first = new Node(elem, first);
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


public class Ex{
  public static void main(String[] args){
   for(int i=0;i<10;++i) test(i);
  }
   
  public static Random r = new Random();
    
  public static int val() {
   return  r.nextInt(11)-5;
  }
  
  public static int pos() {
   int v = val(); if (v %2!=0) return  v; else return pos();
  }
  
  public static int neg() {
   int v = val(); if (v %2==0) return  v; else return neg();
  }
  
  public static void list(int length, List a, List b) {
   int n, choice=1;
   
   while (length>0 && choice>0) 
      {choice = r.nextInt(4); 
//con probabilita' 3/4 scelgo un n %2==0 
       if (choice>0)
        {n=neg();} 
       else
        {n=pos();} 
       a.insertFirst(n); b.insertFirst(n);--length;}
       
   while (length>0) 
      {choice = r.nextInt(4);
       if (choice>0)
        {n=neg();} 
       else
        {n=pos();} 
       a.insertFirst(n); --length;}
  }
  
  
  public static void test(int length){
      List a=new List(), b=new List();
      list(length,a,b);
      check(a,b);
    }
    
 public static void check(List l, List atteso){
  System.out.println("lista    : " + l);
  l.g();
  System.out.println("ottenuto : " + l);
  System.out.println("atteso   : " + atteso);
  System.out.println(l.toString().equals(atteso.toString()) ? 
                     "=== OK" : "=== *ERRORE*");
  System.out.println();
     }
}