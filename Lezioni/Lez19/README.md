# Lezione 19

## Interfacce Comparable, Iterator e Iterable

Lezione 19. Parte 1. La classe Bottiglia come implementazione dell'interfaccia `Comparable<Bottiglia>`. (35 minuti)

Se dichiariamo che `Bottiglia` implementa l'interfaccia `Comparable<Bottiglia>`, dobbiamo aggiungere alla classe `Bottiglia` un'implementazione del metodo astratto `int compareTo(Bottiglia b)`, per confrontare due bottiglie. In cambio, possiamo usare i metodi generici `void Arrays.sort()` e `void Arrays.binarySearch()` (che importiamo dalla libreria Java con `import java.util.*;`) per ordinare un array di bottiglie e per la ricerca binaria in un array ordinato di bottiglie. Questi metodi possono essere applicati a un array di una classe `T` qualunque, ma hanno un vincolo: `T` deve implementare `Comparable<T>`.

Ricordiamo che il metodo `int compareTo(Bottiglia b)` deve restituire 0 se l'oggetto `this` è uguale all'oggetto `b` passato come parametro, un valore > 0 se l'oggetto `this` è più grande di quello passato come parametro, e un valore < 0 altrimenti. Chi progetta la classe decide come fare il confronto e di conseguenza l'implementazione del metodo. In questo caso, decidiamo di confrontare due bottiglie solo in base al loro livello, ignorandone la capacità. Consideriamo equivalenti due bottiglie con lo stesso livello, anche se una è una damigiana e l'altra una bottiglietta. Nulla ci vieta di fare una scelta diversa, confrontando le bottiglie in base alla capacità.

Un dettaglio: nella Parte 1 della lezione utilizziamo per la prima volta il costrutto `foreach` su un array, definito da `for(C c:v) {...c...}` per `v` array di elementi della classe `C`. Il costrutto esegue `{...c...}` per `c=v[0], ..., v[n-1]` in quest'ordine, con `n=v.length()`.


# Lezione 19

## Parte 2. Le interfacce `Comparable<T>`, `Iterable<E>` e `Iterator<E>`. Una classe `T` che implementa due interfacce. (65 minuti)

L'interfaccia `Iterable<E>`. Spieghiamo l'uso di `Iterable<E>`. Supponiamo di voler scrivere un `for` che attraversi una lista `l` di elementi di tipo `E=Integer`, ma senza rendere pubblici gli indirizzi dei nodi all'interno di `l`. Lo scopo è impedire di alterare dall'esterno la lista `l`. Riprendiamo la soluzione vista nella Lezione 14, questa volta usando le interfacce `Iterable<E>` e `Iterator<E>`: il vantaggio è che questa volta Java, attraverso le interfacce, può controllare se la costruzione che facciamo è corretta.

Usiamo come esempio una classe `ListExt` di liste di oggetti di tipo `Integer`, fornite di un attributo "size". Non vogliamo consentire di modificare il numero degli elementi di una lista dall'esterno, perché aggiungere o togliere elementi produrrebbe una inconsistenza con il valore di `size`.

Per impedirlo, definiamo in `ListExt` una implementazione per l'interfaccia `Iterable<Integer>`. L'implementazione richiede un metodo `public ListIterator iterator()` che ri-etichetta una lista `l` di `ListExt` (dunque di `Iterable<Integer>`) come un oggetto di `ListIterator`. Qui avviene (in modo sicuro, ovvero senza esporre i puntatori all'esterno, causandone leaking) l'iterazione su `l`.

Per eseguire l'iterazione in modo sicuro, `ListIterator` implementa (dunque è una sottoclasse di) una seconda interfaccia, `Iterator<E>`, dove `E=Integer`. L'interfaccia `Iterator<Integer>` contiene il minimo necessario per eseguire l'iterazione: il metodo `boolean hasNext()`, per sapere quando la traversata di una lista `l` è finita, e il metodo `Integer next()`, per conoscere il valore dell'elemento `e:E` contenuto nel nodo corrente di `l` e per spostarsi al nodo successivo.

Il prossimo disegno riassume tutta la situazione: abbreviamo sempre `E=Integer`. `ListExt` appare incluso in `Iterable<E>` e `ListIterator` appare incluso in `Iterator<E>`.



Implementati `Iterable<Integer>` in `ListExt` e `Iterator<Integer>` in `ListIterator`, possiamo usare in `ListExt` il costrutto `foreach`: `for (Integer e:l){...e...}`, dove `l` ha tipo `ListExt`. Un `foreach` rietichetta `l` in `ListIterator`, quindi esegue `{...e...}` una volta per ogni elemento `e` della lista `l`, nell'ordine, usando i metodi `hasNext()`, `next()` di `ListIterator`. In tutto il processo, gli indirizzi dei nodi di `l` non vengono resi pubblici.

Ci sono anche altri vantaggi nell'usare l'interfaccia `Iterable<Integer>`. Questa interfaccia ci consente di utilizzare al...

Per quanto riguarda l'iterazione sequenziale, abbiamo la possibilità di utilizzare l'iterazione parallela, che è molto più veloce, utilizzando il metodo `splitIterator()` e una seconda interfaccia `SplitIterator<E>`. Tuttavia, non possiamo approfondire questo aspetto nel corso attuale.

È necessario importare il pacchetto `java.util` in cui risiedono le interfacce `Iterator<E>` e `Iterable<E>`. Inoltre, ricordiamo (come abbiamo già discusso) che dobbiamo utilizzare `Integer` come tipo degli elementi di `ListExt` anziché `int`. Il motivo è che in Java gli interi non sono una classe, ma i generici devono essere di tipo classe. Pertanto, utilizziamo la classe `Integer` come rappresentazione degli interi. Come abbiamo già detto, `Integer` è un semplice "wrapper" di `int`, il che significa che gli oggetti di `Integer` sono oggetti il cui unico attributo è un intero, e Java effettua automaticamente la conversione tra `int` e `Integer` (un'operazione chiamata autoboxing).

Forniamo un esempio di una classe che implementa due interfacce. Per aggiungere un esempio di classe che implementa due interfacce, scegliamo di implementare in `ListExt` una seconda interfaccia, `Comparable<ListExt>`, che confronta due liste in `ListExt`. Come implementazione di `compareTo` per le liste di interi, scegliamo il confronto lessicografico tra le liste, simile all'ordine tra le parole in un vocabolario. Una lista è considerata inferiore a un'altra se è un prefisso (parte iniziale) della seconda lista, oppure se, nella prima posizione in cui le due liste sono diverse, la prima lista ha un elemento minore della seconda.
