import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDate;

public class Server {
    public static void main(String[] arg) throws Exception {
        ServerSocket ss = new ServerSocket(7777);
        System.out.println("Server listening to the port 7777");

        Socket s = ss.accept();
        String client_ip = s.getInetAddress().getHostAddress();

        DataInputStream dis = new DataInputStream(s.getInputStream());
        DataOutputStream dos = new DataOutputStream(s.getOutputStream());

        while (true) {
            String text = dis.readUTF();
            System.out.println("Client : " + text);
            
            if(text.equals("hi")){
                dos.writeUTF("hi");
            } else if(text.equals("date")){
                dos.writeUTF(LocalDate.now().toString());
            } else if(text.equals("ip")) {
                dos.writeUTF(client_ip);
            } else if(text.equals("exit")) {
                dos.writeUTF("Disconnected");
                dos.flush();
                break;
            }else {
                dos.writeUTF("Invalid input");
            }
            dos.flush();
            System.out.println();
            
        }
        s.close();
        ss.close();
    }
}
