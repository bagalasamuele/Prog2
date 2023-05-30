//TestFigura.java
/**
 * Classe introdotta per provare a usare la classe Figura e il
 * dynamic binding. La classe Figura ha solo metodi astratti per area e
 * perimetro, non utilizzabili. Gli oggetti di Figura appartengono tutti
 * a sottoclassi non astratte, dove esistono metodi che sovrascrivono
 * area() e perimetro(): sono questi ultimi ad essere usati. Vediamo un
 * esempio.
 */
public class TestFigura {
    /**
     * Metodo per trovare la figura di massima area in un array di
     * figure non vuoto
     */
    public static int maxArea(Figura[] V) {
        // esempio di dynamic binding
        // metodo da eseguire: determinato dal tipo esatto di un oggetto
        int n = V.length;
        assert n > 0; // controllo che a non sia vuoto
        int m = 0; // m=indice massima area trovata, all'inizio indice di V[0]
        for (int i = 1; i < n; i++) {
            if (V[i].area() > V[m].area())
                m = i;
        }
        // ogni volta che trovo un'area V[i] piu' grande di V[m] aggiorno m
        return m;
    }

    public static void main(String[] args) {
        Figura f = new Cerchio(1.0);
        /**
         * Il tipo esatto di f e' Cerchio, quindi l'area di f si calcola
         * con il metodo area() definito per i cerchi
         */
        System.out.println("\n Area cerchio f di raggio 1 = " +
                f.area());
        /**
         * Finalmente incassiamo un vantaggio dalla classe astratta
         * Figura: ora posso definire un array con figure di OGNI TIPO e
         * gestirlo con un solo metodo statico maxArea
         */
        Figura[] a = {
                new Cerchio(1.0), // Cerchio di raggio 1
                new Rettangolo(1, 2), // Rettagolo di base 1 e altezza 2
                new PolReg(6, 2), // Esagono regolare di raggio 2
                new Trapezio(1, 2, 3) // Base minore 1, base maggiore 2, alt 3
        };
        int n = a.length;
        System.out.println

        ("\n Stampo area e perimetro delle figure in a.");
        System.out.println("Non ottengo il valore esatto 12 del perimetro dell'esagono.");
        for (int i = 0; i < n; i++) {
            System.out.println(" Area a[" + i + "] = " + a[i].area());
            System.out.println(" Perimetro a[" + i + "] = " + a[i].perimetro());
        }
        System.out.println("\n Indice figura di massima area in a="
                + maxArea(a));
    }
}
// end class TestFigura