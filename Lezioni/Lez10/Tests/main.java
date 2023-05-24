public class main {
    public static void main(String args[]) {
        // LIFO
        // Ultimo entrato e il primo in lista
        // Last in first out
        GenericStack<String> p = new GenericStack<>();
        // Creiamo una lista di tipo stringa e inseriamo 2 elementi
        p.push("Elemento 1");
        System.out.println(p);
        p.push("Elemento 2");
        System.out.println(p);
    }
}
