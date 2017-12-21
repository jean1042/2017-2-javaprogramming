package newVendingMachine_1105.copy;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSplitPane;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JFormattedTextField;
import javax.swing.JSpinner;
import java.awt.Color;
import javax.swing.JTextPane;
import javax.swing.JCheckBox;
import javax.swing.border.BevelBorder;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txtWelcomeTo;
	private JTextField textField;
	
	Beverage beverage = new Beverage(); //beverage 객체 선언
	
	
	//database
	int userprice;//사용자가 넣어준 돈
	int userprice500; //사용자가 넣어준 500원 동전의 값
	int userprice100; //사용자가 넣어준 100원 동전의 값
	int stockNum; //재고의 개수
	int paynum=0; // 사용자가 음료수를 사먹은 횟수
	
	int selectBeverageId;
	int selectBeverageindex;
	int selectBeveragePrice;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					VendingMachine myMachine = new VendingMachine(20);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws ClassNotFoundException 
	 */
	public MainFrame() throws ClassNotFoundException {
	
		
		VendingMachine myMachine = new VendingMachine(20);
		
		myMachine.addBeveragelist(VendingMachine.tempBeverage);
		
	
		/*
		//사용자가 선택한 음료수 아이디로 벤딩머신의 어디에 들어있는지 찾음
		selectBeverageindex = myMachine.searchBeveragelist(selectBeverageId);
		try {
			selectBeveragePrice=myMachine.searchBeverageObjlist(selectBeverageindex).getPrice();
		} catch (Exception e2) {
			System.out.println("selectBeveragePrice 가져오기 실패");
			e2.printStackTrace();
		}
		*/
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 632);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(null);
		
		txtWelcomeTo = new JTextField();
		txtWelcomeTo.setBounds(148, 5, 126, 21);
		txtWelcomeTo.setFont(new Font("굴림", Font.BOLD, 12));
		panel.add(txtWelcomeTo);
		txtWelcomeTo.setHorizontalAlignment(SwingConstants.CENTER);
		txtWelcomeTo.setEnabled(false);
		txtWelcomeTo.setEditable(false);
		txtWelcomeTo.setText("VendingMachine\r\n");
		txtWelcomeTo.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_2.setBounds(14, 38, 394, 242);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_3.setBounds(14, 12, 89, 109);
		panel_2.add(panel_3);
		
		JLabel lblNewLabel=new JLabel("음료수1");
		try {
			lblNewLabel = new JLabel(myMachine.searchBeverageObjlist(0).gettrayName());
		} catch (Exception e3) {
			System.out.println("음료수 이름 변경 실패");
			e3.printStackTrace();
		}
		panel_3.add(lblNewLabel);
		
		JSpinner spinner = new JSpinner();
		panel_3.add(spinner);
		
		//음료수1 선택시 아이디 저장하는 이벤트 구현
		JButton btnNewButton = new JButton("선택");
		btnNewButton.addActionListener(new ActionListener() { // 
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() ==btnNewButton ){
					selectBeverageId=1;
				}
			}
		});
		panel_3.add(btnNewButton);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_4.setBounds(106, 12, 89, 109);
		panel_2.add(panel_4);
		
		JLabel label = new JLabel("음료수2");
		try {
			label = new JLabel(myMachine.searchBeverageObjlist(1).gettrayName());
		} catch (Exception e3) {
			System.out.println("음료수 이름 변경 실패");
			e3.printStackTrace();
		}
		panel_3.add(lblNewLabel);
		panel_4.add(label);
		
		JSpinner spinner_1 = new JSpinner();
		panel_4.add(spinner_1);
		
		//음료수2 선택시 아이디 저장하는 이벤트 구현
		JButton button_12 = new JButton("선택");
		button_12.addActionListener(new ActionListener() { // 
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() ==btnNewButton ){
					selectBeverageId=2;
				}
			}
		});
		panel_4.add(button_12);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_5.setBounds(197, 12, 89, 109);
		panel_2.add(panel_5);
		
		JLabel label_1 = new JLabel("음료수3");
		try {
			label_1 = new JLabel(myMachine.searchBeverageObjlist(2).gettrayName());
		} catch (Exception e3) {
			System.out.println("음료수 이름 변경 실패");
			e3.printStackTrace();
		}
		panel_3.add(lblNewLabel);
		panel_5.add(label_1);
		
		JSpinner spinner_2 = new JSpinner();
		panel_5.add(spinner_2);
		
		//음료수3 선택시 아이디 저장하는 이벤트 구현
		JButton button_13 = new JButton("선택");
		button_13.addActionListener(new ActionListener() { // 
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() ==btnNewButton ){
					selectBeverageId=3;
				}
			}
		});
		panel_5.add(button_13);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_6.setBounds(291, 12, 89, 109);
		panel_2.add(panel_6);
		
		//음료수 이름 사용자가 설정한 것으로 바꿔주는 이벤트 구현
		JLabel label_2 = new JLabel("음료수4");
		try {
			label_2 = new JLabel(myMachine.searchBeverageObjlist(3).gettrayName());
		} catch (Exception e3) {
			System.out.println("음료수 이름 변경 실패");
			e3.printStackTrace();
		}
		panel_3.add(lblNewLabel);
		panel_6.add(label_2);
		
		JSpinner spinner_3 = new JSpinner();
		panel_6.add(spinner_3);
		
		JButton button_14 = new JButton("선택");
		button_14.addActionListener(new ActionListener() { // 
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() ==btnNewButton ){
					selectBeverageId=4;
				}
			}
		});
		panel_6.add(button_14);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_7.setBounds(14, 121, 89, 109);
		panel_2.add(panel_7);
		
		JLabel label_3 = new JLabel("음료수5");
		try {
		label_3 = new JLabel(myMachine.searchBeverageObjlist(4).gettrayName());
		} catch (Exception e3) {
			System.out.println("음료수 이름 변경 실패");
			e3.printStackTrace();
		}
		panel_3.add(lblNewLabel);
		panel_7.add(label_3);
		
		JSpinner spinner_4 = new JSpinner();
		panel_7.add(spinner_4);
		
		JButton button_15 = new JButton("선택");
		button_15.addActionListener(new ActionListener() { // 
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() ==btnNewButton ){
					selectBeverageId=5;
				}
			}
		});
		panel_7.add(button_15);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_8.setBounds(106, 121, 89, 109);
		panel_2.add(panel_8);
		
		JLabel label_4 = new JLabel("음료수6");
		try {
			label_4 = new JLabel(myMachine.searchBeverageObjlist(5).gettrayName());
		} catch (Exception e3) {
			System.out.println("음료수 이름 변경 실패");
			e3.printStackTrace();
		}
		panel_3.add(lblNewLabel);
		panel_8.add(label_4);
		
		JSpinner spinner_5 = new JSpinner();
		panel_8.add(spinner_5);
		
		JButton button_16 = new JButton("선택");
		button_16.addActionListener(new ActionListener() { // 
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() ==btnNewButton ){
					selectBeverageId=6;
				}
			}
		});
		panel_8.add(button_16);
		
		JPanel panel_9 = new JPanel();
		panel_9.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_9.setBounds(197, 121, 89, 109);
		panel_2.add(panel_9);
		
		JLabel label_5 = new JLabel("음료수7");
		try {
			label_5 = new JLabel(myMachine.searchBeverageObjlist(6).gettrayName());
		} catch (Exception e3) {
			System.out.println("음료수 이름 변경 실패");
			e3.printStackTrace();
		}
		panel_3.add(lblNewLabel);
		panel_9.add(label_5);
		
		JSpinner spinner_6 = new JSpinner();
		panel_9.add(spinner_6);
		
		JButton button_17 = new JButton("선택");
		button_17.addActionListener(new ActionListener() { // 
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() ==btnNewButton ){
					selectBeverageId=7;
				}
			}
		});
		panel_9.add(button_17);
		
		JPanel panel_10 = new JPanel();
		panel_10.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_10.setBounds(291, 121, 89, 109);
		panel_2.add(panel_10);
		
		JLabel label_6 = new JLabel("음료수8");
		try {
			label_6 = new JLabel(myMachine.searchBeverageObjlist(7).gettrayName());
		} catch (Exception e3) {
			System.out.println("음료수 이름 변경 실패");
			e3.printStackTrace();
		}
		panel_3.add(lblNewLabel);
		panel_10.add(label_6);
		
		JSpinner spinner_7 = new JSpinner();
		panel_10.add(spinner_7);
		
		JButton button_18 = new JButton("선택");
		button_18.addActionListener(new ActionListener() { // 
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() ==btnNewButton ){
					selectBeverageId=8;
				}
			}
		});
		panel_10.add(button_18);
		
		JPanel panel_11 = new JPanel();
		panel_11.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_11.setBounds(14, 281, 394, 112);
		panel.add(panel_11);
		panel_11.setLayout(null);
		
		JLabel label_7 = new JLabel("100원 : ");
		label_7.setBackground(Color.LIGHT_GRAY);
		label_7.setForeground(Color.BLACK);
		label_7.setBounds(233, 15, 64, 18);
		panel_11.add(label_7);
		
		//100원 동전 textField
		JFormattedTextField formattedTextField = new JFormattedTextField();
		formattedTextField.setBounds(289, 12, 80, 24);
		panel_11.add(formattedTextField);
				
				
		JLabel label_8 = new JLabel("500원 : ");
		label_8.setForeground(Color.BLACK);
		label_8.setBackground(Color.LIGHT_GRAY);
		label_8.setBounds(233, 48, 64, 18);
		panel_11.add(label_8);
		
		JLabel label_9 = new JLabel("현재 금액: ");
		label_9.setForeground(Color.BLACK);
		label_9.setBackground(Color.LIGHT_GRAY);
		label_9.setBounds(220, 79, 80, 18);
		panel_11.add(label_9);
		
		//500원 textField
		JFormattedTextField formattedTextField_2 = new JFormattedTextField();
		formattedTextField_2.setBounds(289, 45, 80, 24);
		panel_11.add(formattedTextField_2);
		
		textField = new JTextField();
		textField.setBounds(289, 81, 80, 24);
		
		panel_11.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("확인");
		btnNewButton_1.addActionListener(new ActionListener() { // 사용자가 넣어준 동전 받아오는 이벤트 구현
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() ==btnNewButton_1 ){
					
					String scan100= formattedTextField.getText();
					String scan500= formattedTextField_2.getText();
					
					int money100=Integer.parseInt(scan100); //textField 로 받아온 100원 문자 숫자로 바꿔주기
					System.out.println("money100 : " + money100);
					int money500=Integer.parseInt(scan500);
					System.out.println("money500 : " + money500);
					
					userprice100=money100*100;	//사용자가 넣어준 100원 돈 변수에 저장
					userprice500=money500*500; // 사용자가 넣어준 500원 돈 변수에 저장
					
					userprice = userprice100 + userprice500; //100원 돈 변수와 500원 돈 변수를 합해 사용자가 넣어준 돈 저장
					System.out.println("userprice : "+ userprice);
					
					textField.setText(String.valueOf(userprice));
					myMachine.setuserPrice(userprice);
					paynum++; //사용자가 사먹은 횟수 증가
					myMachine.setSales(selectBeveragePrice); //판매량변수에 현재 넣은 돈 저장
				}
			}
		});
		btnNewButton_1.setBounds(33, 44, 105, 27);
		panel_11.add(btnNewButton_1);
		
		JLabel label_10 = new JLabel("돈 투입구");
		label_10.setFont(new Font("굴림", Font.BOLD, 15));
		label_10.setBounds(14, 12, 89, 18);
		panel_11.add(label_10);

		
		JCheckBox checkBox = new JCheckBox("관리자모드로→");
		checkBox.addActionListener(new ActionListener() { // 사용자가 넣어준 동전 받아오는 이벤트 구현
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() ==checkBox ){
					try {
						ManagerFrame manage = new ManagerFrame();
						manage.setVisible(true);
					} catch (ClassNotFoundException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		
		checkBox.setBounds(277, 540, 131, 27);
		panel.add(checkBox);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_1.setBounds(14, 415, 394, 123);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel label_11 = new JLabel("거스름돈 반환구");
		label_11.setFont(new Font("굴림", Font.BOLD, 15));
		label_11.setBounds(14, 12, 122, 18);
		panel_1.add(label_11);
		
		JLabel lblNewLabel_1 = new JLabel("100원 : ");
		lblNewLabel_1.setBounds(230, 36, 62, 18);
		panel_1.add(lblNewLabel_1);
		
		JLabel label_12 = new JLabel("500원 : ");
		label_12.setBounds(230, 66, 62, 18);
		panel_1.add(label_12);
		
		//100원 거스름돈 표시할 칸
		JFormattedTextField formattedTextField_3 = new JFormattedTextField();
		formattedTextField_3.setBounds(284, 33, 80, 24);
		panel_1.add(formattedTextField_3);
		
		//500원 거스름돈 표시할 칸
		JFormattedTextField formattedTextField_4 = new JFormattedTextField();
		formattedTextField_4.setBounds(284, 63, 80, 24);
		panel_1.add(formattedTextField_4);
		
		//거스름돈 계산, 표시 구현
		JButton button = new JButton("거스름돈 받기");
		button.addActionListener(new ActionListener() { // 사용자가 넣어준 동전 받아오는 이벤트 구현
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == button ){
					int change; //거스름돈 변수
					
					String string100=null; //칸에 100원 거스름돈 표시해주기 위해 string 변수 선언 
					String string500=null; //칸에 500원 거스름돈 표시해주기 위해 string 변수 선언 
					change = userprice - selectBeveragePrice;
					try {
						int pay100=myMachine.pay100(change, selectBeveragePrice);
						int pay500=myMachine.pay500(change, selectBeveragePrice);
						
						System.out.println("100원 거스릅돈 : " + pay100);
						System.out.println("500원 거스릅돈 : " + pay500);
						
						//칸에 표시를 위해 string값으로 변환
						string100 = String.valueOf(pay100);
						string500 = String.valueOf(pay500);
				       
					} catch (Exception e2) {
						System.out.println("거스름돈 가져오기 실패");
						e2.printStackTrace();
					}
					
				formattedTextField_3.setText(string100);
				formattedTextField_4.setText(string500);
				}
			}
		});
		button.setBounds(31, 62, 130, 27);
		panel_1.add(button);
		
		
		
		
	}
}
