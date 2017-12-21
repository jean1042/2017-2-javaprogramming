package newVendingMachine_1105.copy;



import java.io.*;
import java.util.Scanner;

public class Show {

	// ObjectOutputStream의 객체 fw 생성
	static ObjectInputStream in;
	static ObjectOutputStream out = null;

	static Beverage beverage = new Beverage();

	static Scanner input = new Scanner(System.in);

	// database
	static int stockNum; // 재고의 개수
	static int traySize; // 트레이의 사이즈 설정
	static int paynum = 0; // 사용자가 음료수를 사먹은 횟수

	// main 함수 시작
	public static void main(String args[]) throws Exception {

		VendingMachine myMachine = new VendingMachine(20);

		System.out.println("음료수를 먼저 추가해주세요");
		System.out.println("추가할 음료수의 개수를 입력하세요");
		traySize = input.nextInt();

		for (int i = 0; i < traySize; i++) {

			// Beverage 객체 생성
			Beverage p1 = new Beverage();

			System.out.println("추가할 음료수의 번호, 이름, 가격, 재고를 입력하세요 (ex) 0(enter) 사이다(enter) 500(enter) 0(enter)");
			p1.settrayNum(input.nextInt());

			input.nextLine();
			p1.settrayName(input.nextLine());

			p1.setPrice(input.nextInt());

			p1.setStock(input.nextInt());

			// Beverage의 객체를 trayslist에 insert한후 배열 출력하기
			myMachine.addBeveragelist(p1);

			// 배열 출력 (각 음료의 번호trayNum 출력)
			System.out.println(p1.gettrayNum() + " 번 트레이에 추가되었습니다.");
			System.out.println();

			// 파일에 음료의 정보를 쓰는 과정
			try {
				p1.writeBeverageFile();

			} catch (Exception e) {
				System.out.println(e);
			}
			try {
				p1.bringBeverageFile();
			} catch (Exception e) {
				System.out.println(e);
			}

		}

		Show myscreen = new Show();
		myscreen.firstmain();

	}

