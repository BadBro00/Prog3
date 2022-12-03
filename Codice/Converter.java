import java.util.Scanner;

public class Converter{
	enum Conv{
		DOLLARI,YEN;
	}
	
	public final static double JPYrate = 0.75;
	public static double bal;
	public static double JPYbal;
	
	public static void AddBalance(double amnt){
		bal += amnt;
	}

	public static void PrintBal(){
		System.out.println("Il tuo saldo (VALUTA 1): "+bal);
		System.out.println("\nIl tuo saldo (VALUTA 2): "+JPYbal);
	}

	public static void Balance(){
		System.out.println("Il tuo saldo e': "+bal);
	}

	public static void Convert(Conv C,double amnt){
		if(C == Conv.DOLLARI)
			Prova.AddBalance(amnt);
		else if(C == Conv.YEN)
			Prova.JPYConv(amnt);
		else
			return;
	}

	public static double JPYConv(double amnt){
		JPYbal += amnt * JPYrate;
		return JPYbal;
	}

	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		Prova P = new Prova();
		double amnt;
		int choice;
		int valuta;
		Conv C;
		System.out.println("Valuta:\n1)Dollari\n2)Yen");
		valuta = sc.nextInt();
		if(valuta == 1)
			C = Conv.DOLLARI;
		else
			C = Conv.YEN;
		System.out.println("Inserire soldi:\n");
		amnt = sc.nextDouble();
		P.AddBalance(amnt);
		System.out.println("In quale valuta convertirli?\n1)Dollari\n2)YEN\n3)T'attacchi\n");
		choice = sc.nextInt();
		switch(choice){
			case 1:
				C = Conv.DOLLARI;
				break;
			case 2:
				C = Conv.YEN;
				break;
			default:
				System.out.println("Ti attacchi\n");
				break;
		}
		Convert(C,amnt);
		PrintBal();
	}
}
