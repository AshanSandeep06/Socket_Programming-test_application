import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * @author : Ashan Sandeep
 * @since : 0.1.0
 **/

public class ClientApp {
    public static void main(String[] args) {
        final int PORT = 5000;
        try{
            Socket remoteSocket = new Socket("localhost",PORT);

            // Step 1
            PrintWriter printWriter = new PrintWriter(remoteSocket.getOutputStream());
            printWriter.println("Hello Server, What's up..!");
            printWriter.flush();

            //--------------------------------------------------------------------------------------------------

            // Step 2
            /*DataOutputStream dataOutputStream = new DataOutputStream(remoteSocket.getOutputStream());
            dataOutputStream.writeUTF("Hello Server.!");*/


        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
