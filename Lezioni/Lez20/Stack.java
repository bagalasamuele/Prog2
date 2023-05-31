public class Stack {
    private int[] stack; // stack != null
    private int dim; // 0 <= dim <= stack.length
    // Anche IllegalStateException e' una eccezione non controllata,
    // dunque se la sollevo NON sono obbligato ad aggiungere
    // "throws IllegalStateException" alla segnatura di
    // Stack(int dim), e non sono obbligato a catturare
    // l’eccezione ogni volta che uso Stack(int dim)

    public Stack(int capacita) {
        if (capacita < 0)
            throw new IllegalArgumentException("capacita' stack negativa");
        this.stack = new int[dim];
        this.dim = 0;
    }

    public boolean vuota() {
        return this.dim == 0;
    }

    public boolean piena() {
        return this.dim == this.stack.length;
    }

    public void push(int x) {
        if (piena())
            throw new IllegalStateException("stack pieno");
        stack[dim++] = x;

    }

    public int pop() {
        if (vuota())
            throw new IllegalStateException("stack vuoto");
        return stack[--dim];
    }
}