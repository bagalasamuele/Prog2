public class main {

    public static void main(String Args[]) {

        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(8);
        Node c1 = new Node(9);
        Node c2 = new Node(10);
        /////////////////////////////////////////
        List l = new List(a);
        l.pop(b);
        l.pop(c);
        l.pop(c1);
        l.pop(c2);
        System.out.println("Lista l: " + l);
        //////////////////////////////////
        Node h = new Node(1);
        Node e = new Node(2);
        Node f = new Node(15);


        List d = new List(h);

        d.pop(e);
        d.pop(f);
        System.out.println("Lista d: " + d);
        // l.deleteDispari();
        System.out.println("8: " + l.isContain(8));
        System.out.println("1: " + l.isContain(1));

        // System.out.println(l.diff(d));
        // l.deleteElem(9);s
    }
}