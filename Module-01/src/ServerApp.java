import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author : Ashan Sandeep
 * @since : 0.1.0
 **/

public class ServerApp {
    public static void main(String[] args) {
        final int PORT = 5000;
        InputStreamReader inputStreamReader;
        BufferedReader bufferedReader;
        String clientMsg = "";
        try{
            ServerSocket serverSocket = new ServerSocket(PORT);

            System.out.println("Server Started..!");

            Socket localSocket = serverSocket.accept();

            if(localSocket!=null){
                System.out.println("Client Accepted..");
                System.out.println(localSocket.getPort());
                System.out.println(localSocket.getInetAddress());

                System.out.println("---------------------------------------------------------");

                // Step 1
                inputStreamReader = new InputStreamReader(localSocket.getInputStream());
                bufferedReader = new BufferedReader(inputStreamReader);
                clientMsg = bufferedReader.readLine();

                //--------------------------------------------------------------------------------------------------

                // Step 2
                /*DataInputStream dataInputStream = new DataInputStream(localSocket.getInputStream());
                clientMsg = dataInputStream.readUTF();*/

                System.out.println("Client Says : "+clientMsg);
            }


        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
