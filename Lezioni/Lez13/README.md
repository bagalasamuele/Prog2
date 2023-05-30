# Lezione 13

## Tipo esatto e binding dinamico

Lezione 13. Parte 1. Tipo esatto e tipo apparente. Downcast e upcast, binding dinamico. 

Supponiamo che `C` sia una classe che estende una classe `D`, ovvero che `class C extends D`. Allora ogni oggetto di tipo `C` viene considerato anche un oggetto di tipo `D`. Questo è possibile perché ogni oggetto di tipo `C` ha tutti gli attributi di un oggetto di tipo `D`, più possibilmente degli attributi specifici di `C`. Basta ignorare gli attributi specifici di `C` (senza per questo cancellarli) per considerare l'oggetto di tipo `C` come un oggetto di tipo `D`. Questa operazione è disponibile in Java e si chiama upcasting. Grazie all'upcasting, un oggetto in Java può avere diversi tipi, tutte estensioni dello stesso tipo. Chiamiamo "tipo esatto" di un oggetto il tipo con cui l'oggetto è stato costruito tramite una `new()`: allora l'oggetto può avere come tipo tutti e soli i tipi che includono (cioè che estendono) il suo tipo esatto.

L'operazione opposta (in una certa misura) di upcast si chiama downcast. Un downcast di `obj` alla classe `C` si indica con `((C) obj)`. Durante la compilazione, `((C) obj)` con `obj` di tipo apparente `D` viene considerato di tipo `C` se questo è almeno possibile, cioè se esiste una sottoclasse `E` inclusa in `C, D`. Altrimenti, il compilatore dà errore. Occorre però poi che anche durante l'esecuzione, `obj` abbia davvero un tipo esatto `E` incluso in `C, D`. Altrimenti, calcolare `((C) obj)` solleva una eccezione, detta `ClassCastException`, e termina il programma, dato che non è possibile considerare `obj` di tipo `C`. Un downcast `((C) obj)` andrebbe utilizzato solo quando si è assolutamente certi che, in tutte le esecuzioni possibili, `obj` ha tipo esatto `C` o incluso in `C`. Di solito, il downcast si usa per passare a una classe più piccola, dal tipo apparente `D` a un tipo `C` incluso in `D`. Tuttavia, vedremo esempi di downcast corretti con la classe `C` non inclusa in `D`, ma con una sottoclasse `E` in comune con `D`.

Si noti che l'upcast è invece sempre valido, perché è corretto sostituire un oggetto di un tipo più preciso al posto di un tipo meno preciso. Per esempio, se `class C extends D`, gli oggetti di tipo `C` possono essere usati in tutti i contesti in cui si usano gli oggetti di tipo `D` (ma non vale il viceversa), perché un oggetto di tipo `C` può fare tutto quello che può fare (ovvero rispondere ai metodi di) un oggetto di tipo `D`.

In ogni comando Java si chiama "tipo apparente" di una espressione il tipo che questa espressione ha in base al tipo delle variabili che la compongono. Il primo controllo fatto da Java è che il tipo apparente di una espressione sia quello richiesto dal comando che la usa, oppure sia incluso in esso. Se non è così, il programma dà un errore di tipo (non compila). In questo corso faremo particolare attenzione ad imparare come si evitano gli errori di tipo.

Se il programma compila, durante l'esecuzione Java conosce i valori delle variabili di una espressione, e da esse deduce il tipo esatto di un oggetto. Java utilizza il tipo esatto di un oggetto `obj` per decidere quale versione di un metodo applicare all'oggetto (ovvero da quale classe nella gerarchia prendiamo il metodo). Questo meccanismo viene chiamato dynamic binding (perché avviene a run time) o anche, a volte, late binding (perché avviene dopo la compilazione). Tuttavia, la seconda terminologia è meno usata perché si applica anche in altri ambiti dei linguaggi di programmazione. Il dynamic binding è un argomento centrale del corso. Se Java deve chiamare `obj.m(...)` e ci sono diverse versioni sovrascritte di `m(...)`, Java parte dal tipo esatto `C` di `obj` e cerca il metodo `m` nella classe `C`. Se non lo trova, Java cerca il metodo `m` nella classe `D` di cui `C` è estensione, nella classe `E` di cui `D` è estensione e così via. Il primo metodo trovato viene applicato. Dato che il programma compila, sappiamo che c'è almeno una versione del metodo `m` applicabile a `obj`, quella contenuta nel tipo apparente di `obj`. A volte ce ne sono anche altre, e prevale la prima trovata.

