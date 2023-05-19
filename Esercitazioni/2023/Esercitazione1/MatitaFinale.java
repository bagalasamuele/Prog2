// Matita.java
public class Matita {
	// Attributi statici (comuni a tutte le istanze di Matita) e final (non modificabili)
	public static final int minStelo = 10;  //min. lunghezza matita (mm)
	public static final int maxStelo = 200; //max. lunghezza matita (mm)
	public static final int maxPunta =   5; //max. lunghezza punta  (mm)
	
	//Una matita e' uno stelo seguito da una punta
	//Notare l'uso di attributi privati
	private int stelo; // 0 <= stelo <= maxStelo 
	private int punta; // 0 <= punta <= maxPunta 
	
	/** Metodo costruttore */
	public Matita(int stelo) {
		assert minStelo<=stelo && stelo<=maxStelo:
		"stelo matita non accettabile:" + stelo;
		this.stelo = stelo;
		this.punta = maxPunta;
	}

	/** disegna restituisce true quando la matita ha ancora punta, e ne riduce la punta di 1 mm. Restituisce false se la punta e' finita. */
	public boolean disegna() {
		if (this.punta > 0) {
			this.punta--;
			return true;
		}
		else
			return false;
	}

	/** "tempera" riduce di un 1mm la matita, e allunga di 1mm la punta
	a meno che la lunghezza della punta sia gia' il massimo. */
	public boolean tempera() {
		if (this.stelo > minStelo) {
			this.stelo--;
			this.punta = Math.min(this.punta + 1, maxPunta);
			return true;
		} 
		else
			return false;
	}

	/** Metodi getters per stelo e punta */
	public int getStelo() {return this.stelo;}
	public int getPunta() {return this.punta;}
}
