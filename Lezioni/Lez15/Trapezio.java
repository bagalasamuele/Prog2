//Il numero dei lati e' fisso a 4.
public class Trapezio extends Poligono {
    private double baseMinore; // INV. 0 < baseMinore
    private double baseMaggiore; // INV. baseMinore <= baseMaggiore
    private double altezza; // INV. altezza > 0

    public Trapezio(double baseMinore, double baseMaggiore, double altezza) {
        /*
         * l'invocazione a super(...) deve essere la prima istruzione del costruttore
         * nell’estensione, altrimenti Java inserisce comunque l’istruzione super();
         */
        super(4); // Il trapezio e' un poligono di 4 lati
        assert baseMinore > 0 && baseMinore <= baseMaggiore && altezza > 0;
        // per mantenere l’invariante
        this.baseMinore = baseMinore;
        this.baseMaggiore = baseMaggiore;
        this.altezza = altezza;
    }

    public double getBaseMinore() {
        return baseMinore;
    }

    public double getBaseMaggiore() {
        return baseMaggiore;
    }

    public double getAltezza() {
        return altezza;
    }

    public void setBaseMinore(double baseMinore) {
        assert baseMinore > 0;
        this.baseMinore = baseMinore;
    }

    public void setBaseMaggiore(double baseMaggiore) {
        assert baseMinore <= baseMaggiore;
        this.baseMaggiore = baseMaggiore;
    }

    public void setAltezza(double altezza) {
        assert altezza > 0;
        this.altezza = altezza;
    }

    // Formula per l'area del trapezio (anche non isoscele)
    public double area() {
        return (baseMinore + baseMaggiore) * altezza / 2;
    }

    // Formula per il perimetro del trapezio isoscele
    public double perimetro() {
        return 2 * lato() + baseMinore + baseMaggiore;
    }

    // Formula per il lato del trapezio isoscele
    public double lato()
    {return Math.sqrt(Math.pow(altezza, 2) + Math.pow((baseMaggiore-baseMinore)/2,2));
}
}
// end class Trapezio