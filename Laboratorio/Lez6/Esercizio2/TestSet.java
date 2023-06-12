public class TestSet{
	public static void main(String [] args){
		Set<Integer> gestione = new Set<Integer>();
		gestione.add(9);
		gestione.add(5);
		gestione.add(1);
		Set<Integer> gestione2 = new Set<Integer>();
		gestione2.add(1);
		boolean rimuovi =gestione.remove(5);
		boolean cerca = gestione.contains(9);
		boolean sottoInsieme = gestione2.subsetOf(gestione);
		Set<Integer> unionList = gestione.union(gestione2);
		Set<Integer> intesectionList = gestione.intersection(gestione2);
		gestione.print();
		System.out.println("Remove :"+rimuovi);
		System.out.println("Contains :"+cerca);
		System.out.println("subsetOf :"+sottoInsieme);
		System.out.print("union :");unionList.print();
		System.out.println();
		System.out.println("Intersection :");
		intesectionList.print();
	}
}