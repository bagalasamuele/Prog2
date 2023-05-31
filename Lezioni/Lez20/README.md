# Lezione 20

## Eccezioni controllate e non controllate

Le eccezioni in Java sono oggetti della classe `Exception` e vengono utilizzate per segnalare situazioni che il programma non sa gestire. Ci sono classi di eccezioni che descrivono errori interni al programma scoperti durante l'esecuzione. Probabilmente avete già visto queste eccezioni come messaggi di errore quando un programma non termina correttamente. Alcuni esempi di eccezioni comuni sono:

- `ArithmeticException` (divisione per zero, radice di un numero negativo)
- `IllegalArgumentException` (un metodo riceve valori di input non corretti, ad esempio cercare una parola vuota in un dizionario italiano)
- `IllegalStateException` (lo stato del programma non consente l'uso di un dato metodo, ad esempio aggiungere un elemento a uno stack già pieno)
- `ArrayIndexOutOfBoundsException` (tentativo di accedere a un elemento inesistente di un array)
- `NullPointerException` (tentativo di accedere a un attributo o metodo di un oggetto nullo)

Vediamo alcuni esempi di questo primo gruppo di eccezioni e di altre. Definiamo dei metodi che sono accettati dal compilatore ma generano errori durante l'esecuzione.
