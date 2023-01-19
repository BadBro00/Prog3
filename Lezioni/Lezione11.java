/*
                                                              |Annotazioni|
  Tipo di struttura dati del linguaggio
  Si va ad aggiungere alle classi, alle interfacce e alle enumerazion
  */
public @interface DaCompletare {
  String descrizione();
  String assegnataA() default "da assegnare"; //default fornisce un'Annotazione alla function assegnatA
}

                                          /*|Annotazione Ordinaria|*/
  //Interfaccia contenente metodi astratti
  public @interface DaCompletare {
    String descrizione();
    String assegnataA() default "da assegnare";
  }
  public class DaCompletareImpl implements DaCompletare {
    private String descrizione;
    private String assegnataA = "da assegnare";
    public String descrizione() {
      return descrizione;
    }
    public String assegnataA() {
      return assegnataA;
    }
 }
 //Immaginando l'annotazione come un'interfaccia 
/*
All’interno di un’annotazione è possibile dichiarare
  Metodi (implicitamente astratti)
  Costanti
  Enumerazioni
  Tipi innestati

Un’annotazione viene usata come se fosse un modificatore*/
@NomeAnnotazione ([lista di coppie] nome=valore)
/*
                                            |Annotazione a valore Unico|
Un tipo di annotazione che contiene un singolo metodo value()*/
public @interface Serie {
  Alfabeto value();
  enum Alfabeto {A,B,C};
}
@Serie(value = Serie.Alfabeto.A) public void faQualcosa() {
}
/*
                                             |Annotazione Marcatrice|*/
public @interface Marker {}
@Marker() public void faQualcosa(){
}
/*
                                              |Meta-Annotazioni|
In java.lang.annotation
  Retention
  Target
  Documented
  Inherited
  Native (Java 8)
  Repeatable (Java 8)
                    
                    |Target|*/
//Enumerazione ElementType
package java.lang.annotation;
public enum ElementType {
  TYPE, // Classi, interfacce, o enumerazioni
  FIELD, // variabili d'istanza (anche se enum)
  METHOD, // Metodi
  PARAMETER, // Parametri di metodi
  CONSTRUCTOR, // Costruttori
  LOCAL_VARIABLE, // Variabili locali o clausola catch
  ANNOTATION_TYPE, // Tipi Annotazioni
  PACKAGE // Package
  TYPE_PARAMETER // Tipi parametro (visti con i
  Generics)
  TYPE_USE // Uso di un tipo
}

//Limitazione dell'Enumerazione da assegnare
import java.lang.annotation.*;
import static java.lang.annotation.ElementType;
@Target({TYPE, METHOD, CONSTRUCTOR, PACKAGE, ANNOTATION_TYPE}) @Retention(RetentionPolicy.RUNTIME) public @interface DaCompletare {
  String descrizione();
  String assegnataA() default "da assegnare";
}
//Definizione dell'annotation Target
package java.lang.annotation;
@Documented @Retention(RetentionPolicy.RUNTIME) @Target(ElementType.ANNOTATION_TYPE) public @interface Target {
  ElementType[] value( );
}
/*                                  |Type Annotations|
Da Java 8
Fa uso dell'elemento dell'enumerazione ElementType.TYPE_USE*/

//Esempio dell'annotazione
import java.lang.annotation.*;
@Target(ElementType.TYPE_USE) @interface TestTP {
}
//Esempio di utilizzo
public class TypeParameterExample<@TestTP T> {
  public void metodo (@TestTP T t){
    System.out.println(t);
  }
}/*

                    |Retention|
Specifica come deve essere conservata dall’ambiente Java l’annotazione a cui viene applicata*/

//Enumerazione RetentionPolicy
package java.lang.annotation;
public enum RetentionPolicy {
  SOURCE, // l'annotazione è eliminata dal compilatore
  CLASS, /* l'annotazione viene conservata anche nel file ".class", ma ignorata dall JVM */
  RUNTIME /* l'annotazione viene conservata anche nel file ".class", e letta dalla JVM */
}

import java.lang.annotation.*;
@Retention(RetentionPolicy.RUNTIME) public @interface DaCompletare {
  String descrizione();
  String assegnataA() default "da assegnare";
}
/*Le annotazioni di tipo DaCompletare sono conservate nei file compilati, per essere letti anche dalla JVM

                      |Documented|
Permette di includere nella documentazione generata da Javadoc anche le annotazioni a cui è applicata*/

