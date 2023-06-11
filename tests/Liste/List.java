// import Lezioni.Lez09.NodeUtil.Node;

public class List {
    private Node first;

    public List(Node first) {
        this.first = first;
    }

    public void pop(Node top) {
        Node aux = first;
        first = top;
        first.setNext(aux);
    }

    public void deletePari() {
        Node aux = first;
        Node previus = null;

        while (aux != null) {
            if (aux.getElem() % 2 == 0) {

                if (aux == first) {
                    first = aux.getNext();
                } else {
                    previus.setNext(aux.getNext());
                }
            } else {
                previus = aux;
            }

            aux = aux.getNext();
        }

    }

    public void deleteDispari() {
        Node aux = this.first;
        Node previus = null;

        while (aux != null) {
            if (aux.getElem() % 2 != 0) {

                if (aux == first) {
                    first = aux.getNext();
                } else {
                    previus.setNext(aux.getNext());
                }
            } else {
                previus = aux;
            }
            aux = aux.getNext();
        }

    }


    public void deleteElem(int elem) {
        Node aux = this.first;
        Node previus = null;

        while (aux != null) {
            if (first.getElem() == elem) {
                first = aux.getNext();
            } else if (aux.getElem() == elem) {
                previus.setNext(aux.getNext());
            } else {
                previus = aux;
            }
            aux = aux.getNext();
        }
    }

    public boolean isContain(int x) {
        Node aux = this.first;

        while (aux != null) {
            if (aux.getElem() == x)
                return true;
            aux = aux.getNext();
        }

        return false;
    }



    public static String toString(Node p)
    {if (p==null) 
      return ""; 
     else 
      return p.getElem() +" " +  toString(p.getNext());
    }

}