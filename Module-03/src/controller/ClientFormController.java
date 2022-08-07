package controller;

import javafx.event.ActionEvent;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author : Ashan Sandeep
 * @since : 0.1.0
 **/

public class ClientFormController {

    public TextArea textArea;
    public TextField textField;

    private DataOutputStream dataOutputStream;
    private DataInputStream dataInputStream;
    private final int PORT = 5000;
    Socket remoteSocket;
    String serverMessage = "";

    public void initialize(){
        new Thread(() -> {
            try{
                remoteSocket = new Socket("localhost",PORT);

                dataInputStream = new DataInputStream(remoteSocket.getInputStream());
                dataOutputStream = new DataOutputStream(remoteSocket.getOutputStream());

                while(!serverMessage.equalsIgnoreCase("finish")){
                    serverMessage = dataInputStream.readUTF();
                    textArea.appendText(serverMessage+"\n");
                }

            }catch (IOException e){
                e.printStackTrace();
            }
        }).start();
    }

    public void txtSendOnAction(ActionEvent event) throws IOException {
        dataOutputStream.writeUTF(textField.getText().trim());
    }

    public void sendOnAction(ActionEvent event) throws IOException {
        dataOutputStream.writeUTF(textField.getText().trim());
    }
}
