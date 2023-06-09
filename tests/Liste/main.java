public class main {

    public static void main(String Args[]) {

        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(8);
/////////////////////////////////////////
        List l = new List(a);
        l.pop(b);
        l.pop(c);
        System.out.println(l);
        l.deletePari();
        System.out.println(l);
//////////////////////////////////
        Node d = new Node(9);
        Node e = new Node(11);
        Node f = new Node(12);
        Node g = new Node(10);
        l.pop(d);
        l.pop(e);
        l.pop(f);
        l.pop(g);
        System.out.println(l);
        l.deleteDispari();
        System.out.println(l);
        l.deleteElem(9);
        System.out.println(l);

    }
}