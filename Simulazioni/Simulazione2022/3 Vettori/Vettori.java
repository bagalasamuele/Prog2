class Ex{
 public static <T extends Comparable<T>> boolean sym(T v[][])
 {for(int i=0;i<v.length;i++) 
   if (v[i].length != v.length) 
    return false;
    
  for(int i=0;i<v.length;i++)
   for(int j=0;j<v[i].length;j++)
    if (v[i][j].compareTo(v[j][i]) !=0)
     return false;
      
  return true;}

static Integer v[][][]=
  {
    {{0,1},{1,0}},                        //v[0]
    {{0,1},{1}},                          //v[1]
    {{0,1},{1,0,-1}},                     //v[2]
    {{0,1},{1,0},{}},                     //v[3]
 };   

 public static void check(String s, boolean a, boolean b)
 {if (a==b) 
   System.out.println(s + a + " OK"); 
  else 
   System.out.println(s + a + " EXPECTED " + b);
 }

public static void main(String[] args)
 {
  check("sym(v[0])=",sym(v[0]),true);
  check("sym(v[1])=",sym(v[1]),false);
  check("sym(v[2])=",sym(v[2]),false);
  check("sym(v[3])=",sym(v[3]),false);
  
 }
      
}





