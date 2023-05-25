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

    public List deletePari(List p) {
        Node aux = p.first;
        Node aux2 = null;

        while (aux != null) {

            if (aux.getElem() % 2 == 0) {
                if (aux == p.first) { // caso in cui e pari ed e il first del primo elemento
                    aux = aux.getNext();
                    p.first = aux;
                }
                else { // Caso in cui e pari e in mezzo
                    aux2.setNext(aux.getNext());
                    aux = aux.getNext();
                }
            } else {
                aux2 = aux;  //assegno ad aux2 aux perche nel caso in cui il primo fosse dispari non deve restare null 
                aux = aux.getNext();  
            }
        }
        return p;
    }

}

