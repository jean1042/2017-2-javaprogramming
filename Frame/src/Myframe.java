import java.awt.*;
import javax.swing.*;
public class Myframe extends JFrame {
public Myframe(){
	
	JButton button = new JButton("디늉이버튼");
	this.add(button);
	setSize(300,200);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setTitle("Myframe");
	setLayout(new FlowLayout());
	setVisible(true);
	
}
}

