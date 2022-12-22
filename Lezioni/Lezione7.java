/*
                                                        |Polimorfismo|
-------------------------------------------------------------------------------------------------------------------------------

Consente di riferirci ad 'entita' diverse con lo stesso nome. Un'operazione polimorfica e' un'operazione che puo' essere eseguita da diversi oggetti

Esistono vari tipi di polimorfismo:
    i) Per dati:
       Parametri polimorfi, Collezioni eterogenee, Metodi virtuali
    ii) Per metodi:
        Overload, Override, Metodi virtuali

Overload:
  La parte di un metodo costituita dal nome dello stesso e dai suoi parametri e' detto FIRMA.
  Il tipo di ritorno del metodo non concorre alla definizione della firma.
  In una classe possono coesistere diversi metodi con stesso nome, MA DIVERSA FIRMA.
*/
public class Aritmetica {
  public int somma(int a, int b) {
    return a + b;
  }
  public float somma(int a, float b) {
    return a + b;
  }
  public float somma(float a, int b) {
    return a + b;
  }
  public int somma(int a, int b, int c) {
    return a + b + c;
  }
  public double somma(int a, double b, int c) {
    return a + b + c;
  }
}
/*
Override:
  Le sottoclassi possono ridefinire un metodo della classe base, che dovra' avere la stessa firma del metodo della superclasse.
  Dovra' coincidere anche il tipo ritornato (o essere un tipo che estende), altrimenti viene definito un nuovo metodo, diverso da quello della superclasse.
  Il metodo ridefinito nella sottoclasse non deve avere minor accesso di quello della superclasse. (protected -> Prot/Public)
*/
//Classe base Punto
public class Punto{
  private int x, y;
  public void setX(int x){
    this.x = x; 
  }
  public int getX(){
    return x;
  }
  public void setY(int y){
    this.y = y; 
  }
  public int getY(){
    return y;
  }
  public double distanzaDallOrigine(){
    int tmp = (x*x) + (y*y);
    return Math.sqrt(tmp);
  }
}
//Sottoclasse Punto3D
public class Punto3D extends Punto {
  private int z;
  public void setZ(int z) {
    this.z = z;
  }
  public int getZ() {
    return z;
  }
  public double distanzaDallOrigine() {
    int tmp = (getX()*getX()) + (getY()*getY())+ (z*z); // N.B. : x ed y non sono ereditate
    return Math.sqrt(tmp);
  }
}
/*
Polimorfismo per dati:
  Permette di poter assegnare un reference di una superclasse ad un oggetto della sottoclasse.
*/
Punto ogg = new PuntoTridimensionale();
/*
  Ad esempio, supponiamo di avere una superclasse "FiguraGeometrica", che ha un metodo 'disegnaFigura()'.
  Questa ha tre sottoclassi, 'Rettangolo', 'Cerchio' e 'Quadrato', che contengono lo stesso metodo disegnaFigura(), implementandolo per ciascuna.
  Il sistema e' in grado di capire automaticamente quale figura disegnare, ed invocarne il metodo corretto della figura coinvolta.
  In un sistema NON AD OGGETTI, usare il costrutto 'switch'
  
Parametri Polimorfi:
  In un metodo, un parametro di tipo 'Reference', si definisce polimorfo:
      Puo' puntare ad un oggetto istanziato dalla sottoclasse
      Metodo println che prende un parametro di tipo Object
*/
Punto p1 = new Punto();
System.out.println(p1);
/*
Collezioni Eterogenee:
  E' una collezione di oggetti di diverse classi
  Ad esempio, un array di Object che pero' contiene oggetti diversi tra loro (Int, Double, Punto...)
  Il polimorfismo per dati garantisce l'uso delle collezioni eterogenee
*/
Object arr[] = {new Punto(), "Hello World!", new Date()};
/*
                                              |istanceof|
-------------------------------------------------------------------------------------------------------------------------------
Il comando istanceof ci permette di risalire a quale TIPO DI ISTANZA punta un reference. 
Restituisce 'true' se il primo parametro punta ad un oggetto del secondo parametro o da una sottoclasse, 'false' altrimenti
*/
public class Dipendente{
  //Codice
}
public class Lavoratore extends Dipendente{
  //Codice
}
public void pagaDipendente(Dipendente dip){
  if(dip istanceof Lavoratore){
    //Codice
  }
}
/*
                                          |Casting di oggetti|
Il reference che punta ad un oggetto di una sottoclasse non puo' accedere ai membri e metodi della sottoclasse.
Il casting ci permette di dare accesso al reference ai vari metodi e campi.
*/
if (dip instanceof Programmatore) {
  Programmatore pro = (Programmatore) dip;
}
/*
Non usando questo metodo, il compilatore segnalera' errore, perche' non e' avvenuto il casting del reference.
*/
Programmatore pro = dip;
/*
                                                |Invocazione Virtuale dei Metodi|
-------------------------------------------------------------------------------------------------------------------------------
L'invocazione di un metodo M puo' definirsi virtuale se:
      1) M e' definito in una classe A
      2) M e' ridefinito (override) nella sottoclasse B
      3) M viene invocato su un oggetto di B tramite reference di A
A questo punto, verra' richiamato il metodo M ridefinito nella sottoclasse B
*/
