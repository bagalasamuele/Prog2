/*
Esercizio 1
1.Salvate tutto in un solo file Ex.java. 
2.Completate il metodo boolean g(T x, T z) in Leaf<T> e Branch<T> in modo che restituisca true se vale (elem minore di x) oppure (elem uguale a z) oppure se g(x,z) restituisce  true sul sottoalbero sinistro oppure sul destro. Altrimenti restituite false. Restituite false sull'albero vuoto. Usate a.compareTo(b) per confrontare a,b in T e supponete che gli elementi dell'albero e x,z non siano null. Usate una definizione ricorsiva. Non modificate altro. Non usate "for" nè "while".
3.Eseguite il main della classe Ex come test per la risposta. Non definite il vostro metodo per casi sui test. 
4.Ricopiate nel Quiz e fate verificare di nuovo le risposte dal Quiz, se passano il controllo del Quiz inviate tutto e terminate, altrimenti correggete gli errori. Normalmente i test devono essere tutti giusti perché la soluzione abbia valore.
*/

import java.util.*;

//SALVATE TUTTO IN UN SOLO FILE Ex.java
abstract class Tree<T extends Comparable<T>> {
    public abstract boolean g(T x, T z);

    public abstract String toString();
}

class Leaf<T extends Comparable<T>> extends Tree<T> {
    public boolean g(T x, T z) {

    }

    public String toString() {
        return "{}";
    }
}

class Branch<T extends Comparable<T>> extends Tree<T> {
    private T elem;
    private Tree<T> left, right;

    public Branch(T elem, Tree<T> left, Tree<T> right) {
        this.elem = elem;
        this.left = left;
        this.right = right;
    }

    public boolean g(T x, T z) {
        /* INSERT CODE HERE */
    }

    public String toString() {
        return "{" + elem.toString()
                + "," + left.toString()
                + "," + right.toString() + "}";
    }

}

class Ex1 {

    // TEST DEFINITION
    public static Random r = new Random();

    public static T r() {
        int n = r.nextInt(5);
        if (n == 0)
            return new T("a");
        else if (n == 1)
            return new T("b");
        else if (n == 2)
            return new T("c");
        else if (n == 3)
            return new T("d");
        else // n=4
            return new T("e");
    }

    static T b = new T("b");
    static T d = new T("d");

    public static T p() {
        T y = r();
        boolean cond = (y.compareTo(b) < 0) || (y.compareTo(d) == 0);
        if (cond == true)
            return y;
        else
            return p();
    }

    public static T n() {
        T y = r();
        boolean cond = (y.compareTo(b) < 0) || (y.compareTo(d) == 0);
        if (cond == false)
            return y;
        else
            return n();
    }

    public static boolean c(T y) {
        return (y.compareTo(b) < 0) || (y.compareTo(d) == 0);
    }

    public static Tree<T> makeTree(T v[]) {
        Tree<T> l = new Leaf<>();
        Tree<T> t1 = new Branch<>(v[1],
                l,
                new Branch<>(v[2],
                        new Branch<>(v[3], l, l),
                        new Branch<>(v[4], l, l)));
        Tree<T> t2 = new Branch<>(v[5],
                new Branch<>(v[6],
                        new Branch<>(v[7], l, l),
                        new Branch<>(v[8], l, l)),
                l);
        return new Branch<>(v[0], t1, t2);
    }

    // Testing t = makeTree(v)
    public static void msg(T v[]) {
        Tree<T> t = makeTree(v);
        check("t = " + t.toString() + "\n t.g(b,d)=",
                t.g(b, d),
                c(v[0]) || c(v[1]) || c(v[2]) || c(v[3]) || c(v[4]) ||
                        c(v[5]) || c(v[6]) || c(v[7]) || c(v[8]) ? true : false);
    }

    public static void test() {
        // one element of v in random position satisfies: (elem minore di b) oppure
        // (elem uguale a d)
        T[] v = { p(), n(), n(), n(), n(), n(), n(), n(), n() };
        T temp = v[0];
        int i = r.nextInt(v.length);
        v[0] = v[i];
        v[i] = temp;
        // all elements of v falsify: (elem minore di b) oppure (elem uguale a d)
        T[] w = { n(), n(), n(), n(), n(), n(), n(), n(), n() };
        // testing for t=makeTree(v), makeTree(w)
        msg(v);
        msg(w);
        System.out.println();
    }

    // COMPARING WITH THE RIGHT ANSWER
    public static <T> void check(String s, T a, T b) {
        if (a.equals(b))
            System.out.println(s + a + " OK");
        else
            System.out.println(s + a + " *EXPECTED* " + b);
    }

    static void msg() {
        System.out.println("Alberi nella forma leaf={}, branch = {elem,left,right}");
        System.out
                .println("g restituisce true se almeno una volta abbiamo: (elem minore di b) oppure (elem uguale a d)");
    }

    // TEST EXECUTION
    public static void main(String[] args) {
        msg();
        test();
        test();
        test();
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

    public String toString() {
        return s;
    }
}
