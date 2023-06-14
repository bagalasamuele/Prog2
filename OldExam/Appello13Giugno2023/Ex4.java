package OldExam.Appello13Giugno2023;
// Salvate tutto in un solo file Ex.java.
// Leggete attentamente la definizione del metodo Node l(Node p). Completate il corpo del metodo boolean ok(Node p) in modo che restituisca vero se e solo se eseguire il metodo Node l(Node p) completerebbe senza sollevare eccezioni, nè restituendo valori inf, NaN. Non usate 'catch', ma fornite un algoritmo che decida quando non ci sono eccezioni/inf/NaN. Non modificate altro che il corpo di ok.
// Eseguite il main della classe Ex come test per la risposta. Non definite il vostro metodo per casi sui test.
// Ricopiate nel Quiz e fate verificare di nuovo le risposte dal Quiz, se passano il secondo controllo inviate tutto e terminate, altrimenti correggete gli errori. Normalmente un programma con errori vale 0 punti.


import java.util.*;

class Ex{
//METHOD TO FILL IN  
  public static boolean ok(Node p )
  { 
    return false;
  }
//Mia Soluzione:
//   public static boolean ok(Node p )
//   { 
//       Node aux = p;
      
//       if((p == null) || (p.getNext() == null)){
//           return false;
//       }
//       while(aux.getNext() != null){
//           if(aux.getElem() >= aux.getNext().getElem()){
//                     return true;     
//           }
//           aux = aux.getNext(); 
//       }
      
//     return false;
//   }
    
 public static Node l(Node p)
  { while( (p.getElem() >= p.getNext().getElem()) 
           == false ) 
     { p=p.getNext(); } 
    return p; } 
     
//TEST DEFINITION
public static String toString(Node p)
 { String s="";
  while(p!=null) { s=s+p.getElem()+" "; p=p.getNext();}
  return s;
 }

public static Random r = new Random();
public static int r(int a){return a + r.nextInt(11) - 5;}
public static int prop(int a, boolean b)
 {int i = r(a); 
  if ( ( (i >= a) == false ) == b ) 
   return i;
  else
   return prop(a,b);}
   
public static Node list(int a, int n,boolean ris)
 {if (n==0) 
   return null;
  else if (n==1) 
   return new Node(a,null);
  else
  {Node p=new Node(a,null); 
   int j = (ris==true) ? r.nextInt(n-1)+1 : n;
   for(int i=1;i<n;++i) 
    if (i == j) 
     {a=prop(a,false); p=new Node(a,p);}
    else 
     {a=prop(a,true); p=new Node(a,p);}
   return p;}
 }
  
public static void test(int a, int n, boolean ris)
{ Node p = list(a,n,ris); 
  check("p = " + toString(p) + " ok(p)=",
       ok(p),
       ris);
}

public static void test()
 { int a = r.nextInt(11)-5;
   System.out.print("liste di lunghezza <= 1: \n");
   test(a,0,false);test(a,1,false);
   for(int i=2;i<10;i++) 
     {System.out.print("liste di lunghezza " + i + ":\n"); 
      a = r.nextInt(11)-5;
      test(a,i,true); 
      test(a,i,false);}
 }
     
//COMPARING WITH THE CORRECT ANSWER
//USE "*" ONLY FOR FAILURE, NEVER USE IN msg
  public static void check(String s, boolean a, boolean b)
   {if (a==b) 
     System.out.println(s + a + " OK"); 
    else 
     System.out.println(s + a + " *EXPECTED* " + b);}

//TEST EXECUTION    
  public static void main(String[] args)
   { test(); }
}

class Node { private int elem; private Node next;
  public Node(int elem, Node next){this.elem=elem;this.next=next;}
  public int getElem(){return elem;}
  public Node getNext(){return next;}
  public void setElem(int elem){this.elem=elem;}
  public void setNext(Node next){this.next=next;}}