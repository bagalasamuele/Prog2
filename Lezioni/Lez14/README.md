# Lezione 14

## Esempi di ereditarietà e array come liste

Lezione 14. Parte 1. Vediamo nuovi esempi di uso del dynamic binding.

Nella lezione precedente, abbiamo visto una classe `Figura` di figure, con diversi metodi di disegno a seconda del tipo esatto della figura: il metodo da applicare veniva deciso con la regola del dynamic binding. 

Vediamo ora l’esempio di una classe `Persona` con due metodi uguali di conversione in stringa: `String toString()` e `String nomeToString()`. Riscriviamo `toString()` in ogni sottoclasse, non riscriviamo invece `nomeToString()`. Proveremo quindi ad applicare i due metodi a un array di persone. 

Nel caso di `toString()`, il metodo usato dipende dalla sottoclasse a cui appartiene una data persona, mentre nel caso di `nomeToString()`, applichiamo sempre il metodo della classe `Persona`.

Cominciamo con un diagramma UML della classe `Persona` e le sue sottoclassi `Docente` e `Studente`. Nella classe `Persona` abbiamo un attributo `nome` con metodi `get` e `set`, mentre nelle classi `Docente` e `Studente` abbiamo un attributo aggiuntivo, rispettivamente `stipendio` e `matricola`, anch'essi con metodi `get` e `set`.




Quando applichiamo String toString() e String nomeToString() a docenti e studenti nella classe Persona, in base alle regole del Dynamic Binding, viene usato il metodo definito nel tipo più vicino (nel diagramma UML) al tipo esatto. Nel primo caso il metodo usato è quello della sottoclasse Docente o Studente, nel secondo caso è quello della classe Persona.




# Lezione 14. Parte 2. Le classi MiniLinkedList e Iterator.

Lasciamo momentaneamente da parte ereditarietà e dynamic binding per svolgere un esercizio sulle liste di nodi, in cui una classe viene usata come etichetta per consentire/proibire una certa operazione, in questo caso, la traversata veloce di una lista. 

Il nostro obiettivo è definire le classi MiniLinkedList e Iterator che implementano gli array tramite liste e l’iterazione su queste liste: questo comporta una difficoltà non immediatamente visibile.

Definiamo la classe MiniLinkedList delle liste concatenate V, attraverso una lista di nodi V_0, ..., V_(size-1), ognuno dei quali punta al successivo, e con un attributo size che indica il numero dei nodi. L’attributo size è solo un esempio: potremmo avere diversi attributi che descrivono caratteristiche importanti della lista. La lista viene identificata con l’indirizzo first di V_0. 

I metodi pubblici di MiniLinkedList sono:
1. `int get(int i)`: Restituisce il contenuto del nodo numero i se 0 <= i < size. Con accesso lento, numero di getNext() richiesti = i.
2. `void set(int i, int x)`: Assegna il valore x al nodo numero i, se 0 <= i < size.
3. `void add(int i, int x)`: Aggiunge un nodo di contenuto x in posizione i, se 0 <= i <= size, e incrementa size.
4. `int remove(int i)`: Cancellala il nodo di posto i dalla lista, se 0 <= i < size, e decrementa size.

Aggiungiamo un metodo privato `Node node(int i)` che restituisce l’indirizzo del nodo numero i. Viene usato dai metodi pubblici, non è pubblico perché consentirebbe un accesso ai nodi.

MiniLinkedList assomiglia alla classe degli array di dimensioni statiche, con il vantaggio che la dimensione size di V non è fissata a priori, e che V occupa esattamente lo spazio di memoria di cui ha bisogno. C’è però uno svantaggio: l'operazione `V.get(i)` raggiunge il nodo i passando attraverso i nodi 0, ..., i-1, quindi usa un numero di getNext() uguale ad i. L'accesso a un array statico, invece, avviene con un solo accesso a un indirizzo.

Spieghiamo ora come definire l’iterazione su MiniLinkedList: ora vediamo comparire la difficoltà. Supponiamo infatti che il nostro obbiettivo sia passare attraverso ciascun nodo della lista, svolgendo per ognuno di essi la stessa operazione. Questo compito richiede 0+1+2+...+(size-1) volte getNext(), uguale a size(size-1)/2 volte getNext(), un netto svantaggio per grandi valori di size rispetto al numero di operazioni che richiederebbe un array.

Vogliamo consentire un passaggio veloce in sola lettura a tutti i nodi della lista, con un numero totale di getNext() pari a size.

Un modo semplice è rendere pubblico l’attributo first della lista, e usare un ciclo che rimpiazzi ogni nodo con il successivo fino a esaurimento nodi. Questo però comporta il rischio che un programmatore possa scrivere del codice che modifica la lista dall’esterno (ovvero senza utilizzare i metodi), vanificando l’invariante di classe “size rappresenta il numero di elementi presenti nella struttura”, se, per esempio, il programmatore si dimentica di modificare l’attributo size della lista quando aggiunge/toglie nodi.

Per consentire una scansione veloce della lista ma senza consentire di modificare direttamente i puntatori ai nodi (ma solo con i metodi di MiniLinkedList) definiamo un metodo `iterator()`, che “racchiude” una lista l in un oggetto di una nuova classe, detta MiniIterator, dentro alla quale avverrà la scansione. 

MiniIterator ha un metodo `int next()` che legge il contenuto di un puntatore e sposta il puntatore al nodo dopo, ma senza modificare i puntatori dei nodi. L’oggetto MiniIterator può essere usato per iterare la stessa operazione (per esempio: la stampa) su tutti gli elementi della lista l, senza consentire di aggiungere/togliere nodi da l. Per farlo, siamo obbligati a usare i metodi di MiniLinkedList, che modificano l’attributo size se la dimensione della lista cambia, e ci impediscono di sbagliare il valore di size.

Riassumiamo con il seguente disegno:

