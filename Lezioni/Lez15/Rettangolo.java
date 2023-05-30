
/**
 * Rettangolo.java. Sottoclasse non astratta di Poligono e quindi di
 * Figura. Rettangolo ha dei metodi implementati, non astratti, uno
 * ereditato dalla classe Poligono: getLati(). Il numero dei lati e'
 * fisso a 4.
 */
public class Rettangolo extends Poligono {
    private double base;
    private double altezza; // INVARIANTE: base>0, altezza>0

    public Rettangolo(double base, double altezza) {
        super(4);
        assert base > 0 && altezza > 0; // per mantenere l’invariante
        this.base = base;
        this.altezza = altezza;
    }

    public double getBase() {
        return base;
    }

    public double getAltezza() {
        return altezza;
    }

    public void setBase(double base) {
        assert base > 0;
        this.base = base;
    }

    public void setAltezza(double altezza) {
        assert altezza > 0;
        this.altezza = altezza;
    }

    public double area() {
        return base * altezza;
    }

    public double perimetro() {
        return 2 * (base + altezza);
    }
}
// end class Rettangolo