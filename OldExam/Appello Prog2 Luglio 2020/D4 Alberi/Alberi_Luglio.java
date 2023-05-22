import java.util.*;

//SALVATE TUTTO IN UN SOLO FILE Ex.java
abstract class Tree<T extends Comparable<T>> 
 {public abstract Tree<T> k(T x, T z);
  public abstract String toString();
 }

class Leaf<T extends Comparable<T>> extends Tree<T> 
 {public Tree<T> k(T x, T z){ return this; } 
  public String toString(){return "{}";}
 }

class Branch<T extends Comparable<T>> extends Tree<T> 
 {private T elem;private Tree<T> left, right;
  public Branch(T elem, Tree<T> left, Tree<T> right) 
   {this.elem = elem;this.left = left;this.right = right;}

  public Tree<T> k(T x, T z)
   {left.k(x,z); 
    right.k(x,z);
    if ( (elem.compareTo(x)< 0) || (elem.compareTo(z) == 0) ) 
      {Tree<T> temp = left; left=right; right=temp;}
    return this;}
     
  public String toString()
   {return "{" + elem.toString()  
         + "," + left.toString()
         + "," + right.toString() + "}";
   }
 }
 
class Ex{

//TEST DEFINITION
 public static Random r = new Random();
 
 public static T r()
 {int n = r.nextInt(5);
  if (n==0) 
   return new T("a");
  else if (n==1)
   return new T("b");
  else if (n==2)
   return new T("c");
  else if (n==3)
   return new T("d");
  else //n=4
   return new T("e");
 }
 
 static T b=new T("b"); static T d=new T("d");

 public static Tree<T> c(T elem, Tree<T> left, Tree<T> right)
  {return new Branch<T>(elem, left, right);}
  
public static Tree<T> d(T elem, Tree<T> left, Tree<T> right)
  {if ( (elem.compareTo(b)< 0) || (elem.compareTo(d) == 0) )
    return new Branch<T>(elem, right, left);
   else
    return new Branch<T>(elem, left, right);
  }
  
public static void test(){
T[] v = {r(),r(),r(), r(),r(),r(), r(),r(),r()};
Tree<T> l = new Leaf<>();

Tree<T> t1 = c(v[1], l, c(v[2],c(v[3],l,l), c(v[4],l,l)) );
Tree<T> t2 = c(v[5],  c(v[6],c(v[7],l,l),c(v[8],l,l)), l );

Tree<T> ris1 = d(v[1], l, d(v[2],d(v[3],l,l), d(v[4],l,l)) );
Tree<T> ris2 = d(v[5],  d(v[6],d(v[7],l,l),d(v[8],l,l)), l );
  
check("t1 = " + t1.toString() + "\n t1.k(b,d)=",
       t1.k(b,d).toString(),
       ris1.toString()
       );
check("t2 = " + t2.toString() + "\n t2.k(b,d)=",
       t2.k(b,d).toString(),
       ris2.toString()
       );
} 

//COMPARING WITH THE RIGHT ANSWER
 public static void check(String s, String a, String b)
 {if (a.equals(b)) 
   System.out.println(s + a + " OK"); 
  else 
   System.out.println(s + a + " *EXPECTED* " + b);
 }

 static void msg()
 { System.out.println
   ("Alberi nella forma leaf={}, branch = {elem,left,right}");
   System.out.println
   ("k rimpiazza left con right tutte le volte che vale: (elem minore di b) oppure (elem uguale a d)");
  }
  
//TEST EXECUTION
public static void main(String[] args)
 {
  msg();test();test();test();
 }
      
}

class T implements Comparable<T>
{public String s;
 public T(String s){this.s=s;}
 public int compareTo(T y)
  {return s.compareTo(y.s);}
 public String toString(){return s;}
}