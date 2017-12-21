import java.util.Scanner;

public class Test {
	public static void main(String args[]){
		String name = null;
		Scanner scanner = new Scanner(System.in);
		
		do{
			System.out.println("대화명을 입력하세요");
			System.out.println(">>>");
			name = scanner.nextLine();
			
			if(name.isEmpty()){
				System.out.println("대화명을 한글자 이상 입력해주세요");
			}
		}while (name.isEmpty());
		
		new MultichatGUIClient(name).launchTest();
	}
}