	public static void firstmain() throws Exception {

		System.out.println("----------사용자/관리자 모드 선택----------- ");
		System.out.println(" ");
		System.out.println(" 관리자모드로 음료수를 추가한 후 사용자모드를 이용해 주십시오");
		System.out.println(" 1.  사용자모드");
		System.out.println(" 99. 관리자모드");
		System.out.println(" 0. 프로그램 종료");
		System.out.println("------------------------------------- ");

		int usernum; // 사용자모드, 관리자 모드 선택할 숫자 저장하는 변수 선언
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
			System.out.println("프로그램 종료");
			out.close();
			in.close();
		}
	}

	public static void userMode() throws Exception {
		VendingMachine myMachine = new VendingMachine(20);

		// 1. 사용자에게 돈 입력받기
		System.out.println("돈을 넣어주세요");
		int userprice;// 사용자가 넣는 금액 변수 선언
		Scanner scan1 = new Scanner(System.in);
		userprice =scan1.nextInt();

		paynum++; // 사용자가 음료수를 사먹은 횟수 증가
		// Vending machine의 price에 사용자가 입력한 돈 넣기
		myMachine.setuserPrice(userprice);
		// 사용자에게 입력받은 현재금액 알려주기
		System.out.println("현재금액 : " + myMachine.getuserPrice(userprice) + " 입니다.");

		// 2. 금액에 따라 뽑아 먹을 수 있는 음료수 다르게 해서 출력하기
		System.out.println("선택할 수 있는 음료수 뒤에  *가 표시되어 있습니다.");

		// 지금한거
		myMachine.settraySize(traySize);

		for (int i = 0; i < traySize; i++) {
			int beverageprice; // 음료수 각각의 가격을 가져오는 변수 선언
			beverageprice = myMachine.getuserPrice(myMachine.searchBeverageObjlist(i).getPrice());
			// 여기까지 겁나 잘됨

			if (userprice >= beverageprice) // 사용자가 넣은 금액이 음료수 금액보다 크거나 같을 때 *과
				// 함께 출력
				System.out.println(
						myMachine.getBeverageNum(i) + "번 : " + myMachine.searchBeverageObjlist(i).gettrayName() + "*");

			else if (userprice < beverageprice) // 사용자가 넣은 금액이 음료수 금액보다 작으면 이름만
				// 출력
				System.out.println(
						myMachine.getBeverageNum(i) + "번 : " + myMachine.searchBeverageObjlist(i).gettrayName());

		}

		// 3. 물건 선택 구현

		System.out.println("메뉴를 선택해 주세요");
		Scanner scanuser = new Scanner(System.in);
		// 사용자한테 입력값까지 잘 받았다.

		int money, selectBeverageId, selectBeveragePrice, selectBeverageindex; // 사용자가
		// 입력할 물건번호 선언

		String selectBeverageName; // 물건이름 변수 선언

		selectBeverageId = scanuser.nextInt();

		// 1-1 selectBeverageindex = myMachine.searchBeverage(selectBeverageId);
		// 1-2 수정
		selectBeverageindex = myMachine.searchBeveragelist(selectBeverageId);

		selectBeverageName = myMachine.searchBeverageObjlist(selectBeverageindex).gettrayName();
		selectBeveragePrice = myMachine.searchBeverageObjlist(selectBeverageindex).getPrice();
		System.out.println("선택하신 음료는" + selectBeverageName + "이며 금액은" + selectBeveragePrice + "입니다.");

		myMachine.setSales(selectBeveragePrice);

		myMachine.searchBeverageObjlist(selectBeverageindex).changeStock(1);

		// 4. 거스름돈 받기

		// 거스름돈 변수 선언
		int change;
		change = userprice - selectBeveragePrice;
		System.out.println("-----거스름돈------");
		System.out.println("500원 : " + myMachine.pay500(change, selectBeveragePrice) + "개");
		System.out.println("100원 : " + myMachine.pay100(change, selectBeveragePrice) + "개");

		// 자판기에 거스름돈만큼 지불한 500, 100원의 수를 변경함
		int something500 = myMachine.changeCurrentMoney500(myMachine.pay500(change, selectBeveragePrice));
		int something100 = myMachine.changeCurrentMoney100(myMachine.pay100(change, selectBeveragePrice));

		System.out.println("---------- ");
		System.out.println("맛있게 드십시오.");
		System.out.println("----------");

		System.out.println("다른 음료수를 선택하시겠습니까? (다른 음료수 선택 : 0번 / 사용자-관리자 선택화면으로 돌아가기 : 1번)");
		Scanner scannum = new Scanner(System.in);
		int selectnum;
		selectnum = scannum.nextInt();
		if (selectnum == 0)
			userMode();

		else
			System.out.println("자판기를 이용해주셔서 감사합니다.");
		firstmain();
	}

	public static void managerMode() throws Exception {
		VendingMachine myMachine = new VendingMachine(20);

		System.out.println("-----------관리자 모드-------- ");
		System.out.println(" 1.  새로운 음료수 추가");
		System.out.println(" 2.  자판기에 동전 추가");
		System.out.println(" 3.  현재 자판기의 동전의 개수 확인");
		System.out.println(" 4.  음료수 삭제");
		System.out.println(" 5.  판매량 출력");
		System.out.println(" 6.  음료수 재고 확인");
		System.out.println(" 0.  사용자 메뉴로 돌아가기");
		System.out.println("-------------------------- ");

		int managernumber;// manager가 선택할 기능 변수 선언
		Scanner scanmanager = new Scanner(System.in);
		managernumber = scanmanager.nextInt();

		switch (managernumber) {
		case 1:

			// 1. 새로운 음료수 관리자에게 직접 입력받아서 추가한다.

			// 관리자에게 traySize 입력받기
			System.out.println("추가할 음료수의 개수를 입력하세요");
			Scanner scansize = new Scanner(System.in);
			traySize = scansize.nextInt();

			for (int i = 0; i < traySize; i++) {

				System.out
						.println("추가할 음료수의 traynumber, 이름, 가격, 재고를 입력하세요 (ex) 0(enter) 사이다(enter) 500(enter) 0(enter)");
				Scanner scan1 = new Scanner(System.in);
				int trayNum = scan1.nextInt();
				Scanner scan2 = new Scanner(System.in);
				String trayName = scan2.nextLine();
				Scanner scan3 = new Scanner(System.in);
				int price = scan3.nextInt();
				Scanner scan4 = new Scanner(System.in);
				int stock = scan4.nextInt();

				// Beverage의 객체를 만들어서 trayslist에 insert한후 배열 출력하기
				Beverage p1 = new Beverage();
				p1 = new Beverage(trayNum, trayName, price, stock);
				myMachine.addBeveragelist(p1);

				// 배열 출력 (각 음료의 번호trayNum 출력)
				System.out.println(trayNum + " 번 트레이에 추가되었습니다.");
				System.out.println();

				// 파일에 음료의 정보를 쓰는 과정
				out = new ObjectOutputStream(new FileOutputStream("output3.txt"));
				p1.writeBeverageFile();

			}

			in.close();

			managerMode();
			break;

		// 2. 동전 보충-100원짜리
		case 2:

			int money100 = 0; // 실제 vending machine에 들어갈 100원의 개수
			System.out.println("보충할 100원짜리 동전의 개수를 입력하시오");
			Scanner scan100 = new Scanner(System.in);

			money100 = myMachine.setCurrentMoney100(scan100.nextInt());
			System.out.println("money100 : " + money100);
			// 동전보충-500원짜리
			int money500 = 0; // 500원의 개수
			System.out.println("보충할 500원짜리 동전의 개수를 입력하시오");
			Scanner scan500 = new Scanner(System.in);
			money500 = myMachine.setCurrentMoney500(scan500.nextInt());
			System.out.println("money500 : " + money500);
			// myMachine.saveFile(dw);
			managerMode();
			break;

		// 3. 남아 있는 500원과 100원의 동전의 개수 확인하기
		case 3:
			System.out.println("현재 자판기의 500원의 개수는" + myMachine.getCurrentMoney500() + " 입니다.");

			System.out.println("현재 자판기의 100원의 개수는" + myMachine.getCurrentMoney100() + " 입니다.");

			managerMode();
			break;

		// 4. 음료수 삭제
		case 4:
			int userdeletenumber; // 사용자가 삭제하려고 하는 번호 입력받음
			System.out.println("삭제할 번호를 입력하세요");
			for (int i = 0; i < traySize; i++) {
				System.out.println(
						myMachine.searchBeveragelist(i) + " 번 : " + myMachine.searchBeverageObjlist(i).gettrayName());

			}

			Scanner scan2 = new Scanner(System.in);
			userdeletenumber = scan2.nextInt();

			myMachine.searchBeveragelist(userdeletenumber); // 배열 어디있는지 찾음

			System.out.println(userdeletenumber + " 번 음료수를 삭제하겠습니다.");

			myMachine.deleteBeveragelist(userdeletenumber); // 음료수 삭제

			// 음료수를 삭제했으니 traySize 하나 적게 변경
			// myMachine.settraySize(traySize - 1);
			traySize = myMachine.gettraySizelist();
			System.out.println("gettraySize: " + traySize);

			System.out.println("음료수 삭제 완료");

			// 남아 있는 음료수 출력
			for (int j = 0; j < traySize; j++) {
				System.out.println(myMachine.searchBeverageObjlist(j).gettrayName());
			}

			managerMode();
			break;

		// 5. 판매량 출력
		case 5:
			int totalSales;
			totalSales = myMachine.getSales();
			System.out.println("총 판매 수익은 " + totalSales + " 원 입니다.");

			managerMode();
			break;

		// 6. 재고 확인
		case 6:
			int checkStock; // 관리자가 확인할 음료수의 재고 변수 선언
			int checkStockNum; // 관리자가 확인할 음료수 입력하는 숫자 받아오는 변수 선언
			System.out.println("어떤 음료수의 재고를 확인하시겠습니까? ");

			for (int i = 0; i < traySize; i++) {
				System.out.println(myMachine.searchBeveragelist(i) + " 번");
			}

			Scanner scanstock = new Scanner(System.in);
			checkStockNum = scanstock.nextInt();

			checkStock = myMachine.searchBeverageObjlist(checkStockNum).getStock();
			System.out.println("남은 재고는" + checkStock + " 개 입니다.");

			managerMode();
			break;
		case 0:
			firstmain();

		}
	}
}
