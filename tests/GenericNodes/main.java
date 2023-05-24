package tests.GenericNodes;
public class main {
    public static void main(String args[]) {
        // LIFO
        // Ultimo entrato e il primo in lista
        // Last in first out


        // Creiamo una lista di tipo stringa e inseriamo 2 elementi
        GenericStack<String> p = new GenericStack<>();
        p.push("Elemento 1");
        System.out.println(p);
        p.push("Elemento 2");
        System.out.println(p);


        //Creo un Nodo di tipo doble 
        GenericStack<Double> doubleNode = new GenericStack<>();
        doubleNode.push(1.0);
        doubleNode.push(1.1);
        doubleNode.push(1.2);
        System.out.println(doubleNode);

    }
}
