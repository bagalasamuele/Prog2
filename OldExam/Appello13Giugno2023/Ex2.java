package OldExam.Appello13Giugno2023;
// Completate il metodo int q(T z[][], T x) nella classe Ex in modo che conti
// gli elementi che non sono uguali ad x in un vettore di vettori generico z con
// elementi di tipo T. Usate x.compareTo(y) e supponete che x non sia null. Non
// modificate altro.
// Fate verificare la risposta a Moodle. Non definite il vostro metodo per casi
// sui test. Se la risposta passa il controllo inviate tutto e terminate,
// altrimenti correggete gli errori. Normalmente i test devono essere tutti
// giusti perché la soluzione abbia valore.

import java.util.*;

class Ex2 {

    public static <T extends Comparable<T>> int q(T z[][], T x) {
        // METHOD TO FILL IN
        return 1;
    }
    // Soluzione:

    // public static <T extends Comparable<T>> int q(T z[][], T x)
    // {
    // int counter = 0;
    // for(int i=0; i < z.length; i++){
    // for(int j = 0; j < z[i].length; j++){
    // if(z[i][j].compareTo(x) != 0){
    // counter ++;
    // }
    // }
    // }

    // return counter;
    // }

    // TEST DEFINITION
    public static int c(int y) {
        if (!(y == 1))
            return 1;
        else
            return 0;
    }

    public static int c2(T y) {
        if (!(y.s.compareTo("b") == 0))
            return 1;
        else
            return 0;
    }

    public static String toString(Integer[] v, int i) {
        if (v.length == 0)
            return "{}";
        else if (v.length == 1)
            return "{" + v[0] + "}";
        else if (i == 0)
            return "{" + v[0] + "," + toString(v, 1);
        else if (i == v.length - 1)
            return v[i] + "}";
        else
            return v[i] + "," + toString(v, i + 1);
    }

    public static String toString(Integer[][] v, int i) {
        if (v.length == 0)
            return "{}";
        else if (v.length == 1)
            return "{" + toString(v[0], 0) + "}";
        else if (i == 0)
            return "{" + toString(v[0], 0) + "," + toString(v, 1);
        else if (i == v.length - 1)
            return toString(v[i], 0) + "}";
        else
            return toString(v[i], 0) + "," + toString(v, i + 1);
    }

    public static void test1() {
        Integer v[][][] = {
                { { 1 }, { 1 + 1, 1 + 2 } }, // v[0]
                { { 1 }, { 1 + 1, 1 - 1 } }, // v[1]
                { { 1, 1 - 1 }, { 1 } }, // v[2]
                { { 1, 1 - 1 }, { 1 - 2 } }, // v[3]
                { { 1, 1, 1 }, {} }, // v[4]
                { { 1 }, { 1 + 1, 1 } }, // v[5]
                { {}, {}, {} }, // v[6]
        };

        Integer answ[] = { c(1) + c(1 + 1) + c(1 + 2),
                c(1) + c(1 + 1) + c(1 - 1),
                c(1) + c(1 - 1) + c(1),
                c(1) + c(1 - 1) + c(1 - 2),
                c(1) + c(1) + c(1),
                c(1) + c(1 + 1) + c(1),
                0
        };

        for (int i = 0; i < v.length; i++)
            check("v[" + i + "]=" + toString(v[i], 0)
                    + "\n q(v[" + i + "],1)=",
                    q(v[i], 1),
                    answ[i]);

        T a = new T("a"), b = new T("b"), c = new T("c");
        T[][] w = { { a, b, b, c }, { c, c, c } };
        int answ2 = c2(a) + c2(b) * 2 + c2(c) * 4;
        check("w={ {a,b,b,c}, {c,c,c} } \n q(w,b)=",
                Ex.q(w, new T("b")),
                answ2);
    }

    // COMPARING WITH THE RIGHT ANSWER
    public static void check(String s, int a, int b) {
        if (a == b)
            System.out.println(s + a + " OK");
        else
            System.out.println(s + a + " *EXPECTED* " + b);
    }

    // TEST EXECUTION
    public static void main(String[] args) {
        test1();
    }

}

class T implements Comparable<T> {
    public String s;

    public T(String s) {
        this.s = s;
    }

    public int compareTo(T y) {
        return s.compareTo(y.s);
    }
}