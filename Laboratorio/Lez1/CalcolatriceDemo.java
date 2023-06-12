class Calcolatrice { //classe non eseguibile e non pubblica
    // la memoria di una calcolatrice e' una pila che contiene fino a 100 interi.
    // L'ultimo intero e' il risultato delle operazioni fatte finora
    // e la prossima operazione agisce sugli ultimi due interi a,b
    // e li rimpiazza con a+b (per una addizione) oppure a*b (per una moltiplicazione)

    // stack = pila che contiene fino a 100 interi */
    private int[] stack = new int[100];

    // size = numero di interi presenti nella pila: all'inizio 0
    // le posizioni occupate dell'array hanno indice: 0, 1, ..., size-1
    private int size = 0;

    // push(x): aggiunge un intero x allo stack dopo la parte utilizzata
    // e aumenta di 1 la parte di stack utilizzata (variabile size)
    private void push(int x) {
        stack[size] = x;
        size++;
    }

    // pop(): restituisce l'ultima intero dello stack
    // e lo "cancella" riducendo di 1 la parte di stack utilizzata (variabize size)
    private int pop() {
        size--;
		return stack[size];
    }
	public void stampa(){
		System.out.println(size);//stampo la dimensione
		for(int i = 0; i<size; i++)
			System.out.print(stack[size]+" ");//stampo il contenuto della pila
		System.out.println("");
	}
	
    // questo e' un metodo pubblico
public int esegui(String istruzioni) {
        int numeroIstruzioni = istruzioni.length(); //lunghezza
        int pc = 0; // inizio leggendo la prima istruzione, in posizione 0

        while (pc < numeroIstruzioni) { //eseguo le istruzioni in ordine
            char c = istruzioni.charAt(pc); //c = carattere di posto pc
            if (c >= '0' && c <= '9') { //vero se c e' una cifra
                push(c - '0');  //questa formula mi da' il valore della cifra c
            } 
            else if (c == '+') {
                int ultimo = pop(); //risultato ultimo calcolo
                int penultimo = pop(); //risultato penultimo calcolo
                push(penultimo + ultimo);
            } 
            else if (c == '*') {
                int ultimo = pop(); //risultato ultimo calcolo
                int penultimo = pop(); //risultato penultimo calcolo
                push(penultimo * ultimo);
            }
			else if (c == '-') {
                int ultimo = pop(); //risultato ultimo calcolo
                int penultimo = pop(); //risultato penultimo calcolo
                push(penultimo - ultimo);
            }
			else if (c == '/') {
                int ultimo = pop(); //risultato ultimo calcolo
                int penultimo = pop(); //risultato penultimo calcolo
                push(penultimo / ultimo);
            }
			else if (c == '%') {
                int ultimo = pop(); //risultato ultimo calcolo
                int penultimo = pop(); //risultato penultimo calcolo
                push(penultimo % ultimo);
            }
			else if (c == '#'){
				stampa();// operazione di stampa della pila
			}
            pc++; // passiamo alla prossima istruzione
        }
        return pop(); //alla fine restituisco l'ultimo risultato ottenuto
    }
}

// Un esperimento di uso della classe calcolatrice
// Classe eseguibile pubblica, deve stare in CalcolatriceDemo.java
public class CalcolatriceDemo {
    public static void main(String[] args) {
        Calcolatrice C = new Calcolatrice();

        System.out.println("Eseguo istruzioni 23+ (due piu' tre)");
        System.out.println(C.esegui( "23+" ) + "\n");
        
        System.out.println( "Eseguo istruzioni 23* (due per tre) ");
        System.out.println(C.esegui( "23*" ) + "\n");

        System.out.println("Eseguo istruzioni 23*9+ (due per tre piu' nove) ");
        System.out.println(C.esegui( "23*9+" ) + "\n");

        System.out.println("Eseguo istruzioni 99*9* (nove per nove per nove) ");
        System.out.println(C.esegui( "99*9*" ) + "\n");

        System.out.println("Eseguo istruzioni 99*9*1+ (nove per nove per nove piu' uno) ");
        System.out.println(C.esegui( "99*9*1+" ) + "\n");
		
		//Esempi calcolatrice
		System.out.println("Esempi del pdf");
		System.out.println("Eseguo istruzioni 12+3*");
        System.out.println(C.esegui( "12+3*" ) + "\n");
		
		System.out.println("Eseguo istruzioni 52*52**252**+3+");
        System.out.println(C.esegui( "52*52**252**+3+" ) + "\n");
		
		System.out.println("Eseguo istruzioni 2222222222*********");
        System.out.println(C.esegui( "2222222222*********" ) + "\n");
		
		System.out.println("Esercizio 2");
		
		System.out.println("Eseguo istruzioni (15 + 16) × 17");
        System.out.println(C.esegui( "96+88++89+*" ) + "\n");

		System.out.println("Eseguo istruzioni 10!");
        System.out.println(C.esegui( "123456789********55+*" ) + "\n");
		
		System.out.println("Eseguo istruzioni numero negativo con + o *");
        System.out.println(C.esegui( "999999999999999999****************" ) + "\n");
		
		System.out.println("Esercizio 3");
		
		System.out.println("Eseguo istruzioni 12-");
        System.out.println(C.esegui( "12-" ) + "\n");
		
		System.out.println("Eseguo istruzioni 32/");
        System.out.println(C.esegui( "32/" ) + "\n");
		
		System.out.println("Eseguo istruzioni 53%");
        System.out.println(C.esegui( "53%" ) + "\n");
		
		System.out.println("Esercizio 4");
		System.out.println("Eseguo istruzioni 53+");
        System.out.println(C.esegui( "53+#" ) + "\n");
		
		System.out.println("Esercizio 5");
		String n = "5";
		String s = "2*1+";//operazione per fare 2n+1(n dispari)
		System.out.println("Eseguo 2n+1");
		System.out.println(C.esegui(n+s)+"\n");
		System.out.println("Modo esteso:");
		System.out.println(C.esegui("2"+n+"*1+")+"\n");
		
		System.out.println("Esercizio 6");
		String s1 = "1+2%";//operazione per trovare il numero pari o dispari
		System.out.println("Numeri pari o dispari");
		System.out.println("2 atteso : "+C.esegui("2"+s1));
		System.out.println("0 atteso : "+C.esegui("0"+s1));
		System.out.println("3 atteso : "+C.esegui("3"+s1));
		System.out.println("7 atteso : "+C.esegui("7"+s1)+"\n");
		
	}
}