Un esempio. Vediamo un esempio di una variabile di tipo `Bottiglia` che, a seconda delle circostanze dell'esecuzione del programma, può avere tipo esatto la classe `Bottiglia` oppure tipo esatto la classe `BottigliaConTappo`, più precisa (ovvero di tipo più piccolo).


Upcasting: si “forza” una classe ad essere una sua superclasse. Può essere esplicito, inserendo la superclasse tra parentesi tonde, o implicito.

Esempio

```java
class Animale{
    
}
public class Mucca extends Animale{
    public static void main(String[] args) {
        
        Animale m = new Mucca();
        Mucca m1 = new Mucca();
        //Mucca m = new Animale();// da errore di compilazione
        
        Animale a = m;//Animale a = (Animale)m; è la stessa cosa
        Animale a1 = m1;
        
    }
    
}

```
Downcasting: casting da una classe a una sottoclasse. E’ possibile solo se l’oggetto, a run-time, è veramente un oggetto della sottoclasse. Questo controllo è eseguito solo run-time, e viene lanciata, in caso di esito negativo, una ClassCastException.


Se non siamo sicuri se obj ha tipo esatto C o più piccolo, per evitare di sollevare una eccezione prima di scrivere ((C) obj) dobbiamo fare il test (obj instanceof C). Solo se il test dà come risultato true possiamo eseguire ((C) obj). Il test (obj instanceof C) vale vero se e solo se obj è un oggetto “istanziato” (cioè diverso da null) di C. Come esempio, prendiamo due bottiglie a10 e b10, con tipi originari BottigliaConTappo e Bottiglia. Facciamo vedere che a10 è una istanza delle classi BottigliaConTappo e Bottiglia, mentre b10 solo di Bottiglia, e null non è istanza di nessuna delle due classi (anche se null ha tipo sia BottigliaConTappo che Bottiglia).

Esempi ulteriori sui concetti di sottotipo, upcast, downcast,
tipo apparente e tipo vero.
Il concetto di sottotipo permette di dare più di un tipo a un valore, rendendo quindi più flessibile l'utilizzo di tale valore. Partiamo da

un esempio che già conoscete, e consideriamo il tipo int e il tipo double di Java. Questi due tipi definiscono due insiemi di valori. L'insieme dei numeri rappresentati in int è un sottoinsieme dell’insieme dei numeri rappresentati in double, perché un intero, in particolare, è un reale con la parte decimale uguale a 0. Non è vero il viceversa, cioè un reale non è necessariamente un intero (perché non tutti i double hanno parte decimale pari a 0).
Si dice, in questo caso, che "int è sottotipo di double" e si può usare la notazione:
int <: double
Informalmente, possiamo dire che int "è più preciso" di double, perché
di un int si sa che la parte decimale di sicuro è 0.
L'assegnazione:

```java
    int x = 10;
double y = x;

```
è corretta, perché un int si può considerare un double. Questo cambiamento di tipo si dice upcast (quando un oggetto si sposta da un tipo più piccolo a un tipo più grande). Un upcast è sempre accettato dal compilatore, perchè matematicamente corretto.
Un assegnamento di natura opposta:
```java
    double k = 3.2;
int y = k;
```
invece NON è corretto, perché si avrebbe perdita di informazione: si perderebbe la parte decimale di k. Java permette questa perdita di informazione se il programmatore la indica esplicitamente con un'operatore di cast, che in questo caso è detto downcast (spostamento da un tipo più grande a un tipo più piccolo):
```java
    double k = 3.2;
    int y = (int)k;
```
Sappiamo che la definizione di una classe Java definisce un nuovo tipo (infatti il nome di una classe può essere il tipo di una variabile, di un parametro, di un valore di ritorno di un metodo). Quando si introduce una sottoclasse con una “extends” si introduce anche un sottotipo:
```java
    BottigliaConTappo extends Bottiglia {...}
    ```
