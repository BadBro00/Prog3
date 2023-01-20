/*
                                  1 | DESIGN PATTERN |

            I Design Pattern rappresentano soluzioni di progettazione generiche
            applicabili a problemi ricorrenti all’interno di contesti eterogenei
            

                                      | GoF |

  i) Nome;
  ii) Problema d'applicazione;
  iii) Soluzione;
  iv) Conseguenze;
  
            
            | DESCRIZIONE PATTERN |
         a) Nome e classificazione
         b) Scopo
         c) Nomi alternativi
         d) Motivazione
         e) Applicabilita'
         f) Struttura
         g) Partecipanti
         h) Collaboratori
         i) Conseguenze
         j) Implementazione
         k) Codice d'esempio
         l) Pattern correlati
         m) Utilizzi noti
         
         
            | CATEGORIE GoF |
       
      - Pattern Creazionali
      - Pattern Strutturali
      - Pattern Comportamentali
      
      
                                              | PATTERN NOTI |
        |-----------------------------------------------------------------------------------------------------|
        |             Scopo     |      CREAZIONALI      |     STRUTTURALI     |   COMPORTAMENTALI             |
        | Raggio d'azione       |                       |                     |                               |
        ------------------------|-----------------------|---------------------|-------------------------------|
        |            Class      |       Factory         |      Adapter(class) |      Interpreter              |
        |                       |                       |                     |      Template method          |
        |-----------------------|-----------------------|---------------------|-------------------------------|
        |            Object     |      Abstract Factory |      Adapter(object)|      Chain of Responsibility  |
        |                       |      Builder          |      Bridge         |      Command                  |
        |                       |      Prototype        |      Composite      |      Iterator                 |
        |                       |      Singleton        |      Decorator      |      Mediator                 |
        |                       |                       |      Facade         |      Memento                  |
        |                       |                       |      Flyweight      |      Observer                 |
        |                       |                       |      Proxy          |      State                    |
        |                       |                       |                     |      Strategy                 |
        ------------------------------------------------------------------------------------------------------|
        
        
        
        
                                              |COMPORTAMENTALI|
  
  
                  |Chain of Responsability|*/

//Classe astratta dell'Handler, che gestira' le richieste, tramite il metodo astratto handleRequest
public abstract class Handler{
	protected Handler ©;
	public void setSuccessor(Handler successor){
		m_successor = successor;
	}
  public abstract void handleRequest(Request request);
}
//Primo handler, che estende la classe astratta e ne implementa il metodo
public class ConcreteHandlerOne extends Handler{
     //Gestisce solamente i casi in cui il value della request sia negativo
     public void handleRequest(Request request){
		  if (request.getValue() < 0){
        //if request is eligible handle it System.out.println("Negative values are handled by ConcreteHandlerOne:");
        System.out.println("\t ConcreteHandlerOne.HandleRequest : " + request.getDescription() + request.getValue());
		  }else{
			  m_successor.handleRequest(request);
		  }
	  }
 }
//Secondo handler, che estende la classe astratta e ne implementa il metodo
public class ConcreteHandlerTwo extends Handler{
  //Gestisce solamente il caso in cui il value della request sia positivo
  public void handleRequest(Request request){
      if (request.getValue() > 0){
        //if request is eligible handle it System.out.println(”Positive values are handled by ConcreteHandlerTwo:");
        System.out.println("\t ConcreteHandlerTwo.HandleRequest : " + request.getDescription() + request.getValue());
		  }else{
			  m_successor.handleRequest(request);
		  }
	  }
 }
//Terzo handler, che estende la classe e ne implementa il metodo
public class ConcreteHandlerThree extends Handler{
  //Gestisce solamente il caso in cui il value della request sia 0
  public void handleRequest(Request request){
		if (request.getValue() == 0){
      //if request is eligible handle it System.out.println(”Zero values are handled by ConcreteHandlerThree:");
      System.out.println("\t ConcreteHandlerThree.HandleRequest : " + request.getDescription() + request.getValue());
		}else{
			m_successor.handleRequest(request);
		}
	}
}
//Classe della request
public class Request {	
	private int m_value;
	private String m_description;
	public Request(String description, int value){
		m_description = description;
		m_value = value;
	}
	public int getValue(){
		return m_value;
	}
	public String getDescription(){
		return m_description;
	}          
}
//Main del programma
public class Main {
	public static void main(String[] args) {
	// Setup Chain of Responsibility
	Handler h1 = new ConcreteHandlerOne();
	Handler h2 = new ConcreteHandlerTwo();
	Handler h3 = new ConcreteHandlerThree();
	h1.setSuccessor(h2);
	h2.setSuccessor(h3);
	// Send requests to the chain
	h1.handleRequest(new Request("Negative Value ", -1));
	h1.handleRequest(new Request("Zero Value ",  0));
	h1.handleRequest(new Request("Positive Value ",  1));
	h1.handleRequest(new Request("Positive Value ",  2));
	h1.handleRequest(new Request("Negative Value ", -5));	    
	}
}
/*--------------------------------------------------------------------------
                       |COMMAND|*/
import java.util.*;

// Invoker.
class Agent {
  //private ArrayList m_ordersQueue = new ArrayList();  
  //private LinkedList m_ordersQueue = new LinkedList();  
  Queue m_ordersQueue = new LinkedList();
  public Agent() {}
  void placeOrder(Order order) {
    m_ordersQueue.add(order);
	  m_ordersQueue.remove();
    order.execute();
  }    
}
//ConcreteCommand Class.
class BuyStockOrder implements Order {
  private StockTrade stock;
  public BuyStockOrder ( StockTrade st) {
    stock = st;
  }
  public void execute( ) {
    stock . buy( );
  }
}
// Client
public class Client {
  public static void main(String[] args) {
    StockTrade stock = new StockTrade();
    BuyStockOrder bsc = new BuyStockOrder (stock);
    SellStockOrder ssc = new SellStockOrder (stock);
    Agent agent = new Agent();
    agent.placeOrder(bsc); // Buy Shares
    agent.placeOrder(ssc); // Sell Shares
  }
}
public interface Order {
    public abstract void execute();
}
//ConcreteCommand Class.
class SellStockOrder implements Order { 
  private StockTrade stock;
  public SellStockOrder ( StockTrade st) {
    stock = st;
  }
  public void execute( ) {
    stock . sell( );
  }
}
// Receiver class.
class StockTrade {
  public void buy() {
    System.out.println("You want to buy stocks");
  }
  public void sell() {
    System.out.println("You want to sell stocks ");
  }
}
/*------------------------------------------------------
                    |MEDIATOR|*/
