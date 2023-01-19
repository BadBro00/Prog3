/*
                                                      |TIPI GENERICI|
              |Array|
              
Sequenza prefissata di valori dello stesso tipo. Puo' essere un tipo primitivo o una classe.

*/
import java.awt.*

Button bottoni[];

char alfabeto[];

alfabeto = new char[21];
bottoni = new Button[dim];

/*
Gli array possono anche essere bidimensionali, e non per forza rettangolari
*/

Button bott = new Button[2][3];

bott[0][0] = ...;
bott[1][0] = ...;
bott[2][3] = ...;
/*
Gli array sono utilizzati relativamente poco in Java, sono preferiti gli oggetti della libreria Collections.
              
              |Vettori|

I vettori (ArrayList) sono insiemi di oggetti posti in sequenza. Si puo' accedere indipendentemente a ciascun elemento.
*/
import java.util.ArrayList;

ArrayList coins = new ArrayList();
coins.add(new Coin(0.1, “dime”));
coins.add(new Coin(0.25, “quarter”));
/*
[Codice di riferimento: Purse.java]
    
      
Abbiamo diversi metodi:
-Per accedere all'elemento i-simo usiamo:
      <nomearray>.get(i);
-Per settare un valore all'elemento i-simo usiamo:
      <nomearray>.set(x);
-Per ottenere la cardinalita' del vettore usiamo:
      <nomearray>.size();
-Per aggiungere un nuovo elemento usiamo:
      <nomearray>.add();
      
Un oggetto ArrayList memorizza riferimenti ad oggetti di tipo Object.
------------------------------|ESERCIZIO|------------------------------------------    
Creare una classe Purse (borsellino contenente monete) contenente i seguenti metodi
  add()
  getTotal()
  count()
  find(Coin)
  count (Coin)
  getMaximum()
-----------------------------------------------------------------------------------
[Codice di Riferimento: Purse.java - implementare PurseTest.java]

                                      |Tipo Generico|
Quando dichiariamo una classe o un’interfaccia possiamo “renderla generica” (generic type), aggiungendo alla definizione uno o più tipi parametro
*/
class identificatoreDellaClasse <T1, T2,... Tn> {
//. . .
}
/*
Abbiamo diverse opzioni per indicare il tipo generico in Java:
  
  "E", per Element
  "K", per Key
  "N", per Number
  "T", per Type
  "V", per Value
  "S","U","V", per secondo, terzo e quarto tipo
  

                                    |Framework Collections|
Collezione : 
    Oggetto che raggruppa piu' elementi in una singola entita'.
    
Framework :
    insieme di classi e di interfacce riutilizzabili ed estendibili

                                    |Generics e Collection|
L'interfaccia 'List' estende l'interfaccia 'Collection', dichiarata anch'essa generica
La sottoclasse 'List' implementa 'ArrayList'
*/
public interface List<E> extends Collection<E>
public boolean add(E o) //metodo add di List

List<Auto> lista = new ArrayList<Auto>();
/*
Anche se una classe è definita generica, l’utilizzo dei tipi parametri non è obbligatorio.

Esiste anche la possibilita' di utilizzare una classe detta "wrapper", che funziona da contenitore ad un tipo primitivo.
Non hanno metodi set, e un esempio e' Integer, che fa da wrapper al tipo integer*/
int i = Integer.parseInt(“1”);
/*

                                  |Autoboxing & Autounboxing|

Le collezioni accettano come elementi solo oggetti, e non tipi di dati primitivi.
Grazie all'autoboxing, e' possibile aggiungere ad una collezione un tipo primitivo*/
List list = new ArrayList();
list.add(5.3F);
//OPPURE
List list = new ArrayList();
list.add(new Float(5.3F));
/*

                                          |Iterator|
L'interfaccia del framework Collection le permette di iterare sulla collezione.*/
Iterator<String> i = strings.iterator();
/*
Come iterator e' possibile specificare la "Wildcard" <?>, che accetta quindi qualsiasi tipo*/
Iterator<?> i = strings.iterator();
/*
                                        |Metodi Generici|
Sono metodi che definiscono il proprio tipo generico*/
public class GenericMethod {
  public static <N extends Number> String getValue(N number) {
    String value = number.toString();
  return value;
  }
}
/*
                                        |Type inference|
*/
ArrayList<String> arrayList;
//Da Java 7 in poi:
ArrayList<String> arrayList = new ArrayList<>();
/*
                                        |Parametri Covarianti|
Creano la possibilità di creare override di metodi il cui tipo di restituzione è una sottoclasse del tipo di restituzione del metodo originale*/
interface Cibo {
  String getColore();
}
interface Animale {
  void mangia(Cibo cibo);
}
public class Erba implements Cibo {
  public String getColore() {
    return "verde";
  }
}
public class Carnivoro implements Animale {
  public void mangia(Cibo cibo) {
    //un carnivoro potrebbe mangiare erbivori
  }
}
public class Erbivoro implements Cibo, Animale {
  public void mangia(Cibo cibo) {
    //un erbivoro mangia erba
  }
  public String getColore() {
    //...
  }
}
/*
Usando questo metodo di scrittura, sia un erbivoro che un carnivoro potrebbero mangiare qualsiasi cibo.*/
interface Animale<C extends Cibo> {
  void mangia(C cibo);
}
public class Carnivoro implements Animale<Erbivoro> {
  public void mangia(Erbivoro erbivoro) {
    //un carnivoro potrebbe mangiare erbivori
  }
}
public class Erbivoro<E extends Erba> implements Cibo, Animale<E> {
  public void mangia(E erba) {
    //un erbivoro mangia erba
  }
  public String getColore() {
    //...
  }
}
public class TestAnimali {
  public static void main(String[] args) {
    Animale<Erbivoro> tigre = new Carnivoro<Erbivoro>();
    Erbivoro<Erba> erbivoro = new Erbivoro<Erba>();
    tigre.mangia(erbivoro);
  }
}
