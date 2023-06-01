//MiniLinkedList.java

import Ex1.Node;

public class MiniLinkedList {
  private Node first;
  private int size;

  // INVARIANTE DI CLASSE:(first punta a elemento n.0 della lista
  // concatenata)
  // e (size = numero nodi accessibili da first)
  /** Costruttore della lista vuota con 0 elementi */
  public MiniLinkedList() {
    first = null;
    size = 0;
  }

  public int size() {
    return this.size;
  }

  /**
   * Metodo privato node(i) = indirizzo del nodo V_i della lista V.
   * Viene usato dalla classe per definire gli altri metodi
   * Non viene reso pubblico per evitare che dall'esterno sia
   * possibile modificare i nodi della classe senza aggiornare size
   * (-> per evitare information leak).
   */
  private Node node(int i) {
    // controllo che V_i sia un nodo della lista
    assert 0 <= i && i < size : "i non in [0,size-1]";
    // creo una copia di first per non modificare l'originale
    Node p = this.first;
    // il primo nodo lo consideriamo in posizione 0
    while (i > 0) {
      // rimpiazzo per i volte il p con il nodo dopo
      assert p != null : "size non rispetta invariante";
      // se vale l'invariante questo assert e' vero
      p = p.getNext();
      i--;
    }
    // Dopo aver applicato p = p.getNext() per i volte abbiamo p=node(i)
    assert p != null : "size non rispetta invariante";
    // se vale l'invariante questo assert e' vero
    return p;
    // nel caso i=0, node(i) restituisce proprio p = first

  }

  /** DEFINIZIONE get(i),set(i,x),add(i,x),remove(i) usando node(i) */
  /** get(i) = contenuto node(i) */
  public int get(int i) {
    return node(i).getElem();
  }

  /** set(i,x) assegna node(i) ad x */
  public void set(int i, int x) {
    node(i).setElem(x);
  }

  /** add(i,x) aggiunge un nodo che contiene x in posizione i */
  public void add(int i, int x) {
    assert 0 <= i && i <= size;
    if (i == 0) {
      first = new Node(x, first);
    }
    // aggiungo un nodo all'inizio
    else {
      // calcolo il nodo precedente al nodo da aggiungere
      Node prev = node(i - 1);
      // aggiungo un nodo tra prev e prev.getNext()
      prev.setNext(new Node(x, prev.getNext()));
    }
    // l'invariante di classe e` temporaneamente non valido: size
    // vale uno meno il numero di elementi della lista. Quindi
    // aggiungiamo 1:
    size++;
  }

  /** remove(i) elimina il nodo n. i e ne restituisce il contenuto x */
  public int remove(int i) {
    assert 0 <= i && i < size;
    int x;
    if (i == 0) {
      // elimino first: “Nuovo” first = “Vecchio” first.getNext()
      x = first.getElem();
      first = first.getNext();
    }

    else {
      // i>0
      // Nodo prev = precedente il nodo da eliminare = node(i-1):
      Node prev = node(i - 1);
      // Nodo el = il nodo da eliminare =
      // = nodo i-esimo =
      // = nodo che viene dopo prev (= nodo (i-1)-esimo):
      Node el = prev.getNext();
      x = el.getElem();
      // Per eliminare el, collego prev al nodo che viene dopo el
      prev.setNext(el.getNext());
    }
    size--;
    return x;
  }

  /*
   * Definiamo un metodo che inserisce una MiniLinkedList in un oggetto che fa
   * parte della classe MiniIterator. MiniIterator consente di eseguire un ciclo
   * senza rendere pubblici gli indirizzi dei nodi.
   */
  public MiniIterator iterator() {
    return new MiniIterator(first);
  }
  // Per visitare la lista l scriverò MiniIterator it = l.iterator()
  // e farò muovere it, si veda sotto nella classe TestMiniIterator.
}