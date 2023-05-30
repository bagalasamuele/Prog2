/**
 * Cerchio.java Sottoclasse non astratta di Figura:
 * sovrascrive area() e perimetro(), ha un attributo e metodi specifici
 * per il raggio del cerchio
 */
public class Cerchio extends Figura {
    private double raggio; // INVARIANTE: raggio>0

    public Cerchio(double raggio){
   
   assert raggio >= 0;
       this.raggio = raggio;
      }

    public double getRaggio() {
        return raggio;
    }

    public void setRaggio(double raggio) {
        assert raggio >= 0; // per rispettare l’invariante
        this.raggio = raggio;
    }

    public double area() {
        return Math.PI * raggio * raggio;
    }

    public double perimetro() {
        return 2 * Math.PI * raggio;
    }
}
// end class Cerchio