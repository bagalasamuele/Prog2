class Ex{
//METHOD TO FILL IN  
  public static boolean ok(double v[])
  {if (v.length == 0) return false;
   for( int i=0; i<v.length; i++)  
     if ( v[i] <= 8 ) 
      return false;
      
   return true;}
    
 public static double l(double v[])
  { boolean b = true;//This is a fixed parameter
    double ris=0; 
    for(int i=0; i < v.length; i++) 
     if (b==true)
       ris = ris + Math.log( v[i] - 8 ); 
     else 
       ris = ris + Math.log( 8 - v[i] );
    return ris/v.length;
  } 
     
//TEST DEFINITION
public static String toString(double v[], int i)
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
 
 public static void test(){ 
 double[][] v=
 { { 8, 8, 8 },              //m[0]
   { 8 +3,  8 +2, 8 +1 },    //m[1]
   { 8 -3,  8 -2, 8 -1 },    //m[2]
   { 8 +2,  8 +1, 8  },      //m[3]
   { 8 -2,  8 -1, 8  },      //m[4]
   { 8 -1,  8, 8 + 1},       //m[5]
   { }                                   //m[6]
 };
 
 boolean exception[] = {/*when a exception is raised*/ 
     8 <= 8,
     8 + 1 <= 8,
     8 - 1 <= 8,
     (8 <= 8) || (8+1 <= 8),
     (8 <= 8) || (8-1 <= 8),
     true,
     true
 };
 
 for(int i=0;i<v.length;i++) 
     check("v[" + i + "]=" + toString(v[i],0) + 
           "\n ok(v[" + i + "]=",ok(v[i]),
           !exception[i]);
}

//COMPARING WITH THE CORRECT ANSWER
//USE "*" ONLY FOR FAILURE, NEVER USE IT IN msg
  public static void check(String msg, boolean a, boolean b)
   {if (a==b) 
     System.out.println(msg + a + " OK"); 
    else 
     System.out.println(msg + a + " *EXPECTED* " + b);}

//TEST EXECUTION    
  public static void main(String[] args)
   {test();}

}

