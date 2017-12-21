import java.io.*;
import java.util.Scanner;

public class Beverage {
	// data
	private int trayNum; // 상품번호
	protected String trayName; // 제품명
	protected int price; // 제품가격 = 원금
	protected int stock; // 재고량
	private int sales; // 판매량

	// 생성자

	Beverage(int trayNum, String trayName, int price, int stock) {
		this.trayNum = trayNum;
		this.trayName = trayName;
		this.price = price;
		this.stock = stock;
	}
	
	Beverage(){
		
	}
	// 함수 구현
	// trayNum set 함수
	public void settrayNum(int num) {
		this.trayNum = num;
	}

	// trayNum get 함수
	public int gettrayNum() {
		return trayNum;
	}

	// trayName set 함수
	public void settrayName(String name) {
		this.trayName = name;
	}

	// trayName get 함수
	public String gettrayName() {
		return trayName;
	}

	// price set 함수
	public void setPrice(int userprice) {
		this.price = userprice;
	}

	// price get 함수
	public int getPrice(int num) {
		return price;
	}

	// stock set 함수
	public void setStock(int amount) {
		this.stock = amount;
	}

	// stock 변경하는 함수
	public int changeStock(int num) {
		stock -= num;
		return stock;
	}

	// stock get 함수
	public int getstock() {
		return stock;
	}

	// 제품의 판매량 변경한다
	public void setSales(int salesamount) {
		this.sales = salesamount;
	}

	// 제품의 판매량을 알 수 있다
	public int getSales() {
		return sales;
	}

	// 재고 추가 함수 구현
	public void addStock(int amount) {
		stock += amount;
	}

	// 재고 감소 함수 구현
	public void subStock(int amount) {
		stock -= amount;
	}

	// 판매량 증가 함수
	public void addSales(int amount) {
		sales += amount;
	}
	
	// 파일에 쓰는 함수
	public void writeBeverageFile(DataOutputStream dw) throws Exception {
		try {
			dw.writeInt(trayNum);
			dw.writeChars(trayName);
			dw.writeInt(price);
			dw.writeInt(stock);
		
		} 
		catch (Exception ioe) {
			throw new Exception("저장할 수 없습니다.");

		}
	}
	
	//파일을 불러오는 함수
	public void bringBeverageFile(DataInputStream iw) throws Exception{
		try{
			iw.readInt();
			iw.readUTF();
			iw.readInt();
			iw.readInt();
			
		}
		catch(Exception ioe){
			throw new Exception("파일을 불러올 수 없습니다");
			
		}
	}

	@Override
	public String toString() {
		return "Beverage [trayNum=" + trayNum + ", trayName=" + trayName + ", price=" + price + ", stock=" + stock
				+ ", sales=" + sales + "]";
	}
	
	
}
