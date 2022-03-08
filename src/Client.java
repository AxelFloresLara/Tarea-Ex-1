import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Client {

    JFrame window_chat = null;
    
    JTextField message = null;
    
    JTextArea chat_area = null;
    
    JButton send_button = null;
    
    JPanel stock_chat = null;
    
    JPanel stock_send_button = null;
    
    public Client(){
        MakeInterface();
    }
        public void MakeInterface(){

        window_chat = new JFrame("Client");

        message = new JTextField(4);

        send_button = new JButton("Send");

        send_button.setFont(new Font("Serif", Font.ITALIC, 20));

        send_button.setBackground(Color.gray);

        chat_area = new JTextArea(10, 12);

        stock_chat = new JPanel();

        stock_chat.setLayout(new GridLayout(1,1));

        stock_chat.add(chat_area);

        stock_send_button = new JPanel();

        stock_send_button.setLayout(new GridLayout(1,2));

        stock_send_button.add(message);

        stock_send_button.add(send_button);

        window_chat.add(stock_chat, BorderLayout.NORTH);

        window_chat.add(stock_send_button, BorderLayout.SOUTH);

        window_chat.setSize(300, 240);

        window_chat.setResizable(false);

        window_chat.setVisible(true);
        
    }
    
    public static void main(String [] args){
        new Client();

    }    
}