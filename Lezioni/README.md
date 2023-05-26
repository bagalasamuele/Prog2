Lezione 12: Estensioni ripetute di classi
Introduzione
Nella Lezione 12, esploreremo il concetto di estensione ripetuta di classi in Java. Spesso, il codice di un programma viene scritto attraverso una serie di modifiche successive. Una di queste modifiche può essere l'estensione di una classe esistente. Vedremo cosa accade quando estendiamo una classe più volte in Java.

Procedura
Inizieremo con la classe DynamicStack, che rappresenta una pila dinamica (come descritto nella Lezione 08). Aggiungeremo due nuovi attributi: max (valore massimo) e size (numero di elementi) alla classe DynamicStack.

All'interno del file DynamicStack.java, sostituiremo la parola chiave private con protected davanti all'attributo top. Questo modificatore di visibilità consente di utilizzare top in tutte le classi nello stesso package (cartella) e in tutte le classi che estendono la classe corrente (in altre cartelle), ma non altrove. Nel nostro caso, dobbiamo accedere alla posizione top della pila quando calcoliamo il valore massimo in un'altra classe. L'utilizzo di protected ci impedisce di modificare un attributo di una classe importata da un'altra cartella (cosa che di solito è meglio evitare per prevenire la propagazione di errori tra le classi), ma semplifica la definizione di classi nella stessa cartella.

Estendere una classe richiede l'aggiunta di un'invariante di classe con le condizioni che descrivono i valori desiderati per max e size.

java
Copy code
// classi Node.java e DynamicStack.java: copiatele dalla Lezione 08
// Dopo aver copiato, nella definizione di DynamicStack sostituite:
//        "private Node top"       con       "protected Node top"
// Cancellate il costruttore DynamicStack(int n). Otterrete:
Assicurati di copiare le classi Node.java e DynamicStack.java dalla Lezione 08. Successivamente, sostituisci la parola chiave private con protected davanti all'attributo top nella definizione di DynamicStack. Infine, elimina il costruttore DynamicStack(int n). Seguendo queste istruzioni, otterrai:
