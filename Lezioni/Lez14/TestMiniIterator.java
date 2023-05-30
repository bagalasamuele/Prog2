/**
 * TestMiniIterator.java (controlliamo MiniLinkedList e
 * MiniIterator)
 */
public class TestMiniIterator {
    public static void main(String[] args) {
        // Definisco una lista l = {9,8,7,6,5,4,3,2,1,0} aggiungendo
        // 0,1,2,3,4,5,6,7,8,9
        // sempre in posizione 0, dunque ogni elemento davanti ai precedenti
        MiniLinkedList l = new MiniLinkedList();
        for (int i = 0; i < 10; i++)
            l.add(0, i);
        // Cancello l_7, cioe' il terzo elemento di l dal fondo: il 2
        // Resta l = { ... 3 1 0}
        System.out.println(" l.size()  = " + l.size());
        System.out.println("Cancello l_7 (contiene 2)");
        System.out.println(" l.remove(7)  = " + l.remove(7));
        System.out.println(" l.size()  = " + l.size());
        // Stampo senza MiniIterator: complessità in tempo alta come
        // spiegato nell'introduzione (vedi sopra), perché ogni get(i)
        // ricomincia dal primo nodo.
        System.out.println("Stampo l usando le get(i):");
        for (int i = 0; i < l.size(); i++) {
            System.out.println(" " + l.get(i));
        }
        /*
         * Per evitare una complessità in tempo alta, potrei invece consentire l’accesso
         * al first di MiniLinkedList mettendolo public. Ma l’accesso
         * 
         * 
         * al first provocherebbe una "information leaking", un accesso a informazioni
         * private della classe, che puo' produrre danni, involontari o intenzionali.
         * Abbiamo introdotto introdotto quindi il concetto di "iterator", che è come un
         * puntatore temporaneo, ma che sta nella heap con gli altri oggetti, non nello
         * stack.
         */
        // Stampo tramite MiniIterator per il puntatore della stampa:
        // creo it = l.iterator() e faccio stampare utilizzando it.
        System.out.println("Stampo l usando MiniIterator:");
        MiniIterator it = l.iterator();
        while (it.hasNext())
            System.out.println(" " + it.next());
    }
}