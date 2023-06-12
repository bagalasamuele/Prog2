public class Underground {
    private int prossimaStazione = 0;
    private int line = 1;
    private String id="";

    public int getProssimaStazione() {
        return prossimaStazione; // RISPOSTA è un metodo di lettura
    }

    public void setProssimaStazione(int prossimaStazione) {
        this.prossimaStazione = prossimaStazione;//RISPOSTA Metodo di tipo scrittura
    }

    public int getLine() {
		return line;// RISPOSTA è un metodo di lettura
    }

    public void setLine(int line) {
        this.line = line;//RISPOSTA Metodo di tipo scrittura
    }

    public String getId() {
        return id; // RISPOSTA Metodo di tipo lettura
    }

    public void setId(String id) {
        this.id = id;//RISPOSTA Metodo di tipo scrittura
    }

    public int atStation(){
        if(this.prossimaStazione ==9){// se la stazione è alla numero 9 allora
			this.prossimaStazione = 0;//torna alla stazione iniziale
		}
		else{
			// altrimenti vai alla stazione successiva
			this.prossimaStazione++;
		}
		return this.prossimaStazione;//ritorna la stazione successiva
    }

    public static void main(String[] args) {
        Underground t1 = new Underground();// instanza o oggetto del primo treno
        Underground t2 = new Underground();//instanza o oggetto del secondo treno
        t1.setId("aaa");//chiamata del metodo di  tipo scrittura (setId) per mettere il valore del id del treno
        t1.setLine(1);//chiamata del metodo di  tipo scrittura (setLine) per mettere il valore della line del treno
        t1.setProssimaStazione(8);//chiamata del metodo di  tipo scrittura (setProssimaStazione) per mettere il valore della prossimaStazione del treno
        t2.setId("bbb");// stessa cosa con il secondo treno
        t2.setLine(1);
        t2.setProssimaStazione(5);

        for (int ix=0; ix<2; ix++){
			//ciclo for per andare alla stazione successiva
            int t1PrxSt=t1.atStation();//chiamata al metodo atStation per andare alla stazione successiva
            System.out.println("t1: "+t1PrxSt);//stampa la stazione successiva del treno 1
            int t2PrxSt=t2.atStation();
            System.out.println("t2: "+t2PrxSt);//stampa la stazione successiva del treno 2
        }
    }
}