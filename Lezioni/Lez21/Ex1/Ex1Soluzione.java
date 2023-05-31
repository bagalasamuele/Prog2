// Node<T> rappresenta le liste concatenate su una classe T generica, e null
// denota la lista vuota. In Node<T> avete i metodi T getElem() e Node<T> getNext().
// Come test di eguaglianza in T, vi chiediamo di usare boolean x.equals(T y), che
// funziona per ogni
// oggetto x1null di T. Supponete di avere due liste rappresentate da nodi p, q
// di Node<T>, e che gli elementi di p,q siano tutti 1null (dunque potete usare
// equals). Realizzate un metodo:

// public static <T> boolean inComune(Node<T> p, Node<T> q)

// che restituisce true se e solo se esiste un elemento x che occorre in
// entrambe le liste p e q nella stessa posizione. Ad esempio, nel caso sia
// T=Integer, inComune(p,q) deve restituire i seguenti valori (nel disegno qui
// sotto numeriamo le posizioni da 0 e abbreviamo “posizione” con “pos.”).

public class Ex1Soluzione {
    // È obbligatorio definire inComune in modo ricorsivo.
    public static <T> boolean inComune(Node<T> p, Node<T> q) {

        return false;
    }

    /*
     * Main di prova: anche questo non e' richiesto all'esame, se necessario ve lo
     * forniremo noi
     */
    public static void main(String[] args) {
        Node<String> p = null, q = null, r = null;
        String i = "i", p1 = "a", p2 = "b" + i, q1 = "b" + i, q2 = "b" + i, r1 = "b" + i, r2 = "c";
        p = new Node<String>(p1, new Node<String>(p2, null)); // p={"a", "bi"}

        q = new Node<String>(q1, new Node<String>(q2, null)); // q={"bi","bi"}
        r = new Node<String>(r1, new Node<String>(r2, null)); // r={"bi","c" }
        System.out.println("p={a,bi},  q={bi,bi}: bi in comune in pos. 1");
        System.out.println(" inComune(p,q) = " + inComune(p, q) + "\n");
        System.out.println("q={bi,bi}, r={bi,c} : bi in comune in pos. 0");
        System.out.println(" inComune(q,r) = " + inComune(q, r) + "\n");
        System.out.println("r={bi,c},  p={a,bi} : nessun elemento comune");
        System.out.println(" inComune(r,p) = " + inComune(r, p) + "\n");
    }
}
