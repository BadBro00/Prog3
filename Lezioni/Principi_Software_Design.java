/*
                                           |Metodo Agile|
  Le caratteristiche di una cattiva progettazione da evitare sono:

      Rigidità
        Il sistema è difficile da cambiare poiché ogni cambiamento si ripercuote su molte parti del sistema

      Fragilità
        Un cambiamento di una parte del sistema comporta la rottura di una parte inaspettata

      Immobilità
        E' difficile riutilizzare qualche componente in un’altra applicazione perché non può essere estrapolata dall’applicazione corrente
        
      Viscosità
        L’ambiente di sviluppo è tenuto insieme in modo inappropriato
  
      Complessità inutile
        Strutture di codice non necessarie attualmente ma probabilmente in futuro

      Ripetizioni inutili
        Inutili Cut and Paste
        
Alcuni di questi problemi derivano da dipendenze mal gestite
Il codice è visto come un groviglio “spaghetti code”
I linguaggio OO permettono di gestire le dipendenze :

  Interfacce
    Rompono o invertono la direzione di certe dipendenze
  Polimorfismo
    Invocano funzioni senza dipendere dai moduli che le contengono

                                                |Refactoring|
Tecnica strutturata per modificare la struttura interna di porzioni di codice senza modificarne il comportamento esterno
  Miglioramenti:
    Leggibilità
    Manutenibilità
    Riusabilità
    Estendibilità
    Riduzione della sua complessità
 Introduzione a posteriori di design pattern
 
 Elemento importante delle principali metodologie emergenti di sviluppo del software
      Metodologie agili
      Extreme programming
      Test driven development
      
      
      
      |Clean Code|
            No bloat
            No duplication
            Self-Explanatory
            Covered with tests
          Clean code as result
          
      |Refactoring|
            Set of small changes
            One change at a time
            Changes should not add new stuff
            Changes should not break autotest
         Clean code as result
         
        Quando
       Rule of three : Fai qualche cosa di simile la terza volta
       Aggiunta di una caratteristica
       Quando viene fissato un Bug
       Review del codice
       
       
                                          |PRINCIPI SOLID|
  SOLID
Acronimo che si riferisce ai primi 5 principi dello sviluppo del software (Michael Feathers)
  Single Responsability Principle
  Open-Closed Principle
  Liskov Substitution
  Interface Segregation
  Dependency Inversione
Linee guida per lo sviluppo di software estendibile e manutenibile

        
        |SRP|
  Una classe dovrebbe avere un solo motivo per cambiare        
  Ogni elemento di un programma (classe, metodo, variabile) deve avere una sola responsabilità
  Tale responsabilità debba essere interamente incapsulata dall’elemento stesso
  */
// single responsibility principle
interface IEmail {
  public void setSender(String sender);
  public void setReceiver(String receiver);
  public void setContent(IContent content);
}
interface IContent {
  public String getAsString();}
  class Content implements IContent {
  public String getAsString() {...}
}
class Email implements IEmail {
  public void setSender(String sender) {// set sender; }
  public void setReceiver(String receiver) {// set receiver; }
  public void setContent(IContent content) {// set content; }
}
/*
    
        |OCP|
  Quando scriviamo una classe dobbiamo garantire che per una sua estensione non c’è bisogno di cambiare la classe stessa
  Il design e la scrittura del codice dovrebbero essere fatti in modo che la nuova funzionalità dovrebbe essere aggiunta 
    con cambiamenti minimi nel codice esistente 
    
Può essere assicurato usando classi astratte e classi concrete per implementare il loro comportamento*/
    // Open-Close Principle

    // Open
-Close Principle
class GraphicEditor{
  public void drawShape (Shape s) {
      s.draw();
  }
}
class Shape{
  abstract void draw();
}
class Rectangle extends Shape {
  public void draw(){
    // draw the rectangle
  }
}/*

        |LSP|
Se q(x) è una proprietà che si può dimostrare essere valida per oggetti x di tipo T,
allora q(y) deve essere valida per oggetti y di tipo S dove S è un sottotipo di T
    
Dobbiamo essere sicuri che nuove classi derivate stanno estendendo le loro classi base senza cambiare il comportamento
Le classi derivate dovrebbero essere capaci di rimpiazzare le classi base senza cambiamenti nel codice



        |ISP|
Un client non dovrebbe dipendere da metodi che non usa
E' preferibile che le interfacce siano molte, specifiche e piccole (composte da pochi metodi)
  piuttosto che poche, generali e grandi
*/
interface IWorkable {
  public void work();
}
interface IFeedable{
  public void eat();
}
class Worker implements IWorkable, IFeedable{
  public void work() {
    // ....working
  }
  public void eat() {
    //.... eating in launch break
  }
}

class Robot implements IWorkable{
  public void work() {
    // ....working
  }
}
class SuperWorker implements IWorkable, IFeedable{
  public void work() {
    //.... working much more
  }
  public void eat() {
    //.... eating in launch break
  }
}
class Manager {
  Workable worker;
  public void setWorker(Workable w) {
    worker=w;
  }
  public void manage() {
    worker.work();
  }
}/*

        |DIP|
I moduli di alto livello non dovrebbero dipendere dai moduli di basso livello. Entrambi dovrebbero dipendere dalle astrazioni.
Le astrazioni non dovrebbero dipendere dai dettagli.
I dettagli dovrebbero dipendere dalle astrazioni.

Per lo sviluppo di applicazioni software consideriamo
  Classi a basso livello per le operazioni primarie
  Classi ad alto livello per incapsulare la logica complessa
*/
    // Dependency Inversion Principle
interface IWorker{
  public void work();
}
class Worker implements IWorker {
  public void work() {
    // ....working
  }
}
class SuperWorker implements IWorker{
  public void work(){
    //.... working much more
  }
}
class Manager{
  IWorker worker;
  public void setWorker (IWorker w) {
    worker = w;
  }
  public void manage(){
    worker.work();
  }
}
/*
          |LOD|
Ogni unità di programma dovrebbe conoscere solo poche altre unità di programma strettamente correlate;
Ogni unità di programma dovrebbe interagire solo con le unità che conosce direttamente.

Un oggetto A può richiedere un servizio (ovvero, chiamare un metodo) di un altro oggetto B ma l’oggetto A non può usare l’oggetto B per
  raggiungere un terzo oggetto C che possa soddisfare le sue richieste
