# Lezione 20

## Eccezioni controllate e non controllate

Le eccezioni in Java sono oggetti della classe `Exception` e vengono utilizzate per segnalare situazioni che il programma non sa gestire. Ci sono classi di eccezioni che descrivono errori interni al programma scoperti durante l'esecuzione. Probabilmente avete già visto queste eccezioni come messaggi di errore quando un programma non termina correttamente. Alcuni esempi di eccezioni comuni sono:

- `ArithmeticException` (divisione per zero, radice di un numero negativo)
- `IllegalArgumentException` (un metodo riceve valori di input non corretti, ad esempio cercare una parola vuota in un dizionario italiano)
- `IllegalStateException` (lo stato del programma non consente l'uso di un dato metodo, ad esempio aggiungere un elemento a uno stack già pieno)
- `ArrayIndexOutOfBoundsException` (tentativo di accedere a un elemento inesistente di un array)
- `NullPointerException` (tentativo di accedere a un attributo o metodo di un oggetto nullo)

Vediamo alcuni esempi di questo primo gruppo di eccezioni e di altre. Definiamo dei metodi che sono accettati dal compilatore ma generano errori durante l'esecuzione.


Ci sono altri tipi di eccezioni, tipicamente causate da errori esterni al programma. Ad esempio, `FileNotFoundException` viene sollevata quando si tenta di aprire un file inesistente, mentre `IOException` viene sollevata in caso di errori durante la lettura/scrittura da un file o dalla rete. Per utilizzare le classi di eccezioni IO, è necessario includere l'importazione di `java.io.*`.

Infine, ci sono gli errori, che sono eccezioni particolarmente gravi. Ad esempio, il comando `assert cond:"messaggio";` solleva un errore di tipo `AssertionError` quando la condizione `cond` è falsa, interrompendo così l'esecuzione del programma e inviando un messaggio di errore. Abbiamo già visto come utilizzare l'assert per segnalare errori.

Esistono due tipi di eccezioni: le eccezioni non controllate e le eccezioni controllate. Le eccezioni non controllate prendono il nome da responsabilità del programmatore, che può decidere se gestirle quando si verificano o meno. Gestire un'eccezione può essere complicato, come vedremo, ma anche non gestirle può avere un costo molto elevato. Il programmatore può evitare l'apparizione delle eccezioni non controllate cercando tutti gli errori che impediscono al programma di terminare correttamente, ma senza prevedere un piano di emergenza nel caso in cui si verifichino. Al contrario, il programmatore è tenuto a gestire sempre le eccezioni controllate che ha inserito nel codice, poiché queste ultime sono causate da eventi esterni che non dipendono dal suo codice e che non possono essere previsti all'interno del programma stesso.

Vediamo le relazioni di sottoclasse tra questi due tipi di eccezioni. La classe `Exception` include sottoclassi di eccezioni controllate ("checked"), come `IOException` (input/output Exception), e sottoclassi più specifiche, come `EOFException` e `FileNotFoundException`. La classe `Exception` include anche classi di eccezioni non controllate ("unchecked"), come `RuntimeException`, e sottoclassi più specifiche, come `NullPointerException`. `NullPointerException` è forse l'eccezione non controllata più comune. La classe `Error` è separata dalla classe `Exception` ed è considerata un'eccezione non controllata. Entrambe le classi sono incluse nella classe `Throwable`, che rappresenta tutte le eccezioni e gli errori che possono essere sollevati.


Cattura di eccezioni. Non sempre è desiderabile terminare un programma in presenza di una eccezione. Ad esempio, un programma non deve terminare se cerca di aprire un file e non lo trova; questa situazione è comune e quindi deve essere gestita. Per evitare la terminazione del programma, è possibile catturare le eccezioni utilizzando il blocco try-catch.

Il codice viene scritto nella forma:

```java

try {
// Codice che può generare un'eccezione
} catch (TipoEccezione x) {
// Gestione dell'eccezione
}
```



Questo codice esegue il corpo del blocco try. Se viene sollevata un'eccezione di tipo `TipoEccezione`, anziché terminare il programma, viene eseguito il corpo del blocco catch, con `x` assegnato all'eccezione sollevata.

Si consiglia di utilizzare la classe `Error` per situazioni in cui non esiste un rimedio, evitando la cattura di un errore (anche se la cattura di un errore è possibile in Java).

È possibile specificare quale tipo di eccezione sollevare all'interno di un metodo `void m()` utilizzando l'istruzione `throw new TipoEccezione(...)`. Inoltre, è possibile avvisare Java che il metodo `m()` può sollevare un'eccezione di tipo `TipoEccezione` aggiungendo `throws TipoEccezione` alla firma del metodo. In questo caso, il metodo `m()` può essere utilizzato solo all'interno di un codice che gestisce l'eccezione di tipo `TipoEccezione`.

Supponiamo che `m()` contenga `throw new TipoEccezione(...)`. Le regole per l'uso di `throws` sono le seguenti:

1. Nel caso in cui `TipoEccezione` sia un'eccezione non controllata, non è obbligatorio scrivere `throws` nella firma del metodo `m()`.
2. Nel caso in cui `TipoEccezione` sia un'eccezione controllata, è obbligatorio scrivere `throws TipoEccezione` nella firma del metodo `m()`.


Possiamo definire le nostre classi di eccezioni estendendo qualsiasi classe di eccezioni esistente. Per le nostre eccezioni valgono le stesse regole delle eccezioni di Java.

È possibile catturare più eccezioni utilizzando clausole try-catch multiple:

```java


try {
// Codice che può generare eccezioni
} catch (TipoEccezione_1 e_1) {
// Gestione dell'eccezione TipoEccezione_1
} catch (TipoEccezione_2 e_2) {
// Gestione dell'eccezione TipoEccezione_2
}
```



La prima clausola catch che corrisponde al tipo di eccezione sollevata, o che contiene il tipo di eccezione sollevata, verrà eseguita.

Quando sviluppiamo un programma, utilizziamo gli assert per sollevare eccezioni non controllate, terminare il programma e tracciare l'errore. Queste eccezioni non vengono catturate. D'altra parte, le eccezioni catturate rappresentano le procedure di emergenza che utilizziamo quando incontriamo un'eccezione. Vogliamo avvisare dell'errore, ma evitare di interrompere il programma completamente.

Ad esempio, possiamo interrompere solo il calcolo corrente, segnalare il tipo di errore insieme ai suoi parametri e continuare con il resto del calcolo. Questa scelta è necessaria quando sviluppiamo un programma che non può essere interrotto immediatamente per motivi di sicurezza (ad esempio, guida di un'automobile, di un aereo o di un drone), o che interrompere completamente produrrebbe danni economici (ad esempio, un sistema di prenotazioni o di pagamenti elettronici), o quando l'errore dipende dai dati inseriti e deve essere previsto (ad esempio, chiedere a un'applicazione di aprire un file inesistente).

Di seguito sono riportati alcuni semplici esempi di eccezioni non controllate, in cui è possibile catturarle o meno. È importante notare che, in generale, non è possibile né consigliabile cercare di catturare tutte le eccezioni non controllate, poiché spesso derivano da errori logici nel programma che dovrebbero essere corretti.

Esempi di eccezioni non controllate (cattura possibile):
In questo esempio, rivediamo la classe Bottiglia (Lezione 05) e sostituiamo l'uso di assert con il lancio di un'eccezione di tipo IllegalArgumentException, che è una eccezione non controllata. Questa eccezione può essere catturata o meno, e vedremo entrambe le possibilità.


“Catch” ripetuti. Vediamo infine un esempio di cattura di diverse eccezioni (non controllate), con l’uso di diversi catch.

```java
public class TestTryCatch {
    public static void m() {
        throw new IllegalStateException("non dovevi chiamarmi");
    }

    public static void main(String[] args) {
        try {
            m();
            System.out.println("Impossibile! Ho la risposta di m()");
        } catch (RuntimeException e) {
            System.out.println("Catturata IllegalStateException):\n" + e);
        } catch (Exception e) {
            System.out.println("Catturata eccezione (non IllegalStateException):\n" + e);
        } finally {
            System.out.println("\n... Posto per la clausola finale...\n");
        }
    }
}

```
