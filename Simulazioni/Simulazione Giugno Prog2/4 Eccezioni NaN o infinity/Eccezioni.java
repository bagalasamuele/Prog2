class Node
{private int elem; private Node next;
 public Node(int elem,Node next){this.elem=elem;this.next=next;}  
 public int getElem(){return elem;} 
 public Node getNext(){return next;} 
 public void setElem(int elem){this.elem=elem;} 
 public void setNext(Node next){this.next=next;} 
}

class Ex{
 public static void metodo(Node p, int x)
  {for(  ;x>=0;x--) {p.setElem(x);p=p.getNext();}}  

  public static boolean ok(Node p, int x)
  {for( ;x>=0;x--)  
     {if (p==null) return false; p=p.getNext();}
    return true;}
    
 static Node p = new Node(10, new Node(20, new Node(30, null)));
 
  public static void check(String s, boolean a, boolean b)
   {if (a==b) 
     System.out.println(s + a + " OK"); 
    else 
     System.out.println(s + a + " EXPECTED " + b);}

  public static void main(String[] args)
   {check("ok(p,1)=", ok(p,1), true);
    check("ok(p,2)=", ok(p,2), true);   
    check("ok(p,3)=", ok(p,3), false);   
   }

}