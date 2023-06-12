
import java.util.Random;

// Costruisce e stampa delle liste realizzate con la classe astratta List
public class TestList {
    
    public static void main(String[] args) {
        List l = new Nil();
        // generatore di numeri casuali
        Random gen = new Random();
        int n=100;
        System.out.println("\nLista l ottenuta aggiungendo n = " + n + " volte");
        System.out.println("un intero casuale tra 0 (compreso) e 2*n (escluso)");
        for (int i = 0; i < n; i++) {
            l = l.insert(gen.nextInt(n*2));
        }

        //Stampiamo la lista l usando il metodo toString modificato 
        System.out.println(l);

        System.out.println("\nAlcuni elementi sono stati aggiunti piu' volte, cosi':"); 
        System.out.println(" l.size() = " + l.size() + " < n = " + n);

        System.out.println("\nEsempi di unione di a={1,2} con b={3,4}");
        System.out.println("Aggiungendo a e b in ordine diverso il risultato non cambia");
        List a = new Cons(1, new Cons(2, new Nil()));
        List b = new Cons(3, new Cons(4, new Nil()));
        System.out.println(" a.append(b) = " + a.append(b));
        System.out.println(" b.append(a).append(a) = " + b.append(a).append(a));

        //USO DEI NUOVI METODI
        l = new Nil();
        n = 10;
        System.out.println("\nLista l ottenuta aggiungendo n = " + n + " volte");
        System.out.println("un intero casuale tra 0 (compreso) e 2*n (escluso)");
        for (int i = 0; i < n; i++) {
            l = l.insert(gen.nextInt(n*2));
        }
        System.out.println(l);
        System.out.println("\nSomma degli elementi della lista: "+l.sum());

        for (int i = 0; i < l.size(); i++){
            System.out.println("\nElemento in posizione "+i+": "+l.get(i));
        }

        System.out.println("\nLista ottenuta incrementando di uno ogni elemento della lista l:\n");
        System.out.println(l.succ());

        for (int i = 0; i < 3; i++){
            int x = gen.nextInt(n*2);
            System.out.println("\nSottolista di l contenente tutti gli elementi di l minori o uguali a "+ x+":");
            System.out.println(l.filter_le(x));
            System.out.println("Sottolista di l contenente tutti gli elementi di l maggiori di "+ x+":");
            System.out.println(l.filter_gt(x));
            System.out.println();
        } 

        List m = new Nil();
        for (int i = 0; i < n; i++) {
            m = m.insert(gen.nextInt(n*2));
        }
        System.out.println("\nIntersezione delle due seguenti liste:");
        System.out.println("\nLista 1: "+l);
        System.out.println("\nLista 2: "+m);
        System.out.println("\nIntersezione : "+l.intersect(m));
    }
}
