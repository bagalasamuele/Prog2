//DynamicStackSize.java
public class DynamicStackSize extends DynamicStackMax {
    private int size;

    public DynamicStackSize() {
        super();
        size = 0;
    }

    public int getSize() {
        return size;
    }

    @Override
    public void push(int n) {
        super.push(n);
        size++;
    }

    @Override
    public int pop() {
        assert !empty();
        size--;
        return super.pop();
    }

    public String toString() {
        return super.toString() + " || size = " + size + "\n";
    }
}
