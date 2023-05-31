# Lezione 19

## Interfacce Comparable, Iterator e Iterable

Lezione 19. Parte 1. La classe Bottiglia come implementazione dell'interfaccia `Comparable<Bottiglia>`. (35 minuti)

Se dichiariamo che `Bottiglia` implementa l'interfaccia `Comparable<Bottiglia>`, dobbiamo aggiungere alla classe `Bottiglia` un'implementazione del metodo astratto `int compareTo(Bottiglia b)`, per confrontare due bottiglie. In cambio, possiamo usare i metodi generici `void Arrays.sort()` e `void Arrays.binarySearch()` (che importiamo dalla libreria Java con `import java.util.*;`) per ordinare un array di bottiglie e per la ricerca binaria in un array ordinato di bottiglie. Questi metodi possono essere applicati a un array di una classe `T` qualunque, ma hanno un vincolo: `T` deve implementare `Comparable<T>`.

Ricordiamo che il metodo `int compareTo(Bottiglia b)` deve restituire 0 se l'oggetto `this` è uguale all'oggetto `b` passato come parametro, un valore > 0 se l'oggetto `this` è più grande di quello passato come parametro, e un valore < 0 altrimenti. Chi progetta la classe decide come fare il confronto e di conseguenza l'implementazione del metodo. In questo caso, decidiamo di confrontare due bottiglie solo in base al loro livello, ignorandone la capacità. Consideriamo equivalenti due bottiglie con lo stesso livello, anche se una è una damigiana e l'altra una bottiglietta. Nulla ci vieta di fare una scelta diversa, confrontando le bottiglie in base alla capacità.

Un dettaglio: nella Parte 1 della lezione utilizziamo per la prima volta il costrutto `foreach` su un array, definito da `for(C c:v) {...c...}` per `v` array di elementi della classe `C`. Il costrutto esegue `{...c...}` per `c=v[0], ..., v[n-1]` in quest'ordine, con `n=v.length()`.
