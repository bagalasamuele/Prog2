//Node class, simplified (elem, next are public fields)
class Node {
    public int elem;
    public Node next;

    public Node(int elem, Node next) {
        this.elem = elem;
        this.next = next;
    }
}

public class Esercizio1FacSimile2 {
    public static Node diff(Node p, Node q) {
        if (p == null) {
            return null;
        }
    
        if (q == null) {
            return p;
        }
    
        Node result = diff(p.next, q.next);
    
        if (result == null && p.elem == q.elem) {
            return null;
        }
    
        p.next = result;
        return p;
    
    }

    // METHODS INCLUDED FOR SOLUTION TESTING ONLY

    // list to string, format "1,2,3" (empty string "" for the empty list)
    public static String toStringAux(Node p) {
        if (p == null)
            return "";
        else if (p.next == null)
            return p.elem + "";
        else
            return p.elem + "," + toStringAux(p.next);
    }

    // list to string, format "[1,2,3]" (string "[]" for the empty list)
    public static String toString(Node p) {
        return "[" + toStringAux(p) + "]";
    }

    // equality test, element-by-element
    public static boolean equal(Node p, Node q) {
        return (p == null && q == null) ||
                (p != null && q != null && p.elem == q.elem && equal(p.next, q.next));
    }

    // We check whether diff(p,q)=expectedResult or not, and we print the answer
    public static void diffTest(Node p, Node q, Node expectedResult) {
        Node ris = diff(p, q);
        String answer = equal(ris, expectedResult) ? "OK" : "***ERROR***";
        System.out.println(answer + " : " + toString(p) + " - " + toString(q) + " = " + toString(ris));
    }

    // static list constructor with varargs: list(1,2,3)= the list [1,2,3]
    public static Node list(int... v) // list(1,2,3) is read as list(v) where int[] v={1,2,3};
    {
        Node ris = null;
        for (int i = v.length - 1; i >= 0; --i)
            // We move backwards in the array v.
            // The last element we insert in the list ris is the first element of v.
            ris = new Node(v[i], ris);

        return ris;
    }

    // TESTING THE SOLUTION diff(p,q)
    public static void main(String[] args) {
        // Test examples for diff(p,q): last list = expected result
        // We can insert p,q as input only if they are weakly increasing.
        diffTest(list(1, 1, 1), list(1), list());
        diffTest(list(1, 2, 3, 4, 5, 6), list(2, 4, 6), list(1, 3, 5));
        diffTest(list(1, 2, 3, 4, 5, 6), list(), list(1, 2, 3, 4, 5, 6));
        diffTest(list(2, 4, 6), list(1, 2, 3, 4, 5, 6), list());
    }

}
