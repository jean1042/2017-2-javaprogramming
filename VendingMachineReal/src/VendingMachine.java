import java.io.*;
import java.util.Arrays;

public class VendingMachine {

	// data
	int size;
	static int count = 0; // ���빰�� ����
	int usermoney; // (�ӽ�) ����ڰ� �־��ִ� ��
	static int currentMoney100;
	static int currentMoney500;
	int sales = 0; // �Ǹŷ� �����ϴ� �Լ�
	int deletenum;
	// beverage ��ü�� ��� trays ����
	Beverage trays[];

	Beverage tempBeverage;
	// beverage�� ���� �˷��ִ� ����

	// ������
	
	VendingMachine(int size, DataInputStream di) {
		
		
			trays = new Beverage[size];
			try{
			//���Ϸκ��� ������ �о��
				
			di=new DataInputStream(new FileInputStream("Beverageoutput.txt"));
			currentMoney100=di.readInt(); 
			currentMoney500=di.readInt();
			count=0;
		
			while(true){
				tempBeverage= new Beverage();
				
				tempBeverage.settrayNum(di.readInt());
				tempBeverage.settrayName(di.readUTF());
				tempBeverage.setPrice(di.readInt());
				tempBeverage.setStock(di.readInt());
				
				trays[count]=tempBeverage;
			count++;
			}
		}
			catch(IOException ioe){
				System.out.println(ioe);
			}
	}

		
	// beverage ��ü�� Vendingmachine�� ����ִ� �Լ�
	public int addBeverage(Beverage beverageObj) {
		// trays=new Beverage[size];
		trays[count++] = beverageObj;
		return (count - 1);
	}

	// ���ڸ� �Է��ϸ� tray���� ã�� �� �����ȣ�� ��ȯ���ִ� �Լ�
	public int searchBeverage(int usernum) {
		for (int i = 0; i < count - 1; i++)
			if (usernum == trays[i].gettrayNum()) {
				usernum = i;
			}
		return usernum;
	}

	// 2) ���ڸ� �Է��ϸ� tray ���� ã�� �� ���� ��ü�� ��ȯ���ִ� �Լ�
	public Beverage searchBeverageObj(int usernum) throws Exception {
		int i = searchBeverage(usernum);

		if (i > -1)
			return trays[i];

		else
			throw new Exception("���� ����");
	}

	// ���ڸ� �Է��ϸ� tray ���� ã�� �� ���� ��ȣ�� ��ȯ���ִ� �Լ�
	public int searchBeverageNum(int usernum) {
		for (int i = 0; i < count - 1; i++)
			if (usernum == trays[i].gettrayNum()) {
				usernum = i;
			}
		return usernum;
	}

	// ����ڰ� �־��� ���� ���Ǳ⿡ �־���� �Լ�
	public void setuserPrice(int usermoney) {
		this.usermoney = usermoney;
	}

	// ����ڰ� �־��� ���� ��ȯ�ϴ� �Լ�
	public int getuserPrice(int usermoney) {
		return usermoney;
	}

	// �Ǹŷ� set �Լ�
	public void setSales(int usermoney) {
		sales += usermoney;
	}

	// �Ǹŷ� �����س��� �Լ�
	public int getSales() {
		return sales;
	}

	// ������ ��ȣ �޾ƿ��� �Լ�
	public int getdeletenum(int number) {
		this.deletenum = number;
		return deletenum;
	}

	// SEARCH �Լ� �̿��ؼ� ����� �����ϱ�
	public void deleteBeverage(int index) {

		int index2 = searchBeverage(index);
		// if(i>-1){
		// trays[i]=null;
		for (int i = index2; i < count; i++) {
			trays[i] = trays[i + 1];

		}
		count--;

		// throw new Exception("������ �������� �ʽ��ϴ�");

		// try {
		// index = searchBeverage(index);

		// } catch (Exception e) {
		// throw new Exception("�ش� ��ǰ�� �����ϴ�.");
		// }

		// if(index==count){ //�迭�� �Ǹ����� �϶�
		// trays[count]=null;
		// }
	}

