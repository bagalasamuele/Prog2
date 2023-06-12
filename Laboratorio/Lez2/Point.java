import java.lang.Math;
public class Point{
	public static void main(String [] args){
		//Mutabile
		System.out.println("Mutabile:");
		Mutabile p1 = new Mutabile(2,4);
		Mutabile p2 = new Mutabile(2,4);
		System.out.println("punto 1 == "+p1.getx()+" , "+p1.gety());
		//traslare
		p1.traslare(1,3);
		System.out.println("punto traslato == "+p1.getx()+" , "+p1.gety());
		//distanza
		System.out.println("La distanza è :"+p1.distanza(p2));
		//ruotare
		p1.ruotare(Math.PI/2.0);
        System.out.println("La rotazione è :  " + p1.getx() + ", " + p1.gety()+"\n");
		
		System.out.println("Immutabile:");
		//Immutabile
		Immutabile pt1 = new Immutabile(2,4);
		Immutabile pt2 = new Immutabile(6,11);
		System.out.println("punti x " +pt1.getx()+" , y "+pt1.gety());
		Immutabile traslazione = pt1.traslare(1,3);
		System.out.println("La traslazione e' : "+traslazione);
		Immutabile rotazione = pt1.ruotare(Math.PI/2.0);
		System.out.println("La distanza e' : "+pt1.distanza(pt2));
		System.out.println("La rotazione e' : "+rotazione);
	}
}
class Mutabile{
	private double x;
	private double y;
	public Mutabile(double x, double y){
		//metodo costruttore per dichiarare i valori
		this.x = x;
		this.y = y;
	}
	public double getx(){
		return x;//chiamata di lettura per il punto in x
	}
	public double gety(){
		return y;//chiamata di lettura per il punto in y
	}
	public void traslare(double dx , double dy){
		//per traslare una retta basta che sommi il punto in cui devi traslarlo con il punto attuale
		x+=dx;
		y+=dy;
	}
	public void ruotare(double angolo){
		//formula per ruotare un punto in un determinato angolo
		double rx = x*Math.cos(angolo)-y*Math.sin(angolo);
		double ry = Math.round(x*Math.sin(angolo)+y*Math.cos(angolo));
		x=rx;
		y=ry;
	}
	public double distanza(Mutabile p){
		//formula per la distanza di un p di tipo mutabile
		return  Math.sqrt(Math.pow(x - p.x, 2) + Math.pow(y - p.y, 2));
	}
}
class Immutabile{
	private double x;
	private double y;
	public Immutabile(double x, double y){
		this.x = x;
		this.y = y;
	}
	public double getx(){
		return x;
	}
	public double gety(){
		return y;
	}
	public Immutabile traslare(double dx , double dy){
		//ritorno la dichiarazione di un punto gia compilato e di tipo immutabile e applico la formula per traslare
		return new Immutabile(x+dx, y+dy);
	}
	public Immutabile ruotare(double angolo){
		//ritorno la dichiarazione di un punto gia compilato e di tipo immutabile e applico la formula per ruotare
		return new Immutabile(
			x*Math.cos(angolo)-y*Math.sin(angolo),
			Math.round(x*Math.sin(angolo)+y*Math.cos(angolo))
		);
	}
	public double distanza(Immutabile p){
		return Math.sqrt(Math.pow(x - p.x, 2) + Math.pow(y - p.y, 2));
	}
	public String toString(){
		return x+ " , "+ y;
	}
}