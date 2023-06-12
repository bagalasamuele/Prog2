public class TestString {

    // ritorna la stringa piu' lunga in un array di stringhe
    public static String longest(String[] s) {
		String max = " ";//variabile vuota per vedere qual'è la stringa più grande
		for(int i =  0; i< s.length; i++){
			//se max è più piccolo dell ' elemento corrente dell array allora
			if(max.length() < s[i].length()){
				//max è uguale a quell'elemento
				max = s[i];
			}
		}
		return max; // RITORNO MAX
    }

    // ritorna la concatenazione di tutte le stringhe nell'array s
    public static String concatAll(String[] s) {
		String concatenation ="";//variabile vuota per concatenare l'array di stringe
		for(int i = 0; i< s.length; i++){
			concatenation = concatenation.concat(s[i]);
			//COL METODO CONCAT CONCATENO OGNI ELEMENTO DELL'ARRAY
		}
		return concatenation; // RITORNO L'ARRAY CONCATENATO
    }

    // elimina gli spazi iniziali e finali della stringa @s
    public static String trim(String s) {
		int start = 0;// variabile per trovare la lettera iniziale
		int end = 0;//varibile per trovare la lettera finale
		for(int i = 0; i < s.length()&&start == 0; i++){
			if (s.charAt(i) != ' ')//finche non trovo uno spazio
				start = i;//la posizione iniziale è uguale ad indice
		}
		for(int j = s.length()-1 ; j>=0&& end==0; j--){
			if(s.charAt(j)!=' ')//finche non trovo uno spazio
				end = j;//la posizione finale è uguale all'indice
		}
		return s.substring(start,end+1); //RESTITUISCO L'INIZI DELLA STRINGA E LA FINE
    }
	
    // testa i tre metodi
	public static void main(String[] args) {
		//Non darà nessuna stampa dato che se è giusto non stampa niente se è sbagliato stampa sbagliato
		String[] a = {" corto  ", "il piu lungo", "cattivo"};

		String pl = longest(a);
	    if (pl != a[1]) System.out.println("longest (SBAGLIATO) =     |" + pl + "|");

	    String ca = concatAll(a);
	    if (!(ca.equals(a[0]+a[1]+a[2]))) System.out.println("concatAll (SBAGLIATO) =     |" + ca + "|");

	    assert a.length > 0;
	    String tr = trim(a[0]);
	    if (!(tr.equals("corto"))) System.out.println("trim (SBAGLIATO) =     |" + tr + "|");
    }
}