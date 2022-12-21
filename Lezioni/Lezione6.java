/*
                                      |Ereditarieta' ed Interfacce|
------------------------------------------------------------------------------------------------------                                      
Nel mondo reale classifichiamo tutto in classi e sottoclassi.

Possiamo creare una sottoclasse usando la keyword:
                extends
*/
public class Libro{
  //Codice
}

public class Romanzo extends Libro{
  //Codice
}

public class Saggio extends Libro{
  //Codice
}
/*
Esercizio:
  Creare una sottoclasse di BankAccount "SavingsAccount" per descrivere un conto bancario che garantisce un tasso fisso (costante, nel codice) sul bilancio.
        
        AddInterest(){
          interest = (balance * interestRate) / 100;
        }
  Codice di riferimento : BankAccount.java
  
Esercizio : 
  Modificare BankAccount o SavingAccounts inserendo un array di conti corrente.
  [Tenere in considerazione la possibilità di aggiungere una nuova classe Bank e che tipo di relazione è necessaria con tra gli elementi]
    Bisogna:
      Stampare il bilancio TOTALE della banca.
      Stampare il numero di depositi TOTALI della banca.
      Stampare il numero di conto usando SEMPRE dieci cifre.
      Tassare, una tantum, i conti correnti con bilancio maggiore di 5000EUR.
      Convertire la valuta di un singolo conto corrente (switch).
-------------------------------------------------------------------------------------------------------------------      
                                    |Variabili d'Istanza e Metodi|
Per descrivere i metodi di una sottoclasse, abbiamo tre possibilita':
      i) Sovrascrivere o ridefinire i metodi della superclasse, tramite un metodo con stessa FIRMA.
      ii) Ereditando metodi della superclasse.
      iii) Ridefinendo nuovi metodi.
      
Per definire le variabili istanza in una sottoclasse, possiamo ereditare variabili dalla superclasse:
      Tutte le variabili istanza della superclasse sono ereditate automaticamente.
      Possiamo definire nuovi variabili istanza con scope locale alle sottoclassi
      Le variabili istanza NON possono essere ridefinite.
Una sottoclasse non ha accesso alle variabili istanza delle superclassi. Per modificare una variabile istanza, bisogna usare i metodi pubblici della superclasse.

Esercizio:
    Costruire una classe CheckingAccount che addebbita commissioni ogni tre transazioni.
    CheckingAccount e SavingsAccount devono essere sottoclassi di BankAccount.
    [Codice di riferimento : CheckingAccount.java]
    La classe CheckingAccount utilizza un metodo aggiuntivo "deductFees", ha un'ulteriore variabile istanza 'transactionCount', e sovrascrive Deposit e Withdraw:
    
Esercizio:
    Costruire una classe TimeDepositAccount, sottoclasse di SavingsAccount
    [Codice di riferimento : TimeDepositAccount.java]
    
-------------------------------------------------------------------------------------------------------------------
                                      |Modificatore final|
Tramite il modificatore final:
      Una variabile diviene costante.
      Su un metodo non e' applicabile l'override (non e' piu' ridefinibile).
      Una classe non puo' essere estesa.
      Le variabili ed i parametri locali di metodi non saranno modificabili localmente.
      
-------------------------------------------------------------------------------------------------------------------
                                      |Relazione "is a"|
In Java non e' propriamente definita l'ereditarieta' multipla, in Java 8 e' applicabile alle interfacce.

L'ereditarieta' non e' applicabile ai costruttori, che come prima istruzione invocano un costruttore della superclasse.
Per invocare un metodo della superclasse, si usa la keyword 'super'
*/
public void richiamaSuper(){
   super.Nome_Metodo();
}
/*
-------------------------------------------------------------------------------------------------------------------
                                      |Superclasse 'Object'|
La superclasse Object [import java.lang] astrae il concetto di 'oggetto generico'. Essa e' la superclasse di ogni classe.
Tutte le classi estendono ed ereditano i membri da Object. 

-------------------------------------------------------------------------------------------------------------------
                                      |Conversioni|
In Java, i riferimenti a sottoclasse possono essere convertiti in riferimenti a superclasse.
*/
SavingsAccount collegeFund = new SavingsAccount(10);
BankAccount anAccount = collegeFund;
Object anObject = CollegeFund;
/*
Le tre variabili si riferiscono sempre allo stesso oggetto [collegeFund->SavingsAccount(10)], ma non e' possibile ottenerne tutte le informazioni.
[Codice di riferimento : AccountTest.java]

I membri piu' utili della superclasse Object sono:
*/
String toString(); //Restituisce una rappresentazione dell'oggetto in stringa
boolean equals(Object otherObject); //Ritorna true se l'indirizzo di memoria dei due oggetti e' uguale
Object clone(); //Crea una copia completa dell'oggetto
/*

-------------------------------------------------------------------------------------------------------------------
                                      |Override|
Per essere applicati alle nostre classi, i metodi sopra citati devono essere 'sovrascritti'.
*/
//BankAccount
public String toString() {
  return getClass().getName()+ “[balance=“ + balance + “]”;
}
//Coin
public boolean equals (Object otherObject) {
Coin other = (Coin) otherObject
  return name.equals(other.name) && value == other.value
}
//BankAccount
public Object clone() {
BankAccount cloned = BankAccount();
  cloned.balance = balance;
  return cloned;
}
/*
-------------------------------------------------------------------------------------------------------------------
                                      |Metodi e classi Astratte|
Un metodo astratto e' un metodo cui non viene definita l'implementazione.
Questa tecnica obbliga i programmatori delle sottoclassi a definirla in ciascuna.
Non e' possibile costruire oggetti di classi aventi metodi astratti, ma se in una sottoclasse si implementa il metodo, si puo' istanziare la sottoclasse.
Come vantaggio, obbliga le sottoclassi ad implementare un comportamento.
Viene usao il modificatore 'abstract', che per le classi puo' essere inteso come "l'opposto del modificatore final".

Una classe astratta puo' avere:
    Campi non statici e final
    Metodi non pubblici [protected/private]
    Un costruttore
    Metodi astratti.
      Una classe che contiene metodi astratti dev'essere FORZATAMENTE dichiarata abstract

Quando estendiamo (o deriviamo) da una classe astratta:
  La classe derivata, per essere istanziata, DEVE fornire un'implementazione di tutti i metodi astratti.
  Se non vengono definite le implementazioni, la sottoclasse dev'essere dichiarata abstract.
  
-------------------------------------------------------------------------------------------------------------------
                                      |Interfacce|
Un'interfaccia e' un'evoluzione delle classi astratte.
Fino a Java 7, non poteva contenere:
  Metodi dichiarati implicitamente public e abstract
  Variabili dichiarate implicitamente public,static e final.
  
Le interfacce si devono scrivere all'interno di file con lo stesso nome dell'interfaccia che definiscono.
Un'interfaccia non e'istanziabile, per essere usata va ESTESA.

In un'interfaccia:
  Tutti i metodi sono abstract:
    Hanno un nome, un elenco di parametri, un tipo di ritorno ma non hanno implementazione.
  Tutti i metodi sono public.
  Non ci sono variabili istanza.
  
Per realizzare un'interfaccia, una classe deve implementare tutti i metodi della stessa.
[Codici di riferimento : DataSetTest.java, DataSet.java, BankAccount.java, Coin.java, Mearurable.java, Purse.java]

Solo un'altra interfaccia puo' estendere un'interfaccia, ed e' possibile costruire gerarchie di interfacce.
Abbiamo bisogno che le classi ereditino dalle interfacce, tramite la keyword 'implements'.
Si possono implementare un numero indefinito di interfacce, rendendo di fatto attuabile l'eredita' multipla, ma solo in questo caso.
Una classe puo' implementare un'interfaccia che puo' estendere un'altra interfaccia.

Con Java 8 le interfacce:
    Possono aver definiti al loro interno metodi statici, che non vengono ereditati.
    Possono avere al loro interno metodi 'default'.
    Possono essere implementate molteplicitamente da un'unica classe. Le classi possono ereditare solo la parte 'funzionale' (i metodi) e le costanti (final).
    
Bisogna stare attenti con queste ereditarieta' ed implementazioni, altrimenti si incorre nel Diamond Problem, ovvero un caso in cui una classe eredita da 
  due interfacce, che ne estendono una e ne ridefiniscono un metodo. In questo caso, richiamando il metodo, non si sa a quale interfaccia si fa riferimento.
Bisogna quindi ridefinire il metodo per specificarne l'implementazione.
*/
public sottoclasse implements Interfaccia1,Interfaccia2{
  //Codice
  public void metodo(){
    Interfaccia1.super.metodo();
    Interfaccia2.super.metodo();
  }
  //Metodo
}
/*
-------------------------------------------------------------------------------------------------------------------
                                      |Conflitto di Nomi|
In una classe che implementa piu' interfacce:
    Tra un metodo astratto ereditato da Interf1 ed un metodo concreto ereditato da Interf2:
      Soluzione : ridefinire il metodo della classe specificandone l'implementazione.
    Tra due metodi astratti:
      Soluzione : ridefinire il metodo nella sottoclasse.
In una classe che implementa un'interfaccia che ne estende un'altra:
    Nella classe che le implementa c'e' il conflitto di nomi:
      Soluzione : viene ereditata l'implementazione dell'interfaccia piu' specifica.
In una classe che eredita un conflitto di FIRME tra un metodo ereditato da un'interfaccia estesa ed un metodo della classe implementata:
    Soluzione : viene ereditata l'implementazione della classe, anche se astratta.
    
-------------------------------------------------------------------------------------------------------------------
                                      |Classi vs Interfacce|
                                      
1) Una classe può implementare un numero arbitrario di interfacce, ma può ereditare al più da una classe astratta
2) Una classe astratta può avere metodi non astratti. Tutti i metodi di un’interfaccia sono invece astratti
3) Una classe astratta può dichiarare variabili istanza che saranno ereditate da tutte le sottoclassi. Un’interfaccia può definire solo campi static final
4) Una classe astratta può definire dei costruttori, un’interfaccia no
5) Una classe astratta può avere metodi di visibilità protected, private, o non specificata (package); ogni metodo di un’interfaccia dev’essere public
6) Una classe astratta eredita da Object, anche metodi come clone() ed equals()

                                      |Stub dell'interfaccia|
E' possibile implementare uno 'stub' per un'interfaccia che specifica una collezione di metodi di notifica.
Lo 'stub', e' una classe che implementa i metodi vuoti.
E' possibile l'ereditarieta' dallo stub, tramite overriding dei metodi importanti all'applicazione
[Classe WindowsAdapter di java.awt.event]

