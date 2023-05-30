
//TestTree.java. Instanzio Tree su diverse classi che implementano
//l’interfaccia Comparable<T>
import java.util.*; //per la classe Random
//Provo l'implementazione degli alberi binari di ricerca

public class TestTree {
    public static void Title(String s) { // Stampa di un titolo
        System.out.println("--------------------------------------"
                + "\n" + s + "\n" +
                "--------------------------------------");
    }

    public static void main(String[] args) {
        Random r = new Random(); // r = un generatore di numeri casuali
        // Creo un albero t con n reali casuali tra 0 e 1
        int n = 8;
        Tree<Double> t = new Leaf<>(); // L'albero t nasce vuoto
        for (int i = 0; i < n; i++)
            t = t.insert(r.nextDouble()); // Accresco t un elem. alla volta
        // Provo il metodo di stampa e il calcolo del massimo
        Title("Stampa albero casuale t di " + n + " elementi");
        System.out.println(t + "\n\n t.max() = " + t.max());
        // Creo un albero u di interi inserendo sempre elementi piu' grandi
        // quindi sempre a destra
        Tree<Integer> u = new Leaf<>();
        for (int i = 0; i < n; i++)
            u = u.insert(i);
        Title("Stampa albero u di " + n + " elementi, tutti figli destri");
        System.out.println(u);
        // Creo un albero u di stringhe inserendo sempre elementi piu'
        // piccoli
        // quindi sempre a sinistra
        Tree<String> v = new Leaf<>();
        for (int i = n - 1; i >= 0; i--)
            v = v.insert("numero " + i);
        Title("Stampa albero v di " + n + " elementi, tutti figli sinistri");
        System.out.println(v);

        // Provo il metodo di cancellazione per un albero di ogg. Contatto
        Tree<Contatto> w = new Leaf<>();
        Contatto c = new Contatto("Cafasso", "cafasso@ristorante");
        Contatto a = new Contatto("Anfossi", "anfossi@scuola");
        Contatto d = new Contatto("Davanzo", "davanzo@comune");
        Contatto b = new Contatto("Borghi", "borghi@ditta");
        w = w.insert(c);
        w = w.insert(a);
        w = w.insert(d);
        w = w.insert(b);
        Title("Stampa albero w di contatti {a,b,c,d}");
        System.out.println(w);
        Title("w senza il contatto c");
        w.remove(c);
        System.out.println(w);
    }
}
// end class TestTree