# Lezione 14

## Esempi di ereditarietà e array come liste

Lezione 14. Parte 1. Vediamo nuovi esempi di uso del dynamic binding.

Nella lezione precedente, abbiamo visto una classe `Figura` di figure, con diversi metodi di disegno a seconda del tipo esatto della figura: il metodo da applicare veniva deciso con la regola del dynamic binding. 

Vediamo ora l’esempio di una classe `Persona` con due metodi uguali di conversione in stringa: `String toString()` e `String nomeToString()`. Riscriviamo `toString()` in ogni sottoclasse, non riscriviamo invece `nomeToString()`. Proveremo quindi ad applicare i due metodi a un array di persone. 

Nel caso di `toString()`, il metodo usato dipende dalla sottoclasse a cui appartiene una data persona, mentre nel caso di `nomeToString()`, applichiamo sempre il metodo della classe `Persona`.

Cominciamo con un diagramma UML della classe `Persona` e le sue sottoclassi `Docente` e `Studente`. Nella classe `Persona` abbiamo un attributo `nome` con metodi `get` e `set`, mentre nelle classi `Docente` e `Studente` abbiamo un attributo aggiuntivo, rispettivamente `stipendio` e `matricola`, anch'essi con metodi `get` e `set`.




Quando applichiamo String toString() e String nomeToString() a docenti e studenti nella classe Persona, in base alle regole del Dynamic Binding, viene usato il metodo definito nel tipo più vicino (nel diagramma UML) al tipo esatto. Nel primo caso il metodo usato è quello della sottoclasse Docente o Studente, nel secondo caso è quello della classe Persona.