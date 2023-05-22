/*
public > boolean f(T v[][], T x)
1) In modo che restituisca true se trova almeno un elemento in v minore di x,  e false altrimenti. 
2) Confrontate gli elementi di T usando x.compareTo(y) (supponete che x non sia null). 
3) Non modificate altro che il corpo del primo metodo.
*/
class Ex {  
//METHOD TO FILL IN    
 public static <T extends Comparable<T>> boolean f(T v[][], T x)
  {   //Codice per completare metodo
    for(int i=0; i<v.length; i++)
    for(int j=0; j<v[i].length; j++)
        if(x != null)
          if(v[i][j].compareTo(x) < 0) {
            return true;
          }
            return false;
  }  
//COMPARING WITH THE CORRECT ANSWER
//USE "*" ONLY FOR FAILURE, NEVER USE IN msg
public static void comp(String msg, boolean a, boolean b)
 { if (a==b) 
   System.out.println(msg + a + " OK");
  else
   System.out.println(msg + a + " *EXPECTED* " + b);
  } 
//TEST DEFINITION
public static void test1()
{ Integer v[][] = { {0}, {0,0} };
   for (int i=1;i<=3;++i)
    for (int j=1;j<=3;++j)
     for (int k=1;k<=3;++k)
      {v[0][0]=i;v[1][0]=j;v[1][1]=k;
       String msg = "v={ {"+i+"},{"+j+","+k+"} }, f(v,2)=";
       boolean disj = ((i < 2) || 
                       (j < 2) ||
                       (k < 2)); 
       comp(msg,f(v,2),disj == true);
     }
}
//TEST EXECUTION
public static void main(String[] args)
 { test1();}
 
 }