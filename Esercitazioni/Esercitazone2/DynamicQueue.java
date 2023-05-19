// FIFO 

public class DynamicQueue {

  private Node first;
  private Node last;

  // (i) un costruttore per la coda vuota;
  public DynamicQueue() {
    first = last = null;
  }

  // (ii) un metodo di scrittura;
  public String toString() {
    String message = new String();
    for (Node p = first; p != null; p = p.getNext()) {
      message = message + "| " + p.getElem() + "| ";
    }
    return message;
  }

  // (iii) un metodo void enqueue(int x) per aggiungere un elemento dietro
  // l’ultimo;
  public void enqueue(int x) {
    Node newElement = new Node(x, null);
    if (first == null)
      first = last = newElement;
    else {
      last.setNext(newElement);
      last = newElement;
    }
  }

  // (iv) un metodo int dequeue() per togliere il primo elemento della coda;
  public int dequeue() {
    assert !empty() : "Err. rimozione da coda vuota.";
    int elemento = first.getElem();
    first = first.getNext();
    if (first == null)
      last = null;
    return elemento;
  }

  // (v) un metodo int size() per contare gli elementi della coda;
  public int size() {
    int n = 0;
    for (Node p = first; p != null; p = p.getNext())
      n++;
    return n;
  }

  // (vi) un metodo int front() per leggere il primo elemento della coda senza
  // toglierlo;
  // TODO aggiungere assert
  public int front() {
    assert !empty() : "La lista e' vuota";
    return first.getElem();

  }

  // (vii) un metodo boolean empty() per verificare se la coda è vuota;
  public boolean empty() {
    return first == null ? true : false;
  }

  // (viii) un metodo pubblico boolean contains(int x) per verificare se la coda
  // contiene un dato elemento x;
  public boolean contains(int x) {
    for (Node p = first; p != null; p = p.getNext()) {
      if (p.getElem() == x)
        return true;
    }
    return false;

  }

  // Tutti i metodi devono preservare il seguente invariante della classe: ogni
  // nodo tranne l’ultimo punta al precedente, e first e last puntano al primo e
  // all’ultimo elemento della coda, inoltre sono uguali a null se la coda è
  // vuota.
}
