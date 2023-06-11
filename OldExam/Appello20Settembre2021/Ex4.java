
/*
Esercizio 4
1.Leggete attentamente la definizione del metodo public static void k(Node p, int[] u, int n). Completate il corpo del metodo public static boolean ok(Node p, int[] u, int n) in modo che restituisca vero se e solo se l'esecuzione di k(p,u, n) completerebbe senza sollevare eccezioni, nè restituendo valori inf, NaN. Non usate 'catch', ma fornite un algoritmo che decida quando non ci sono eccezioni/inf/NaN. Non modificate altro che il corpo di ok. 
2.Fate verificare la risposta a Moodle. Non definite il vostro metodo per casi sui test. Se la risposta passa il controllo inviate tutto e terminate, altrimenti correggete gli errori. Normalmente i test devono essere tutti giusti perché la soluzione abbia valore.
 
*/

import java.util.*;

//CLASS Ex
class Ex4{
//METHOD TO FILL IN  
  public static boolean ok(Node p, int[] u, int n )
  { 
   /* INSERT CODE HERE */
  }
    
 public static void k(Node p, int[] u, int n)
 {
  for(int i=0; i<u.length;i++) 
  {
   if(Math.sqrt(u[i]) <= n) 
   {
    Node q = p;
    for(int j=0;j<u[i];j++) 
     q=q.getNext();
    System.out.println(q.getElem());
   }
  }
 } 
     
//TEST DEFINITION
public static String toString(Node p){
 String s="";
 while(p!=null){
  s=s+p.getElem()+" ";
  p=p.getNext();
 }
 return s;
 }

public static String toString(int[] v){
 int i=0, l = v.length;
 String s="";
 while(i<l){
  s=s+v[i]+" ";
  i=i+1;
 }
 return s;
}

public static Random r = new Random();

public static Node list(int n){
 Node p = null;
 for(int i=n;i>0;i--) {
  p = new Node(r.nextInt(10)-2,p);
 }
 return p;
  
}
  
public static void test(){ 
 
 boolean val = true;
 int n = r.nextInt(3);
 int m = r.nextInt(3);
 Node p = list(n);
 int u[] = new int[r.nextInt(5)];
    for(int i=0;i<u.length;i++) {
     u[i] = r.nextInt(3);
     u[i] = u[i]*u[i];
     if (r.nextInt(10)==0) 
      u[i]=-1;
     val = val && (u[i]>=0)
     &&((Math.sqrt(u[i]) <= m)==false 
       || u[i] < n); 
    }
    check("p = " + toString(p) + 
      "\nv = "+ toString(u)+
      "\nn = "+m+"\nok(p, v, " + m + ")=",
            Ex.ok(p,u,m),
            val);
    
 }

 //USE "*" ONLY FOR FAILURE, NEVER USE IN msg
  public static void check(String s, boolean a, boolean b)
   {if (a==b) 
     System.out.println(s + a + " OK"); 
    else 
     System.out.println(s + a + " *EXPECTED* " + b + "\n");}

//TEST EXECUTION    
  public static void main(String[] args){ 
   for(int i=0;i<10;++i) 
   {System.out.println("   ------test n." + i + "------"); test();}
  }
}


//CLASS Node
class Node { 
 private int elem; 
 private Node next;
 public Node(int elem, Node next){
  this.elem=elem;this.next=next;
 }
 public int getElem(){
  return elem;
 }
 public Node getNext(){
  return next;
 }
 public void setElem(int elem){
  this.elem=elem;
 }
 public void setNext(Node next){
  this.next=next;
 }
}
