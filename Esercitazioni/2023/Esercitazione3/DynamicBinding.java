

class Persona {
  public void parla() {System.out.println("Persona parla");}
}

class Docente extends Persona {
  public void parla() {System.out.println("Docente parla");}
}


public class DynamicBinding {
  public static void main(String args[]) {
    Persona andrea = new Persona();
    Persona daniele = new Docente();

    andrea.parla(); // andrea è persona
    daniele.parla(); // daniele è docente
  }
}