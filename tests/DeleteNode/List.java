// Esercizio Per cancellare nodi 

public class List {
    private Node first;

    public List() {
        first = null;
    }

    public void insertFirst(int elem) {
        first = new Node(elem, first);
    }

    public Node getFirst() {
        return first;
    }

    public String toString() {
        String s = "";
        for (Node p = first; p != null; p = p.getNext()) {
            if (p != first)
                s += ", ";
            s += p.getElem();
        }
        return s;
    }

    // Viene dichiarato il metodo deleteEvenFromList senza un tipo di ritorno (void)
    // perché modificherà direttamente la lista senza restituirla.
    // Viene inizializzata una variabile current con il primo nodo della lista
    // (this.first) e una variabile previous a null.
    // Viene eseguito un ciclo while finché current non diventa null, ovvero finché
    // non abbiamo attraversato tutti i nodi della lista.
    // All'interno del ciclo, viene verificato se l'elemento di current è pari
    // (current.getElem() % 2 == 0).
    // Se l'elemento è pari, il nodo corrente (current) viene eliminato dalla lista:
    // Se il nodo corrente è il primo nodo della lista (previous == null), il
    // puntatore this.first viene spostato al nodo successivo, eliminando così il
    // primo nodo dalla lista.
    // Altrimenti, il puntatore next del nodo precedente (previous) viene collegato
    // al nodo successivo di current, eliminando così il nodo corrente dalla lista.
    // Se l'elemento è dispari, il nodo corrente viene mantenuto nella lista e viene
    // aggiornato previous per puntare al nodo corrente (previous = current).
    // Alla fine di ogni iterazione, il puntatore current viene spostato al nodo
    // successivo (current = current.getNext()), in modo da passare al prossimo nodo
    // della lista.
    // Una volta attraversata tutta la lista, il metodo termina senza restituire
    // nulla, poiché la lista è stata modificata direttamente.

    public void deleteEvenFromList2() {
        Node current = this.first;
        Node previous = null;

        while (current != null) {
            if (current.getElem() % 2 == 0) {
                if (previous == null) {
                    // Caso in cui il nodo da eliminare è il primo della lista
                    this.first = current.getNext();
                } else {
                    // Collego il nodo precedente al successivo, eliminando il nodo corrente
                    previous.setNext(current.getNext());
                }
            } else {
                // Mantengo il nodo corrente come nodo precedente
                previous = current;
            }
            // Passo al nodo successivo
            current = current.getNext();
        }
    }

    public void deleteEvenFromList() {
        Node prec = first;
        Node current = null;

        while (current != null) {
            if (current.getElem() % 2 == 0) {
                if (prec == null) {
                    // Caso in cui il nodo da eliminare è il primo della lista
                    this.first = current.getNext();
                } else {
                    prec.setNext(current.getNext());
                    
                }
            } else {
                prec = current;
            }
            current = current.getNext();
        }
    }

    public void deleteDispari(){}

}
