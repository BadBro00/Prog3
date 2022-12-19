/*
                                            |Le basi della programmazione OO|
---------------------------------------------------------------------------------------------------------------------------------------
I concetti alla base della programmazione OO in Java sono:

1) Classe 
2) Oggetto
3) Membro
    i) Attributo
    ii) Metodo
4) Costruttore
5) Package

"Una classe è un’astrazione indicante un insieme di oggetti che condividono le stesse caratteristiche e le stesse funzionalità"
"Un oggetto è un’istanza (ovvero una creazione fisica) di una classe"

Per creare un oggetto di una classe, si usa la keyword new

Per importare classi esterne (ad es, da lib), si usa import

Una classe definisce i metodi che si possono applicare ai suoi oggetti. Il metodo serve a definire una funzionalità che deve avere il concetto che si sta astraendo 
    con la classe
Le variabili istanza sono delle variabili utili a memorizzare lo stato della classe. Ogni oggetto della classe ha il proprio insieme di variabili istanza.
Le variabili istanza sono generalmente dichiarate private, e viene usato l'incapsulamento affinche' solo i metodi della classe possano accedervi.

Un costruttore e' un particolare metodo che crea un oggetto di una classe. Il nome del costruttore e' sempre uguale a quello della classe.
Se non viene fornito un costruttore ad una classe, Java ne fornira' uno di sistema, per permetterci comunque di creare oggetti di quella classe.

/ESERCIZI:
  Creare il codice completo per la classe Greeter ed una classe di test che visualizzi il nome e il cognome 
  
  Implementare una classe BankAccount che permette di gestire un conto bancario contenente un saldo che può essere modificato da depositi e prelievi
    costruttore
    metodo deposit per versare denaro nel conto bancario
    metodo withdraw preleva denaro dal conto bancario
    metodo getBalance ritorna il saldo attuale

  Implementare una classe BankAccountTest per il collaudo della classe BankAccount
    Inserimento denaro
    Prelievo
    Stampa Saldo
    
    
/Domanda: come associare automaticamente un numero di conto in base all’ultimo numero di conto associato?

                                                |TIPI DI VARIABILI|
----------------------------------------------------------------------------------------------------------------------------
In Java, le variabili possono essere:
  i) Istanza: appartengono all'oggetto, possono non essere inizializzate, verra' fornito un valore di default
  ii) Parametri o locali: appartengono al metodo, devono essere inizializzate, o verra' segnalato errore dal compilatore
  
Per accedere al parametro implicito, ovvero l'oggetto con il quale viene invocato il metodo, si puo' usare la keyword this

                                                    |OVERLOADING|
----------------------------------------------------------------------------------------------------------------------------
Una classe puo' avere diversi metodi omonimi, ma con parametri diversi (FIRMA diversa)

Un costruttore puo' invocare un altro costruttore della stessa classe.

Per ottenere o impostare i valori dei campi di un oggetto, si usano i metodi Set e i metodi Get

In Java, i numeri ed i riferimenti ad un oggetto sono passati per valore (pass-by-value)

Un metodo statico non ha parametro implicito, mentre un parametro static non appartiene a nessun oggetto, ma alla classe stessa.
*/
//ESERCIZI SVOLTI:
//1) Greeter&GreeterTest
//---------------------------------------------------------------
//Classe Greeter
public class Greeter{
  public void Greet(String name, String surname){
    System.out.println("Hello, "+name+" "+surname+"!\n");
  }
}
//Classe GreeterTest
import java.util.Scanner;
public class GreeterTest{
  String name,surname;
  public static void main(String args[]){
    Scanner sc = new Scanner(System.in);
    System.out.println("Insert your name:\n");
    name = sc.nextLine();
    System.out.println("Insert your surname:\n");
    surname = sc.nextLine();
    Greeter G = new Greeter();
    G.Greet(name,surname);
  }
}
//--------------------------------------------------------------------
//2) BankAccount
//--------------------------------------------------------------------
import java.util.Scanner;
public class BankAccount{
  public double balance = 0;
  public double amnt = 0;
  public static void main(String args[]){
    Scanner sc = new Scanner(System.in);
    public int choice = 0;
    System.out.println("Choose operation:\n1)Deposit\n2)Withdraw\n3)Balance\n4)Exit\n");
    while(choice != 4){
      choice = sc.nextInt();
      switch(choice){
        case 1:
          System.out.println("Deposit\nInsert amount:\n");
          amnt = sc.nextDouble();
          this.Deposit(amnt);
          break;
        case 2:
          System.out.println("Withdraw\nInsert amoutn:\n");
          amnt = sc.nextDouble();
          this.Withdraw(amnt);
          break;
        case 3:
          System.out.println("Balance\n"+this.Balance());
          break;
        case 4:
          return;
        default:
          System.out.println("|INVALID CHOICE|\n");
          break;
      }
    }
  }
  public void Deposit(double amnt){
    this.balance += amnt;
  }
  public void Withdraw(double amnt){
    this.balance -= amnt;
  }
  public double Balance(){
     return this.balance;
  }
}
//--------------------------------------------------------------------
