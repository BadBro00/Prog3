public class Template{
  private static double nomedouble = 0;
  public static void main(String args[]){
    System.out.println("Template\n");
    //Codici
  }
  public void metodoSet(double dbl){
    this.nomedouble = dbl;
  }
  public double metodoGet(){
    return this.nomedouble;
  }
}

public class TemplateExtends extends Template{
  public static void main(String args[]){
    //Codice
  }
}
