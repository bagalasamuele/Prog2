
// BottigliaConTappoDemo.java
/* Controlliamo che lo stato "bottiglia aperta" lasci invariati i

travasi, e che lo stato "bottiglia chiusa" li azzera. */
public class BottigliaConTappoDemo {
    public static void main(String[] args) {
        System.out.println("Definisco b da 100 litri vuota e la apro");
        BottigliaConTappo b = new BottigliaConTappo(100);
        b.apri();
        System.out.println(b);
        System.out.println(" b.aperta() = " + b.aperta());
        System.out.println("Aggiungo 50 litri in b poi chiudo b");
        System.out.println(" b.aggiungi(50) = " + b.aggiungi(50));
        b.chiudi();
        System.out.println(b);
        System.out.println(" b.aperta() = " + b.aperta());
        System.out.println("Chiedo di rimuovere 20 litri da b: zero");
        System.out.println(" b.rimuovi(20) = " + b.rimuovi(20));
        System.out.println(" b.getLivello() = " + b.getLivello());
        System.out.println(b);
        System.out.println("Apro b: ora riesco a togliere 20 litri");
        b.apri();
        System.out.println(" b.aperta() = " + b.aperta());
        System.out.println(" b.rimuovi(20) = " + b.rimuovi(20));
        System.out.println(b);
        System.out.println(" b.getLivello() = " + b.getLivello());
    }
}
