import java.awt.*;
import javax.swing.*;
public class Myframe extends JFrame {
public Myframe(){
	
	setSize(200,200);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setTitle("�й� 2016111556");
	
	JPanel panel= new JPanel(); //�г� ����
	JLabel lable = new JLabel("�й�: "); //���̺� ����
	JTextField t1= new JTextField(10); // textfield ����
	
	
	
	JLabel lable2= new JLabel("��й�ȣ : "); //
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

