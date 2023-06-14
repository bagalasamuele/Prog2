package OldExam.Appello13Giugno2023;
// Completate il metodo Tree<T> f(T x, T z, boolean k) in Leaf<T>
// e Branch<T> secondo questa specifica:
// Sia t un nodo foglia. Allora t.f(x,z,k) restituisce t se k=false, altrimenti
// restituisce un nuovo albero contenente z come unico elemento.
// Sia t un nodo Branch. Allora t.f(x,z,k) richiama se stesso nel sotto-albero
// di sinistra e di destra con il parametro k assegnato al valore della
// condizione booleana: (elem minore di x) oppure (elem maggiore di z). Finite
// le chiamate ricorsive, t.f(x,z,k) restituisce l'albero modificato.
// Usate a.compareTo(b) sia per confrontare a,b in T, sia come test di
// eguaglianza tra a,b in T. Supponete che gli elementi dell'albero e x, z non
// siano null. Usate new Leaf<T>() e new Branch<T>(...). Se dimenticate la
// precisazione <T> allora Moodle considera la definizione "unchecked or
// unsafe", in questo caso aggiungete <T>. Usate una definizione ricorsiva. Non
// modificate altro. Non usate "for" nè "while" ne "instanceof".
// Fate verificare la risposta a Moodle. Non definite il vostro metodo per casi
// sui test. Se la risposta passa il controllo inviate tutto e terminate,
// altrimenti correggete gli errori. Normalmente i test devono essere tutti
// giusti perché la soluzione abbia valore.




import java.util.*;

//SALVATE TUTTO IN UN SOLO FILE Ex.java
abstract class Tree<T extends Comparable<T>> {
    public abstract Tree<T> m(T x, T z, boolean k);
    public abstract String toString();
}

class Leaf<T extends Comparable<T>> extends Tree<T> {
    public Tree<T> m(T x, T z, boolean k) { 
            // INSERIRE QUI IL CODICE
            if (k)
                return new Branch<>(z, this, this);
            else
                return this;
    } 
    public String toString(){return "{}";}
}

class Branch<T extends Comparable<T>> extends Tree<T> {
    private T elem;
    private Tree<T> left, right;
    public Branch(T elem, Tree<T> left, Tree<T> right) 
    {this.elem = elem;this.left = left;this.right = right;}

    public Tree<T> m(T x, T z, boolean k) {
        if ( (elem.compareTo(x)< 0) || (elem.compareTo(z) >  0) ) {
            left = left.m(x, z, true);
            right = right.m(x, z, true);
        }
        else {
            left.m(x, z, false);
            right.m(x, z, false);
        }
        return this;
    }

    public String toString() {
        return "{" + elem.toString()  
             + "," + left.toString()
             + "," + right.toString() + "}";
    }

    public void setElem(T e) { this.elem = e; }
    public void setLeft(Tree<T> left) { this.left = left; }
    public void setRight(Tree<T> right) { this.right = right; }
}

class Ex{
    //TEST DEFINITION
    public static Random r = new Random();

    public static T r() {
        int n = r.nextInt(5);
        if (n==0) return new T("a");
        else if (n==1) return new T("b");
        else if (n==2) return new T("c");
        else if (n==3) return new T("d");
        else   /*n=4*/ return new T("e");
    }

    static T b=new T("b"); static T d=new T("d");
    public static boolean c(T y) {
        return ( (y.compareTo(b)< 0) || (y.compareTo(d) >  0) );
    }

    public static void gen(int p, Branch<T> br, Branch<T> bf) {
        T rr = r();
        br.setElem(rr); bf.setElem(rr);
        if (c(rr)) {
            br.setLeft(new Leaf<>());
            bf.setLeft(new Branch<>(d, new Leaf<>(), new Leaf<>()));
        }
        else if (r.nextInt(6) < p) {
            Branch<T> b1 = new Branch<>(null, null, null);
            Branch<T> b2 = new Branch<>(null, null, null);
            br.setLeft(b1);
            bf.setLeft(b2);
            gen(p-1, b1, b2);
        }
        else {
            br.setLeft(new Leaf<>());
            bf.setLeft(new Leaf<>());
        }

        if (c(rr)) {
            br.setRight(new Leaf<>());
            bf.setRight(new Branch<>(d, new Leaf<>(), new Leaf<>()));
        }
        else if (r.nextInt(6) < p) {
            Branch<T> b1 = new Branch<>(null, null, null);
            Branch<T> b2 = new Branch<>(null, null, null);
            br.setRight(b1);
            bf.setRight(b2);
            gen(p-1, b1, b2);
        }
        else {
            br.setRight(new Leaf<>());
            bf.setRight(new Leaf<>());
        }
    }

    public static void test(int p) {
        Branch<T> ii = new Branch<T>(null, null, null);
        Branch<T> oo = new Branch<T>(null, null, null);
        gen(p, ii, oo);
     check("t = " + ii + "\nt.m("+b+","+d+",false)=",
              ii.m(b,d,false).toString(), oo.toString());
    }

    public static void test2(){
        T[] v = {r(),r(),r(), r(),r(),r(), r(),r(),r()};
        Tree<T> l  = new Leaf<>();
        Tree<T> u1 = new Branch<>
            (v[2],
            new Branch<>(v[3],l,l),
            new Branch<>(v[4],l,l)
            );
        Tree<T> t1 = new Branch<>
            (v[1],
            l,
            u1
            );
        Tree<T> u2 = new Branch<>
            (v[6],
            new Branch<>(v[7],l,l),
            new Branch<>(v[8],l,l)
            );
        Tree<T> t2 = new Branch<>
            (v[5],
            u2,
            l
            );
        Tree<T> t = new Branch<>(v[0],t1,t2); 

        String ts = t.toString();
        String us = u1.toString();
        check("t = " + us + "\n t.m(b,d,false)=",
            u1.m(b,d,false), ts);
        check("t = " + us + "\n t.m(b,d,false)=",
            u1.m(b,d,false), ts);
        check("t = " + ts + "\n t.m(b,d,false)=",
            t.m(b,d,false), ts);
        check("t = " + ts + "\n t.m(b,d,false)=",
            t.m(b,d,false), ts);
        System.out.println("--------------------");
    } 

    //COMPARING WITH THE RIGHT ANSWER
    public static <T> void check(String s, T a, T b) {
        if (a.equals(b)) 
            System.out.println(s + a + "\n ===OK==="); 
        else 
            System.out.println(s + a + "\n ***EXPECTED*** " + b);
    }

    //TEST EXECUTION
    public static void main(String[] args) {
        test(0); test(0); test(1); test(1);
        test(2); test(2); test(3); test(3);
        test(4); test(4); test(5); test(5);
        test(6); test(6); test(7); test(7);
    }
}

class T implements Comparable<T> {
    public String s;
    public T(String s) { this.s=s; }
    public int compareTo(T y) { return s.compareTo(y.s); }
    public String toString() { return s; }
}