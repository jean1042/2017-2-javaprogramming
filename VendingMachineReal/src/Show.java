
import java.io.*;
import java.util.Scanner;

public class Show {

	// DataOutputStream�� ��ü fw ����
	static DataOutputStream fw;
	static DataOutputStream dw;
	
	Beverage tempBeverage = new Beverage();
	// database
	static int stockNum; // ����� ����
	static int traySize; // Ʈ������ ������ ����
	static int paynum = 0; // ����ڰ� ������� ����� Ƚ��

	// ������ �ҷ��;� ��
	static FileInputStream a;
	static DataInputStream in;

	// mymachine �ȿ� ����ִ� ������� �о�;���

	static VendingMachine myMachine;
	 // VendingMachine��
																	// ������ �����
																	// ���Ǳ� ����


	public static void main(String args[]) throws Exception {
		
		try{

			
			a = new FileInputStream("BeverageOutput.txt");
			in = new DataInputStream(a);
			fw = new DataOutputStream(dw);
		
			myMachine=new VendingMachine(20, in);
		}catch(Exception e) {
			System.out.println(e);
		}
		
		Show myscreen = new Show();
		myscreen.firstmain();

	}

	public static void firstmain() throws Exception {

		System.out.println("----------�����/������ ��� ����----------- ");
		System.out.println(" ");
		System.out.println(" �����ڸ��� ������� �߰��� �� ����ڸ�带 �̿��� �ֽʽÿ�");
		System.out.println(" 1.  ����ڸ��");
		System.out.println(" 99. �����ڸ��");
		System.out.println(" 0. ���α׷� ����");
		System.out.println("------------------------------------- ");

		int usernum; // ����ڸ��, ������ ��� ������ ���� �����ϴ� ���� ����
		Scanner scan = new Scanner(System.in);
		usernum = scan.nextInt();

		switch (usernum) {
		case 1:
			userMode();
			break;
		case 99:
			managerMode();
			break;

		case 0:
			System.out.println("���α׷� ����");
			fw.close();
			a.close();
			in.close();
		}
	}

