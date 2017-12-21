package newVendingMachine_1105.copy;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.JMenu;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JMenuItem;
import javax.swing.JSlider;
import javax.swing.JTree;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JPasswordField;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;
import javax.swing.*;
import java.awt.event.*;

public class ManagerFrame extends JFrame{

	private JPanel contentPane;
	private JTextField textField;
	private JTable table_1;
	private JTextField textField_2;
	private JTable table;
	private JTextField textField_3;
	private JTextField price;
	private JComboBox comboBox;
	static int traySize;
	private JTextField textFieldnum;
	private JLabel msg;
	private int stock;
	private JTextField textField_4;
	private JTextField textField_1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) throws Exception {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManagerFrame frame = new ManagerFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
					System.out.println("main_frame 보여주기 실패");
				}
			}
		});

	}

	public ManagerFrame() throws ClassNotFoundException {
		VendingMachine myMachine = new VendingMachine(20);
		Beverage p1 = new Beverage();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 596);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setToolTipText("음료\r\n");
		panel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel.setBounds(5, 12, 413, 201);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel label = new JLabel("음료수");
		label.setFont(new Font("굴림", Font.BOLD, 15));
		label.setBounds(14, 9, 98, 18);
		panel.add(label);

		JLabel lblNewLabel = new JLabel("음료번호");
		lblNewLabel.setBounds(14, 170, 67, 18);
		panel.add(lblNewLabel);

		JLabel label_1 = new JLabel("재고");
		label_1.setBounds(14, 137, 67, 18);
		panel.add(label_1);

		JSpinner spinner = new JSpinner();
		spinner.setBounds(81, 134, 34, 24);
		panel.add(spinner);

		JLabel label_2 = new JLabel("음료이름:");
		label_2.setBounds(14, 74, 67, 18);
		panel.add(label_2);

		textField = new JTextField();
		textField.setBounds(80, 73, 116, 24);
		panel.add(textField);
		textField.setColumns(10);

		// 1. 음료수 추가 _ 새로운 음료수 관리자에게 직접 입력받아서 추가한다.
		JButton btnNewButton = new JButton("추가");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == btnNewButton) {
					Beverage p1 = new Beverage();
					
					//1) 추가할 번호(JComboBox에서 고름)	
					String scantrayNum=textField_4.getText();
					int usertrayNum=Integer.parseInt(scantrayNum);
					
					System.out.println("usertrayNum = "+usertrayNum);
					
					//2) 가격
					String scanPrice=price.getText();
					int userPrice=Integer.parseInt(scanPrice);
					
					//3) 음료수 이름
					String trayName = textField.getText();
					p1 = new Beverage(usertrayNum, trayName, userPrice, stock);
					myMachine.addBeveragelist(p1);
					
					textFieldnum.setText(null);
					textField.setText(null);
					price.setText(null);
					textField_4.setText(null);
					
					// 이거 구현해 1-> 추가 되었습니다. 화면 띄우기
					System.out.println(usertrayNum+ " 번 에 음료 추가가 완료되었습니다.");
					
					
				}
			}
		});
		btnNewButton.setBounds(294, 74, 105, 27);
		panel.add(btnNewButton);

		// 2. 음료수 삭제 버튼 _ 삭제 버튼 이벤트 처리까지 구현
		JButton button_13 = new JButton("삭제");
		button_13.addActionListener(new ActionListener() { // 삭제 버튼 이벤트 구현
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == button_13) {

					String userdeletenumberstr = textField_4.getText(); // 사용자가
					int userdeletenumber = Integer.parseInt(userdeletenumberstr);													
					
					myMachine.searchBeveragelist(userdeletenumber); // 배열 어디있는지 찾음
					System.out.println("userdeletenumber = "+ userdeletenumber);
																	
					try {
						myMachine.deleteBeveragelist(userdeletenumber);
					} catch (Exception e1) {
						e1.printStackTrace();
						System.out.println("삭제 실패");
					}
					myMachine.settraySize(traySize - 1);

				}
			}
		});
		button_13.setBounds(294, 113, 105, 27);
		panel.add(button_13);

		// label_개수
		JLabel label_4 = new JLabel("개수");
		label_4.setBounds(14, 39, 67, 18);
		panel.add(label_4);

		JLabel label_7 = new JLabel("가격");
		label_7.setBounds(14, 108, 67, 18);
		panel.add(label_7);

		price = new JTextField();
		price.setColumns(10);
		price.setBounds(80, 104, 116, 24);
		panel.add(price);

		// 개수버튼
		textFieldnum = new JTextField();
		textFieldnum.addActionListener(new ActionListener() { // 개수 동전 받아오는 이벤트
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() ==textFieldnum) {
					String scanStock= textField_1.getText();
					stock=Integer.parseInt(scanStock); //textField 로 받아온 100원 문자 숫자로 바꿔주기
							
				}
			}
		});
		
		textFieldnum.setBounds(81, 39, 116, 24);
		panel.add(textFieldnum);
		textFieldnum.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(80, 167, 116, 24);
		panel.add(textField_4);
		textField_4.setColumns(10);

		// comboBox에 들어갈 숫자 배열 선언
		String[] rainbow = { "1", "2", "3", "4", "5", "6" };

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_3.setLayout(null);
		panel_3.setBounds(5, 214, 413, 130);
		contentPane.add(panel_3);

		JLabel label_5 = new JLabel("동전");
		label_5.setFont(new Font("굴림", Font.BOLD, 15));
		label_5.setBounds(14, 12, 137, 18);
		panel_3.add(label_5);

		table_1 = new JTable();
		table_1.setBounds(24, 131, 178, -78);
		panel_3.add(table_1);

		JLabel lblNewLabel_1 = new JLabel("100원:");
		lblNewLabel_1.setBounds(14, 42, 62, 18);
		panel_3.add(lblNewLabel_1);

		JLabel label_6 = new JLabel("500원:");
		label_6.setBounds(14, 75, 62, 18);
		panel_3.add(label_6);


		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(73, 72, 116, 24);
		panel_3.add(textField_2);

		// 3. 100원, 500원 동전 보충
		JButton button_12 = new JButton("추가");
		button_12.addActionListener(new ActionListener() { // 100원 동전 받아오는 이벤트
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == button_12) {
					String scan100= textField_1.getText();
					int money100=Integer.parseInt(scan100); //textField 로 받아온 100원 문자 숫자로 바꿔주기
					myMachine.setCurrentMoney100(money100);			
					
					String scan500= textField_2.getText(); //500원 동전 받아오는 이벤트
					int money500=Integer.parseInt(scan500); //textField 로 받아온 100원 문자 숫자로 바꿔주기
					myMachine.setCurrentMoney500(money500);
				
					
				}
			}
		});
		button_12.setBounds(294, 25, 105, 27);
		panel_3.add(button_12);
		
		//4. 동전을 자판기 밖으로 꺼내 수합하고, 초기화 하는 이벤트
		JButton button_16 = new JButton("동전 수합");
		button_16.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == button_16) {
					myMachine.setCurrentMoney100(0);
					myMachine.setCurrentMoney500(0);
				}
			}
		});
		
		button_16.setBounds(294, 71, 105, 27);
		panel_3.add(button_16);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(73, 42, 116, 24);
		panel_3.add(textField_1);

		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_1.setBounds(5, 356, 254, 162);
		contentPane.add(panel_1);

		JLabel label_3 = new JLabel("판매량");
		label_3.setFont(new Font("굴림", Font.BOLD, 15));
		label_3.setBounds(14, 12, 137, 18);
		panel_1.add(label_3);

		table = new JTable();
		table.setBounds(24, 131, 178, -78);
		panel_1.add(table);

		JButton button = new JButton("판매량확인");
		button.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == button) {
					int totalSales;
					totalSales = myMachine.getSales();
					String totalSalesstr = String.valueOf(totalSales);
					textField_3.setText(totalSalesstr);
					
				}
			}
		});
		button.setBounds(14, 52, 105, 27);
		panel_1.add(button);

		JButton btnReset = new JButton("초기화");
		btnReset.setBounds(135, 123, 105, 27);
		panel_1.add(btnReset);

		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(133, 53, 107, 24);
		panel_1.add(textField_3);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_2.setBounds(271, 356, 147, 162);
		contentPane.add(panel_2);

		JButton button_2 = new JButton("1");
		panel_2.add(button_2);

		JButton button_4 = new JButton("2");
		panel_2.add(button_4);

		JButton button_5 = new JButton("3");
		panel_2.add(button_5);

		JButton button_6 = new JButton("4");
		panel_2.add(button_6);

		JButton button_7 = new JButton("5");
		panel_2.add(button_7);

		JButton button_8 = new JButton("6");
		panel_2.add(button_8);

		JButton button_9 = new JButton("7");
		panel_2.add(button_9);

		JButton button_10 = new JButton("8");
		panel_2.add(button_10);

		JButton button_11 = new JButton("9");
		panel_2.add(button_11);

		JButton button_17 = new JButton("*");
		panel_2.add(button_17);

		JButton button_18 = new JButton("0");
		panel_2.add(button_18);

		JButton button_19 = new JButton("#");
		panel_2.add(button_19);
		
		//사용자 모드 체크박스 체크하면 사용자모드 화면 뜨도록 구현
		JCheckBox checkBox = new JCheckBox("사용자모드로→");
		checkBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() ==checkBox ){
					try {
						MainFrame mainframe = new MainFrame();
						mainframe.setVisible(true);
					} catch (ClassNotFoundException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		checkBox.setBounds(301, 522, 131, 27);
		contentPane.add(checkBox);
	}
}
