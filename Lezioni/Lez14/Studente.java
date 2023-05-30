// Studente.java
public class Studente extends Persona {
    // Su uno studente abbiamo informazioni in piu' che su una persona
    private int matricola;

    public Studente(String nome, int matricola) {
        super(nome);
        this.matricola = matricola;
    }

    public int getMatricola() {
        return matricola;
    }

    public void setMatricola(int matricola) {
        this.matricola = matricola;
    }

    // OVERRIDE del metodo toString(): raccolgo le informazioni in piu'
    public String toString() {
        return super.toString() + " matricola = " + matricola;
    }
    // NON faccio override di nomeToString(): questo metodo
    // viene semplicemente ereditato

}