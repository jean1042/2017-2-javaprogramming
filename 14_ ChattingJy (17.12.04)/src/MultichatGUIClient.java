import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.Socket;
import java.awt.*;

public class MultichatGUIClient implements ActionListener {

	Frame f;
	Panel p;
	Button b1;
	TextField tf;
	TextArea ta;
	
	String name;
	ClientSender sender;
	
	public MultichatGUIClient(String name){
		this.name = name;
		f = new Frame(name);
		
		p = new Panel();
		b1 = new Button("send");
		tf = new TextField();
		ta = new TextArea(20, 50);
	}
	
	public void launchTest(){
		f.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(0);
				
			}
		});
		
		f.add(BorderLayout.SOUTH, p);
		b1.addActionListener(this);
		b1.setBackground(Color.gray);
		
		tf.setColumns(40);
		tf.addKeyListener(new KeyAdapter(){
			public void keyReleased(KeyEvent e){
				char keyCode = e.getKeyChar();
				if(keyCode == KeyEvent.VK_ENTER){
					actionPerformed(null);
				}
			}
		});
		
		p.setBackground(Color.blue);
		p.add(tf);
		p.add(b1);
		
		f.add(BorderLayout.CENTER, ta);
		
		f.setVisible(true);
		f.pack();
		
		Socket socket = null;
		
		try{
			String ip = "220.116.72.117";
			socket = new Socket(ip, 621);
			System.out.println("서버에 연결되었습니다.");
			
			//메시지 전송용 thread 생성
			sender = new ClientSender(socket);
			
			//메시지 수신용 Thread 생성
			Thread receiver = new Thread(new ClientReceiver(socket));
			
			receiver.start();
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		sender.send(tf.getText());
		
		tf.setText("");
		tf.requestFocus();
	}
	
	public void setMessage(String message){
		ta.append(message);
		ta.append("\n");
	}

	
}

