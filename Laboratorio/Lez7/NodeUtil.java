public class NodeUtil<T>{
	public static <T> int size(Node<T> p){
		int count = 0;
		for(Node<T> f = p; f!=null; f=f.getNext()){
			count++;
		}
		return count;
	}
	public static <T> int occurrences(Node<T> p, T x){
		int count = 0;
		for(Node<T> f = p; f !=null; f = f.getNext()){
			if(f.getElem().equals(x)){
				count++;
			}
		}
		return count;
	}
	public static <T> boolean included(Node<T> p, Node<T> q) {
		Node<T> p1 = p;
		Node<T> q1 = q;
		while(p1!=null && q1 !=null){
			if(!p1.getElem().equals(q1.getElem())){
				q1 =q1.getNext();
			}else{
				p1 = p1.getNext();
				q1 = q1.getNext();
			}
		}
		return p1 == null;
	}
	public static <T> Node<T> reverse(Node<T> p){
		Node<T> reverseList = new Node<T>(p.getElem(),null);
		while(p.getNext()!=null){
			p = p.getNext();
			reverseList = new Node<T>(p.getElem(),reverseList);
		}
		return reverseList;
	}
	public static <T> void printList(Node<T> p){
		System.out.print("[");
		for(Node<T> i = p; i!=null ; i = i .getNext()){
			System.out.print(" "+i.getElem()+" ");
		}
		System.out.print("]");
	}
	public static <T> Node<Integer> cardinality(Node<Node<T>> listOfList){
		Node<Integer> nElementi = null;
		for(Node<Node<T>> aux = listOfList; aux!=null; aux= aux.getNext()){
			nElementi = new Node<Integer>(size(aux.getElem()),nElementi);
		}
		return  nElementi;
	}
}