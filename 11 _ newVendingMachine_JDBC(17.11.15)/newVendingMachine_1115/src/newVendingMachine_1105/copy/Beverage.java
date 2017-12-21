package newVendingMachine_1105.copy;

import java.io.*;
import java.util.Scanner;

public class Beverage implements Serializable {
	 private static final long serialVersionUID = 1L;
	
	 // data
	private int trayNum; // 상품번호
	private String trayName; // 제품명
	private int price; // 제품가격 = 원금
	private int stock; // 재고량
	private int sales; // 판매량

	// 생성자

	Beverage(int trayNum, String trayName, int price, int stock) {
		this.trayNum = trayNum;
		this.trayName = trayName;
		this.price = price;
		this.stock = stock;
		this.sales=0;
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
	public int getPrice() {
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
	public int getStock() {
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
	
	
	// 수정10) 객체의 직렬화 - 파일에 쓰는 함수
	public void writeBeverageFile() throws Exception {
		FileOutputStream file = null;
		ObjectOutputStream out = null;
		
		try {
			out= new ObjectOutputStream(new FileOutputStream("output3.txt"));
			out.writeObject(this);
			System.out.println("파일에 잘 써졌습니다.");
		} 
		catch (Exception ioe) {
			throw new Exception("저장할 수 없습니다.");
		}
		finally {
			if(file !=null){
				try{
					file.close();
				}
				catch (IOException e){
					throw new Exception("파일로 쓸 수 없습니다.");
				}
			} 
			if( out!=null){
				try{
					file.close();
				}
				catch (IOException e){
					throw new Exception("파일로 쓸 수 없습니다.");
				}
			}
		}
	}
	
	
	//파일을 불러오는 함수
	public void bringBeverageFile() throws Exception{
		FileInputStream file2 = null;
		ObjectInputStream in = null;
		
		
		try{
			file2= new FileInputStream("output3.txt");
			in = new ObjectInputStream(file2);
			
			Beverage b=(Beverage) in.readObject();
			System.out.println(b.toString());
		}
		catch(Exception ioe){
			ioe.printStackTrace();
		} finally {
            if (file2 != null) {
                try {
                    file2.close();
                } catch (IOException e) {
                    throw new Exception("2파일을 읽을 수 없습니다.");
                }
            }
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    throw new Exception("3파일을 읽을 수 없습니다.");
                }
            
	}
}
		}

	@Override
	public String toString() {
		return "Beverage [trayNum=" + trayNum + ", trayName=" + trayName + ", price=" + price + ", stock=" + stock
				+ ", sales=" + sales + "]";
	}
	
	
}
