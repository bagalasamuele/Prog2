# Lezione 18
## Generici vincolati, interfacce e alberi di ricerca

Lezione 18. In questa lezione introduciamo i generici vincolati, cioè le variabili di classe `T` con restrizioni o vincoli. Come esempio di vincolo, chiediamo che la classe `T` abbia una relazione di ordine, e usiamo `T` per definire una classe astratta degli alberi di ricerca su una generica classe `T`.

### Interfacce Java

Per spiegare la nozione di vincolo su una classe generica `T` è necessario prima conoscere la nozione di interfaccia in Java. Una interfaccia è una classe astratta: si presenta come una lista di segnature di metodi dinamici, quindi metodi astratti, senza nessuna implementazione. Un'interfaccia può contenere metodi statici implementati. Una classe astratta può avere degli attributi e dei metodi concreti, una interfaccia no. Una interfaccia viene definita usando la parola chiave `interface`. Per estendere una interfaccia, al posto della parola chiave `extends`, usiamo la parola chiave `implements`. Per implementare una interfaccia dobbiamo sovrascrivere con metodi concreti tutti i suoi metodi astratti. Una classe Java può estendere al più una classe, ma può implementare un numero qualunque di interfacce, scrivendo `C implements I, J, ...`. 

Notiamo che nel caso delle classi (astratte e concrete), se per esempio abbiamo due classi `A`, `B` che forniscono due versioni concrete diverse dello stesso metodo `m`, se la classe `C` estendesse `A, B` si avrebbe un conflitto su quale versione di `m` ereditare. Per questa ragione, Java non consente l'ereditarietà multipla tra una classe e due o più classi. Questo conflitto non succede aggiungendo un numero qualsiasi di interfacce: se `C` implementa due interfaccie `I, J` e `m` compare sia in `I` che in `J`, allora `I, J` non forniscono versioni concrete del metodo `m`, e quindi non si crea un conflitto.

Un esempio di deduzione a partire dalle definizioni date. Supponiamo di avere `B` che estende `A` che implementa l'interfaccia `I`: qual è la relazione tra `B` ed `I`? `A` sovrascrive tutti i metodi di `I`, dunque lo stesso vale per `B` che estende `A`. Concludiamo: `B` implementa `I`.

### L'interfaccia `Comparable<T>`

Per definire gli alberi di ricerca su una generica classe `T`, abbiamo bisogno dell'interfaccia predefinita `Comparable<T>`. Questa interfaccia ha un unico metodo astratto `int compareTo(T y)`. Questo metodo viene interpretato come un confronto tra due elementi di `T`: se `y` è in `T`, allora `x.compareTo(y)` è negativo se `x` precede `y`, è 0 se `x` e `y` sono uguali, è positivo se `x` è maggiore di `y`. Quando dichiariamo che una classe `C` implementa `Comparable<C>`, siamo tenuti a fornire in `C` una implementazione per `int compareTo(C y)`. Così facendo scegliamo una nozione di eguaglianza e una nozione di ordine per `C`.

Come esempio di `compareTo`: le classi predefinite `Integer`, `Double`, `String` implementano `Comparable<T>` rispettivamente per `T=Integer, Double, String`. Se `T=Integer, Double`, allora `x.compareTo(y)` è l'ordine tra numeri. Se `T=String`, allora `x.compareTo(y)` è l'ordine lessicografico (l'ordine del vocabolario).

### Generici Vincolati

Possiamo definire una classe astratta `Tree<T>` di alberi di ricerca su `T` aggiungendo un vincolo alla classe generica `T` che utilizziamo: possiamo scrivere `Tree<T extends I>`, dove `I` è una classe astratta oppure una interfaccia (bizzarramente, qui si scrive "T extends I" e non "T implements I"). In questo caso quando descriviamo `Tree<T>` abbiamo a disposizione tutti i metodi di `I`: per esempio il metodo `x.compareTo(y)` se `I=Comparable<T>`. Però in questo modo abbiamo contratto un debito, e quando vogliamo utilizzare `Tree<C>` per una particolare classe `C` possiamo solo scegliere una classe che estende `I` (se `I` è una classe) oppure implementa `I` (se `I` è una interfaccia), altrimenti Java segnala un errore. Quando scriviamo `Tree<T extends I>`, diciamo che `T` è un generico vincolato.

### La classe astratta `Tree<T extends Comparable<T>>` degli alberi di ricerca sulla classe `T`

Per costruire la classe astratta degli alberi di ricerca su una classe `T` generica abbiamo bisogno di un vincolo su `T`: chiediamo che `T` estenda l'interfaccia `I = Comparable<T>`, ovvero che `T` abbia una relazione che interpretiamo come una relazione di ordine. In questo modo possiamo usare `compareTo` per confrontare tra loro gli oggetti di `T` e definire gli alberi di ricerca su `T`. Quando scegliamo un valore per `T`, dobbiamo scegliere una classe `C` che estenda `Comparable<C>`, cioè che fornisca una implementazione per `int compareTo(C y)`.

### Un esempio di albero di ricerca

Ecco una rappresentazione semplificata di un albero di ricerca `t={1,2,3}` in Java. Il tipo di `t` è `Tree<T>`, ottenuto istanziando su `T=Integer`. L'albero `t` ha radice 2 e figli 1 e 3. La radice di `t` contiene l'elemento 2, e l'indirizzo dei sottoalberi `t.left` e `t.right` (sinistri e destri) dell'albero. Nel disegno poniamo `t.left` a sinistra e `t.right` a destra, consideriamo le foglie di `t` distinte tra loro e gli interi 1, 2, 3 parte dell'albero.


Quando scriviamo un programma, di solito ci basta la rappresentazione semplificata vista qui sopra. Accenniamo che la rappresentazione precisa di t nella memoria di un programma Java è più complessa: gli elementi di Integer non sono parte dell’albero ma sono delle “box” esterne di contenuto 1,2,3, inoltre è possibile che le foglie di t vengano identificate tra loro per risparmiare spazio. In questo caso dai nodi contenenti 1,3 partono quattro frecce che arrivano allo stesso elemento di Leaf.


Proviamo ora ad applicare tutte le idee che abbiamo appena visto per realizzare la classe degli alberi di ricerca sopra una generica classe T, con una relazione di ordine rappresentata dal metodo compareTo dell’interfaccia Compare<T>. Come abbiamo detto, questa richiesta si traduce nel vincolo: T extends Compare<T>. La definizione di Tree<T extends Comparable<T>> sarà molto simile alla definizione della classe Tree degli alberi di ricerca su interi (Lezione 17). Come test per il codice scritto, sceglieremo T = la classe Contatto dei contatti, classe in cui siamo tenuti a implementare l’interfaccia Comparable<T>. Ottenerremo così: la classe Tree<Contatto> degli alberi di ricerca sui contatti.