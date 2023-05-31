class Ex3 {
    public static boolean ok(Node p) { // ok(p) controlla
        // che ogni elemento negativo in p sia seguito da un altro elemento
        while (p != null) {
            if (p.getElem() < 0 && p.getNext() == null)
                // se p ha un elem negativo che non e' seguito da elementi allora:
                return false;
            p = p.getNext();
        }
        /*
         * Se il while finisce, allora ogni elemento
         * negativo in p e' seguito da un elemento, allora:
         */
        return true;
    }

    /*
     * DESCRIZIONE metodo(p): per ogni elemento negativo in p, il metodo cerca
     * l'elemento seguente e lo elimina se positivo, altrimenti non lo elimina, in
     * ogni caso continua. Quindi metodo(p) esamina tutti gli elementi negativi
     * nella versione originaria di p, e solleva eccezione se: un elemento negativo
     * non ha seguente
     */
    public static void metodo(Node p) {
        assert ok(p) : "C'e' un elemento negativo nella lista senza elemento seguente";
        while (p != null) {
            if (p.getElem() < 0 && p.getNext().getElem() > 0)
                p.setNext(p.getNext().getNext());
            p = p.getNext();
        }
    }

    public static void scriviOutput(Node p) {
        while (p != null) {
            System.out.println("  " + p.getElem());
            p = p.getNext();
        }
    }

    public static void main(String[] args) {
        Node p = new Node(0, new Node(-1, null));
        // p={0,-1}
        Node q = new Node(0, new Node(-1, new Node(+1, null)));
        // q={0,-1,+1}
        System.out.println(" ok(p)=" + ok(p) + " ok(q)=" + ok(q));
        System.out.println(" p =");
        scriviOutput(p);
        if (!ok(p)) // p non viene accettata da ok(p) perche’:
            System.out.println("l’elemento -1 non ha successore in p");
        // metodo(p); //NO: se lancio metodo(p) scatta l'asserzione
        System.out.println(" q =");
        scriviOutput(q);
        metodo(q);
        // metodo(q) cancella +1 perche' +1 segue -1 in q
        System.out.println("dopo metodo(q): q=");
        scriviOutput(q);
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
