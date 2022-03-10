import java.net.*;
import java.io.*;
import java.awt.event.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Client {

    JFrame window_chat = null;
    
    JTextField message = null;
    
    JTextArea chat_area = null;
    
    JButton send_button = null;
    
    JScrollPane scroll = null;
  
    JPanel stock_chat = null;
    
    JPanel stock_send_button = null;
    
    Socket client = null;
    
    PrintWriter writer = null;
    
    BufferedReader reader = null;
    
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
        
        scroll = new JScrollPane(chat_area);
        stock_chat.add(scroll);

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
    public void read(){
        
        Thread read_thread = new Thread(new Runnable(){
            public void run(){
                try{
                    reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
                        while(true){
                            String message_received = reader.readLine();
                            chat_area.append("Server say :"+ message_received);
                        }
                }catch(Exception ex){
                    ex.printStackTrace();
                }
                
            }
        });
        read_thread.start();
    }
    public void write(){
        Thread write_thread = new Thread(new Runnable(){
            public void run(){
                try{
                    writer = new PrintWriter(client.getOutputStream(), true);
                    send_button.addActionListener(new ActionListener(){
                        public void actionPerformed(ActionEvent e){
                            String send_message = message.getText();
                            writer.println(send_message);         
                        }
                    });
                }catch(Exception ex){
                    ex.printStackTrace();        
                }
            }
        });
        write_thread.start();
    }    
    
    public static void main(String [] args){
        new Client();

    }    
}