Implica, con la notazione appena vista, che:
```java
    BottigliaConTappo <: Bottiglia
```


Vale lo stesso discorso di upcast che per i tipi primitivi, ovvero posso scrivere:
```java
Bottiglia b2 = new BottigliaConTappo(10);
```
assegnando un oggetto di un tipo più piccolo (più specifico) un oggetto di tipo più grande. Infatti tutte gli oggetti che appartengono all'insieme BottigliaConTappo sono anche Bottiglie (ma non è vero il viceversa).
Si parla di "tipo apparente" per indicare il tipo con cui viene *dichiarata* una variabile, si dice "tipo vero" quello indotto dalla 'new', quando l’oggetto viene costruito. Per esempio:
    (1) BottigliaConTappo b1 = new BottigliaConTappo(10);
(2) Bottiglia b2 = new BottigliaConTappo(10);
in (1) tipo apparente e tipo vero coincidono, mentre invece in (2) il tipo apparente è Bottiglia, mentre il tipo vero è BottigliaConTappo.
Il compilatore fa i controlli di tipo sui tipi apparenti, più restrittivi (quindi che garantiscono una sicurezza maggiore), ma durante l’esecuzione del programma, a runtime, la versione del metodo da chiamare dipende dal tipo vero. Per esempio, se scriviamo:
int q = b2.aggiungi(3);
la versione del metodo aggiungi() che verrà invocata sarà quella della (sotto)classe BottigliaConTappo, che sovrascrive (fa l'override del) metodo corrispondente della (sopra)classe Bottiglia, specializzandolo. Anche il risultato di b2.aggiungi(3) cambia: nel caso di una bottiglia con tappo, l’aggiunta di 3 litri fallisce se la bottiglia è chiusa.
Anche fra classi è possibile fare downcast espliciti, ovvero:
```java
    BottigliaConTappo c1 = new BottigliaConTappo(3);
    Bottiglia c2 = c1;
    BottigliaConTappo c3 = (BottigliaConTappo)c2; // downcast
```
L'ultimo assegnamento dice al compilatore di considerare un oggetto di tipo apparente Bottiglia (c2) come BottigliaConTappo. Cosa succede al runtime? Va tutto bene, perché il tipo vero di c2 è BottigliaConTappo. Invece ci sarebbe un errore a runtime se il tipo vero NON fosse BottigliaConTappo (o una sua sottoclasse).
È sempre possibile fare un test con 'instanceof' per scoprire il tipo vero (corrispondente alla classe di un oggetto) prima di un downcast (vedere Lezione 13), per evitare errori a runtime:
   if (c2 instanceof BottigliaConTappo)
     // caso particolare: c2 == null --> instanceof false
148

BottigliaConTappo c3 = (BottigliaConTappo)c2; // downcast
Si noti che:
'''java
   c1.aperta(); // compila
   c2.aperta(); // NON compila
   c3.aperta(); // compila
    '''
perché il compilatore controlla se il tipo apparente di c2 corrisponde a una classe che contiene il metodo aperta() e questo è solo contenuto nella classe BottigliaConTappo.
Con il programma che segue, facciamo qualche esperimento con instanceof, cast, binding dinamico.
Ci ricordiamo che:
- il compilatore fa i controlli di tipo usando i tipi *apparenti*;
- a runtime, viene scelta la versione di un metodo (dinamico) in base al tipo *vero* dell'oggetto su cui viene chiamato il metodo.
Ricordiamo anche che un downcast (C)obj funziona a runtime solo se:
- obj ha tipo vero C;
- obj ha tipo vero D <: C.
Infine, ricordiamo il comportamento di instanceof: (obj instanceof C) = true
  SE obj=/=null AND tipo_vero(obj) = C
(obj instanceof C) = false
  ALTRIMENTI.