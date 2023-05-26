public class DynamicStack {
    protected Node top;
    /*
     * Rispetto alla classe Dynamic Stack, cambia la visibilità di top
     * da private a protected: visibile a tutte le classi dello stesso
     * package, e a tutte le sottoclassi, anche in package diversi. Questo
     * perché top dovrà essere accessibile da parte dei metodi delle
     * sottoclassi di DynamicStack che definiremo.
     */
    public DynamicStack() {
        top = null;
    }

    public boolean empty() {
        return top == null;
    }

    public void push(int x) {
        top = new Node(x, top);
    }

    public int pop() {
        assert !empty();
        int x = top.getElem();
        top = top.getNext();
        return x;
    }

    public int top() {
        assert !empty();
        int x = top.getElem();
        return x;
    }

    public String toString() {
        Node temp = top;
        String s = "";
        while (temp != null) {
            s = s + " || " + temp.getElem() + "\n";
            temp = temp.getNext();
        }
        return s;
    }
}