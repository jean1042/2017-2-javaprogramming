import java.io.*;
import java.util.Scanner;

public class Beverage {
	// data
	private int trayNum; // ��ǰ��ȣ
	protected String trayName; // ��ǰ��
	protected int price; // ��ǰ���� = ����
	protected int stock; // ���
	private int sales; // �Ǹŷ�

	// ������

	Beverage(int trayNum, String trayName, int price, int stock) {
		this.trayNum = trayNum;
		this.trayName = trayName;
		this.price = price;
		this.stock = stock;
	}
	
	Beverage(){
		
	}
	// �Լ� ����
	// trayNum set �Լ�
	public void settrayNum(int num) {
		this.trayNum = num;
	}

	// trayNum get �Լ�
	public int gettrayNum() {
		return trayNum;
	}

	// trayName set �Լ�
	public void settrayName(String name) {
		this.trayName = name;
	}

	// trayName get �Լ�
	public String gettrayName() {
		return trayName;
	}

	// price set �Լ�
	public void setPrice(int userprice) {
		this.price = userprice;
	}

	// price get �Լ�
	public int getPrice(int num) {
		return price;
	}

	// stock set �Լ�
	public void setStock(int amount) {
		this.stock = amount;
	}

	// stock �����ϴ� �Լ�
	public int changeStock(int num) {
		stock -= num;
		return stock;
	}

	// stock get �Լ�
	public int getstock() {
		return stock;
	}

	// ��ǰ�� �Ǹŷ� �����Ѵ�
	public void setSales(int salesamount) {
		this.sales = salesamount;
	}

	// ��ǰ�� �Ǹŷ��� �� �� �ִ�
	public int getSales() {
		return sales;
	}

	// ��� �߰� �Լ� ����
	public void addStock(int amount) {
		stock += amount;
	}

	// ��� ���� �Լ� ����
	public void subStock(int amount) {
		stock -= amount;
	}

	// �Ǹŷ� ���� �Լ�
	public void addSales(int amount) {
		sales += amount;
	}
	
	// ���Ͽ� ���� �Լ�
	public void writeBeverageFile(DataOutputStream dw) throws Exception {
		try {
			dw.writeInt(trayNum);
			dw.writeChars(trayName);
			dw.writeInt(price);
			dw.writeInt(stock);
		
		} 
		catch (Exception ioe) {
			throw new Exception("������ �� �����ϴ�.");

		}
	}
	
	//������ �ҷ����� �Լ�
	public void bringBeverageFile(DataInputStream iw) throws Exception{
		try{
			iw.readInt();
			iw.readUTF();
			iw.readInt();
			iw.readInt();
			
		}
		catch(Exception ioe){
			throw new Exception("������ �ҷ��� �� �����ϴ�");
			
		}
	}

	@Override
	public String toString() {
		return "Beverage [trayNum=" + trayNum + ", trayName=" + trayName + ", price=" + price + ", stock=" + stock
				+ ", sales=" + sales + "]";
	}
	
	
}
