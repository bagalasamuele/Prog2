// // Matita.java

// (i)  minStelo,  maxStelo,  maxPunta  sono  attributi  interi  pubblici, 
// statici e final della classe Matita (non legati a un oggetto ma alla 
// classe). Invece stelo e punta sono attributi interi dinamici.  
//  (ii) Il costruttore di Matita consente di costruire una matita con 
// punta di lunghezza massima dato lo stelo. Un assert impedisce 
// lunghezze non accettabili dello stelo. 
//  (iii) La classe ha i metodi get per stelo e punta e nessun metodo 
// set: non consento di cambiare la lunghezza a una matita.  
//  (iv) Un metodo “disegna” restituisce “true” (successo) se la matita 
// ha almeno 1mm di punta, e “false” (fallimento) altrimenti. Nel primo 
// caso usa la matita fino a ridurne la punta di un 1mm.  

//  (v) Un metodo “tempera” restituisce “true” (successo) se la matita è 
// più lunga del minimo e “false” (fallimento) altrimenti. Nel primo caso 
// riduce  lo  stelo  di  1mm  e  allunga  la  punta  di  1mm,  a  meno  che  la 
// lunghezza della punta sia già il massimo. In questo caso la matita si 
// accorcia ma la punta resta invariata. 

//  Scrivete  Matita.maxStelo  per  richiamare  il  massimo  dello  stelo 
// (attributo statico). Scrivete Math.min per richiamare il metodo statico 
// min(x,y)  della  classe  Math,  che  calcola  il  minimo.  Includiamo  una 
// classe  TestMatita  per  sperimentare  la  classe  Matita:  eseguitela  e 
// controllate che i risultati siano sensati. 

public class Matita {
	// Attributi statici (comuni a tutte le istanze di Matita) e final (non
	// modificabili)
	public static final int minStelo = 10; // min. lunghezza matita (mm)
	public static final int maxStelo = 200; // max. lunghezza matita (mm)
	public static final int maxPunta = 5; // max. lunghezza punta (mm)

	int punta;
	int stelo;

	// Attributi non statici (proprii di ogni istanza) stelo e punta
	// Notare l'uso di attributi privati

	/** Metodo costruttore */
	public Matita(int lunghezza) {
		assert this.stelo > maxStelo;
		this.punta = maxPunta;
		this.stelo = lunghezza;
	}

	/**
	 * disegna restituisce true quando la matita ha ancora punta, e ne riduce la
	 * punta di 1 mm. Restituisce false se la punta e' finita.
	 */
	public boolean disegna() {
		if (this.punta > 1) {
			this.stelo--;
			this.punta++;
			return true;
		} else
			return false;

	}

	/**
	 * "tempera" riduce di un 1mm la matita, e allunga di 1mm la punta
	 * a meno che la lunghezza della punta sia gia' il massimo.
	 */
	public boolean tempera() {
		if (this.stelo > minStelo) {
			if (this.punta != maxPunta) {
				this.stelo = this.stelo - 1;
				this.punta = this.punta + 1;
			} else
				this.stelo = this.stelo - 1;
			return true;
		} else
			return false;
	}

	/** Metodi getters per stelo e punta */
	public int getStelo() {
		return this.stelo;
	}

	public int getPunta() {
		return this.punta;
	}
}
