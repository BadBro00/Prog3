/*
                                                |PARADIGMI DELLA PROGRAMMAZIONE OO|
------------------------------------------------------------------------------------------------------------------------------
I paradigmi principali della programmazione OO sono:

  1)Incapsulamento
  2)Ereditarieta
  3)Polimorfismo
  4)Astrazione
  5)Riuso
  
            Astrazione:
Ci sono 3 tipi di astrazione:
    i) Astrazione Funzionale : Implementazione di un metodo
    ii) Astrazione dei Dati : definiamo una classe, raccogliendo in essa solo le caratteristiche e le funzionalità essenziali degli oggetti che essa deve definire
    iii) Astrazione del Sistema : definiamo un’applicazione nei termini delle classi essenziali che devono soddisfare agli scopi dell’applicazione stessa 


            Riuso:
Il riuso e' una conseguenza dell'astrazione e dell'incapsulamento. Permette appunto, di ri-utilizzare le classi e i metodi di una classe, in piu' oggetti.

            Incapsulamento:
Grazie all'incapsulamento, una classe riesce ad ottenere caratteristiche di robustezza, indipendenza e reusabilita'.
E' la chiave principale della programmazione OO.
La filosofia dell'incapsulamento prevede un accesso controllato ai dati mediante metodi che possano accedere ai dati senza usura e con correttezza.
Gli attributi vengono dichiarati private e sono accessibili solo da quei metodi (set & get). L'accesso potra' inoltre essere fornito attraverso un'apposita interfaccia.
L'incapsulamento puo' essere
        Funzionale:
    Usando metodi privati, che potranno essere richiamati solo dai metodi della stessa classe, che potranno anche essere public
    Permette agli oggetti di una classe di accedere in modo pubblico ai rispettivi metodi privati.
    
        Parametro Implicito:
    All'interno di un metodo e' possibile dichiarare ed utilizzare nuove variabili. Queste hanno scope locale alla funzione e vengono distrutte dopo l'utilizzo.
    Java permette di creare parametri impliciti con lo stesso nome delle variabili membro della classe, che vengono messi in ombra dalle nuove variabili.
    L'accesso alle variabili membro viene effettuato tramite il parametro implicito this.
    
        Modificatori d'Accesso:
    I modificatori d'accesso sono:
       Public : permette l'accesso a tutti i campi ed i metodi della classe madre, tranne i private. Tutti i campi/valori rimangono dei loro modificatori
       Protected : permette l'accesso ai campi public e protected della classe madre. Gli attributi public diventano protected, e i protected private.
       Private : non permette l'accesso a nessun metodo o campo della classe madre.
       
        Static:
    Un metodo static non potranno interagire con gli oggetti, ma solo con la classe. Potranno interagire con le variabili statiche.
    Un campo static e public puo' essere considerato come variabile globale.
*/

public class Lezione5{
  public static int due = 2;
  public double tre = 3.0;
  public static void main(String args[]){
    System.out.println("Ciao\n");
    System.out.println("Il valore della var 'due', richiamato dal main, e': "+due+"\n");
    System.out.println("Il valore della var 'tre', richiamato dal main, e': "+tre+"\n");
    System.out.println("Richiamo la function 'print_Due'\n");
    print_Due();
  }
  public static void printa_Due(){
    System.out.println("Il valore della var 'due', richiamato dalla function, e': "+due+"\n");
  }
}