	public static void userMode() throws Exception {

		// 1. ����ڿ��� �� �Է¹ޱ�
		System.out.println("���� �־��ּ���");
		int userprice;// ����ڰ� �ִ� �ݾ� ���� ����
		Scanner scan1 = new Scanner(System.in);
		userprice = scan1.nextInt();

		paynum++; // ����ڰ� ������� ����� Ƚ�� ����
		// Vending machine�� price�� ����ڰ� �Է��� �� �ֱ�
		myMachine.setuserPrice(userprice);
		// ����ڿ��� �Է¹��� ����ݾ� �˷��ֱ�
		System.out.println("����ݾ� : " + myMachine.getuserPrice(userprice) + " �Դϴ�.");

		// 2. �ݾ׿� ���� �̾� ���� �� �ִ� ����� �ٸ��� �ؼ� ����ϱ�
		System.out.println("������ �� �ִ� ����� �ڿ�  *�� ǥ�õǾ� �ֽ��ϴ�.");

		for (int i = 0; i < traySize; i++) {
			int beverageprice; // ����� ������ ������ �������� ���� ����
			beverageprice = myMachine.getuserPrice(myMachine.searchBeverageObj(i).getPrice(i));

			if (userprice >= beverageprice) // ����ڰ� ���� �ݾ��� ����� �ݾ׺��� ũ�ų� ���� �� *��
				// �Բ� ���
				System.out.println(myMachine.getBeverageNum(i) + "�� : " + myMachine.getBeverage(i).gettrayName() + "*");

			else if (userprice < beverageprice) // ����ڰ� ���� �ݾ��� ����� �ݾ׺��� ������ �̸���
				// ���
				System.out.println(myMachine.getBeverageNum(i) + "�� : " + myMachine.getBeverage(i).gettrayName());

		}

		// 3. ���� ���� ����

		System.out.println("�޴��� ������ �ּ���");
		Scanner scanuser = new Scanner(System.in);

		// ��������� �Է°����� �� �޾Ҵ�.

		int money, selectBeverageId, selectBeveragePrice, selectBeverageindex; // ����ڰ�
		// �Է���
		// ���ǹ�ȣ
		// ����
		// ����
		String selectBeverageName; // �����̸� ���� ����

		selectBeverageId = scanuser.nextInt();

		selectBeverageindex = myMachine.searchBeverage(selectBeverageId);

		selectBeverageName = myMachine.getBeverage(selectBeverageindex).gettrayName();
		selectBeveragePrice = myMachine.getBeverage(selectBeverageindex).getPrice(selectBeverageindex);
		System.out.println("�����Ͻ� �����" + selectBeverageName + "�̸� �ݾ���" + selectBeveragePrice + "�Դϴ�.");

		myMachine.setSales(selectBeveragePrice);

		myMachine.getBeverage(selectBeverageindex).changeStock(1);

		// 4. �Ž����� �ޱ�

		// �Ž����� ���� ����
		int change;
		change = userprice - selectBeveragePrice;
		System.out.println("-----�Ž�����------");
		System.out.println("500�� : " + myMachine.pay500(change, selectBeveragePrice) + "��");
		System.out.println("100�� : " + myMachine.pay100(change, selectBeveragePrice) + "��");

		// ���Ǳ⿡ �Ž�������ŭ ������ 500, 100���� ���� ������
		int something500 = myMachine.changeCurrentMoney500(myMachine.pay500(change, selectBeveragePrice));
		int something100 = myMachine.changeCurrentMoney100(myMachine.pay100(change, selectBeveragePrice));

		System.out.println("---------- ");
		System.out.println("���ְ� ��ʽÿ�.");
		System.out.println("----------");

		System.out.println("�ٸ� ������� �����Ͻðڽ��ϱ�? (�ٸ� ����� ���� : 0�� / �����-������ ����ȭ������ ���ư��� : 1��)");
		Scanner scannum = new Scanner(System.in);
		int selectnum;
		selectnum = scannum.nextInt();
		if (selectnum == 0)
			userMode();

		else
			System.out.println("���Ǳ⸦ �̿����ּż� �����մϴ�.");
		firstmain();
	}

