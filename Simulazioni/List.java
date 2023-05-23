class List {
  private Node top = null;

  public List(Node top) {
    this.top = top;
  }

  public List rev(List m) {
    // List newList = m; 

    // Node ThisListNode = this.top;
    // Node NewListNode = m.top;
    // Node Aux;

    // while (ThisListNode != null) {
      // System.out.println(ThisListNode.getElem());
      // // Aux = NewList;
      // // concateneteListNode = ThisListNode;
      // // concateneteListNode.setNext(Aux);

      // // ThisListNode = ThisListNode.getNext();
      // // NewList = NewList.getNext();
      
      // Aux = newList.top;
      // newList.top = ThisListNode;
      // newList.top.setNext(Aux);


      // ThisListNode = ThisListNode.getNext();
      // NewListNode = NewListNode.getNext();


    }

    // System.out.println(m);
    // while (PuntatoreM != null) {
    // System.out.println(PuntatoreM.getElem());

    // Aux = PuntatoreM;
    // PuntatoreNuovLista = PuntatoreM;
    // PuntatoreNuovLista.setNext(Aux);

    // PuntatoreM = PuntatoreM.getNext();
    // PuntatoreNuovLista = PuntatoreNuovLista.getNext();

    // }

    // System.out.println(concateneteList);
    // while (Thispointer != null) {
    // Nuova = Thispointer;
    // Nuova.setNext(Thispointer);

    // System.out.println(newList);

    // Thispointer = Thispointer.getNext();

    // }
    System.out.println("---------");
    return newList;
  }

  // p={1,2,3}
  static Node p = new Node(1, new Node(2, new Node(3, null)));
  // q={10,20,30}
  static Node q = new Node(10, new Node(20, new Node(30, null)));

  public String toString() {
    Node p = this.top;
    String s = "";
    while (p != null) {
      s = s + p.getElem() + " ";
      p = p.getNext();
    }

    return s;
  }

  public static void check(String msg, String a, String b) {
    if (a.equals(b))
      System.out.println(msg + a +
          " OK");
    else
      System.out.println(msg + a +
          " INSTEAD OF " + b);
  }

  public static void main(String[] args) {
    check(
        "l.rev(m)=",
        new List(p).rev(new List(q)).toString(),
        "3 2 1 10 20 30 ");
  }

}

class Node {

  private int elem;
  private Node next;

  public Node(int elem, Node next) {
    this.elem = elem;
    this.next = next;
  }

  public int getElem() {
    return elem;
  }

  public Node getNext() {
    return next;
  }

  public void setElem(int elem) {
    this.elem = elem;
  }

  public void setNext(Node next) {
    this.next = next;
  }
}
