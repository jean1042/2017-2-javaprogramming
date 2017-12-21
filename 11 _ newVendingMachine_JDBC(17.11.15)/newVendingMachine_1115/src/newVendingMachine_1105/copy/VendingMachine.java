package newVendingMachine_1105.copy;

import java.io.*;
import java.util.*;

public class VendingMachine {

	// data
	static int size; //beverage객체를 담을 수 있는 최대 한계 수
	static int count = 0; // 내용물의 개수
	int usermoney; // 사용자가 넣어주는 돈
	static int currentMoney100=0;
	static int currentMoney500=0;
	int sales = 0; // 판매량 저장하는 함수
	int deletenum;
	static Beverage tempBeverage=null; 
static Beverage testBeverage = new Beverage();
	// 수정 1) beverage객체를 담는 ArrayList list 선언
	public static ArrayList<Beverage> trayslist = new ArrayList<Beverage>(50);
	// 생성자
	VendingMachine(int size) {
		try {
				while(true){
					ConnectDatabase connect = new ConnectDatabase();
					
					int trayNum = connect.gettrayNumdata();
					System.out.println("trayNum"+trayNum);
					
					String trayName = connect.gettrayNamedata();
					System.out.println("trayName"+trayName);
					
					int price = connect.getpricedata();
					System.out.println("price"+price);
					
					int stock = connect.getstockdata();
					System.out.println("stock" + stock);
					
					
					//tempBeverage 에 삽입
					tempBeverage.settrayNum(trayNum);
					tempBeverage.settrayName(trayName);
					tempBeverage.setPrice(price);
					tempBeverage.setStock(stock);
					
					count++;
					
					trayslist.add(tempBeverage);
					System.out.println("trayslist" + trayslist);
				
				}
			
		}	catch(Exception e ){
			System.out.println(e);
		}
			
	}
				

	// 수정2) beverage 객체를 Vendingmachine에 trayList 이용해 집어넣는 함수
	public void addBeveragelist(Beverage beverageObj) {
		trayslist.add(beverageObj);
	}

	// 수정3) 숫자를 입력하면 trayslist에서 찾아 음료 객체를 반환해주는 함수
	public Beverage searchBeverageObjlist(int usernum) throws Exception {
		int num = searchBeveragelist(usernum); // 사용자가 넣은 숫자의 trayNum이 얼마인지 알려줌

		Beverage beverageObj;
		if (num > -1) {
			beverageObj = trayslist.get(num);
			return beverageObj;
		}
		else
			throw new Exception("정보 없음");
	}

	// 수정4) 숫자를 입력하면 trayslist에서 찾아 음료번호(해당객체의 인덱스) 를 반환해주는 함수
	public int searchBeveragelist(int usernum) {

		for (int i = 0; i < (trayslist.size() - 1); i++) {
			if (usernum == trayslist.get(i).gettrayNum())
				usernum = i;

		}

		return usernum;
	}

	// 수정5) searchBeveragelist 함수를 이용해 음료수 삭제하기
	public void deleteBeveragelist(int index) throws Exception {
		int index2 = searchBeveragelist(index);
		if (index2 > -1) {

			for (int i = 0; i < trayslist.size(); i++) {
				trayslist.remove(index2);
			}
		
		} else
			throw new Exception("해당 물품이 없어 음료수를 삭제할 수 없습니다.");
	}

	// 수정6) trayslist에 몇개의 음료수가 들어가있는지 traySize 알려주는 함수
	public int gettraySizelist() {
		return trayslist.size();
	}

	// 사용자가 넣어준 돈을 자판기에 넣어오는 함수
	public void setuserPrice(int usermoney) {
		this.usermoney = usermoney;
	}

	// 사용자가 넣어준 돈을 반환하는 함수
	public int getuserPrice(int usermoney) {
		this.usermoney = usermoney;
		return usermoney;
	}

	// 판매량 set 함수
	public void setSales(int usermoney) {
		sales += usermoney;
	}

	// 판매량 저장해놓을 함수
	public int getSales() {
		return sales;
	}

	// 삭제할 번호 받아오는 함수
	public int getdeletenum(int number) {
		this.deletenum = number;
		return deletenum;
	}

	// tray의 일정 위치의 Beverage 번호를 반환 해주는 함수
	public int getBeverageNum(int index) {
		return index;
	}

	// 자판기가 가진 100원짜리 동전의 수를 변경한다
	public int setCurrentMoney100(int money100) {
		currentMoney100 += money100;
		return currentMoney100;

	}

	// 자판기가 가진 500원짜리 동전의 수를 변경한다
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

	// 자판기가 가진 100원짜리 동전의 수를 반환한다.
	public int getCurrentMoney100() {
		System.out.println(currentMoney100);
		return currentMoney100;

	}

	// 자판기가 가진 500원짜리 동전의 수를 반환한다
	public int getCurrentMoney500() {
		System.out.println(currentMoney500);
		return currentMoney500;

	}

	// traySize 정하는 함수
	public int settraySize(int size) {
		this.count=trayslist.size();
		return (trayslist.size());
		
	}

	// pay함수 -> 100원짜리, 500원짜리 몇개인지 받는 클래스 거스릅돈 계산
	public void pay(int beveragePrice) {
		// 거스릅돈
		int change;// 거스름돈 변수
		int coin500; // 사용자에게 주는 500원짜리 동전의 개수
		int coin100; // 사용자에게 주는 100원짜리 동전의 개수
		change = usermoney - beveragePrice;
		coin500 = change / 500;
		int rest = change % 500;
		coin100 = rest / 100;

	}

	// 500원짜리 거스름돈 반환해주는 함수
	public int pay500(int change, int beveragePrice) {

		int rest;
		int coin500;
		change = usermoney - beveragePrice;
		rest = change % 500;
		coin500 = change / 500;

		currentMoney500 -= coin500;
		return coin500;

	}

	// 100원짜리 거스름돈 반환해주는 함수
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

	/*수정8) VendingMachine 내역 파일에 저장
	public void saveFile(DataOutputStream fw) throws Exception {
		ObjectOutputStream out = null;
		try {
			fw.write(currentMoney100);
			fw.write(currentMoney500);

			for (int cnt = 0; cnt < trayslist.size(); cnt++) {
				trayslist.get(cnt).writeBeverageFile(fw);
			}

		} catch (IOException ioe) {
			throw new IOException("상태를 저장할 수 없습니다");
		}
	}
*/
	
	
	
	@Override
	public String toString() {
		return "VendingMachine [size=" + size + ", usermoney=" + usermoney + ", sales=" + sales + ", deletenum="
				+ deletenum + ", trays=" + /* Arrays.toString(trays) + */ ", tempBeverage=" + tempBeverage + "]";
	}

}

