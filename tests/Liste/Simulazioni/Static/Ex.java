// Salvate tutto in un solo file Ex.
// Completate il corpo del metodo Node rev(Node p, Node q) in modo che fornisca la lista p in ordine inverso seguita dalla lista q. Non modificate altro che il corpo del metodo.
// Eseguite il main della classe Ex come test per la risposta.
// Ricopiate nel Quiz e fate verificare di nuovo le risposte dal Quiz, se passano il secondo controllo inviate tutto e terminate, altrimenti correggete gli errori

class Ex {
    public static Node rev(Node p, Node q) {
        Node newNode;
        Node aux;

        for (newNode = q; newNode != null; newNode = newNode.getNext()) {
            aux = p.getNext();  //Ottengo da nodo ausiliare in nodo successivo di p , e lo salvo 
            p.setNext(q);  //Assegno come successivo a P il nodo q 
            q = p;  //Riassegno a q tutto p
            p = aux; //e p diventa il nodo ausiriale successivo a p 
        }
        // System.out.println(p.getElem());
        return q;
    }

    // p={1,2,3}
    static Node p = new Node(1, new Node(2, new Node(3, null)));
    // q={10,20,30}
    static Node q = new Node(10, new Node(20, new Node(30, null)));

    public static String toString(Node p) {
        if (p == null)
            return "";
        else
            return p.getElem() + " " + toString(p.getNext());
    }

    public static void check(String msg, String a, String b) {
        if (a.equals(b))
            System.out.println(msg + a + " OK");
        else
            System.out.println(msg + a + " INSTEAD OF " + b);
    }

    public static void main(String[] args) {
        check("rev(p,q)=", toString(rev(p, q)), "3 2 1 10 20 30 ");
    }

}

class Node {
    private int elem;
    private Node next;

    public Node(int elem, Node next) {
        this.elem = elem;
        this.next = next;
    }

    public int getElem() {
        return elem;
    }

    public Node getNext() {
        return next;
    }

    public void setElem(int elem) {
        this.elem = elem;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
