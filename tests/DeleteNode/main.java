public class main {
    public static void main(String[] args) {

        // List a = new List();
        List l = new List();
        l.insertFirst(1);
        l.insertFirst(2);
        l.insertFirst(3);
        l.insertFirst(4);
        System.out.println(l);
        l.deletePari(l);
        System.out.println(l);

    }

}
