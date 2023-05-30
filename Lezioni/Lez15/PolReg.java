/**
 * PolReg.java. Sottoclasse non astratta di Poligono e quindi di
 * Figura: ha dei metodi veri per area e perimetro, piu' attributi e
 * metodi specifici per raggio, lato e apotema.
 */
public class PolReg extends Poligono {
    private double raggio; // invariante raggio>0

    public PolReg(int lati, double raggio) {
        super(lati);
        assert raggio >= 0; // per mantenere l’invariante
        this.raggio = raggio;
    }

    // Il numero dei lati di un poligono regolare puo' cambiare.
    public double getRaggio() {
        return this.raggio;
    }

    public void setRaggio(double raggio){
         assert raggio >= 0; // per mantenere l’invariante
         this.raggio=raggio; 
  }

    public void setLati(int lati) { // richiede "lati" protected
        assert lati >= 3; // per mantenere l’invariante
        this.lati = lati;
    }

    // Formula per apotema
    public double apotema() {
        return raggio * Math.cos(Math.PI / getLati());
    }

    // Formula per lato
    public double lato() {
        return 2 * raggio * Math.sin(Math.PI / getLati());
    }

    // Formula per perimetro
    public double perimetro() {
        return lato() * getLati();
    }

    // Formula per area
    public double area() {
        return getLati() * (lato() * apotema() / 2);
    }

    /**
     * ESEMPIO di cosa viene accettato da Java. Questo main serve a far
     * vedere che posso assegnare un oggetto E della sottoclasse PolReg a
     * una variabile di tipo Figura (classe astratta) perche' questa
     * sottoclasse non e' astratta. Il tipo esatto di E determina il metodo
     * usato per calcolare l'area di E.
     */
    public static void main(String[] args) {
        Figura E = new PolReg(6, 1.0);
        System.out.println(E.area()); // calcolata nella classe PolReg
    }
}