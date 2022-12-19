/*
                                        |Introduzione OO e Java|
-------------------------------------------------------------------------------------------------------
1) Paradigmi di Programmazione:
Un linguaggio fornisce costrutti e meccanismi per programmare in uno o più paradigmi.
Java, come il C++, fornisce i paradigmi "Imperativo" e "OO":

i) Programmazione Imperativa : Enfasi posta nella progettazione e nella scrittura del procedimento con il quale, a partire dai dati in ingresso, si
   producono i risultati
   
ii) Enfasi posta nella progettazione di un modello del dominio di applicazione 

Nella programmazione OO, un 'oggetto' e' una rappresentazione di un concetto o di un oggetto del mondo reale

Java e' un linguaggio che viene "interpretato": il bytecode e' indipendente dall'Hardware, e puo' quindi essere runnato su qualunque macchina 
 su cui giri un ambiente run-time Java.

Per compilare ed eseguire da linea di comando:

  i) touch <nomefile>.java
  ii) //Scrivi il codice
  iii) javac <nomefile>.java
  iv) java <nomefile>(.class)

Il nome del file ed il nome della classe devono corrispondere. Ogni file puo' contenere al massimo una classe.
Possiamo inoltre creare una documentazione per un progetto Java tramite:
    
    javadoc <nomefile>(.class)
    
*/
public class Lezione1{
   public static void main(String args[]){
     System.out.println("Hello World!");
   }
}
