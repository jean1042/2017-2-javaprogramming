package newVendingMachine_1105.copy;

import java.sql.*;
import java.util.*;

public class ConnectDatabase {

	// 읽어온 정보를 담을 변수 선언
	static int trayNumdata;
	static String trayNamedata;
	static int pricedata;
	static int stockdata;
	
	static Beverage ttempBeverage = new Beverage();
	
	public static Connection makeConnection() {
		String url = "jdbc:mysql://localhost/vendingMachine_db";
		String id = "root";
		String password = "sm34986713";
		Connection con = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("드라이버 적재 성공");
			con = DriverManager.getConnection(url, id, password);
			System.out.println("데이터베이스 연결" + " 성공");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버를 찾을 수 없습니다.");
		} catch (SQLException e) {
			System.out.println("연결에 실패하였습니다.");
		}
		return con;
	}

	// ConnectDatabase 생성자
	ConnectDatabase() {
		ResultSet rs = null;
		Connection conn = null; //연결 도구
		Statement stmt = null; //보낼 도구

		conn = makeConnection(); // jdbc 드라이버와 연결

		
		ArrayList<Beverage> list2 = new ArrayList<Beverage>();
		try {
			stmt = conn.createStatement();
		} catch (SQLException e) {
			System.out.println("createStatement 실패");
			e.printStackTrace();
		}

		//ResultSet 배열인 list에 넣음
		try {
			rs = stmt.executeQuery("select trayNum, trayName, price, stock from beverage;");
			
			
		} catch (SQLException e) {
			System.out.println("executeQuery 실패");
			e.printStackTrace();
		}

		System.out.println("어디 잘 받아왔나 보장");
		
		try {
			
				while (rs.next()) {
					//Beverage 모아놓는 리스트
					
					Beverage ttempBeverage = new Beverage();
		
					trayNumdata = rs.getInt("trayNum");
					ttempBeverage.settrayNum(trayNumdata);
					
					trayNamedata = rs.getString("trayName");
					ttempBeverage.settrayName(trayNamedata);
					
					pricedata = rs.getInt("price");
					ttempBeverage.setPrice(pricedata);
					
					stockdata = rs.getInt("stock");
					ttempBeverage.setStock(stockdata);
					
					list2.add(ttempBeverage);
					
					//System.out.println(trayNumdata + ";" + trayNamedata + ";" + pricedata + ";" + stockdata);
					
				}
				//list2에 잘 들어왔나 확인
					System.out.println("list2 toString : "+list2.toString());
				
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void ttempBeverage(int trayNumdata2, String trayNamedata2, int pricedata2, int stockdata2) {
		// TODO Auto-generated method stub
		
	}

	public static int gettrayNumdata() {
		return trayNumdata;
	}

	public static String gettrayNamedata() {
		return trayNamedata;
	}

	public static int getpricedata() {
		return pricedata;
	}

	public static int getstockdata() {
		return stockdata;
	}


	
}
