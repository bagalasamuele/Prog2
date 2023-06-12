public class Set<T>{
	private Node<T> first;
    private int size;
    public Set(){
        this.first = null;
        this.size = 0;
    }
    public int size(){
        return this.size;
    }
    public boolean empty(){
        return this.first == null;
    }
    public void add(T elem){
        this.first = new Node<T>(elem,first);
    }
    public boolean remove(T elem){
        if(first == null){
            return false;
        }
        for(Node<T> aux = first; aux != null; aux= aux.getNext()){
           boolean exp =aux.getNext().getElem().equals(elem);
           if(exp){
               aux.setNext(aux.getNext().getNext());
               return  true;
           }
        }
        return  false;
    }
    public boolean contains(T elem){
        for(Node<T> aux = first; aux!=null; aux= aux.getNext()){
            if(aux.getElem().equals(elem))
                return true;
        }
        return false;
    }
    public boolean subsetOf(Set<T> s){
        if(this.size()>s.size()){
            return false;
        }
        for(Node<T>p = this.first; p!=null; p=p.getNext()){
            if(!s.contains(p.getElem())){
                return false;
            }
        }
        return true;
    }
    public boolean equalsTo(Set<T> s){
        return this.size() == s.size() && this.subsetOf(s);
    }
    public  Set<T> union(Set<T> s){
        Set<T> newList = new Set<T>();
        for(Node<T> aux = this.first; aux!=null; aux = aux.getNext()){
            newList.add(aux.getElem());
        }
        for( Node<T> aux = s.first; aux!=null; aux = aux.getNext()){
            newList.add(aux.getElem());
        }
        return  newList;
    }
    public  Set<T> intersection(Set<T> s){
        Set<T> intersectionList = new Set<T>();
        for(Node<T> aux1 = this.first; aux1!=null; aux1 = aux1.getNext()){
            for(Node<T> aux2 = s.first; aux2!=null; aux2 = aux2.getNext()){
                if(aux1.getElem() == aux2.getElem()){
                    intersectionList.add(aux1.getElem());
                }
            }
        }
        return intersectionList;
    }
    public void print(){
        System.out.print("[");
        for(Node<T> aux = first; aux!=null; aux = aux.getNext()){
            if(aux!=null)
                System.out.print(aux.getElem()+((aux.getNext()!=null)?",":""));
        }
        System.out.print("]");
        System.out.println();
    }
}