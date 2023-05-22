import java.util.Random;

class Ex{
//METHOD TO FILL IN
 public static int f(int[][] v)
 {
   //COMPLETARE
 }

//TEST DEFINITION
 public static Random r = new Random();
 public static int val()
  {return r.nextInt(5);}
  
 public static int[][] makeVett(int n, int errate)
 //generiamo un vettore di n righe 
 //con un numero di righe non ordinate uguale a "errate"  
  {int[][] v = new int[n][]; int m; boolean err;
   for(int i=0;i<n;i++)
    {m = r.nextInt(n)+2;//m=2,...,n+1=lunghezza della riga numero i
     v[i] = new int[m];
     v[i][0]=val()+50;
     err=false;
     for(int j=0; j<m-1; j++)
      if (r.nextInt(n-i)<errate)
       {v[i][j+1]=v[i][j]+(-val()-1);
        if (err==false) --errate; 
        err=true;}
      else
       {v[i][j+1]=v[i][j]+(+val());}
    }
   return v;
  }
   
public static String toString(int[] v, int i)
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
 
 public static String toString(int[][] v, int i)
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
 
 public static void test(int n, int errate)
 {int[][] v = makeVett(n,errate);
  check("v=" + toString(v,0) 
         + "\n f(v)=",
         f(v), 
         errate ); 
 }
 
 public static void test(){
  System.out.println("Numero di righe NON ordinate per <= \n");
  System.out.println("======================");
  for(int n=0;n<5;n++) 
   {System.out.println(
      "   numero righe = " + n + "\n======================");
   for(int errate=0;errate<=n;++errate)
      test(n,errate);}
} 

//COMPARING WITH THE RIGHT ANSWER
 public static void check(String s, int a, int b)
 {if (a==b) 
   System.out.println(s + a + " OK" + "\n======================"); 
  else 
   System.out.println(s + a + " *EXPECTED* " + b + "\n======================");
 }

//TEST EXECUTION
public static void main(String[] args)
 {
  test();
 }
      
}
