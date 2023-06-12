import java.util.*;

public class TestTree {
    public static void main(String[] args) {
        Random r = new Random();
        // creo un albero con 10 numeri interi casuali
        Tree t = new Leaf();
        for (int i = 0; i < 10; i++)
            t = t.insert(r.nextInt(20));
        testTreeMethods(t);

        // creo un albero come nel testo della specifica
        Tree t1 = new Branch(3,
                new Branch(1,
                        new Leaf(),
                        new Branch(2,
                                new Leaf(),
                                new Leaf())),
                new Branch(5,
                        new Leaf(),
                        new Leaf()));
        testTreeMethods(t1);
    }

    private static void testTreeMethods(Tree t) {
        System.out.println("t = " + t);
        System.out.println("t.sum() = " + t.sum());
        System.out.println("t.size() = " + t.size());
        // System.out.println("t.empty() = " + t.empty());
        System.out.println("t.max() = " + t.max());
        System.out.println("t.contains(6) = " + t.contains(6));
        // System.out.println("t.depth() = " + t.depth());
        // aggiungere le chiamate ai metodi da implementare

    }
}
