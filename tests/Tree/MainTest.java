import java.util.*;

public class MainTest {

    public static void main(String[] args) {

        Leaf n1 = new Leaf();
        Leaf n2 = new Leaf();
        Branch n3 = new Branch(1, n1, n2);

        System.out.println(n3);


        System.out.println("\n\n\n --------\n");

        int n = 8;  //8 elementi
        Random r = new Random(System.currentTimeMillis());  //Numero random 
 
        Tree t = new Leaf(); // L'albero t nasce vuoto
        for (int i = 0; i < n; i++)
            t = t.insert(r.nextInt(n)); // Accresco t un elemento alla volta

        System.out.println(t);
    }

}
