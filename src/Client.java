import java.net.*;

import java.io.*;

import java.awt.event.*;

import java.awt.*;

import java.util.logging.*;

import javax.swing.*;

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
        
        window_chat.setLocation(250, 200);

        message = new JTextField(4);

        send_button = new JButton("Send");

        send_button.setFont(new Font("Arial", Font.ROMAN_BASELINE, 20));

        send_button.setBackground(Color.lightGray);

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

        window_chat.setSize(300, 235);

        window_chat.setResizable(false);

        window_chat.setVisible(true);
               
        Thread principal = new Thread(new Runnable(){
           public void run(){
                try{
                    /* se define la ip local y el mismo puerto asignado al servidor */
                client = new Socket("127.0.0.1", 1200);
                read();
                write();          
                }catch(Exception ex){
                    try {
                        /* se da la excepcion cuando no se ha iniciado el servidor y se inicia el ciente*/
                        Log my_log = new Log("scbr.txt");
                        my_log.logger.setLevel(Level.WARNING);
                        my_log.logger.severe("Servidor aún no iniciado");
                    } catch (SecurityException ex1) {
                        Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex1);
                    } catch (IOException ex1) {
                        Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex1);
                    }
            }    }
        });
        principal.start();
        
    }
    public void read(){
        
        Thread read_thread = new Thread(new Runnable(){
            public void run(){
                Logger Log1 = Logger.getLogger(String.valueOf(Client.class));
                try{              
                    reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
                        while(true){
                            String message_received = reader.readLine();
                            chat_area.append("Server say's: "+ message_received);
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
                Logger Log2 = Logger.getLogger(String.valueOf(Client.class));
                try{
                    
                    writer = new PrintWriter(client.getOutputStream(), true);
                    send_button.addActionListener(new ActionListener(){
                        public void actionPerformed(ActionEvent e){
                            String send_message = message.getText();
                            Log2.info("Mensaje enviado "+ send_message);
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
        /* clase cliente tiene al constructor new Cliente que está en Public Cliente y contiene a MakeInterface, makeinterface hace la interfaz, pone a trabajar los metodos y conecta el socket mediante un thread con ciclo infinito*/
        new Client();

    }    
}