	public static void managerMode() throws Exception {

		System.out.println("-----------������ ���-------- ");
		System.out.println(" 1.  ���ο� ����� �߰�");
		System.out.println(" 2.  ���Ǳ⿡ ���� �߰�");
		System.out.println(" 3.  ���� ���Ǳ��� ������ ���� Ȯ��");
		System.out.println(" 4.  ����� ����");
		System.out.println(" 5.  �Ǹŷ� ���");
		System.out.println(" 6.  ����� ��� Ȯ��");
		System.out.println(" 0.  ����� �޴��� ���ư���");
		System.out.println("-------------------------- ");

		int managernumber;// manager�� ������ ��� ���� ����
		Scanner scanmanager = new Scanner(System.in);
		managernumber = scanmanager.nextInt();

		switch (managernumber) {
		case 1:

			// 1. ���ο� ����� �����ڿ��� ���� �Է¹޾Ƽ� �߰��Ѵ�.

			// �����ڿ��� traySize �Է¹ޱ�
			System.out.println("�߰��� ������� ������ �Է��ϼ���");
			Scanner scansize = new Scanner(System.in);
			traySize = scansize.nextInt();

			for (int i = 0; i < traySize; i++) {
				System.out
						.println("�߰��� ������� traynumber, �̸�, ����, ��� �Է��ϼ��� (ex) 0(enter) ���̴�(enter) 500(enter) 0(enter)");
				Scanner scan1 = new Scanner(System.in);
				int trayNum = scan1.nextInt();
				Scanner scan2 = new Scanner(System.in);
				String trayName = scan2.nextLine();
				Scanner scan3 = new Scanner(System.in);
				int price = scan3.nextInt();
				Scanner scan4 = new Scanner(System.in);
				int stock = scan4.nextInt();
				// Beverage�� ��ü�� ���� trays[]�� insert���� �迭 ����ϱ�

				Beverage p1 = new Beverage(trayNum, trayName, price, stock);
				int beverage1 = myMachine.addBeverage(p1);

				// �迭 ��� (�� ������ ��ȣtrayNum ���)
				System.out.println(beverage1 + " �� Ʈ���̿� �߰��Ǿ����ϴ�.");

				// ���Ͽ� ������ ������ ���� ����
				dw = new DataOutputStream(new FileOutputStream("BeverageOutput.txt"));
				
				p1.writeBeverageFile(dw);

			}

			in.close();

			managerMode();
			break;

		
		// 2. ���� ����-100��¥��
		case 2:
			int money100=0; // ���� vending machine�� �� 100���� ����
			System.out.println("������ 100��¥�� ������ ������ �Է��Ͻÿ�");
			Scanner scan100 = new Scanner(System.in);
			
			money100 = myMachine.setCurrentMoney100(scan100.nextInt());

			// ��������-500��¥��
			int money500=0; // 500���� ����
			System.out.println("������ 500��¥�� ������ ������ �Է��Ͻÿ�");
			Scanner scan500 = new Scanner(System.in);
			money500 = myMachine.setCurrentMoney500(scan500.nextInt());

			myMachine.saveFile(dw);
			managerMode();
			break;

		// 3. ���� �ִ� 500���� 100���� ������ ���� Ȯ���ϱ�
		case 3:
			System.out.println("���� ���Ǳ��� 500���� ������" + myMachine.getCurrentMoney500() + " �Դϴ�.");
			
			System.out.println("���� ���Ǳ��� 100���� ������" + myMachine.getCurrentMoney100() + " �Դϴ�.");

			managerMode();
			break;

		// 4. ����� ����
		case 4:

			int userdeletenumber; // ����ڰ� �����Ϸ��� �ϴ� ��ȣ �Է¹ް�
			System.out.println("������ ��ȣ�� �Է��ϼ���");
			for (int i = 0; i < traySize; i++) {
				System.out.println(myMachine.searchBeverageNum(i) + " ��");
			}

			Scanner scan2 = new Scanner(System.in);
			userdeletenumber = scan2.nextInt();

			myMachine.searchBeverage(userdeletenumber); // �迭 ����ִ��� ã��

			System.out.println(userdeletenumber + " �� ������� �����ϰڽ��ϴ�.");
			System.out.println(myMachine.searchBeverage(userdeletenumber));

			myMachine.deleteBeverage(userdeletenumber); // ����� ����
			
			// ������� ���������� traySize �ϳ� ���� ����
			myMachine.settraySize(traySize - 1);
		
			System.out.println(traySize);
			System.out.println("����� ���� �Ϸ�");

			// ���� �ִ� ����� ���
			for (int j = 0; j < traySize - 1; j++) {
				System.out.println(myMachine.getBeverage(j).gettrayName());
			}
	

			managerMode();
			break;

		// 5. �Ǹŷ� ���
		case 5:
			int totalSales;
			totalSales = myMachine.getSales();
			System.out.println("�� �Ǹ� ������ " + totalSales + " �� �Դϴ�.");

			managerMode();
			break;

		// 6. ��� Ȯ��
		case 6:
			int checkStock; // �����ڰ� Ȯ���� ������� ��� ���� ����
			int checkStockNum; // �����ڰ� Ȯ���� ����� �Է��ϴ� ���� �޾ƿ��� ���� ����
			System.out.println("� ������� ��� Ȯ���Ͻðڽ��ϱ�? ");
			
			for (int i = 0; i < traySize; i++) {
				System.out.println(myMachine.searchBeverageNum(i) + " ��");
			}

			Scanner scanstock = new Scanner(System.in);
			checkStockNum = scanstock.nextInt();

			checkStock = myMachine.searchBeverageObj(checkStockNum).getstock();
			System.out.println("���� ����" + checkStock + " �� �Դϴ�.");

			managerMode();
			break;
		case 0:
			firstmain();

		}
	}
}
