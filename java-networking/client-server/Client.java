import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.util.Scanner;
import java.net.Socket;

public class Client {

    public static void main(String[] args) throws Exception {
        try{
            Socket s = new Socket("localhost", 7777);
            DataInputStream dis = new DataInputStream(s.getInputStream());
            DataOutputStream dos = new DataOutputStream(s.getOutputStream());

            Scanner sc = new Scanner(System.in);


            while (true) {
                System.out.println("----------------------------------");
                System.out.println("| Enter command(hi,ip,date,exit) |");
                System.out.println("----------------------------------");
                
                String text = sc.nextLine();

                dos.writeUTF(text);
                dos.flush();

                String response = dis.readUTF();
                System.out.println("| Server reply: " + response+" |");
                System.out.println("----------------------------------");

                if(text.equals("exit")){
                    break;
                }
            }
        } catch (Exception error) {
            System.out.println(error);
        }
    }
}