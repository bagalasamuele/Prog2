# Lezione 16
## La classe astratta Lista

Lezione 16. Le classi astratte ricorsive. Abbiamo già visto nella Lezione 14 come rappresentare liste di oggetti usando la classe MiniLinkedList con attributo `first` = "l'indirizzo del primo nodo nella lista", `first=null` se la lista è vuota. Un'altra possibilità è rappresentare liste vuote e non vuote con oggetti con etichetta "lista vuota" e "lista non vuota". Rappresentiamo in Java queste etichette con la classe delle liste vuote e la classe delle liste non vuote. Questa rappresentazione contiene delle informazioni in più, utili a Java per scegliere quale versione di un metodo usare attraverso il dynamic binding. Otteniamo questa rappresentazione considerando le liste come una classe astratta ricorsiva.

Nota. Non è essenziale usare le classi astratte ricorsive nel caso delle liste: usiamo le liste solo per avere un esempio semplice. Le classi astratte ricorsive diventano importanti per problemi avanzati, quandi si considerano dati con molte "forme" possibili, con ogni dato composto di un diverso numero e tipo di dati più semplici. Un esempio sono gli alberi di parsing, che vedrete nel corso di Linguaggi Formali. Ora torniamo a parlare di liste come classi astratte ricorsive.

Definiamo una classe astratta `List` delle liste ordinate senza ripetizioni di interi. `List` ha due sottoclassi concrete. Abbiamo la classe `Nil` che contiene (oltre a `null` che NON usiamo in questa particolare rappresentazione per rappresentare la lista vuota) gli oggetti che rappresentano le liste vuote. Abbiamo la classe `Cons` degli oggetti che rappresentano liste contenenti un elemento `elem` e una lista `next`, fatta di elementi tutti più grandi di `elem` (oppure vuota). Dunque `Cons` è definito a partire da `List` che è definito a partire da `Cons`: la definizione di `List` e `Cons` è ricorsiva. Possiamo usare `List` per rappresentare insiemi finiti di interi. Abbiamo scelto di usare liste ordinate senza ripetizioni: questa scelta ha il vantaggio di avere una sola rappresentazione per ogni insieme di valori.

Il primo passo è scegliere quali metodi implementare (tutti dinamici e pubblici). Chiediamo di avere (i) un metodo `boolean empty()` per decidere se una lista è vuota, (ii) un metodo `int size()` per contare gli elementi di una lista, (iii) un metodo `boolean contains(int x)` per decidere se una lista contiene un elemento `x`, e due metodi per costruire nuove liste ordinate senza ripetizioni. Innanzitutto il metodo (iv) `List insert(int x)`, che crea una nuova lista aggiungendo un elemento `x` a una lista data, dopo gli elementi più piccoli e prima di quelli più grandi, e non aggiunge `x` se `x` c'è già. Quindi il metodo (v) `List append(List l)`, che costruisce una nuova lista unione della lista data e della lista `l`. Infine (vi) nelle classi `Nil` e `Cons` riscriviamo il metodo `String toString()` per liste.

In questo esercizio non definiamo metodi che modificano liste già esistenti: questa scelta ha il vantaggio di evitare il rischio di sovrascrivere dati che ancora ci servono, e lo svantaggio di usare tempo e memoria in più, per costruire le nuove liste. Sfruttiamo il più possibile le liste esistenti, come vedremo.

Il costruttore `Cons(int elem, List next)`, della classe `Cons` di liste non vuote, consente di definire liste non ordinate: per questo motivo non ne consentiamo l'uso fuori di `List`, della sua cartella e delle sue sottoclassi, e lo dichiariamo `protected`. Non possiamo definire `Cons` come `private`, perché `Cons` viene usato nella classe `Nil` e dunque fuori di `Cons`, anche se nella stessa cartella. La classe `Nil` ha il costruttore pubblico `Nil()` per la lista vuota.

Un'ultima scelta di implementazione è la seguente. Quando definiamo una nuova lista (ordinata e senza ripetizioni), vogliamo riutilizzare per quanto possibile la lista da cui partiamo. Siano



'''java
a = {10,20}
b = a.insert(5) = {5,10,20}
c = b.insert(15) = {5,10,15,20}
d = c.insert(25) = {5,10,15,20,25}
'''

Vogliamo che `insert` costruisca le liste `b,c,d` riutilizzando per quanto possibile le liste precedenti. Con la particolare definizione di `List` che sceglieremo, otterremo il seguente risultato: la lista `b` riutilizza tutti gli elementi di `a`, la lista `c` riutilizza l'elemento 20 di `a` e `b`, mentre la lista `d` riutilizza la sola costante `Nil()` che indica la lista vuota al fondo di `a,b,c`. Ecco il disegno:

Le liste `a,b,c,d` di cui sopra si sovrappongono in parte (ovvero condividono alcuni nodi).
