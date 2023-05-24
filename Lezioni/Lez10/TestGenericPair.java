public class TestGenericPair {
    /*
     * Questo metodo, dato un (x,y) di tipo GenericPair, restituisce un
     * nuovo (y,x) di tipo GenericPair. Attenzione qui sotto a non scrivere
     * GenericPair al posto di GenericPair<S,T> come tipo di ritorno,
     * altrimenti il compilatore e' costretto a indovinare S, T, e rimpiazza
     * GenericPair con GenericPair<Object,Object>, perdendo informazioni.
     */
    public static <T, S> GenericPair<S, T> inv(GenericPair<T, S> p) {
        return new GenericPair<S, T>(p.getSecond(), p.getFirst());
    }

    public static void main(String[] args) {
        /*
         * Qui creiamo un GenericPair<T,S> in cui il primo elemento (campo
         * first) è di tipo T=String e il secondo (campo second) è di tipo
         * S=Integer. Al posto di GenericPair<String,Integer> dopo la new posso
         * scrivere GenericPair<>, purche' Java sia in grado di dedurre in modo
         * unico i valori di S, T. Attenzione che i compilatori vecchi non
         * accettano la seconda versione.
         */
        GenericPair<String, Integer> p = new GenericPair<>("pluto", 1);
        // nel seguito, "\t" e' la tabulazione e inserisce spazi bianchi
        System.out.println("p = \t\t\t\t" + p);
        System.out.println("inv(p) = \t\t\t" + inv(p));
        System.out.println("p non cambia: \t" + p);
        // Dato che inv e' un metodo statico, al di fuori della sua classe
        // deve venire chiamato p. es. come:
        // TestGenericPair.<String,Integer>inv(p);
    }
}