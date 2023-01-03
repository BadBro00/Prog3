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

Un oggetto ArrayList memorizza riferimenti ad oggetti di tipo Object.
