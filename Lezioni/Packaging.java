/*
                                                            |PACKAGING|
----------------------------------------------------------------------------------------------------------------------------
In Java, il packaging e' un metodo che consente di raggruppare vari file in un'unica cartella, o progetto, per essere utilizzati tutti insieme.
E' la stessa tecnica usata in C++, tramite linking.

Innanzitutto, si imposta, da terminale:
      package <nomepacchetto>
      
Successivamente, in ogni file che dev'essere inserito, si include:
      package <nomepacchetto> (in reverse domain, solitamente)

Un altro metodo, piu' rapido, e' quello di inserire tutti i file (quindi le classi), all'interno di una cartella apposita, contenente solo i file necessari al progetto.

Per compilare ed eseguire, ci sono due modi:

  1) Senza package:
    cd <cartella>
    javac <nomefile1> <nomefile2>....
    
    java <nomecartella>
  
  2) Con package:
    cd <cartella>
    javac <nomefile1> <nomefile2>....
    
    per la compilazione, basta andare all'esterno del package ed usare il comando:
    java <nomepaccheto>.<nomefile>
    
*/
