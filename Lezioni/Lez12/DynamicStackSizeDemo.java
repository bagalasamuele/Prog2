public class DynamicStackSizeDemo {
    public static void main(String[] args) {
        System.out.println("Definisco la pila P = {-1}");
        DynamicStackSize P = new DynamicStackSize();
        P.push(-1);
        System.out.print(P);
        System.out.println("Definisco la pila P = {11,9,7,5,3,1,-1}");
        P.push(1);
        P.push(3);
        P.push(5);
        P.push(7);
        P.push(9);
        P.push(11);
        System.out.print(P);
        System.out.println("Estraggo 11, 9, 7. Leggo 5");
        System.out.println(" P.pop() = " + P.pop());
        System.out.println(" P.pop() = " + P.pop());
        System.out.println(" P.pop() = " + P.pop());
        // Leggiamo il prossimo elemento, 5, senza estrarlo dala pila
        System.out.println("  P.top() = " + P.top());
        System.out.println("Stampo cio' che resta: P={5,3,1,-1}");
        System.out.print(P);
    }
}
