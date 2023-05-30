# Lezione 15. Classi astratte di figure

Lezione 15. Parte 1. Una classe Figure per il calcolo di area e perimetro. Nella Lezione 13 abbiamo visto come disegnare figure diverse usando la nozione di sottoclasse. In questa lezione consideriamo un problema simile: definire delle classi per calcolare area e perimetro delle figure geometriche: cerchi, poligoni regolari, trapezi, rettangoli eccetera. Vedremo anche una versione migliorata della stessa soluzione, utilizzando le classi astratte di Java.

Ecco un’indicazione per una prima soluzione usando la nozione di sottoclasse. Dobbiamo scrivere una copia di ogni metodo statico su figure per i cerchi, i poligoni regolari eccetera. Questa molteplicità di tipi comporta degli svantaggi: per esempio, non possiamo raggruppare delle figure in un array di figure, perché le figure non hanno un tipo comune. Avremmo quindi bisogno di una sola classe Figura che le contenga tutte le classi citate (come sottoclassi), e che non contenga oggetti, oltre agli oggetti costruiti nelle sottoclassi e a null. La difficoltà è che non esiste un metodo generale per calcolare area e perimetro di una figura: dobbiamo quindi dichiarare dei metodi vuoti per le figure e sovrascriverli per ogni sottoclasse. I metodi vuoti non vengono mai usati. Questa soluzione adatta la soluzione vista nella Lezione 13.

Adesso vediamo una soluzione migliorata: dichiariamo una classe come astratta. Possiamo migliorare la soluzione precedente dichiarando una classe e alcuni dei suoi metodi come astratti. I metodi astratti rappresentano l’impegno da parte nostra di definire un metodo con quel nome nelle sottoclassi, e non si possono usare. Inoltre non possiamo definire un oggetto usando il costruttore di una classe astratta (possiamo invece usarlo nella definizione del costruttore di una sottoclasse). Ogni oggetto che appartiene a una classe astratta viene definito dal costruttore di una sottoclasse concreta, oppure è null. Il vantaggio di dichiarare una classe astratta è che Java controlla per noi: che non usiamo un metodo astratto prima di averlo sovrascritto in una sottoclasse, e che non definiamo oggetti usando il costruttore di una classe astratta.

Chiameremo concreta una classe non astratta.

Regole per le classi astratte. (i) Gli attributi non sono astratti. (ii) Se un metodo è astratto la sua classe è astratta, ma una classe astratta può avere anche metodi concreti. (iii) Una classe astratta può definire costruttori, ma questi si possono usare solo nelle sue estensioni. Dunque una classe astratta contiene solo null e gli oggetti costruiti nelle sottoclassi concrete. (iv) Perché una sottoclasse di una classe astratta sia concreta deve sovrascrivere tutti i metodi astratti che eredita.

Nei diagrammi UML, metodi astratti e classi astratte sono solitamente indicati scrivendone il nome in corsivo (noi inoltre li scriviamo in rosso).

Forniamo ora il diagramma UML di una classe Figura di figure per cui vengono forniti metodo per il calcolo di area e perimetro (per questa classe di Figure non abbiamo metodi grafici). Questi sono i soli metodi (astratti) di Figura.

Le sottoclassi sono Cerchio, classe concreta, con l’attributo raggio e relativi get e set, e Poligono, con lati (numero dei lati) e un metodo get. Non possiamo fornire un metodo set per il numero dei lati a Poligono, altrimenti verrebbe ereditato da tutti le sottoclassi, per esempio quella dei Rettangoli, e potremmo ottenere rettangoli con più o meno di quattro lati. Poligono è una classe astratta, perché non abbiamo un metodo per il calcolo di area e perimetro che valga per ogni poligono.

Invece le sottoclassi di Poligono sono concrete: Rettangolo, Trapezio, PolReg, rispettivamente con gli attributi base, altezza, baseMinore, baseMaggiore, raggio e apotema. Per “trapezio” intendiamo “trapezio isoscele”. Nella classe PolReg dei poligoni regolari ha senso inserire un metodo setLati(int lati) per variare il numero dei lati.

Infine, per completare la costruzione, ogni sottoclasse concreta di Figura (Cerchio e le sottoclassi concrete di Poligono) deve avere metodi concreti per il calcolo di area e perimetro.
