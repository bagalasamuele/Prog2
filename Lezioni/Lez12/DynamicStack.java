import Ex1.Node;

public class DynamicStack {
    protected Node top;

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