	// tray�� ���� ��ġ�� Beverage �̸��� ��ȯ���ִ� �Լ�
	public String printBeverage(int index) {
		return (trays[index].gettrayName());
	}

	// tray�� ���� ��ġ�� Beverage ��ü�� ��ȯ ���ִ� �Լ�
	public Beverage getBeverage(int index) {
		return trays[index];
	}

	// tray�� ���� ��ġ�� Beverage ��ȣ�� ��ȯ ���ִ� �Լ�
	public int getBeverageNum(int index) {
		return index;
	}

	// ���ǱⰡ ���� 100��¥�� ������ ���� �����Ѵ�
	public int setCurrentMoney100(int money100) {
		currentMoney100 += money100;
		return currentMoney100;

	}

	// ���ǱⰡ ���� 500��¥�� ������ ���� �����Ѵ�
	public int setCurrentMoney500(int money500) {
		currentMoney500 += money500;
		return currentMoney500;
	}

	public int changeCurrentMoney500(int money500) {
		currentMoney500 -= money500;
		return currentMoney500;
	}

	public int changeCurrentMoney100(int money100) {
		currentMoney100 -= money100;
		return currentMoney100;
	}

	// ���ǱⰡ ���� 100��¥�� ������ ���� ��ȯ�Ѵ�.
	public int getCurrentMoney100() {
		System.out.println(currentMoney100);
		return currentMoney100;

	}

	// ���ǱⰡ ���� 500��¥�� ������ ���� ��ȯ�Ѵ�
	public int getCurrentMoney500() {
		System.out.println(currentMoney500);
		return currentMoney500;
		
	}

	// traySize ���ϴ� �Լ�
	public void settraySize(int num) {
		this.size = num;
	}

	// tray size ������ �˷��ִ� �Լ�
	public int gettraySize() {
		return trays.length;
	}

	// pay�Լ� -> 100��¥��, 500��¥�� ����� �޴� Ŭ���� �Ž����� ���
	public void pay(int beveragePrice) {
		// �Ž�����
		int change;// �Ž����� ����
		int coin500; // ����ڿ��� �ִ� 500��¥�� ������ ����
		int coin100; // ����ڿ��� �ִ� 100��¥�� ������ ����
		change = usermoney - beveragePrice;
		coin500 = change / 500;
		int rest = change % 500;
		coin100 = rest / 100;

	}

	// 500��¥�� �Ž����� ��ȯ���ִ� �Լ�
	public int pay500(int change, int beveragePrice) {

		int rest;
		int coin500;
		change = usermoney - beveragePrice;
		rest = change % 500;
		coin500 = change / 500;

		currentMoney500 -= coin500;
		return coin500;

	}

	// 100��¥�� �Ž����� ��ȯ���ִ� �Լ�
	public int pay100(int change, int beveragePrice) {

		int rest;
		int coin100, coin500;
		change = usermoney - beveragePrice;
		rest = change % 500;
		coin500 = change / 500;
		coin100 = rest / 100;

		currentMoney100 -= coin100;
		return coin100;
	}

	//
	public void saveFile(DataOutputStream fw) throws Exception {
		try {
			fw.write(currentMoney100);
			fw.write(currentMoney500);

			for (int cnt = 0; cnt < count; cnt++)
				trays[cnt].writeBeverageFile(fw);
		} catch (IOException ioe) {
			throw new IOException("���¸� ������ �� �����ϴ�");
		}
	}


	@Override
	public String toString() {
		return "VendingMachine [size=" + size + ", usermoney=" + usermoney + ", sales=" + sales + ", deletenum="
				+ deletenum + ", trays=" + Arrays.toString(trays) + ", tempBeverage=" + tempBeverage + "]";
	}
	
}
