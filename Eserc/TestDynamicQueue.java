//Node.java
//Riutilizzate la classe Node definita nella Lezione 08

//TestDynamicQueue.java
//Usate questa classe come test per DynamicQueue
public class TestDynamicQueue{
  public static void main(String[] args){
    DynamicQueue q = new DynamicQueue();
    System.out.println( "q = {17,42,4} " );
    q.enqueue(17); q.enqueue(42); q.enqueue(4);
    System.out.print(q);
    System.out.println( "q.empty() = " + q.empty());
    // Aggiungete queste righe se avete realizzato "contains"
    System.out.println( "q.contains(4)  = " + q.contains(4)); //true
    System.out.println( "q.contains(40) = " + q.contains(40));//false
    System.out.println("q.size() = " + q.size());  // stampa 3
    System.out.println("q.front()= " + q.front()); // stampa 17
    System.out.println(q.dequeue()); //toglie e stampa 17
    System.out.println(q.dequeue()); //toglie e stampa 42
    System.out.println(q.dequeue()); //toglie e stampa 4: coda vuota
    // gli elementi vengono stampati nello stesso ordine in cui
    // sono stati inseriti, dal momento che la coda e' una
    // struttura FIFO (First-In-First-Out)
    System.out.println( "q.empty() = " + q.empty());
    /** Questo comando deve far scattare un "assert":*/
    //q.front();
  
    
  }
}

