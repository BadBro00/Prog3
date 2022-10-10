import java.util.Scanner;

public class SavingsAccountTest extends SavingsAccount{
	public static void main(String args[]){
		SavingsAccount SA = new SavingsAccount();
		SA.Ingresso();
		Scanner sc = new Scanner(System.in);
		int choice,qt;
		while(choice != 4){
			System.out.println("1)Withdraw\n2)Deposit\n3)Balance\n4)Exit\n");
			choice = sc.nextInt();
			switch(choice){
				case 1:
					System.out.println("Insert amount:\n");
					qt = sc.nextInt();
					SA.withdraw(qt);
					SA.showBal();
				break;
				case 2:
					System.out.println("Insert amount:\n");
					qt = sc.nextInt();
					SA.deposit(qt);
					SA.showBal();
				break;
				case 3:
					System.out.println("The balance is: " + SA.showBal());
				break;
				default:
					return;
			}
		}
	}
}
