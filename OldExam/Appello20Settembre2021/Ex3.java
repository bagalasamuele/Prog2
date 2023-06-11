

/*
Esercizio 3
1.Completate il metodo String h(T v[][], T x) nella classe Ex. h individua gli elementi uguali ad x in un vettore di vettori generico, con elementi di tipo T, li trasforma in stringhe, e ne restituisce la concatenazione, rispettando l’ordine in cui gli elementi compaiono in v[][] (per righe e, all'interno di una riga, da sinistra a destra). Non modificate altro. Usate x.compareTo(y) per confrontare due elementi di T e supponete che x non sia null. Usate toString() per convertire in stringa un elemento di T. 
2.Fate verificare la risposta a Moodle. Non definite il vostro metodo per casi sui test. Se la risposta passa il controllo inviate tutto e terminate, altrimenti correggete gli errori. Normalmente i test devono essere tutti giusti perché la soluzione abbia valore.
*/
import java.util.*;

class Ex3{
//METHOD TO FILL IN
 public static <T extends Comparable<T>> String h(T v[][], T x)
 {
     T.compareTo(x);
 }

//TEST DEFINITION
 public static String c2(T y, T x)
  {if ( y.compareTo(x) == 0) 
    return y.toString(); 
  else 
   return "";}
 
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
 
public static String toString(T[] v, int i)
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
 
 public static String toString(T[][] v, int i)
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

 T a = new T("a"), b = new T("b"), c = new T("c"), d = new T("d"), e = new T("e");
 
 T[][] w1 = { {r(),r(),r(),r()}, {r(),r(),r()} }; 
 String answ1 = c2(w1[0][0],b) + c2(w1[0][1],b) + c2(w1[0][2],b) + c2(w1[0][3],b) 
              + c2(w1[1][0],b) + c2(w1[1][1],b) + c2(w1[1][2],b);   
 check("w1=" +  toString(w1,0) + "\nh(w1,b)=",
       Ex.h(w1,new T("b")),
       answ1);
       
 T[][] w2 = { {r(),r()}, {r()}, {}, {r(),r(),r()} }; 
 String answ2 = c2(w2[0][0],c) + c2(w2[0][1],c) + c2(w2[1][0],c)
              + c2(w2[3][0],c) + c2(w2[3][1],c) + c2(w2[3][2],c);   
 check("w2=" +  toString(w2,0) + "\nh(w2,c)=",
       Ex.h(w2,new T("c")),
       answ2);
} 

//COMPARING WITH THE RIGHT ANSWER
 public static void check(String s, String a, String b)
 {if (a.equals(b)) 
   System.out.println(s + a + "\n ===OK==="); 
  else 
   System.out.println(s + a + "\n ***EXPECTED*** " + b);
 }

//TEST EXECUTION
public static void main(String[] args)
 {
  test1();test1();test1();test1();
 }
      
}

class T implements Comparable<T>
{public String s;

 public T(String s){this.s=s;}
    
 public int compareTo(T y)
  {return s.compareTo(y.s);} 
 
 public String toString(){return s;}
}

