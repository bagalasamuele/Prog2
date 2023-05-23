
// Quadrato.java  quadrato = una possibile forma di una Figura
// Definiamo Quadrato come una sottoclasse di Figura
import java.awt.*; //Abstract Window Toolkit
import javax.swing.*; //estensione di awt per interfacce grafiche

public class Quadrato extends Figura {
  // Un quadrato e' definito dal suo lato
  private int lato;
  private int x;
  private int y;
  private Color color;

  // COSTRUTTORE di un quadrato
  public Quadrato(int x, int y, int lato, Color color) {
    this.x = x;
    this.y = y;
    this.lato = lato;
    this.color = color;
  }

  public void draw(Graphics g) {
    // g.setLocation(x,y);
    g.setColor(color);
    int m = lato / 2;
    g.drawLine(x + m, y + m, x - m, y + m); // disegno primo lato su g
    g.drawLine(x - m, y + m, x - m, y - m); // disegno secondo lato su g
    g.drawLine(x - m, y - m, x + m, y - m); // disegno terzo lato su g
    g.drawLine(x + m, y - m, x + m, y + m); // disegno quarto lato su g
  }

}
