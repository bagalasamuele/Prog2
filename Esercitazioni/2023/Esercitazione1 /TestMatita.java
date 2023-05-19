public class TestMatita {
	public static void main(String[] args){
		
		Matita m = new Matita(5); 
		
		int s = m.getStelo(), p = m.getPunta();
		System.out.println("Matita di stelo " + s + " e punta " + p); 
		System.out.println("Disegno per " + 2*p + " volte:"); 
		System.out.println("dopo " + p + " volte il disegno fallisce");

		for (int i = 0; i < 2*p; i++)
			System.out.println(" Successo disegno n."+i+" = "+m.disegna());

		System.out.println("Tempero di 1mm la matita"); m.tempera();
		System.out.println(" nuova lunghezza punta = " + m.getPunta());
		System.out.println(" nuova lunghezza stelo = " + m.getStelo());
		System.out.println("Stampo la matita m. Ottengo \"Matita@\" seguito dall'indirizzo dell'oggetto (in esadecimale): " + m);
	}
}

// Compilazione : javac Matita.java TestMatita.java
// Esecuzione: java -ea TestMatita