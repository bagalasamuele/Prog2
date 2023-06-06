import java.util.*;

// classe astratta che definisce le operazioni su alberi binari
public abstract class Tree {
    public abstract boolean empty();

    public abstract int max();

    public abstract boolean contains(int x);

    public abstract Tree insert(int x);

    public abstract Tree remove(int x);

    public abstract int depth();

    // nuovi metodi
    public abstract int size();

    public abstract int sum();

    public abstract boolean contains(int x, int n);

    // public abstract boolean balanced();

    // public abstract Tree filter(int x);

    // public abstract int get(int i);
}
