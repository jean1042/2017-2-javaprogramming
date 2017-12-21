import java.io.*;
import java.util.Arrays;

public class VendingMachine {

	// data
	int size;
	static int count = 0; // 내용물의 개수
	int usermoney; // (임시) 사용자가 넣어주는 돈
	static int currentMoney100;
	static int currentMoney500;
	int sales = 0; // 판매량 저장하는 함수
	int deletenum;
	// beverage 객체를 담는 trays 선언
	Beverage trays[];

	Beverage tempBeverage;
	// beverage의 수를 알려주는 변수

	// 생성자
	
	VendingMachine(int size, DataInputStream di) {
		
		
			trays = new Beverage[size];
			try{
			//파일로부터 정보를 읽어옴
				
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

		
	// beverage 객체를 Vendingmachine에 집어넣는 함수
	public int addBeverage(Beverage beverageObj) {
		// trays=new Beverage[size];
		trays[count++] = beverageObj;
		return (count - 1);
	}

	// 숫자를 입력하면 tray에서 찾아 그 음료번호를 반환해주는 함수
	public int searchBeverage(int usernum) {
		for (int i = 0; i < count - 1; i++)
			if (usernum == trays[i].gettrayNum()) {
				usernum = i;
			}
		return usernum;
	}

	// 2) 숫자를 입력하면 tray 에서 찾아 그 음료 객체를 반환해주는 함수
	public Beverage searchBeverageObj(int usernum) throws Exception {
		int i = searchBeverage(usernum);

		if (i > -1)
			return trays[i];

		else
			throw new Exception("정보 없음");
	}

	// 숫자를 입력하면 tray 에서 찾아 그 음료 번호를 반환해주는 함수
	public int searchBeverageNum(int usernum) {
		for (int i = 0; i < count - 1; i++)
			if (usernum == trays[i].gettrayNum()) {
				usernum = i;
			}
		return usernum;
	}

	// 사용자가 넣어준 돈을 자판기에 넣어오는 함수
	public void setuserPrice(int usermoney) {
		this.usermoney = usermoney;
	}

	// 사용자가 넣어준 돈을 반환하는 함수
	public int getuserPrice(int usermoney) {
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

	// SEARCH 함수 이용해서 음료수 삭제하기
	public void deleteBeverage(int index) {

		int index2 = searchBeverage(index);
		// if(i>-1){
		// trays[i]=null;
		for (int i = index2; i < count; i++) {
			trays[i] = trays[i + 1];

		}
		count--;

		// throw new Exception("정보가 존재하지 않습니다");

		// try {
		// index = searchBeverage(index);

		// } catch (Exception e) {
		// throw new Exception("해당 물품이 없습니다.");
		// }

		// if(index==count){ //배열의 맨마지막 일때
		// trays[count]=null;
		// }
	}

	// tray의 일정 위치의 Beverage 이름을 반환해주는 함수
	public String printBeverage(int index) {
		return (trays[index].gettrayName());
	}

	// tray의 일정 위치의 Beverage 객체를 반환 해주는 함수
	public Beverage getBeverage(int index) {
		return trays[index];
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
	public void settraySize(int num) {
		this.size = num;
	}

	// tray size 얼마인지 알려주는 함수
	public int gettraySize() {
		return trays.length;
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

	//
	public void saveFile(DataOutputStream fw) throws Exception {
		try {
			fw.write(currentMoney100);
			fw.write(currentMoney500);

			for (int cnt = 0; cnt < count; cnt++)
				trays[cnt].writeBeverageFile(fw);
		} catch (IOException ioe) {
			throw new IOException("상태를 저장할 수 없습니다");
		}
	}


	@Override
	public String toString() {
		return "VendingMachine [size=" + size + ", usermoney=" + usermoney + ", sales=" + sales + ", deletenum="
				+ deletenum + ", trays=" + Arrays.toString(trays) + ", tempBeverage=" + tempBeverage + "]";
	}
	
}
