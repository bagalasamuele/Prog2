// Completate il metodo statico public static int contaMinoriUguali(Node p, Node q) in NodeSimulazione, in modo che contaMinoriUguali(p,q) restituisca il numero degli elementi nella sequenza di nodi che inizia in p che sono minori o uguali del corrispondente elemento in q. Non modificate altro che il metodo. Per questo esercizio è molto più facile una soluzione ricorsiva.
// Esempio.  Se la sequenza che inizia in p ha elementi [1,2,3,4], la sequenza che inizia in q ha elementi [10,2,3,0] allora e contaMinoriUguali(p,q) restituisce 3, dato che per i primi tre elementi di p abbiamo 1<=10, 2<=2, 3<=3, mentre non abbiamo 4<=0. Se le sequenze hanno lunghezza diversa confrontate soltanto le posizioni che hanno in comune.
// Fate verificare la risposta a Moodle. Non definite il vostro metodo per casi sui test. Se la risposta passa il controllo inviate tutto e terminate, altrimenti correggete gli errori. Normalmente i test devono essere tutti giusti perché la soluzione abbia valore.


public class NodeSimulazione
{

//QUESTA E' LA DOMANDA
 public static int contaMinoriUguali(Node p, Node q){  
   Node auxP = p;
   Node auxQ = q;
   int elem = 0;
   
   while(auxP != null && auxQ != null){
       if(auxP.getElem() <= auxQ.getElem()) {
           elem = elem + 1;
       }
       
       auxP = auxP.getNext();
       auxQ = auxQ.getNext();
   }
    
         return elem;
 //FINE DOMANDA
  }
  
 public static String toString(Node p)
//Metodo statico di conversione a stringa, perche' siamo fuori di Node
  {if (p==null) 
     return ""; 
   else 
     return p.getElem() + " " + toString(p.getNext());}
     
  public static void check(String espr, int trovato, int atteso)  
 {if (trovato!=atteso) 
    System.out.println("*ERROR* "+espr + " vale " + trovato + " valore atteso " + atteso); 
  else
   System.out.println("OK " + espr + " = " + atteso);}
 
 public static void checkOK()
 {System.out.println("\nOK: TUTTI I VALORI TROVATI SONO ATTESI");}
 
 public static void main(String[] args)
   //main di prova per int contaMinoriUguali(Node p, Node q)
 {Node p=new Node(1,new Node(2,new Node(3,null)));
   Node q=new Node(3,new Node(2,new Node(1,null)));
   Node r=new Node(1,new Node(1,new Node(1,null)));
   Node s=new Node(7,new Node(6,null));
   
   System.out.println("p = " + toString(p));
   System.out.println("q = " + toString(q));
   System.out.println("r = "  + toString(r));
   System.out.println("s = "  + toString(s) + "\n");
   
   check("contaMinoriUguali(s,p)",contaMinoriUguali(s,p),0);
   check("contaMinoriUguali(p,r)",contaMinoriUguali(p,r),1);
   check("contaMinoriUguali(p,q)",contaMinoriUguali(p,q),2);
   check("contaMinoriUguali(p,s)",contaMinoriUguali(p,s),2); 
   check("contaMinoriUguali(r,p)",contaMinoriUguali(r,p),3);
   check("contaMinoriUguali(p,p)",contaMinoriUguali(p,p),3);
   check("contaMinoriUguali(p,null)",contaMinoriUguali(p,null),0);
   check("contaMinoriUguali(null,q)",contaMinoriUguali(null,q),0);
   check("contaMinoriUguali(null,null)",contaMinoriUguali(null,null),0); 
   
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

