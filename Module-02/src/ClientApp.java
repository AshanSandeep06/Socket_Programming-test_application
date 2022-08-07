import java.io.*;
import java.net.Socket;

/**
 * @author : Ashan Sandeep
 * @since : 0.1.0
 **/

public class ClientApp {
    public static void main(String[] args) {
        final int PORT = 5000;
        DataOutputStream dataOutputStream;
        DataInputStream dataInputStream;
        BufferedReader bufferedReader;
        String serverMsg = "", reply = "";

        try{
            Socket remoteSocket = new Socket("localhost",PORT);

            dataInputStream = new DataInputStream(remoteSocket.getInputStream());
            dataOutputStream = new DataOutputStream(remoteSocket.getOutputStream());
            bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            while(!serverMsg.equalsIgnoreCase("exit")){
                reply = bufferedReader.readLine();
                dataOutputStream.writeUTF(reply);
                serverMsg = dataInputStream.readUTF();
                System.out.println("Server Says : "+serverMsg);
            }

            dataInputStream.close();
            dataOutputStream.close();
            bufferedReader.close();

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
