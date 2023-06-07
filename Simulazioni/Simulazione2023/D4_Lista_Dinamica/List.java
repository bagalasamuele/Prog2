// Completate il corpo del metodo dinamico List rev(List m) in modo che l.rev(m) restituisca una nuova lista, composta della lista l in ordine inverso seguita dalla lista q. Non modificate altro che il corpo del metodo.
// Esempio. Sia l=[1,2,3], m=[10,20,30]. Allora l.rev(m) restituisce una nuova lista [3,2,1,10,20,30].
// Eseguite il vostro metodo, se passa il controllo inviate tutto e terminate, altrimenti correggete gli errori.


class Node {  
  
    private int elem; 
    private Node next;
    
    public Node(int elem, Node next)
    {this.elem=elem;this.next=next;}
    
    public int  getElem(){return elem;}
    public Node getNext(){return next;}
    public void setElem(int elem){this.elem=elem;}
    public void setNext(Node next){this.next=next;}}
  
  class List
  {
      private Node top=null;
      
      public List(Node top)
      {this.top=top;}
      
      public List rev(List m)
    {
          Node newNode;
          Node aux;
  
          for (newNode = q; newNode != null; newNode = newNode.getNext()) {
              aux = p.getNext();  //Ottengo da nodo ausiliare in nodo successivo di p , e lo salvo 
              p.setNext(q);  //Assegno come successivo a P il nodo q 
              q = p;  //Riassegno a q tutto p
              p = aux; //e p diventa il nodo ausiriale successivo a p 
          }
          // System.out.println(p.getElem());
          return new List (q);
    }
    
   //p={1,2,3}
   static Node p = new Node(1,new Node(2,new Node(3,null)));
   //q={10,20,30}
   static Node q = new Node(10,new Node(20,new Node(30,null)));
   
   public String toString()
   {
    Node p = this.top;
    String s="";
    while (p!=null) 
     {
         s=s+p.getElem()+" ";
         p=p.getNext();
     }
     
     return s;
   }
    
   public static void check(String msg, String a, String b)
    {if (a.equals(b))
      System.out.println(msg + a + 
       " OK");
     else
      System.out.println(msg + a + 
       " INSTEAD OF " + b);
    }
      
  public static void main(String[] args)
   {check(
     "l.rev(m)=", 
     new List(p).rev(new List(q)).toString(), 
     "3 2 1 10 20 30 ");
   }
      
  }
  
  