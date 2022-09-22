import java.util.Scanner;
public class Banca{
	static int Nconto,saldo=0;
	String Nome,Cognome;
	
	public static void main(String args[]){
		Banca.Saldo(Nconto);
		Scanner myScan = new Scanner(System.in);
		while(true){
		System.out.println("1) Deposito\n2) Prelievo\n3) Saldo\n");
		var option = myScan.nextInt();
		if(option == 1){
			int amnt;
			System.out.println("Inserisci importo:\n");
			amnt = myScan.nextInt();
			Deposito(amnt);
		}else if(option == 2){
			int amnt;
			System.out.println("Inserisci importo:\n");
			amnt = myScan.nextInt();
			Prelievo(amnt);
		}else{
			Saldo(Nconto);
		}
		}
	}
	public static void Deposito(int amount){
		System.out.println(String.format("Aggiunti %d al conto: %d\n",amount,Nconto));
		saldo += amount;
		Banca.Saldo(Nconto);
	}
	public static void Prelievo(int amount){
		System.out.println(String.format("Prelevati %d dal conto: %d\n",amount,Nconto));
		saldo -= amount;
		Banca.Saldo(Nconto);
	}
	public static void Saldo(int Nconto){
		System.out.println(String.format("Conto numero: %d\nSaldo: %d EUR\n",Nconto,saldo));
	}
}
