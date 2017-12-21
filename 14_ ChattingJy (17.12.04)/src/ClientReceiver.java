import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

// 메시지 수신용 Thread 
class ClientReceiver implements Runnable {
     Socket socket; 
    DataInputStream in; 

    // 생성자 
  public  ClientReceiver(Socket socket) { 
        this.socket = socket; 

        try { 
            // 서버로 부터 데이터를 받을 수 있도록 DataInputStream 생성
             this.in = new DataInputStream(socket.getInputStream());
         } catch (IOException e) { 
        } 
    } 

   	public void run() {
         while (in != null) { 
            try { 
                // 서버로 부터 전송되는 데이터를 출력 
            	String line =in.readLine();
            	output.append(line+"/n");
                MultichatGUIClient.this.setMessage(in.readUTF());
             } catch (IOException e) { 
            } 
        } 
    } 
}
