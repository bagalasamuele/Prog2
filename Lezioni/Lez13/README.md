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


Downcasting: casting da una classe a una sottoclasse. E’ possibile solo se l’oggetto, a run-time, è veramente un oggetto della sottoclasse. Questo controllo è eseguito solo run-time, e viene lanciata, in caso di esito negativo, una ClassCastException.