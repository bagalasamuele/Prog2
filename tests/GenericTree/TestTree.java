// fornire le implementazioni del metodo detach in Leaf e Branch in modo tale che t.detach(x)
// restituisca una versione modificata di t in cui ogni sottoalbero avente radice x è stato sostituito
// con l’albero vuoto. Se x non è presente, il metodo deve restituire l’albero invariato.

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

        int n = 8;
        Tree<Integer> t = new Leaf<>(); // L'albero t nasce vuoto
        for (int i = 0; i < n; i++)
            t = t.insert(r.nextInt(21));

        System.out.println(t);

        System.out.println("////////////");
        t.detach(5);

        System.out.println(t);

    }
}
// end class TestTree