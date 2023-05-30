//PersonaDemo.java
public class PersonaDemo {
    public static void main(String[] args){
     //Definisco delle persone appartenenti a sottoclassi
     Studente a = new Studente( "Rossi",111);   //111=matricola
     Docente  b = new Docente( "Ferrero",1000); //1000= stipendio
     Persona  c = new Persona( "Bianchi");
     //Definisco un array v con le persone appena introdotte
     int n=3;
     Persona[] v = new Persona[n];
     v[0]=a;
     v[1]=b;
     v[2]=c;
     //tipo apparente v[0],v[1],v[2]: Persona, Persona, Persona
     //tipo esatto: Studente, Docente, Persona
     //Stampo v usando il metodo toString() (CON override): Java
     //utilizza il tipo "esatto" (il tipo originario) di ogni oggetto
     //il metodo toString() per il tipo esatto
     System.out.println( "\nEsempio di toString()");
     for(int i=0;i<n;i++){
       System.out.println(i + " " + v[i].toString());
    }
    //Stampo c usando il metodo nomeToString() (SENZA override):
    //Java utilizza il tipo esatto di ogni oggetto e il metodo
    //nomeToString() per il tipo esatto. IN QUESTO CASO IL METODO E'
    //EREDITATO E RESTA SEMPRE LO STESSO (no override)
     System.out.println( "\nEsempio di nomeToString()");
     for(int i=0;i<n;i++){
       System.out.println(i + " " + v[i].nomeToString());
   
   } }
   }