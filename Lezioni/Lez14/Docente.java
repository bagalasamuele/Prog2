// Docente.java
public class Docente extends Persona {
    // Su un docente abbiamo delle informazioni in piu' che su una
    // persona
    private int stipendio;

    public Docente(String nome, int stipendio) {
        super(nome);
        this.stipendio = stipendio;
    }

    public int getStipendio() {
        return stipendio;
    }

    public void setStipendio(int stipendio) {
        this.stipendio = stipendio;
    }

    // OVERRIDE di toString(): raccolgo le informazioni in piu'
    public String toString() {
        return super.toString() + " stipendio = " + stipendio;
    }
    // NON faccio override di nomeToString():
    // questo metodo viene semplicemente ereditato
}
