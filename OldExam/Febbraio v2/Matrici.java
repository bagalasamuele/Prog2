/*
Salvate tutto in un solo file Ex.java.
Completate il metodo int k(T v[][], T x) nella classe Ex in modo che conti gli elementi diversi da x in un vettore di vettori generico con elementi di tipo T. Usate x.compareTo(y) e supponete che x non sia null. Non modificate altro.
Eseguite il main della classe Ex come test per la risposta. Non definite il vostro metodo per casi sui test.
Ricopiate nel Quiz e fate verificare di nuovo le risposte dal Quiz, se passano il secondo controllo inviate tutto e terminate, altrimenti correggete gli errori.
*/
import java.util.*;

class Ex3{
//METHOD TO FILL IN
 public static <T extends Comparable<T>> int k(T v[][], T x)
 {int ris=0;
  for(int i=0;i<v.length;i++)
   for(int j=0;j<v[i].length;j++)
    {int c=v[i][j].compareTo(x);
     if (c != 0) 
// v[i][j] tra gli elementi diversi da x
      {ris++;}}
    return ris;}

//TEST DEFINITION
 public static int c(int y)
  {if ( y != 5 ) return 1; else return 0;}
  
 public static int c2(T y)
  {if ( y.s.compareTo("b") != 0) 
    return 1; 
  else 
   return 0;}
   
public static String toString(Integer[] v, int i)
 {if (v.length==0)
   return "{}";
  else if (v.length==1)
   return "{" + v[0] + "}";  
  else if (i==0)
   return "{" + v[0] + "," + toString(v,1);
  else if (i == v.length-1) 
   return v[i] + "}"; 
  else 
   return v[i] + "," + toString(v,i+1);
 }
 
 public static String toString(Integer[][] v, int i)
 {if (v.length==0)
   return "{}";
  else if (v.length==1)
   return "{" + toString(v[0],0) + "}";  
  else if (i==0)
   return "{" + toString(v[0],0) + "," + toString(v,1);
  else if (i == v.length-1) 
   return toString(v[i],0) + "}"; 
  else 
   return toString(v[i],0) + "," + toString(v,i+1);
 }
 
 public static void test1(){
  Integer v[][][]=
  {
    { { 5 }, { 5 + 1, 5 + 2 } },     //v[0]
    { { 5 }, { 5 + 1, 5 - 1 } },     //v[1]
    { { 5, 5 - 1}, { 5 }     },      //v[2]
    { { 5, 5 - 1}, { 5 - 2 } },      //v[3]
    { { 5, 5    , 5 }, {}     },     //v[4]
    { { 5 }, { 5 + 1, 5}     },      //v[5]
    { {}, {}, {}},                               //v[6]
 };  
     
  Integer answ[] =
  {c(5) + c(5+1) + c(5+2),
   c(5) + c(5+1) + c(5-1),
   c(5) + c(5-1) + c(5),
   c(5) + c(5-1) + c(5-2),
   c(5) + c(5) + c(5),
   c(5) + c(5+1) + c(5),
    0
  };
  
 for(int i=0;i<v.length;i++) 
   check("v[" + i + "]=" + toString(v[i],0) 
         + "\n k(v[" + i + "],5)=",
         k(v[i],5), 
         answ[i]);

 T a = new T("a"), b = new T("b"), c = new T("c");
 T[][] w = { {a,b,b,c}, {c,c,c} }; 
 int answ2 = c2(a) + c2(b)*2 + c2(c)*4;   
 check("w={ {a,b,b,c}, {c,c,c} } \n k(w,b)=",
       Ex.k(w,new T("b")),
       answ2);
} 

//COMPARING WITH THE RIGHT ANSWER
 public static void check(String s, int a, int b)
 {if (a==b) 
   System.out.println(s + a + " OK"); 
  else 
   System.out.println(s + a + " *EXPECTED* " + b);
 }

//TEST EXECUTION
public static void main(String[] args)
 {
  test1();
 }
      
}

class T implements Comparable<T>
{public String s;

 public T(String s){this.s=s;}
    
 public int compareTo(T y)
  {return s.compareTo(y.s);} 
}