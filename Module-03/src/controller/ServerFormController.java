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

public class ServerFormController {

    public TextArea textArea;
    public TextField textField;

    private DataOutputStream dataOutputStream;
    private DataInputStream dataInputStream;
    private final int PORT = 5000;
    private ServerSocket serverSocket;
    private Socket localSocket;
    private String clientMessage = "";

    public void initialize(){
        new Thread(() -> {
            try{
                serverSocket = new ServerSocket(PORT);
                textArea.appendText("Server Started\n");
                localSocket = serverSocket.accept();
                textArea.appendText("Client accepted..!\n");

                dataInputStream = new DataInputStream(localSocket.getInputStream());
                dataOutputStream = new DataOutputStream(localSocket.getOutputStream());

                while(!clientMessage.equalsIgnoreCase("finish")){
                    clientMessage = dataInputStream.readUTF();
                    textArea.appendText(clientMessage+"\n");
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
