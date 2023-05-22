import java.awt.*;
import javax.swing.*;


class ProvaFlowLayout extends JFrame {
  JButton uno = new JButton("Uno");
  JButton due = new JButton("Due");
  JButton tre = new JButton("Tre");

  public ProvaFlowLayout() {
    super("Flow Layout");
    Container c = this.getContentPane();
    c.setLayout(new FlowLayout());
    c.add(uno);
    c.add(due);
    c.add(tre);
    //pack(); ottimizza 
    setSize(300, 100);
    setVisible(true);
  }
}

class ProvaGridLayout extends JFrame {
  JButton uno = new JButton("Uno");
  JButton due = new JButton("Due");
  JButton tre = new JButton("Tre");
  JButton quattro = new JButton("Quattro");

  public ProvaGridLayout() {
    super("Grid Layout");
    Container c = this.getContentPane();
    c.setLayout(new GridLayout(2, 2));

    c.add(uno);
    c.add(due);
    c.add(tre);
    c.add(quattro);

    setSize(300, 300);
    setVisible(true);
  }
}

class ProvaMixedLayout extends JFrame {
  JPanel pannelloInAlto = new JPanel();
  JPanel pannelloInCentro = new JPanel();
  JPanel pannelloInBasso = new JPanel();

  JLabel infoLabel = new JLabel("Selezionare:");

  JCheckBox opzione1check = new JCheckBox("Opz1");
  JCheckBox opzione2check = new JCheckBox("Opz2");

  JButton okButton = new JButton("OK");
  JButton cancButton = new JButton("Annulla");

  public ProvaMixedLayout() {
    super("Esempio di mixed layouts");
    pannelloInCentro.setLayout(new GridLayout(2, 1));

    pannelloInCentro.add(opzione1check);
    pannelloInCentro.add(opzione2check);
    pannelloInAlto.add(infoLabel);
    pannelloInBasso.add(okButton);
    pannelloInBasso.add(cancButton);

    getContentPane().add(pannelloInAlto, BorderLayout.NORTH);
    getContentPane().add(pannelloInCentro, BorderLayout.CENTER);
    getContentPane().add(pannelloInBasso, BorderLayout.SOUTH);
    pack();
    Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
    setLocation(
            (int) ((dim.getWidth() - this.getWidth()) / 2),
            (int) ((dim.getHeight() - this.getHeight()) / 2)
    );
    setVisible(true);
  }

}


public class ContainersExplore {
  public static void main(String args[]) {
    // ProvaFlowLayout provaFlowLayout = new ProvaFlowLayout();
    // ProvaGridLayout provaGridLayout = new ProvaGridLayout();
    ProvaMixedLayout provaMixedLayout = new ProvaMixedLayout();
  }
}