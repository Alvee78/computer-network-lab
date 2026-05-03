import java.io.*;
import javax.net.ssl.*;
import java.util.*;

public class EmailSender {
    public static DataOutputStream dos;
    public static BufferedReader br;
    public static void main(String[] args) throws Exception {
        String user = "your_email@gmail.com";
        String pass = "your_app_password";

        String userName = new String(Base64.getEncoder().encode(user.getBytes()));
        String password = new String(Base64.getEncoder().encode(pass.getBytes()));
        SSLSocket s = (SSLSocket) SSLSocketFactory.getDefault().createSocket("smtp.gmail.com", 465);

        dos = new DataOutputStream(s.getOutputStream());
        br = new BufferedReader(new InputStreamReader(s.getInputStream()));
        print_response();
        send("EHLO smtp.gmail.com");
        String line;
        while((line = br.readLine()) != null){
            System.out.println("Server : " + line);
            if(line.startsWith("250 "))
                break;
        }
        send("AUTH LOGIN");
        print_response();
        send(userName);
        print_response();
        send(password);
        print_response();
        send("MAIL FROM:<sender_email@example.com>");
        print_response();
        send("RCPT TO: <receiver1@example.com>");
        print_response();
        send("RCPT TO: <receiver2@example.com>");
        print_response();
        send("RCPT TO: <receiver3@example.com>");
        print_response();
        send("RCPT TO: <receiver4@example.com>");
        print_response();
        send("DATA");print_response();
        send("FROM: your_email@gmail.com");
        send("To: receiver1@example.com");
        send("CC: receiver2@example.com");
        send("Subject: Subject of the mail");
        send("");
        send("message here...");
        send(".");
        print_response();
        send("QUIT");
        print_response();

    }
    private static void print_response() throws Exception{
        System.out.println("Server : " + br.readLine());
    }
    private static void send(String s) throws Exception{
        System.out.println("Client : " + s);
        dos.writeBytes(s + "\r\n");
        Thread.sleep(100);
    }
}
