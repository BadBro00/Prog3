/*
                              |Class Diagram|
  Il Class Diagram permette di denotare il contenuto statico e le relazioni tra classi
  Il Class Diagram permette di visualizzare relazioni e dipendenze strutturali che non sono riscontrabili scrivendo codice
  */
public class Dialler {
  private Vector digits;
  int nDigits;
  public void digit (int n);
  protected boolean recordDigit (int n);
}

public class Phone {
  private Button itsButtons[15];
}

                                /*|Stereotipi di classe|

  Durante la rappresentazione in UML, viene posto lo stereotipo (sopra il nome) :
      <<interface>> , se l'oggetto UML e' un'interfaccia
      <<utility>> , se l'oggetto UML e' una classe contenente solo costanti
      <<creates>> , se la classe ha una classe innestata che crea un suo oggetto
      <<local>> , se la classe ha un metodo che crea un oggetto di una classe locale
      <<parameter>> , se la classe ha un metodo che utilizza un oggetto di un'altra classe
      <<delegates>> , se la classe ha un metodo che utilizza un metodo f utilizzando l'implementazione di un'altra classe
      <<anonymous>> , se la classe e' esterna ad una classe anonima.

                                  |Classi Astratte|
  Essendo la classe astratta una classe normale avente un metodo astratto, si indica in modo simile alle classi normali.
  
            nomeclasse
                {abstract}
            ----------------
            metodo{abstract}
            
                                  
                                  |Aggregazione|
  
  Per rappresentare l'aggregazione 'is part of', si inserisce un rombo VUOTO dalla classe 'intero', che fa da base di freccia verso la classe 'parte'
  
                                
                                  |Composizione|
                                  
  Per rappresentare la composizione , si inserisce un rombo NERO dalla classe 'intero', che fa da base di freccia verso la classe 'parte'
  
                                    |Molteplicita'|
                                    
  Per rappresentare la molteplicita', si utilizza una freccia recante un numero intero al di sopra.
  
                                    |Classi Nascoste|
                                    
  Una classe e' nascosta quando e' dichiarata all'interno di un'altra classe. In questo caso, si usa un tondo con croce che fa da base della freccia verso la classe interna.
  
                                    |
