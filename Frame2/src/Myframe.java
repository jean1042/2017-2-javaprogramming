import java.awt.*;
import javax.swing.*;
public class Myframe extends JFrame {
public Myframe(){
	
	setSize(200,200);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setTitle("학번 2016111556");
	
	JPanel panel= new JPanel(); //패널 생성
	JLabel lable = new JLabel("학번: "); //레이블 생성
	JTextField t1= new JTextField(10); // textfield 생성
	
	
	
	JLabel lable2= new JLabel("비밀번호 : "); //
	JTextField t2= new JTextField(10);
	t2.setEditable(true);
	
	
	JButton button = new JButton("OK");
	JButton button2 = new JButton ("cancle");
	button.setRolloverEnabled(true);
	button2.setRolloverEnabled(true);
	
	// set Location
	t1.setLocation(50,100);
	t2.setLocation(70,150);
	lable2.setLocation(90,200);
	lable.setLocation(110, 250);
	
	//add component in panel
	panel.add(lable);
	panel.add(t1);
	panel.add(lable2);
	panel.add(t2);
	panel.add(button);
	panel.add(button2);
	
	
	add(panel);
	setVisible(true);
}
}

