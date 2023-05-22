class Ex{
//METHOD TO FILL IN  
 public static boolean ok(Integer v[]){
    for(int i = 0;i<v.length;i++) {
    	if(v[i] == null)
    		return false;
    	if(v[i] %2 == 0)
    		return true;
    }
    return false;
  }

    
 public static double m(Integer v[])
 {
     boolean found = false;
     int i = 0;
	 while(!found) {
		 if(v[i] %2 == 0) 
			 found = true;
		 else i++;
	 }
	 System.out.println(v[i]); return 0;
  } 

     
//TEST DEFINITION
public static String toString(Integer v[], int i)
 {if (v.length==0)
   return "{}";
  else if (v.length==1)
   return "{" + ((v[0]!=null)?v[0]:"null") + "}";  
  else if (i==0)
   return "{" + ((v[0]!=null)?v[0]:"null") + "," + toString(v,1);
  else if (i == v.length-1) 
   return ((v[i]!=null)?v[i]:"null") + "}"; 
  else 
   return ((v[i]!=null)?v[i]:"null") + "," + toString(v,i+1);
 }
 
 public static void test(){ 
 Integer[][] v={
		 { },
		 {1},
		 {-2},
		 { null, 9, 7 },              
		 { 9,  null, 7 },
		 { 9,  7, null },
		 { -1,  null, 9, 7 },    
		 { -1,  -2, -3  },      
		 { -2,  6 , -4  },      
		 { -1,  9, null},
		 {0},
		 {3},
		 { null, 9, 7 },              
		 { 0,  null, 7 },
		 { 9,  -7, null },
		 { 0,  null, 9, 7 },    
		 { -1,  0, -3  },      
		 { -2,  6 , 0  },      
		 { -1,  0, null}
 };

 
 boolean exception[] = {/*when a exception is raised*/ 
      true,true,false,true,true,true,true,false,false,true,false,true,true,false,true,false,false,false,false
 };
 
 for(int i=0;i<v.length;i++) 
     check("v=" + toString(v[i],0) + 
           "\n ok(v)=",ok(v[i]),
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