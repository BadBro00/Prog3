/*
                                          |Classi innestate|
      Classe definita all’interno di un’altra classe
      Risparmio di codice
      La classe interna ha accesso ai membri della classe esterna anche se dichiarati private
      Possibilità di utilizzare i modificatori d’accesso come per i membri di una classe
      */
public class Outer {
  private String messaggio = "Nella classe ";
  private void stampaMessaggio() {
    System.out.println(messaggio + "Esterna");
  }
  /* la classe interna accede ai membri privati della classe che la contiene */
  public class Inner {
    public void metodo() {
      System.out.println(messaggio + "Interna");
    }
    public void chiamaMetodo() {
      stampaMessaggio();
    }
    //...
  }
//...
}
/*

Per utilizzare le calpublic class Outer {
private String messaggio = "Nella classe ";
private void stampaMessaggio() {
System.out.println(messaggio + "Esterna");
}
/* la classe interna accede ai membri privati
della classe che la contiene */
public class Inner {
public void metodo() {
System.out.println(messaggio + "Interna");
}
public void chiamaMetodo() {
stampaMessaggio();
}
//. . .
}
//. . .
}
/*
  La classe innestata:
    Deve avere un identificatore differente dalla classe che la contiene
    Si possono utilizzare tutti i modificatori d’accesso per dichiarare una classe innestata
    Per istanziare oggetti di una classe innestata (non privata) al di fuori della classe in cui è stata dichiarata
    Ha accesso sia alle variabili d’istanza sia a quelle statiche della classe in cui è dichiarata
  */
Outer outer = new Outer();
Outer.Inner inner;
inner = outer.new Inner();
/*
      Proprieta' delle classi innestate
        Una classe innestata si può dichiarare anche all’interno di un metodo, viene detta classe locale (“local class”)
        Se viene dichiarata statica diventa automaticamente una “top-level class”:
            -Non sarà più definibile come classe interna
            -Non godrà della proprietà di poter accedere alle variabili d’istanza della classe in cui è definita
        Solo se dichiarata statica può dichiarare membri statici
        Può essere dichiarata astratta
        Nei metodi di una classe interna è possibile utilizzare il reference this
        Se compiliamo una classe che contiene una classe interna, saranno creati due file.
                                                
                                                |Classi Anonime|
  Sono classi innestate senza nome
  Godono delle stesse proprietà delle classi innestate
  Sono utilizzate per gli stessi scopi
  
  La dichiarazione richiede
    Contestualmente alla dichiarazione della classe venga anche istanziato un suo oggetto
    L’esistenza di una sua superclasse o di una sua superinterfaccia di cui sfrutterà il costruttore (virtualmente nel caso di un’interfaccia)
    
Una classe anonima:
  Viene dichiarata con lo scopo di fare override di uno o più metodi della classe che estende anche le classi anonime si possono dichiarare all’interno di metodi
  Fa accedere alle variabili locali e ai parametri, solo se dichiarati final
  */
public class Outer4 {
  private String messaggio = "Nella classe ";
    // Definizione della classe anonima e sua istanza
    ClasseEsistente ce = new ClasseEsistente() {
      @Override
      public void metodo() {
        System.out.println(messaggio+"anonima");
      }
    }; //Si noti il ";"
  //...
}
// Superclasse della classe anonima
public class ClasseEsistente {
  public void metodo() {
    System.out.println("Nella classe esistente");
  }
}
/*
                          |ENUM|
L'enum fornisce un tipo di enumerazione, per il quale un oggetto puo' avere valori specifici e preimpostati.*/
public enum MiaEnumerazione{
UNO, DUE, TRE; // elementi o valori
}
/*
Questi si possono salvare col suffisso .java

Un’enumerazione viene trasformata dal compilatore in una classe che estende la classe astratta Enum ereditiamo dalla classe java.lang.Enum diversi metodi*/
System.out.println(MiaEnumerazione.UNO); //MiaEnumerazione <- toString <- Enum
/*
Ogni elemento di MiaEnumerazione è di tipo MiaEnumerazione
Non si può estendere o estendere un’altra classe
È invece possibile far implementare un’interfaccia
*/
//Interfaccia
public interface Numeratore {
  void stampaIndice();
}
//Enumerazione
public enum MiaEnumerazione2 implements Numeratore {
  UNO, DUE, TRE;
  @Override
  public void stampaIndice() {
    System.out.println("Indice: "+this.ordinal());
  }
}
//Polimorfismo
Numeratore n = MiaEnumerazione2.DUE;
n.stampaIndice();
/*
E’ possibile anche creare
  Variabili
  Metodi
  Costruttori

Possono essere usati dai valori dell’enum
  Overload
  Private
  Tipi innestati
  Classi
  Interfacce
  Enumerazioni
  Annotazioni

Essendo Enum una classe, e' possibile creare Enumerazioni innestate:*/
public class Volume {
  public enum Livello {ALTO, MEDIO, BASSO};
    // implementazione della classe . . .
  public static void main(String args[]) {
    System.out.println(Livello.ALTO);
  }
}
/*
-------------------------------|ESERCIZIO|------------------------------
Creare un'interfaccia CurrencyConverter con un metodo convert:
    Si occuperà di effettuare le conversioni tra valute
Creare una classe EURConverter che implementa CurrencyConverter: 1 USD = 0,97 EUR
In BankAccount creare una variabili tramite classe anonime ed una classe innestata:
    JPYConverter di tipo CurrencyConverter (classe anonima): 1 USD = 139,96 JPY (yen)
    GBPConverter di tipo CurrencyConverter (classe innestata): 1 USD = 0,85 GBP (sterlina)
Inserire un metodo convertTo che capisca tramite enumeration il tipo di conversione da eseguire: 
    enum Currency { . . . } 
