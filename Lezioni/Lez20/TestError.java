import java.io.*; //per le IOException

public class TestError {
    public static void m()
    // Error e' non controllato, non sono obbligato scrivere throws.
    // Ma potrei farlo: se lo facessi, dovrei mettere le sue chiamate
    // in un costrutto "try-catch"
    {
        throw new Error("error");
    }

    // viene chiamato il costruttore della classe Error, che prende
    // un parametro String: ricordatevi, le eccezioni sono oggetti!
    public static void m2() throws IOException {
        // IOException e' controllata, devo scrivere throws
        // e le chiamate di m2() devono stare in un try-catch

        throw new IOException("io exception");
    }

    public static void m3()
    // RuntimeException e' non controllata, non devo scrivere throws
    // ma posso farlo: se lo faccio, devo mettere le sue chiamate in
    // un try-catch
    {
        throw new RuntimeException("runtime exception");
    }

    public static void main(String[] args) {
        try {
            m();
            m2();
            m3();
        } catch (Throwable e) // catturo tutti gli errori o eccezioni
        {
            System.out.println("Captured: " + e);
        }
        // finito il body del catch, non si prosegue nel try,
        // ma si prosegue con il programma:
        System.out.println("Sono fuori dal try-catch!");
    }
}