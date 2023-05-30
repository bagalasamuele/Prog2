//Contatto.java - Forniamo una classe C che implementa Comparable<C>
public class Contatto implements Comparable<Contatto> {
    private String nome;
    private String email;

    public Contatto(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String toString() {
        return nome + "<" + email + ">";
    }

    // Implemento un metodo compareTo() nella classe Contatto
    public int compareTo(Contatto x) {
        return this.nome.compareTo(x.nome);
    }
}// end class Contatto