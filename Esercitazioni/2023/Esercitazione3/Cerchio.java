
// Cerchio.java cerchio = una possibile forma di una Figura:
// definiamo Cerchio come una sotto-classe di Figura.
import java.awt.*; //Abstract Window Toolkit
import javax.swing.*; //estensione di awt per interfacce grafiche

public class Cerchio extends Figura {
   // Un cerchio e' definito dal suo raggio r
   private int raggio;
   private int x;
   private int y;
   private Color color;

   // COSTRUTTORE di un quadrato
   public Cerchio(int x, int y, int raggio, Color color) {
      this.x = x;
      this.y = y;
      this.raggio = raggio;
   }

   // OVERRIDE: RI-definiamo il metodo draw per disegnare una figura
   // in un oggetto grafico g, nel caso la figura sia un cerchio.
   // Disegnamo il cerchio nel rettangolo di angolo in basso a sinistra
   // (-r, -r) e di dimensioni 2r x 2r.
   // Scegliamo il colore rosso per le prossime linee in g
   public void draw(Graphics g) {
      g.setColor(color);
      g.drawOval(x - raggio, y - raggio, 2 * raggio, 2 * raggio);
      // g.drawOval(-raggio,-raggio, 2*raggio,2*raggio);
   }
}
