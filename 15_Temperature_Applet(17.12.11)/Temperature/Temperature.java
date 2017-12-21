import java.awt.event.*;
import java.applet.Applet;
import java.awt.*;
import javax.swing.*;
public class Temperature extends JApplet implements ActionListener{
	private static final String NULL = null;
	private JEditorPane edPane;
	private JScrollPane scroll;
	private JPanel panel1, panel2,panel3;
	private JLabel label1, label2;
	private JTextField text1, text2;
	private JButton button;
	private double num1, num2;
	public void init(){
		setSize(400,300);
		setLayout(new BorderLayout());
		panel1 = new JPanel();
		panel2 = new JPanel();
		panel3 = new JPanel();
		edPane = new JEditorPane();
		scroll = new JScrollPane(edPane);
		edPane.setContentType("text/html");
		
		// edPane.setText() �Լ��� �̿��ؼ� 
		// HTML ������ ���� ǥ���Ұ�(����ȭ������)
		String htmlstring ="<html> <h1>화씨 온도를 섭씨온도로 변환하기</h1>"
				+ "<br> <h2> 섭씨온도 <-> 화씨온도 </h2> </br>"
				+ "<br> <font size=5> 화씨온도를 F라 하고, 섭씨온도를 C라 할 때,</font> </br>"
				+ "<br> <font size=5> - 섭씨온도를 화씨온도로 : F = (9/5)C +32 </font> </br>"
				+ "<br> <font size=5> - 화씨온도를 섭씨온도로 : C = (5/9)(F-32) </font> <br>"
				+ "</body>"
				+"</html>";
			

		
		edPane.setText(htmlstring);
		
		label1 = new JLabel("화씨온도  ");
		label2 = new JLabel("섭씨온도   ");
		text1 = new JTextField(15);
		text1.setText("0.0");
		text2 = new JTextField(15);
		text2.setText("0.0");
		button = new JButton("변환하려면 누르시오.");
		button.addActionListener(this);
		
		this.getContentPane().add(scroll, BorderLayout.PAGE_START);
		panel1.setLayout(new BorderLayout());
		panel1.add(label1, BorderLayout.WEST);
		panel1.add(text1, BorderLayout.EAST);
		panel2.add(label2, BorderLayout.WEST);
		panel2.add(text2, BorderLayout.EAST);
		
		panel3.add(panel1, BorderLayout.PAGE_END);
		panel3.add(panel2, BorderLayout.CENTER);
		panel3.add(button, BorderLayout.PAGE_START);
		add(panel3);
		setVisible(true);
		
	}
	public void actionPerformed(ActionEvent e) {
		if(button==e.getSource()){
			
			String ftemp=text1.getText(); 
			String ctemp=text2.getText();
			
			int ftempint;
			int ctempint;
			int resultc;
			int resultf;
			float resultff;
			
			if(text1.getText()==null){
				ftempint=Integer.parseInt(ftemp);
				resultc=(5/9)*(ftempint-32);
				System.out.println("섭씨온도");
				String resultcString = Integer.toString(resultc);
				System.out.println("화씨온도");
				text1.setText(resultcString);
				System.out.println("��±��� �ߵ�");
			}
			
			if(text2.getText()==null){
				ctempint=Integer.parseInt(ctemp);
				resultff=(float)((9/5)*ctempint + 32);
				String resultfString = Float.toString(resultff);
				text2.setText(resultfString);
			}
	
}


	}

}

