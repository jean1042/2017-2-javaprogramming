import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

class ClientSender { 
    Socket socket; 
    DataOutputStream out; 
String name;
    ClientSender(Socket socket) { 
        this.socket = socket; 

        try { 
            this.out = new DataOutputStream(socket.getOutputStream());

            // 시작하자 마자, 자신의 대화명을 서버로 전송 
            if (out != null) {
                 out.writeUTF(name); 
            } 

        } catch (Exception e) { 
        } 
    } 

    public void send(String message) {
         if (out != null) {
             try { 
                // 키보드로 입력받은 데이터를 서버로 전송
                 out.writeUTF("[" + name + "] " + message);
             } catch (IOException e) { 
            } 
        } 
    } 
} 




