// Matita.java
public class Matita {
	// Attributi statici (comuni a tutte le istanze di Matita) e final (non modificabili)
	[...]
		
	// Attributi non statici (proprii di ogni istanza) stelo e punta
	//Notare l'uso di attributi privati
	[...]
	
	/** Metodo costruttore */
	public Matita([...]) {
		[...]
	}

	/** disegna restituisce true quando la matita ha ancora punta, e ne riduce la punta di 1 mm. Restituisce false se la punta e' finita. */
	public boolean disegna() {
		[...]
	}

	/** "tempera" riduce di un 1mm la matita, e allunga di 1mm la punta
	a meno che la lunghezza della punta sia gia' il massimo. */
	public boolean tempera() {
		[...]
	}

	/** Metodi getters per stelo e punta */
	public int getStelo() {[...]}
	public int getPunta() {[...]}
}
