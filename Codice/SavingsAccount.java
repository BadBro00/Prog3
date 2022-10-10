import java.util.Scanner;

public class SavingsAccount{
	private final int NumConto = 9999;
	private float saldo;
	private int InputNum;
	protected void SavingsAccount(){
		this.saldo = 0;
	}
	protected void Ingresso(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Inserisci numero di conto:\n");
		while(InputNum != this.NumConto){
			InputNum = sc.nextInt();
			System.out.println("\t\t\t|ERRORE|\n\t\t|Numero conto errato!|\n");
			if(InputNum == this.NumConto){
				SavingsAccount.Benvenuto();
			}
		}		
	}
	protected int getNConto(){
		return this.NumConto;
	}
	protected void deposit(int qt){
		this.saldo += qt;
		System.out.println("Aggiunti: " + qt + " al saldo.\n");
	}
	protected void withdraw(int qt){
		this.saldo -= qt;
		System.out.println("Prelevati: " + qt + "dal saldo.\n");
	}
	protected int showBal(){
		return this.saldo;
	}
}		
