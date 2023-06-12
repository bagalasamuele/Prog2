// Implementazione della classe Leaf per rappresentare alberi vuoti

public class Leaf extends Tree {
    public Leaf() {
    }

    public boolean empty() {
        return true;
    }

    public int max() {
        // e` illegale invocare l'operazione max sull'albero vuoto...
        assert false;
        // ...tuttavia il compilatore mi costringe a ritornare
        // comunque un valore perche' il metodo ha tipo di ritorno
        // int
        return 0;
    }

    public boolean contains(int x) {
        return false;
    }
    
    public boolean contains(int x, int n){
        return false;
    }

    public Tree insert(int x) {
        return new Branch(x, this, this);
    }

    public Tree remove(int x) {
        return this;
    }

    public boolean balanced() {
        return false;}
    // realizziamo anche un metodo toString per stampare un albero
    // binario sul terminale
    public String toString() {
        return "Leaf";
    }

    protected String toStringAux(String prefix, String root, String left, String right) {
        return prefix + root + "leaf";
    }

    public int depth() {
        return 0;
    }

    public int get(int i){
        return 0;
    }
    

    public int size() {
        return 0;
    }

    public int sum() {
        return 0;
    }


}
