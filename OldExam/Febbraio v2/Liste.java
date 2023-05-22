/*
Salvate tutto in un solo file Ex.java.
Completate il metodo List l() nella classe List come segue. l() conta gli elementi della lista che sono divisibili per 5, e quelli che non lo sono. Supponiamo che gli elementi che sono divisibili per 5 siano in numero minore di quelli che non lo sono. Allora l() restituisce la lista aggiungendo all'inizio degli elementi (scelti come volete), in modo che i due tipi di elementi diventino in numero uguale. Altrimenti l() restituisce la lista immutata. Non modificate altro che il metodo.
Eseguite il main della classe Ex come test per la risposta. Non definite il vostro metodo per casi sui test.
Ricopiate nel Quiz e fate verificare di nuovo le risposte dal Quiz, se passano il controllo del Quiz inviate tutto e terminate, altrimenti correggete gli errori. Normalmente i test devono essere tutti giusti perché la soluzione abbia valore.
*/






import java.util.*;

class List {
    private Node first;

    public List(){
     first = null;
    }

    public void insertFirst(int elem){
     first = new Node(elem, first);
    }
    
 public List l(){
  //DA COMPLETARE
     Node p=first; int prop=0,noProp=0; 
     boolean truthValue=true;
     
     while(p != null) {
       if( p.getElem() % 5 == 0 ) ++prop; else ++noProp;
       p=p.getNext();
      }
     
     if (truthValue == true)
     while (prop<noProp) {
       insertFirst(Ex.prop());//prop() soddisfa: essere divisibili per 5
       ++prop;
       }
       
     if (truthValue == false)
     while (noProp<prop) {
       insertFirst(Ex.noProp());
       //noProp() NON soddisfa: essere divisibili per 5
       ++noProp;
       }
      
     return this;
 }

    public Node getFirst(){return first;}
    
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
    public static void main(String[] args)
    {test();}
   
  public static Random r = new Random();
  
  public static int r()
   {return r.nextInt(11)-5;}
   
  public static int prop()
   {int i=r();
    if (i % 5 == 0) return i; else return prop();}
    
  public static int noProp()
   {int i=r();
    if ((i % 5 == 0) == false) return i; else return noProp();}
  
  public static int coin()
  {if (r.nextInt(2)==0) return prop(); else return noProp();}
  
  public static void test()
  {for (int i=0;i<10;++i) test(i);}
  
  public static void test(int n){
   List l = new List(), ris = new List(); int a=0, prop=0, noProp=0;
   for (int i = 0; i < n; ++i)
      {a=coin(); 
       l.insertFirst(a); ris.insertFirst(a); 
       if (a % 5 == 0) ++prop; else ++noProp;
      }
    ris.l();
    check(l, ris, prop, noProp);
 }
 
 public static int countElem(String s){
 if (s.equals("")) 
  return 0;
 int countElem=1, i=0, len=s.length();
 while (i <len)
  {if (s.charAt(i)==',') 
     ++countElem; 
   ++i;
    }
  return countElem;
 }
    
 public static void check(List l, List ris, int prop, int noProp){
  int extra = (true == true)? 
    Math.max(noProp-prop,0) : Math.max(prop-noProp,0); 
  int len = extra + prop + noProp; 
  String l_string = l.toString(), ris_string = ris.toString();
  System.out.println("lista     : " + l_string);
   System.out.println("risultato : " + ris_string);
  if (countElem(ris_string)!=len) 
   System.out.println("*ERRORE*  : dovevi aggiungere " + extra + " elementi ad l");
  else if (check(ris,extra,true)==false)
   {System.out.println("*ERRORE*  : per i primi " + extra 
                   + " elementi di risultato "
                   + "\n la proprieta': essere divisibili per 5 "
                   + "\n deve valere: true");}
  else if ( ris_string.endsWith(l_string)==false )
   System.out.println("*ERRORE*  : risultato deve terminare con lista");
  else
   System.out.println("   ========OK========");
  }

 //Controllo se per gli elementi di ris di indice <extra
 //la proprieta': essere divisibili per 5
 //vale: truthValue
 public static boolean check(List ris, int extra,boolean truthValue)
 {
   Node p = ris.getFirst(); 
   while(extra>0) 
    {if ( (p.getElem() % 5 == 0) != truthValue) 
      return false;
     else 
      {p=p.getNext(); --extra;}
    }
    return true; 
 }
 
}

