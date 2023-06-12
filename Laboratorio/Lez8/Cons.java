// Sottoclasse concreta (= non astratta) di List: 
// Le istanze di Cons rappresentano le liste NON vuote.
// Le implementazioni sono ricorsive
public class Cons extends List {
    // Una lista (ordinata) non vuota ha due informazioni:
    private int elem;  // primo elemento
    private List next; // riferimento al resto della lista

    // Definiamo il costruttore Cons come protected, perche' consente di 
    // costruire liste non ordinate, mentre voglio che tutti i metodi pubblici
    // di Cons preservino l'ordinamento degli elementi della lista.
    protected Cons(int elem, List next) {
        this.elem = elem; 
        this.next = next;
    }

    // Ritorna true se la lista è vuota.
    // Nel caso di Cons, la lista e' sempre non vuota
    @Override
    public boolean empty() {  
        return false; 
    }

    // Ritorna il numero di elementi nella lista.
    @Override
    public int size() { 
        return 1 + next.size(); 
    }

    // Ritorna true se @x e' contenuto nella lista, false altrimenti.
    @Override
    public boolean contains(int x) { 
        return (x == elem) || next.contains(x); 
    }


    // Aggiunge @x alla lista, mantenendo l'ordine.
    // Ritorna una nuova lista opportunamente modificata.
    @Override
    public List insert(int x) {
        //Se x e' piu' piccolo del primo elemento aggiungo x davanti a tutti
        if (x < elem)
            return new Cons(x, this);
        //Se x e' uguale al primo elemento lascio this come si trova
        else if (x == elem)
            return this;
        //Se x e' maggiore del primo elemento aggiungo x nel resto della lista
        else // x > elem
            return new Cons(elem, next.insert(x));
    }


    // Aggiungi alla lista tutti gli elementi di @l, e ritorna la nuova lista creata.
    // Nel caso di Cons, aggiungi gli elementi uno alla volta, preservando 
    // l'ordine ad ogni passo
    @Override
    public List append(List l) {
        if (l.empty())
            return this;
        else {
            // DOWNCAST: per scrivere l.elem, l.next devo prima fare un downcast
            // ((Cons) l) per spostare l in Cons, dato che elem, next esistono solo in Cons
            // Il downcast e' possibile perche' se l non e' vuota, allora si assume
            // sia di tipo Cons
            int x = ((Cons) l).elem;  // primo elemento di l
            List m = ((Cons) l).next; // successori di l
            // prima aggiungo il primo elemento di l, poi gli altri
            return insert(x).append(m);
        }
        /** NOTA SULL'EFFICIENZA DI append(). 
        * Il nostro append() richiede un numero di usi di new uguali a:
        *      (1/2) * this.size() * l.size()        (circa)
        * Ci sono versioni di append() molto piu' veloci, che richiedono meno
        * usi di new, all'incirca
        *      (this.size() + l.size())
        * Pero' sono piu' difficili: per curiosita', qui sotto includiamo un algoritmo  
        * detto di MERGING: fonde due liste ordinate in una lista ordinata.
        if (l.empty()) 
            return this;
        else if (this.empty())
            return l;
        else {
            int x = ((Cons) l).elem; 
            List m = ((Cons) l).next;
            if (x< elem) 
                return new Cons(x,append(m));
            else if (x == elem) 
                return new Cons(x,next.append(m));
            else
                return new Cons(elem,next.append(l));
        }
        */
    }


    // Ritorna una rappresentazione testuale dell'istanza
    @Override
    public String toString() {
        // trasformo in stringa il primo elemento, poi concateno gli altri
        return elem + " " + next.toString();
    }
    public  int sum(){
        return elem +next.sum();
    }
    @Override
    public int get(int i){
        if(i==0)
            return elem;
        else
            return  next.get(i-1);
    }
    @Override
    public  List succ(){
        return new Cons(elem+1,next.succ());
    }
    @Override
    public List filter_le(int x){
        if(elem <= x)
            return new Cons(elem,next.filter_le(x));
        else
            return new Nil();
    }
    @Override
    public  List filter_gt(int x){
        if(elem > x)
            return this;
        else
            return next.filter_gt(x);
    }

    @Override
    public List intersect(List l) {
        if(l.empty())
            return l;
        if(elem == l.get(0))
            return new Cons(elem,next.intersect(((Cons)l).next));
        else if (elem<l.get(0))
            return next.intersect(l);
        else
            return  intersect(((Cons)l).next);
    }
}
