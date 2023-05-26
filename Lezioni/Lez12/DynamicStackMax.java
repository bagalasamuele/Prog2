
public class DynamicStackMax extends DynamicStack {
    private int max;

    public DynamicStackMax() {
        super();
        max = 0;
    }

    public int getMax() {
        assert !empty();
        return max;
    }

    @Override
    public void push(int n) {
        if (empty())
            max = n;
        else
            max = Math.max(max, n);
        super.push(n);
    }

    private void resetMax() {
        if (!empty()) {

            max = top.getElem();
            for (Node p = top.getNext(); p != null; p = p.getNext())
                max = Math.max(max, p.getElem());
        }
    }

    @Override
    public int pop() {
        assert !empty();
        int n = super.pop();
        if (n == max)
            resetMax();
        return n;
    }

    public String toString() {
        return super.toString() + " || max= " + max + "\n";
    }
}
