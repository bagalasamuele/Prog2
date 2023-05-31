# Lezione 02 

## Attributi e metodi privati, get e set

### Lezione 02. Parte 1.

Un primo esempio di attributi e metodi privati: 
la classe Specie (50 minuti). Spesso è conveniente o necessario fornire 
dei metodi che consentano di accedere ai attributi di una classe. Tali 
metodi prendono il nome di metodi get (per i metodi che leggono 
l’attributo di un oggetto) e metodi set (per i metodi che scrivono 
l’attributo di un oggetto). In questo caso gli attributi vengono resi 
privati: un attributo privato può essere modificato solo dall’interno 
della classe. Il vantaggio di usare metodi get/set pubblici rispetto 
a rendere pubblici gli attributi della classe è controllare in modo 
più fine le possibilità di accesso (es., omettendo il metodo set si 
impone il fatto che un attributo sia disponibile solo in lettura) e di 
impedire modifiche che producono dati contradditori. Per evitare 
l’inserimento di dati contradditori, di solito gli attributi di una 
classe sono privati. Per esempio, nel metodo setSpecie(), si imporrà 
 che il valore della popolazione (campo 'popolazione') sia positivo. 
Un attributo viene reso privato mettendo al posto del modificatore di 
visibilità public il modificatore private. Come primo esempio definiamo 
una classe Specie con metodi get e set (la trovate sul Savich al Cap. 
8). Usando la visualizzazione della memoria, vedremo anche cosa succede 
assegnando un oggetto di Specie a un altro, e la differenza tra due 
oggetti identici (che occupano la stessa memoria) e due oggetti uguali 
 attributo per attributo.  


 /** Effetto dell'assegnazione  

```java
bufaloTerrestre  = bufaloKlingon; 
```

1. L'indirizzo di bufaloTerrestre diventa uguale a quello di  
bufaloKlingon. In altre parole, bufaloTerrestre adesso e' un alias  
di bufaloKlingon. Avete visto lo stesso fenomeno quando si assegna  
 un array a un altro (ProgI sezione 6.4)   
2. Abbiamo l'impressione che i dati del bufaloTerrestre siano  
scomparsi. In realta' sono diventati irraggiungibili: non ho piu' il  
loro indirizzo. Java dopo un poco ricicla le aree di memoria  
irraggiungibili, che a questo punto spariscono davvero (tramite un 
processo che gira in parallelo con il nostro programma, detto Garbage 
Collector). */ 
 
Qui sotto la situazione della memoria a fine programma SpecieDemo. 
Potete ottenerla con un visualizzatore, per es.:  
https://cscircles.cemc.uwaterloo.ca/java_visualize/ 
(Ricordatevi di crocettare le opzioni e di schiacciare il tasto stdin 
e inserire gli input). Questo visualizzatore vi richiede il programma 
in un unico file, dunque dovete definire Specie come classe non pubblica. 
 
Diagramma stack + heap alla fine dell’esecuzione SpecieDemo. Le variabili 
“bufaloTerrestre” e “bufaloKlingon” nel main puntavano ciascuna a una sua area di 
memoria. Dopo aver assegnato “bufaloTerrestre” a “bufaloKlingon” le due variabili  
puntano alla stessa area. L’area con le informazioni sul bufalo terrestre non è 
raggiunta da nessun puntatore e verrà riciclata 
 
 Vi invitiamo a fare il seguente esercizio, che spiega perché è bene 
che gli attributi di una classe siano privati. Definite una classe 
Rettangolo con attributi: base, altezza e area. Un rettangolo è 
correttamente definito se l’area è uguale a base per altezza. Accedendo 
dall’esterno posso ignorare che esiste un attributo area e dimenticarmi 
di modificarlo di conseguenza, creando un rettangolo con dati errati. 
Provate a definire la classe Rettangolo rendendo tutti gli attributi 
privati, e scegliete i metodi get e set in modo da impedire una modifica 
errata dell’area. Trovate la soluzione nel Capitolo 8 del Savich, e in 
queste dispense nella Lezione 03. 
 
 
 
 
### Lezione 02. Parte 2. 


Un esempio non banale di attributi e metodi 
privati: la classe Calcolatrice. (50 minuti). Vediamo ora un esempio 
non banale di attributi privati: la classe Calcolatrice. Gli elementi 
della classe sono oggetti calcolatrici tutte uguali, semplici robot 
virtuali che prendono ricevono una lista di comandi da una tastiera e 
 eseguono dei calcoli.  
Una calcolatrice semplificata. Consideriamo solo operazioni tra interi 
(quindi niente tasto “virgola”) e argomenti di positivi e di una cifra 
(quindi non dobbiamo preoccuparci di raccogliere le cifre per formare 
numeri più grandi). Abbiamo quindi le cifre ‘0’ … ‘9’. Come uniche 
operazioni consideriamo + e *. Ogni operazione binaria prende due 
numeri a e b, inseriti direttamente in memoria oppure risultati degli 
ultimi due calcoli, li cancella e li rimpiazza con un risultato: a+b 
 oppure a*b. 
 La calcolatrice come oggetto. Un oggetto calcolatrice deve avere un 
