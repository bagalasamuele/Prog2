public class NodeUtil {
    public static int dimensione(Node l){
        int count = 0;
        for(Node aux = l; aux != null; aux=aux.getNext()){
            count++;
        }
        return count;
    }
    public static int[] toArray(Node top){
        int [] arrayList = new int[dimensione(top)];
        int i = 0;
        for(Node aux = top; aux!=null; aux= aux.getNext()){
            arrayList[i]= aux.getElem();
            i++;
        }
        return arrayList;
    }
    public static Node fromTo(int m, int n) {
        Node aux = null;
        while (m <= n) {
            aux = new Node(m,aux);
            m++;
        }
        return aux;
    }
    public static int occurrences(Node p, int x){
        int count = 0;
        for(Node aux = p; aux!=null; aux = aux.getNext()){
            if(aux.getElem() == x){
                count++;
            }
        }
        return count;
    }
    public static boolean included(Node p, Node q){
        boolean sequenza = false;
        Node aux1 = p;
        Node aux2 = q;
        while(aux1!=null && aux2!=null){
            if(aux1.getElem() == aux2.getElem()){
                sequenza = true;
                aux1 = aux1.getNext();
                aux2 = aux2.getNext();
            }
            else{
                sequenza = false;
                aux2 = aux2.getNext();
            }
        }
        return sequenza;
    }
    public static Node reverse(Node p){
        if(p==null)
            return p;
        Node reverseList = new Node(p.getElem(),null);
        while (p.getNext()!=null) {
            p = p.getNext();
            reverseList = new Node(p.getElem(), reverseList);
        }
        return reverseList;
    }
    public static String toStringa(Node p){
        String concatena="[";
        for(Node aux = p; aux!=null; aux = aux.getNext()){
            concatena += aux.getElem()+((aux.getNext()!=null)?",":"");
        }
        concatena+="]";
        return concatena;
    }
    public static Node zipSum(Node p, Node q){
        Node sumList = null;
        Node aux1 = p;
        Node aux2 = q;
        while(aux1!=null && aux2!=null){
            sumList= new Node(aux1.getElem()+ aux2.getElem(),sumList);
            aux1=aux1.getNext();
            aux2=aux2.getNext();
        }
        return reverse(sumList);
    }
}
