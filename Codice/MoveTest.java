import java.awt.Rectangle;

public class MoveTest{

	public static void main(String args[]){
		Rectangle cerealBox = new Rectangle(5,10,20,30);
		System.out.println(cerealBox);
		cerealBox.translate(15,25);
		System.out.println(cerealBox);
	}
}