array stack di interi per memorizzare i risultati dei calcoli 
precedenti ancora da utilizzare, e un indice size per indicare quanti 
risultati ci sono in tale stack. Il motivo per cui l’array debba essere 
uno stack, ovvero una struttura LIFO (Last-In-First-Out), si capirà 
meglio nel seguito. Abbiamo bisogno di un metodo dinamico int pop() 
che restituisca l’ultimo risultato inserito nella calcolatrice, 
cancellandolo da stack, aggiornando size, e un metodo dinamico void 
push(int x) che aggiunga un valore x all’array stack, sempre 
aggiornando size. Infine ci vuole un metodo dinamico int esegui(String 
istruzioni) che prenda una stringa che rappresenta una lista di tasti 
premuti e restituisca l’ultimo risultato risultato ottenuto dalla 
 calcolatrice. 
 Un esempio. Supponiamo di aver appena inserito con due “push”: 
push(2), push(3) i numeri 2 e 3 nello stack, portando il “size” dello 
stack a 2. Gli elementi del vettore dalla posizione 2 in poi sono 
irrilevanti, come indicato nel disegno qui sotto: 
 
 
 
 
 Supponiamo di voler eseguire una moltiplicazione tra gli ultimi due 
valori inseriti: allora eseguiamo due comandi “pop”: riprendiamo dalla 
memoria 2 e 3, portando il “size” dello stack a 0. In realtà, il 2 e 
il 3 si trovano ancora sullo stack, ma dato che size vale 0 vengono 
 considerati irrilevanti. 
 
 
 Ora la calcolatrice moltiplica 2 e 3 e ottiene 6. In questo caso è 
stato inutile inserire e poi prelevare 2 e 3 dallo stack, in generale, 
quando i passi di calcolo da fare sono tanti, è necessario. 
  
Metodi e attributi privati. Dobbiamo ora tradurre l’idea appena vista 
in metodi della classe Calcolatrice, scegliendo quali fare pubblici e 
quali privati. L’unico metodo che un utilizzatore della calcolatrice 
ha bisogno di conoscere è “esegui”: tutti gli altri attributi e metodi 
sono difficili da usare (vedi qui sotto) e quindi è prudente vietarne 
l’uso da parte di programmatori che non ne conoscono il funzionamento 
in dettaglio. Renderemo esegui pubblico e tutti gli altri metodi e 
 attributi privati.  
 Una descrizione alternativa della calcolatrice sarebbe rimpiazzare 
gli attributi privati stack e size della classe Calcolatrice con 
variabili stack e size poste nel main. Se provate a scrivere una 
soluzione del genere, tuttavia, vi renderete conto che è più 
macchinosa. È molto più semplice nascondere stack e size nella classe 
Calcolatrice che renderli visibili solo al programmatore che deve 
 implementare una calcolatrice. 
 Supporremo che le istruzioni di una calcolatrice siano scritte in RPN 
(Reverse Polish Notation, notazione inversa polacca), in cui le 
operazioni +, * seguono i loro argomenti anziché comparire tra il primo 
e il secondo argomento. Per esempio scriviamo “(2+3)*9” come “23+9*”: 
il caratteri “23+” indicano (2+3) e aggiungendo “9+” otteniamo (2+3)*9. 
La notazione RPN semplifica, come vedremo, il lavoro alla calcolatrice, 
ma è difficile da leggere per un essere umano. Una calcolatrice più 
 
 
realistica avrebbe anche un metodo per tradurre le istruzioni “(2+3)*9” 
nella forma equivalente RPN: “23+9*”. Per brevità noi non aggiungeremo 
 questo metodo, che pure sarebbe importante avere.  
Fate qualche prova di esecuzioni di istruzioni con il Java Visualizer. 
Il programma che trovate in Calcolatrice e CalcolatriceDemo è troppo 
lungo per essere simulato nel Visualizer, ma potrete fare eseguire 
 singoli esempi. 



Lo stato della memoria verso la fine del calcolo di 2*3 nella calcolatrice C. 
Abbiamo già calcolato 6=2*3, lo stack della calcolatrice contiene zero valori. Ora 
stiamo inserendo il risultato 6 nello stack con il comando this.push(6). this 
indica l’indirizzo dell’oggetto “calcolatrice C” 

```java
//Un esperimento di uso della classe calcolatrice 
//Classe eseguibile pubblica, deve stare in CalcolatriceDemo.java 
public class CalcolatriceDemo { 
   public static void main(String[] args){ 
    Calcolatrice C = new Calcolatrice(); 
   
    System.out.println( "Eseguo istruzioni 23+ (due piu' tre) " ); 
    System.out.println( C.esegui( "23+" ) + "\n" ); 
   
    System.out.println( "Eseguo istruzioni 23* (due  per tre) " ); 
    System.out.println(C.esegui( "23*" ) + "\n"); 
   
    System.out.println("Eseguo istruzioni 23*9+ (due  per tre piu' nove) " );  
    System.out.println(C.esegui( "23*9+" ) + "\n"); 
   
    System.out.println("Eseguo istruzioni 99*9* (nove per nove per nove) " );  
 
 
    System.out.println(C.esegui( "99*9*" ) + "\n");  
   
    System.out.println("Eseguo istruzioni 99*9*1+ (nove per nove per 
 nove piu' uno) ");System.out.println(C.esegui( "99*9*1+" ) + "\n"); 
   } 
} 
```
 
Vediamo ora due esempi di errori di input per la calcolatrice: 
- 1234455+: il risultato è 10 e non si ha errore a runtime, ma lo 
stack non risulta vuoto, ma contiene 12344; 
- 1+++*: si ha una ArrayOutOfBound exception, prodotto dalla ricerca 
del secondo argomento per la prima somma, argomento che viene 
cercato in posizione -1. 