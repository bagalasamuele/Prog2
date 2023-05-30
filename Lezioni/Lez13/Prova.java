public class Prova {
    public static void prova(Bottiglia b) {

        System.out.println("b.aggiungi(6) =" + b.aggiungi(6));

        if (b instanceof Bottiglia)
            System.out.println("b è una bottiglia");

        if (b instanceof BottigliaConTappo) {
            System.out.println("b è una bottiglia con tappo");
            BottigliaConTappo z = (BottigliaConTappo) b;
            System.out.println(" z.aperta()=" + z.aperta());
            System.out.println(" b.aggiungi(6)=" + b.aggiungi(6) + " b=" + b);
            System.out.println(" z.aggiungi(3)=" + z.aggiungi(3) + " z=" + z);

        }
    }

    public static void main(String[] args) {
        Bottiglia a = new Bottiglia(9);
        System.out.println("\nProvo con un Bottiglia =" + a);
        prova(a);
        BottigliaConTappo b = new BottigliaConTappo(9);
        System.out.println("\nProvo con un BottigliaConTappo =" + b);
        prova(b);
    }
}

// Nota avanzata. Riassumiamo come possiamo usare il downcast quando un metodo m
// ha come parametro formale un oggetto di un tipo (apparente) C, dove C è una
// classe genitore di una gerarchia. Al metodo m possiamo passare come parametri
// attuali oggetti delle sottoclassi di C, usando un upcast: un oggetto con tipo
// più preciso si può utilizzare al posto
// di uno con tipo meno preciso. Nel corpo del metodo m possiamo voler scegliere
// che azioni fare a seconda se il parametro attuale è istanza oppure no di un
// tipo dato. Possiamo ottenere questo effetto usando “instanceof”, come
// mostrato sopra.