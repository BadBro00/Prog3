/*          
                                              |Gestione delle Eccezioni|
                                              

    Eccezione : 
        situazione imprevista che può presentarsi durante il flusso di un’applicazione
        
    Errore : 
        come una situazione imprevista non dipendente da un errore commesso dallo sviluppatore
        
    Asserzione : 
        condizione che deve essere verificata affinché lo sviluppatore consideri corretta una parte di codice
        abilitare in fase di sviluppo e test, ed eventualmente disabilitare in fase di rilascio
        
        
        Schema semplificato :
  i) Programma genera un’eccezione
  ii) Lancia l’eccezione (throw) e il gestore automatico della JVM interrompe il programma
  iii) Il nostro codice cattura l’eccezione (catch)
*/
public class Ecc1 {
  public static void main(String args[]) {
    int a = 10;
    int b = 0;
    try {
      int c = a/b;
      System.out.println(c);
    }
    catch (ArithmeticException exc) {
      System.out.println("Divisione per zero...");
    }
  }
}
//Si puo' usare anche
catch (ArithmeticException exc) {
  exc.printStackTrace(); }
}
//Che cattura l'eccezione senza la terminazione del programma
/*

L'eccezione piu' generica da gestire e' la seguente : */
catch (Exception exc){
  exc.printStackTrace();
}
/*
Questo codice gestisce qualunque tipo di eccezione capiti

La keyword 'finally', fornisce un'istruzione che viene eseguita con o senza eccezione.*/
finally {
  System.out.println("Operazione terminata");
}
/*
                                    |Eccezioni Note|
    NullPointerException                                       Ci si riferisce ad un valore NULL
    ArrayIndexOutOfBoundsException                             L'index e' andato oltre il massimo consentito
    ClassCastException                                         Problema di casting di oggetti di una classe
    IOException                                                Eccezione di I/O
    FileNotFoundException, EOFException                        Eccezione di file (Not Found / EOF)
    SQLException                                               Eccezione del linguaggio SQL
    ConnectException                                           Eccezione di connessione [al DB?]
    ...
    
E' possibile definire eccezioni ulteriori, 'customizzate' dall'utente*/
//DEFINIZIONE
public class PrenotazioneException extends Exception {
  public PrenotazioneException() {
    // Il costruttore di Exception chiamato inizializza la
    // variabile privata message
    super("Problema con la prenotazione");
  }
  public String toString() {
    return getMessage() + ": posti esauriti!";
  }
}
//LANCIO ECCEZIONE
PrenotazioneException exc = new PrenotazioneException();
throw exc;
//oppure
throw new PrenotazioneException();
//Per definire un metodo che lanci un'eccezione:
specificatoreDiAccesso valoreRestituito nomeMetodo (tipoParametro nomeParametro, . . .) throws ClasseEccezione, ClasseEccezione{
  //...
}
//Eccezioni Multiple
public void read(BufferReader in) throws IOException, ClassNotFoundException {
  //...
}
/*
                                        |Rimozione Warning|
*/
@SuppressWarnings("<warning>")
/*
Con questo metodo, rimuoviamo un possibile warning che viene fornito a compilazione

                                              |Override|
                                              
Facendo l'override di un metodo :
  Non è possibile specificare clausole throws su eccezioni che il metodo base non comprende nella propria clausola throws
  E' possibile da parte del metodo che effettua override dichiarare una clausola throws ad eccezioni che sono sottotipi di eccezioni,
    comprese dal metodo base nella propria clausola throws

                                              |Asserzioni|
  Istruzione che permette di testare eventuali comportamenti previsti in un’applicazione
  Richiede sia verificata un’espressione booleana che lo sviluppatore ritiene vada verificata nel punto in cui viene dichiarata, bug se negativa
  
 */
assert espressione_booleana;
//oppure
assert espressione_booleana: espressione_stampabile;

//Esempio
assert b > 0;
// equivalente a
if (!(b>0)) {
  throw new AssertionError();
}
/*
