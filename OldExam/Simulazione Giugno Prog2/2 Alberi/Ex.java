//SALVATE TUTTO IN UN SOLO FILE Ex
abstract class Tree<T extends Comparable<T>> 
{public abstract int height();}

class Leaf<T extends Comparable<T>> extends Tree<T> 
 {public int height()
  {/*INSERIRE CODICE QUI*/
    return 0;
  }    
 }

class Branch<T extends Comparable<T>> extends Tree<T> 
{private T elem;private Tree<T> left, right;
 public Branch(T elem, Tree<T> left, Tree<T> right) 
  {this.elem = elem;this.left = left;this.right = right;}

public int height()
 {/*INSERIRE CODICE QUI*/
  return 1 + Math.max(left.height(), right.height());
  }
  
      
    
 }
    
//SALVATE TUTTO IN UN SOLO FILE Ex
class Ex
{static Tree<Integer> l =new Leaf<>();
 static Tree<Integer> t = new Branch<>(1,
 new Branch<>(2,new Branch<>(0,l,l),l),
 new Branch<>(2,l,new Branch<>(3,l,l)));  
 
 public static void check(String s, int a, int b)
 {if (a==b) 
   System.out.println(s + a + " OK"); 
  else 
   System.out.println(s + a + " EXPECTED " + b);
 }

public static void main(String[] args)
 {
  check("l.height()=",l.height(),0);
  check("t.height()=",t.height(),3);
 }
    
}