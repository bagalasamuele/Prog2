
// ComparaBottiglie.java - Classe di test
import java.util.*; //Per la classe Arrays
// COSA ABBIAMO FATTO: nella classe Bottiglia abbiamo aggiunto
// il metodo compareTo(), per confrontare due bottiglie
// COSA OTTENIAMO: possiamo usare i metodi statici di libreria
// Arrays.sort() e Arrays.binarySearch() per ordinare un array di
// bottiglie e per la ricerca binaria in un array ordinato di
// bottiglie

public class ComparaBottiglie {
    public static void main(String[] args) {
        Bottiglia b1 = new Bottiglia(10); // bottiglia vuota di capacita' 10
        Bottiglia b2 = new Bottiglia(20); // bottiglia vuota di capacita' 20
        Bottiglia b3 = new Bottiglia(5); // bottiglia vuota di capacita' 5
        Bottiglia b4 = new Bottiglia(15); // bottiglia vuota di capacita' 15
        // Riempo le prime 3 bottiglie, poi le confronto in base al livello
        b1.aggiungi(3); // b1 e' la piu' piena (la capacita' e'irrilevante)
        b2.aggiungi(2); // b2 e' intermedia
        b3.aggiungi(1); // b3 e' la meno piena
        // b4 resta vuota
        System.out.println("\n b1=" + b1 + "\n b2=" + b2 + "\n b3=" + b3 + "\n b4=" + b4);
        // confronto in base al livello:
        System.out.println(" confronto  b1 (3 litri) con b2 (2 litri): "
                + b1.compareTo(b2));
        System.out.println(" confronto  opposto: " + b2.compareTo(b1));
        System.out.println(" confronto b1 con b1: " + b1.compareTo(b1));
        // ordinamento di un array di bottiglie in base al livello:
        Bottiglia[] bottiglie = { b1, b2, b3 }; // non aggiungo b4
        // posso ordinare le bottiglie in questo array perche'
        // Bottiglia implementa l'interfaccia Comparable

        System.out.println(" Ordino e stampo {b1, b2, b3}");
        Arrays.sort(bottiglie);
        // Dato che "bottiglie" e' un array posso usare il "foreach"
        // (La classe Arrays implementa l’interfaccia Iterable<T>):
        for (Bottiglia b : bottiglie)
            System.out.println(b);
        // Posso eseguire la ricerca binaria della posizione di una bottiglia
        // in questo array ordinato perché Bottiglia implementa l'interfaccia
        // Comparable<Bottiglia>; binarySearch(b) restituisce un numero
        // negativo se b non e' presente
        System.out.println(" cerco posizione di b1 (3 litri) nell'array:" + Arrays.binarySearch(bottiglie, b1));
        System.out.println(" cerco posizione di b2 (2 litri) nell'array:" + Arrays.binarySearch(bottiglie, b2));
        System.out.println(" cerco posizione di b3 (1 litro) nell'array:" + Arrays.binarySearch(bottiglie, b3));
        System.out.println(" cerco posizione di b4 (0 litri) nell'array:" + Arrays.binarySearch(bottiglie, b4));
    }
}
// end class ComparaBottiglie
