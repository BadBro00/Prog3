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
import java.util.ArrayList;
import java.util.List;

public abstract class User {
	protected ChatMediator mediator;
	protected String name;
	public User(ChatMediator med, String name){
		this.mediator=med;
		this.name=name;
	}
	public abstract void send(String msg);
	public abstract void receive(String msg);
}	
public class UserImpl extends User {
  public UserImpl(ChatMediator med, String name) {
  	super(med, name);
  }
  @Override
  public void send(String msg){
  	System.out.println(this.name+": Sending Message="+msg);
  	mediator.sendMessage(msg, this);
  }
  @Override
  public void receive(String msg) {
  	System.out.println(this.name+": Received Message:"+msg);
  }
}
public interface ChatMediator {
	public void sendMessage(String msg, User user);
	void addUser(User user);
}
public class ChatMediatorImpl implements ChatMediator {
	private List<User> users;
  	public ChatMediatorImpl(){
 		this.users=new ArrayList<>();
  	}
  	@Override
  	public void addUser(User user){
  		this.users.add(user);
  	}
  	@Override
  	public void sendMessage(String msg, User user) {
		for(User u : this.users){
			//message should not be received by the user sending it
			if(u != user){
				u.receive(msg);
			}
		}
  	}
}
public class ChatClient {
  public static void main(String[] args) {
    ChatMediator mediator = new ChatMediatorImpl();
    User user1 = new UserImpl(mediator, "Pankaj");
    User user2 = new UserImpl(mediator, "Lisa"); 
    User user3 = new UserImpl(mediator, "Saurabh");
    User user4 = new UserImpl(mediator, "David");
    mediator.addUser(user1);
    mediator.addUser(user2);
    mediator.addUser(user3);
    mediator.addUser(user4);
    user1.send("Hi All");
   }
}

/*-------------------------------------------
			|MEMENTO|*/
public interface Memento {
	public void restoreState();
}
public class FileWriterCaretaker {
	private Object obj;

	public void save(FileWriterUtil fileWriter){
		this.obj=fileWriter.save();
	}
	public void undo(FileWriterUtil fileWriter){
		fileWriter.undoToLastSave(obj);
	}
}
public class FileWriterUtil {
	private String fileName;
	private StringBuilder content;
	public FileWriterUtil(String file){
		this.fileName=file;
		this.content=new StringBuilder();
	}
	@Override
	public String toString(){
		return this.content.toString();
	}
	public void write(String str){
		content.append(str);
	}
	public Memento save(){
		return new Memento(this.fileName,this.content);
	}
	public void undoToLastSave(Object obj){
		Memento memento = (Memento) obj;
		this.fileName= memento.fileName;
		this.content=memento.content;
	}
	private class Memento{
		private String fileName;
		private StringBuilder content;
		public Memento(String file, StringBuilder content){
			this.fileName=file;
			//notice the deep copy so that Memento and FileWriterUtil content variables don't refer to same object
				this.content=new StringBuilder(content);
		}
	}
}
public class FileWriterUtil {
	private String fileName;
	private StringBuilder content;
	public FileWriterUtil(String file){
		this.fileName=file;
		this.content=new StringBuilder();
	}
	@Override
	public String toString(){
		return this.content.toString();
	}
	public void write(String str){
		content.append(str);
	}
	public Memento save(){
		return new Memento(this.fileName,this.content);
	}
	public void undoToLastSave(Object obj){
		Memento memento = (Memento) obj;
		this.fileName= memento.fileName;
		this.content=memento.content;
	}
	private class Memento{
		private String fileName;
		private StringBuilder content;
		public Memento(String file, StringBuilder content){
			this.fileName=file;
			//notice the deep copy so that Memento and FileWriterUtil content variables don't refer to same object
				this.content=new StringBuilder(content);
		}
	}
}
public class FileWriterClient {
	public static void main(String[] args) {
		FileWriterCaretaker caretaker = new FileWriterCaretaker();
		FileWriterUtil fileWriter = new FileWriterUtil("data.txt");
		fileWriter.write("First Set of Data\n");
		System.out.println(fileWriter+"\n\n");
		// lets save the file
		caretaker.save(fileWriter);
		//now write something else
		fileWriter.write("Second Set of Data\n");
		//checking file contents
		System.out.println(fileWriter+"\n\n");
		//lets undo to last save
		caretaker.undo(fileWriter);
		//checking file content again
		System.out.println(fileWriter+"\n\n");
	}
}
public class RandomWalker {
	private int currentMilestone;
	private int lastWalkedDistance;
	private RandomWalker randomWalker;
	public RandomWalker() {
		randomWalker = this;
	}
	public void randomWalk() {
		lastWalkedDistance = (int) ( Math.random() * 100 );
		currentMilestone = currentMilestone + lastWalkedDistance;
	}
	public int getCurrentMilestone() {
		return currentMilestone;
	}
	public int getLastWalkedDistance() {
		return lastWalkedDistance;
	}
	public Memento createMemento( ) {
		return new WalkerMemento( );
	}
}
class WalkerMemento implements Memento{
	private int mem_currentMilestone;
	private int mem_lastWalkedDistance;
	public WalkerMemento() {
		mem_currentMilestone = currentMilestone;
		mem_lastWalkedDistance = lastWalkedDistance;
	}
	public void restoreState() {
		currentMilestone = mem_currentMilestone;
		lastWalkedDistance = mem_lastWalkedDistance;
	}
	} //End of class WalkerMemento
}
public class MementoExample {
	public static void main (String[] arg) {
		RandomWalker luke = new RandomWalker();
		// Creates a Memento that saves the original state
		Memento tripStop = luke.createMemento();
		for(int i=1; i<=4 ;i++) {
			System.out.println("Starting trip...");
			luke.randomWalk();
			whereIs( luke );
			System.out.println("Do you like this place?");
			if(Math.random() < .4) {
				System.out.println("-No!");
				// Restores the last saved state
				tripStop.restoreState();
				whereIs( luke );
			}else {
				System.out.println("-Yes!");
				// Creates a new Memento to save the new state
				tripStop = luke.createMemento();
			}
		}
		System.out.println("You reach the km" +luke.getCurrentMilestone());
	}
	public static void whereIs( RandomWalker rw ) {
		System.out.print ( "You are now stopped at km " + rw.getCurrentMilestone()+ ". " );
		System.out.println( "This place is "+ rw.getLastWalkedDistance() + " kms far from your last stop. ");
	}
}

