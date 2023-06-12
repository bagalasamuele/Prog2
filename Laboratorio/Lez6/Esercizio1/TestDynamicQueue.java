public class TestDynamicQueue{
    public static void main(String[] args) {
        //Esercizio 1
        DynamicQueue<Integer> q1 = new DynamicQueue<Integer>();
        System.out.println( "q1 = {17,42,4} " );
        q1.enqueue(17);
        q1.enqueue(42);
        q1.enqueue(4);
        q1.scriviOutput();

        System.out.println( "q1.empty() = " + q1.empty());
        System.out.println( "q1.contains(4)  = " + q1.contains(4)); //true
        System.out.println( "q1.contains(40) = " + q1.contains(40));//false
        System.out.println("q1.size() = " + q1.size());  // stampa 3
        System.out.println("q1.front()= " + q1.front()); // stampa 17
        System.out.println(q1.dequeue()); //toglie e stampa 17
        System.out.println(q1.dequeue()); //toglie e stampa 42
        System.out.println(q1.dequeue()); //toglie e stampa 4: coda vuota

        // gli elementi vengono stampati nello stesso ordine in cui
        // sono stati inseriti, dal momento che la coda e' una
        // struttura FIFO (First-In-First-Out)
        System.out.println( "q1.empty() = " + q1.empty()+"\n");
        DynamicQueue<Double> q2 = new DynamicQueue<Double>();
        System.out.println( "q2 = {17.0,42.0,4.0} " );
        q2.enqueue(17.0);
        q2.enqueue(42.0);
        q2.enqueue(4.0);
        q2.scriviOutput();

        System.out.println( "q2.empty() = " + q2.empty());
        System.out.println( "q2.contains(4)  = " + q2.contains(4.0)); //true
        System.out.println( "q2.contains(40) = " + q2.contains(40.0));//false
        System.out.println("q2.size() = " + q2.size());  // stampa 3.0
        System.out.println("q2.front()= " + q2.front()); // stampa 17.0
        System.out.println(q2.dequeue()); //toglie e stampa 17.0
        System.out.println(q2.dequeue()); //toglie e stampa 42.0
        System.out.println(q2.dequeue()); //toglie e stampa 4: coda vuota

        // gli elementi vengono stampati nello stesso ordine in cui
        // sono stati inseriti, dal momento che la coda e' una
        // struttura FIFO (First-In-First-Out)
        System.out.println( "q2.empty() = " + q2.empty()+"\n");
        DynamicQueue<Person> q3 = new DynamicQueue<Person>();
        System.out.println( "q3 = {Luis Barrios,Amedeo Bragio,Matilde Berzia} " );
        q3.enqueue(new Person("Luis","Barrios"));
        q3.enqueue(new Person("Amedeo","Bragio"));
        q3.enqueue(new Person("Matilde", "Berzia"));
        q3.scriviOutput();
        Person cercaPersona = new Person("Luis","Barrios");
        System.out.println( "q3.empty() = " + q3.empty());
        System.out.println( "q3.contains(4)  = " + q3.contains(cercaPersona)); //true
        System.out.println( "q3.contains(40) = " + q3.contains(new Person("Pippo","Baudo")));//false
        System.out.println("q3.size() = " + q3.size());  // stampa 3
        System.out.println("q3.front()= " + q3.front()); // stampa Luis Barrios perchè è in testa
        System.out.println(q3.dequeue()); //toglie e stampa Luis Barrios
        System.out.println(q3.dequeue()); //toglie e stampa Amedeo Bragio
        System.out.println(q3.dequeue()); //toglie e stampa 4: Matilde Berzia

        // gli elementi vengono stampati nello stesso ordine in cui
        // sono stati inseriti, dal momento che la coda e' una
        // struttura FIFO (First-In-First-Out)
        System.out.println( "q3.empty() = " + q3.empty()+"\n");
    }
}