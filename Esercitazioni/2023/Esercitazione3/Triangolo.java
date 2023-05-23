
//Disegno.java
import java.awt.*; //Abstract Window Toolkit (finestre grafiche)
import javax.swing.*; //estensione di awt per interfacce grafiche

public class Triangolo extends Figura {
    private int x;
    private int y;
    private int base;
    private int altezza;

    public Triangolo(int x, int y, int base, int altezza) {
        this.x = x;
        this.y = y;
        this.altezza = -altezza;
        this.base = base;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.red);
        g.drawLine((x - base) / 2, y, x + base / 2, y); // base triangolo
        g.drawLine((x - base) / 2, y, x, y + altezza); // lato sinistro
        g.drawLine(x + base / 2, y, x, y + altezza); // lato destro
    }
}