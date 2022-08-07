import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author : Ashan Sandeep
 * @since : 0.1.0
 **/

public class ServerApp {
    public static void main(String[] args) {
        final int PORT = 5000;
        String clientMsg = "", reply = "";
        DataOutputStream dataOutputStream;
        DataInputStream dataInputStream;
        BufferedReader bufferedReader;

        try{
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server Started");

            Socket localSocket = serverSocket.accept();
            System.out.println("Client Accepted..!");

            dataOutputStream = new DataOutputStream(localSocket.getOutputStream());
            dataInputStream = new DataInputStream(localSocket.getInputStream());
            bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            while(!clientMsg.equalsIgnoreCase("exit")){
                clientMsg = dataInputStream.readUTF();
                System.out.println("Client Says : "+clientMsg);
                reply = bufferedReader.readLine();
                dataOutputStream.writeUTF(reply);
            }

            dataInputStream.close();
            dataOutputStream.close();
            bufferedReader.close();


        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