//Meta-Annotazione Target
package java.lang.annotation;
@Documented @Retention(RetentionPolicy.RUNTIME) @Target(ElementType.ANNOTATION_TYPE) public @interface Target {
  ElementType[] value( );
}

//Lunghezza massima di un certo campo
import java.lang.annotation.*;
@Documented @Retention(RetentionPolicy.RUNTIME) @Target (ElementType.FIELD) public @interface MaxLength {
  int value(); 
}
/*
                      |Inherited|
Fa si che le annotazioni applicate a classi possano essere ereditate*/

//Annotazione
import java.lang.annotation.*;
import static java.lang.annotation.ElementType.*;
@Target( {TYPE, METHOD, CONSTRUCTOR, PACKAGE, ANNOTATION_TYPE} ) @Retention(RetentionPolicy.RUNTIME) @Inherited public @interface DaCompletare {
  String descrizione();
  String assegnataA() default "da assegnare";
}
//Annotazione applicata alla classe "SuperClasse"
@DaCompletare (
  descrizione = "Da descrivere..."
)
public class SuperClasse {
  //...
}
//Estenzione della classe "SuperClasse"
public class SottoClasse extends SuperClasse {
  //. . .
}
 /*                           
                        |Repeatable|
Permette di annotare piu' volte con la stessa annotazione un elemento*/

//Annotazione 'TestTrigger'
@TestTrigger(quando="Ogni giorno, ore 18",come=TestTrigger.StrumentoDiTest.JUNIT)@TestTrigger(quando="Ogni venerdì, ore 9",come=TestTrigger.StrumentoDiTest.GUI)
public class TestRepeatable{
  public void metodo(String... args) {
    //...
  }
}
/*

                            |Annotazione Standard|
java.lang
  Override
  Deprecated
  SuppressWarning
  Native
  FunctionalInterface
  

                |Override|
          Annota un metodo con Override*/

//Annotazione java.lang.Override
package java.lang;
import java.lang.annotation.*;
@Target(value=ElementType.METHOD) //-> Interpretabile solo dal compilatore e che non sarà inserita nel bytecode relativo
                                  //   Il compilatore quindi potrà eventualmente segnalarci un problema nel caso il nome del metodo non sia scritto correttamente
@Retention(value=RetentionPolicy.SOURCE)
public @interface Override {}

                /*|Deprecated|
           
           Indica al compilatore e al runtime di Java che un metodo o un qualsiasi altro elemento di codice Java è deprecato*/

//Annotazione java.lang.Deprecated
import java.lang.annotation.*;
import static
java.lang.annotation.RetentionPolicy.RUNTIME;
@Documented @Retention(value=RUNTIME) public @interface Deprecated {}

//Esempio d'utilizzo
@DaCompletare (
  descrizione = "Da descrivere ..."
)
public class SuperClasse {
  /*
  * Questo metodo è stato deprecato
  * @deprecated utilizza un altro metodo per favore
  */
  @Deprecated public void metodo() {
  //...
  }
}
              /*|Suppress Warnings|
          Se vogliamo che il compilatore non generi warnings*/

//Annotazione SuppressWarnings
package java.lang;
import java.lang.annotation.*;
import java.lang.annotation.ElementType;
import static java.lang.annotation.ElementType.*;
@Target({TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE}) @Retention(RetentionPolicy.SOURCE) public @interface SuppressWarnings {
  String[] value();
}

//Esempio d'utilizzo
@SuppressWarnings({"unchecked", "rawtypes"}) public static void main(String args[]) {
  List strings = new ArrayList<String>();
  strings.add("Lambda");
  //...
  Iterator<String> i = strings.iterator();
  while (i.hasNext()) {
    String string = i.next();
    System.out.println(string);
  }
}

/*            |Functional Interface|
    Serve per annotare una functional interface,
      ovvero una interfaccia che ha un unico metodo astratto*/
     
//nterfaccia con errore di compilazione
@FunctionalInterface
public interface FunctionalInterfaceExample {
  void metodoAstratto();
  void secondoMetodoAstratto();
  default void metodoDiDefault(){
    System.out.println("metodo di default");
  }
}

/*            |Native|
  Permette di far interagire codice Java con codice scritto in linguaggio nativo, ovvero in C/C++
*/

//Dichiarazione dell’annotazione Native
@Documented @Target(ElementType.FIELD) @Retention(RetentionPolicy.SOURCE) public @interface Native {
}
//annotazione marcatrice applicabile solo alla dichiarazione di attributi ed in particolare alle costanti

