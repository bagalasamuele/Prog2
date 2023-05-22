import java.awt.*;
import javax.swing.*;


public class PrimaGui {
  public static void main(String args[]) {
    JFrame window = new JFrame("prima finestra"); // nome finestra

    Container c = window.getContentPane();
    c.add(new JLabel("Esercitaz di Prog2")); // testo contenuto nella finestra
    window.setSize(400, 400); // settiamo dimensione
    windows.setLocation(400,400);
    // comportamento alla chiuisura della finestra;: il processo deve terminare
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    window.setVisible(true);
  }
}