/*--------------------------------------
		|OBSERVER|*/
abstract class Observer {               // 2. Root of the "dependent" hierarchy
   protected Subject subj;
   public abstract void update(); 
}
public class ObserverDemo {
   public static void main( String[] args ) {
      Subject sub = new Subject();
      // 7. Client configures the number and type of Observers
      new HexObserver( sub );  new OctObserver( sub );  new BinObserver( sub );
      while (true) {
         System.out.print( "\nEnter a number: " );
         sub.setState( Read.anInt() );
	}
   }
}
class OctObserver extends Observer {
   public OctObserver( Subject s ) {
      subj = s;  subj.attach( this ); } // 4. Observers register themselves
   public void update() {
      System.out.print( "  " + Integer.toOctalString( subj.getState() ) );
	} // 6. Observers "pull" information 
}                                    
class BinObserver extends Observer {
   public BinObserver( Subject s ) {
      subj = s;  subj.attach( this ); } // 4. Observers register themselves
   public void update() {
      System.out.print( "  " + Integer.toBinaryString( subj.getState() ) );
	} // 6. Observers "pull" information 
}                                    
class HexObserver extends Observer {    // 2. Concrete class of the "dependent" 
   public HexObserver( Subject s ) {    //    hierarchy
      subj = s;  subj.attach( this ); } // 4. Observers register themselves
   public void update() {
      System.out.print( "  " + Integer.toHexString( subj.getState() ) );
	}   // 6. Observers "pull" information 
}                                   
class Subject {                                     // 1. The "independent" abs
   private Observer[] observers = new Observer[9];  // 3. Coupled to base class
   private int        totalObs  = 0;
   private int        state;
   public void attach( Observer o ) { observers[totalObs++] = o; } // 3. Coupled
   public int  getState()           { return state; }
   public void setState( int in ) {
      state = in;
      notifyObservers(); }
   private void notifyObservers() {
      for (int i=0; i < totalObs; i++)
         observers[i].update();         // 3. Coupled to base class
}  // 5. Broadcast events to observers
}                                    

/*------------------------------------------
			|STATE|*/
