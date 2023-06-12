public class TestNodeUtil{
	public static void main(String [] args){
		//Laboratorio 7
		System.out.println("Esercizio 1");
		Node<Integer> listaInteger1 = new Node<Integer>(3,new Node<Integer>(1,
				new Node<Integer>(2,new Node<Integer>(1,new Node<Integer>(0,null)))));
		Node<Double> listaDouble1 = new Node<Double>(3.0,new Node<Double>(1.0,
				new Node<Double>(2.0,new Node<Double>(1.0,new Node<Double>(0.0,null)))));
		Node<String> listaString1 = new Node<String>("1",new Node<String>("1",
				new Node<String>("2",new Node<String>("1",new Node<String>("0",null)))));
		Node<Person> listaPerson1 = new Node<Person>(new Person("luis","barrios"),new Node<Person>(new Person("david","barrios"),
				new Node<Person>(new Person("Maria Luisa","Barrios"),new Node<Person>(new Person("Maria Antonieta","Luna Victoria"),
						new Node<Person>(new Person("Luis Augusto","Barrios Araujo"),null)))));
		System.out.println("Integer : "+NodeUtil.size (listaInteger1));
		System.out.println("Double  : "+NodeUtil.size (listaDouble1));
		System.out.println("String  : "+NodeUtil.size (listaString1));
		System.out.println("Person  : "+NodeUtil.size (listaPerson1)+"\n");

		System.out.println("Esercizio 2");
		System.out.println("Integer : "+NodeUtil.occurrences(listaInteger1,1)+"\n");
		System.out.println("Double : "+NodeUtil.occurrences(listaDouble1,1.0)+"\n");
		System.out.println("String : "+NodeUtil.occurrences(listaString1,"1")+"\n");
		System.out.println("Person : "+NodeUtil.occurrences(listaPerson1,new Person("luis","barrios"))+"\n");
		System.out.println("Esercizio 3");
		Node<Integer> listaInteger2 = new Node<Integer>(1,new Node<Integer>(2,
				new Node<Integer>(3,null)));
		Node<Integer> listaInteger3 = new Node<Integer>(0,new Node<Integer>(1,
				new Node<Integer>(2,new Node<Integer>(2,new Node<Integer>(0,
						new Node<Integer>(3,new Node<Integer>(4,null)))))));

		System.out.println("Integer: "+NodeUtil.included(listaInteger2,listaInteger3)+"\n");
		System.out.println("Esercizio 4");
		System.out.print("Integer :");
		NodeUtil.printList(NodeUtil.reverse(listaInteger1));
		System.out.println();
		System.out.print("Double :");
		NodeUtil.printList(NodeUtil.reverse(listaDouble1));
		System.out.println();
		System.out.print("String :");
		NodeUtil.printList(NodeUtil.reverse(listaString1));
		System.out.println();
		System.out.print("Person :");
		NodeUtil.printList(NodeUtil.reverse(listaPerson1));
		System.out.println();
		System.out.println("Esercizio 5 : ");
		System.out.print("Integer: ");
		NodeUtil.printList(listaInteger1);
		System.out.println();
		System.out.print("Double: ");
		NodeUtil.printList(listaDouble1);
		System.out.println();
		System.out.print("String: ");
		NodeUtil.printList(listaString1);
		System.out.println();
		System.out.print("Person: ");
		NodeUtil.printList(listaPerson1);
		System.out.println();
		System.out.println("Esercizio 6");
		Node<Integer> list1 = null;
		Node<Integer> list2 = new Node<Integer>(4,new Node<Integer>(1,new Node<Integer>(2,new Node<Integer>(1,null))));
		Node<Integer> list3 = new Node<Integer>(3,new Node<Integer>(4,new Node<Integer>
				(1,new Node<Integer>(3,new Node<Integer>(2,
						new Node<Integer>(3,new Node<Integer>(1,
								new Node<Integer>(3,null))))))));
		Node<Node<Integer>> listOfList = new Node<Node<Integer>>(list3,new Node<Node<Integer>>(list2,
				new Node<Node<Integer>>(list1,null)));
		NodeUtil.printList(NodeUtil.cardinality(listOfList));

	}
}