// Completate il metodo public static <T extends Comparable<T>>boolean sym(T v[][]) 
//nella classe Ex in modo che risponda vero se e solo se v è una matrice
// (ogni riga ha lunghezza il numero delle righe) ed è simmetrica. Usate x.compareTo(y)
// e supponete che ogni elemento della matrice non sia null. Non modificate altro.
// Eseguite il main di Ex come test per la risposta.
// Ricopiate nel Quiz e fate verificare di nuovo le risposte dal Quiz, 
//se passano il secondo controllo inviate tutto e terminate, altrimenti correggete gli errori.

class Ex {
    public static <T extends Comparable<T>> boolean sym(T v[][]) {
        for(int i=0;i<v.length;i++) { //scorro le righe e confronto, se diversa lunghezza restituisco falso
            if(v[i].length != v.length) //verifico un caso base
              return false;
           }
              for(int i=0; i<v.length; i++) //scorro righe
              for(int j=0; j<v[i].length; j++) //scorro colonne
                  if(v != null) //verifico null
                    if(v[i][j].compareTo(v[j][i]) != 0) //applico condizione di uguaglianza 
                      return false;
                    return true;   
    
    }

    static Integer v[][][] = {
            { { 0, 1 }, { 1, 0 } }, // v[0]
            { { 0, 1 }, { 1 } }, // v[1]
            { { 0, 1 }, { 1, 0, -1 } }, // v[2]
            { { 0, 1 }, { 1, 0 }, {} }, // v[3]
    };

    public static void check(String s, boolean a, boolean b) {
        if (a == b)
            System.out.println(s + a + " OK");
        else
            System.out.println(s + a + " EXPECTED " + b);
    }

    public static void main(String[] args) {
        check("sym(v[0])=", sym(v[0]), true);
        check("sym(v[1])=", sym(v[1]), false);
        check("sym(v[2])=", sym(v[2]), false);
        check("sym(v[3])=", sym(v[3]), false);

    }

}
