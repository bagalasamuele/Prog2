import java.util.Arrays;
public class TestPila {
    public static void main(String[] args){
        System.out.println("Laboratorio 5");
        System.out.println();
        System.out.println("Esercizio 1");
        Node lista1 = new Node(-1,new Node(0,new Node(1,new Node(2,null))));
        int [] convertArray = NodeUtil.toArray(lista1);
        System.out.println(Arrays.toString(convertArray)+"\n");//output

        System.out.println("Esercizio 2");
        Node l2 = NodeUtil.fromTo(-1,2);
        System.out.println(NodeUtil.toStringa(l2));
        Node l3 = NodeUtil.fromTo(2,-1);//ritorno []
        System.out.println(NodeUtil.toStringa(l3));
        System.out.println();
        System.out.println("Esercizio 3");
        Node list4 = new Node(3,new Node(1,new Node(2,new Node(1,new Node(0,null)))));
        int occorenze = NodeUtil.occurrences(list4,1);
        System.out.println(occorenze);
        System.out.println();

        System.out.println("Esercizio 4");
        Node p = new Node(1,new Node(2,new Node(3,null)));
        Node q = new Node(0,new Node(1,new Node(2,new Node(2,new Node(0,new Node(3,new Node(4,null)))))));
        boolean incluso = NodeUtil.included(p,q);
        System.out.println(incluso+"\n");

        System.out.println("Esercizio 5");
        Node listaNormale = new Node(1,new Node(2,new Node(3,null)));
        Node listaInvertita = NodeUtil.reverse(listaNormale);
        System.out.println(NodeUtil.toStringa(listaInvertita)+"\n");

        System.out.println("Esercizio 6");
        Node List1 = new Node(1,new Node(2,new Node(3,null)));
        Node List2 = new Node(4,new Node(5,new Node(6,null)));
        Node sumList = NodeUtil.zipSum(List1,List2);
        System.out.println(NodeUtil.toStringa(sumList));
    }
}