public interface State {
	public void doAction();
}
public class TVContext implements State {
	private State tvState;
	public void setState(State state) {
		this.tvState=state;
	}
	public State getState() {
		return this.tvState;
	}
	@Override
	public void doAction() {
		this.tvState.doAction();
	}
}
public class TVStopState implements State {
	@Override
	public void doAction() {
		System.out.println("TV is turned OFF");
	}
}
public class TVRemote {
	public static void main(String[] args) {
		TVContext context = new TVContext();
		State tvStartState = new TVStartState();
		State tvStopState = new TVStopState();
		context.setState(tvStartState);
		context.doAction();
		context.setState(tvStopState);
		context.doAction();
	}
}
public class TVStartState implements State {
	@Override
	public void doAction() {
		System.out.println("TV is turned ON");
	}
}

/*----------------------------------------
			|ROBOT|*/
public class Robot {
	IBehaviour behaviour;
	String name;

	public Robot(String name)
	{
		this.name = name;
	}

	public void setBehaviour(IBehaviour behaviour)
	{
		this.behaviour = behaviour;
	}

	public IBehaviour getBehaviour()
	{
		return behaviour;
	}

	public void move()
	{
		System.out.println(this.name + ": Based on current position" +
					 "the behaviour object decide the next move:");
		int command = behaviour.moveCommand();
		// ... send the command to mechanisms
		System.out.println("\tThe result returned by behaviour object " +
					"is sent to the movement mechanisms " + 
					" for the robot '"  + this.name + "'");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
public interface IBehaviour {
	public int moveCommand();
}
public class NormalBehaviour implements IBehaviour{
	public int moveCommand()
	{
		System.out.println("\tNormal Behaviour: if find another robot ignore it");
		return 0;
	}
}
public class AgressiveBehaviour implements IBehaviour{
	public int moveCommand()
	{
		System.out.println("\tAgressive Behaviour: if find another robot attack it");
		return 1;
	}
}
public class DefensiveBehaviour implements IBehaviour{
	public int moveCommand()
	{
		System.out.println("\tDefensive Behaviour: if find another robot run from it");
		return -1;
	}
}
public class Main {

	public static void main(String[] args) {

		Robot r1 = new Robot("Big Robot");
		Robot r2 = new Robot("George v.2.1");
		Robot r3 = new Robot("R2");

		r1.setBehaviour(new AgressiveBehaviour());
		r2.setBehaviour(new DefensiveBehaviour());
		r3.setBehaviour(new NormalBehaviour());

		r1.move();
		r2.move();
		r3.move();

		System.out.println("\r\nNew behaviours: " +
				"\r\n\t'Big Robot' gets really scared" +
				"\r\n\t, 'George v.2.1' becomes really mad because" +
				"it's always attacked by other robots" +
				"\r\n\t and R2 keeps its calm\r\n");

		r1.setBehaviour(new DefensiveBehaviour());
		r2.setBehaviour(new AgressiveBehaviour());

		r1.move();
		r2.move();
		r3.move();
	}
}

/*----------------------------------------------
		|SHOPPING CART|*/
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Item {
	private String upcCode;
	private int price;
	public Item(String upc, int cost){
		this.upcCode=upc;
		this.price=cost;
	}
	public String getUpcCode() {
		return upcCode;
	}
	public int getPrice() {
		return price;
	}
}
public class ShoppingCart {
	//List of items
	List<Item> items;
	public ShoppingCart(){
		this.items=new ArrayList<Item>();
	}
	public void addItem(Item item){
		this.items.add(item);
	}
	public void removeItem(Item item){
		this.items.remove(item);
	}
	public int calculateTotal(){
		int sum = 0;
		for(Item item : items){
			sum += item.getPrice();
		}
		return sum;
	}
	public void pay(PaymentStrategy paymentMethod){
		int amount = calculateTotal();
		paymentMethod.pay(amount);
	}
}
public interface PaymentStrategy {
	public void pay(int amount);
}
public class ShoppingCartTest {
	public static void main(String[] args) {
		ShoppingCart cart = new ShoppingCart();
		Item item1 = new Item("1234",10);
		Item item2 = new Item("5678",40);
		cart.addItem(item1);
		cart.addItem(item2);
		//pay by paypal
		cart.pay(new PaypalStrategy("myemail@example.com", "mypwd"));
		//pay by credit card
		cart.pay(new CreditCardStrategy("Pankaj Kumar",
		"1234567890123456", "786", "12/15"));
	}
}
public class CreditCardStrategy implements PaymentStrategy {
	private String name;
	private String cardNumber;
	private String cvv;
	private String dateOfExpiry;
	public CreditCardStrategy(String nm, String ccNum, String cvv,String expiryDate){
		this.name=nm;
		this.cardNumber=ccNum;
		this.cvv=cvv;
		this.dateOfExpiry=expiryDate;
	}
	@Override
	public void pay(int amount) {
		System.out.println(amount +" paid with credit/debit card");
	}
}
public class PaypalStrategy implements PaymentStrategy {
	private String emailId;
	private String password;
	public PaypalStrategy(String email, String pwd){
		this.emailId=email;
		this.password=pwd;
	}
	@Override
	public void pay(int amount) {
		System.out.println(amount + " paid using Paypal.");
	}
}
/*--------------------------------------------
			|HOUSE (Template Method)||*/
public abstract class HouseTemplate {
	//template method, final so subclasses can't override
	public final void buildHouse(){
		buildFoundation();
		buildPillars();
		buildWalls();
		buildWindows();
		System.out.println("House is built.");
	}
	//default implementation
	private void buildWindows() {
		System.out.println("Building Glass Windows");
	}
	//methods to be implemented by subclasses
	public abstract void buildWalls();
	public abstract void buildPillars();
	private void buildFoundation() {
		System.out.println("Building foundation with cement,iron rods and sand");
	}
}
public class HousingClient {
	public static void main(String[] args) {
	HouseTemplate houseType = new WoodenHouse();
	//using template method
	houseType.buildHouse();
	System.out.println("************");
	houseType = new GlassHouse();
	houseType.buildHouse();
	}	
}
public class GlassHouse extends HouseTemplate{
	@Override
	public void buildWalls() {
		System.out.println("Building Glass Walls");
	}
	@Override
	public void buildPillars() {
		System.out.println("Building Pillars with glass coating");
	}
}
public class WoodenHouse extends HouseTemplate {
	@Override
	public void buildWalls() {
		System.out.println("Building Wooden Walls");
	}
	@Override
	public void buildPillars() {
		System.out.println("Building Pillars with Wood coating");
	}
}

/*--------------------------------------------
		|VISITOR (Shopping Cart)|*/
public interface ItemElement {
	public int accept(ShoppingCartVisitor visitor);
}
public class Book implements ItemElement {
	private int price;
	private String isbnNumber;
	public Book(int cost, String isbn){
		this.price=cost;
		this.isbnNumber=isbn;
	}
	public int getPrice() {
		return price;
	}
	public String getIsbnNumber() {
		return isbnNumber;
	}
	@Override
	public int accept(ShoppingCartVisitor visitor) {
		return visitor.visit(this);
	}
}
public class Fruit implements ItemElement {
	private int pricePerKg;
	private int weight;
	private String name;
	public Fruit(int priceKg, int wt, String nm){
		this.pricePerKg=priceKg;
		this.weight=wt;
		this.name = nm;
	}
	public int getPricePerKg() {
		return pricePerKg;
	}
	public int getWeight() {
		return weight;
	}
	public String getName(){
		return this.name;
	}
	@Override
	public int accept(ShoppingCartVisitor visitor) {
		return visitor.visit(this);
	}
}
public class ShoppingCartClient {
	public static void main(String[] args) {
		ItemElement[] items = new ItemElement[]{new Book(20,"1234"),new Book(100, "5678"), new Fruit(10, 2, "Banana"), new Fruit(5, 5, "Apple")};
		int total = calculatePrice(items);
		System.out.println("Total Cost = "+total);
	}
	private static int calculatePrice(ItemElement[] items) {
		ShoppingCartVisitor visitor = new ShoppingCartVisitorImpl();
		int sum=0;
		for(ItemElement item : items){
			sum = sum + item.accept(visitor);
		}
		return sum;
	}
}
public interface ShoppingCartVisitor {
	int visit(Book book);
	int visit(Fruit fruit);
}
public class ShoppingCartVisitorImpl implements ShoppingCartVisitor {
	@Override
	public int visit(Book book) {
		int cost=0;
		//apply 5$ discount if book price is greater than 50
		if(book.getPrice() > 50){
			cost = book.getPrice()-5;
		}else cost = book.getPrice();
			System.out.println("Book ISBN::"+book.getIsbnNumber() + " cost ="+cost);
			return cost;
		}
		@Override
		public int visit(Fruit fruit) {
			int cost = fruit.getPricePerKg()*fruit.getWeight();
			System.out.println(fruit.getName() + " cost = "+cost);
			return cost;
		}
	}
}
/*---------------------------------------
			|ABSTRACT FATTORY|*/
