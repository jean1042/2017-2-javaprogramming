import javax.swing.JFrame;

public class Test {
	public static void main(String args[]){
		JFrame frame = new JFrame();
		frame.setSize(800,300);
		frame.setTitle("±×¸®±â");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MyComponent component = new MyComponent();
		
		frame.add(component);
		frame.setVisible(true);
	}
}
