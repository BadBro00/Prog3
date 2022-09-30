public class Purse{
  int Nick=0,Dime=0,Quart=0;
  double totValue=0;
  public static void main(String args[]){
    Purse P = new Purse();
    int opt,qt;
    Scanner sc = new Scanner(System.in);
    while(true){
      System.out.println("N : " + P.Nick + " | D : " + P.Dime + " | Q : " + P.Quart + "\n");
      System.out.println("1) Add Nickels\n2) Add Dimes\n3) Add Quarters\n4) Get Total\n5) Exit\n");
      opt = sc.nextInt();
      switch (opt){
        case 1:
          System.out.println("Insert number of Nickel coins:\n");
          qt = sc.nextInt();
          P.addNick(qt);
          break;
        case 2:
          System.out.println("Insert number of Dime coins:\n");
          qt = sc.nextInt();
          P.addDime(qt);
          break;
        case 3:
          System.out.println("Insert number of quarter coins:\n");
          qt = sc.nextInt();
          P.addQuart(qt);
          break;
        case 4:
          System.out.println("Il totale e': \n");
          System.out.print(P.getTotal(P.Nick,P.Dime,P.Quart));
          System.out.println("\n");
          break;
        default:
          return;
      }
    }
  }
  public double getTotal(int N,int D, int Q){
    totValue = N * 0.01 + D * 0.1 + Q * 0.25;
    return totValue;
  }
  public void addNick(int qt){
    Nick += qt;
    totValue = getTotal(Nick,Dime,Quart);
  }
  public void addDime(int qt){
    Dime += qt;
    totValue = getTotal(Nick,Dime,Quart);
  }
  public void addQuart(int qt){
    Quart += qt;
    totValue = getTotal(Nick,Dime,Quart);
  }
}
