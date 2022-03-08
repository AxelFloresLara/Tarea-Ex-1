/*importar abstract window Toolkit (kit de herramientas grafico) */
import java.awt.*;
/* importar java swing (biblioteca grafica)*/
import javax.swing.*;

public class Server {
    /* Se deben definir los primeros objetos que van a componer la interfaz*/
    
    /* Jframe: es utilizado para generar la ventana inicial, la cual será personalizada posteriormente */
    JFrame window_chat = null;
    
    /* Jtextfield: permite ingresar al operador del programa insertar caracteres mediante el teclado*/
    JTextField message = null;
    
    /*JTextArea: un cuadro de texto más grande que el JtextField */
    JTextArea chat_area = null;
    
    /* Jbutton: es un botón que tiene como objetivo interactuar con él para realizar una accion determinada */
    JButton send_button = null;
    
    /* Jpanel: es un contenedor de componentes, botones, campos de texto etc...*/
    JPanel stock_chat = null;
    JPanel stock_send_button = null;
    
    /* Constructor de la clase*/
    public Server(){        
    }
    /* Metodo para interfaz */
    public void MakeInterface(){
        
        window_chat = new JFrame("Server");
        message = new JTextField(4);
        send_button = new JButton("Send");
        chat_area = new JTextArea(12, 14);
        stock_chat = new JPanel();
        stock_chat.setLayout(new GridLayout(1,1));
        stock_chat.add(chat_area);
        stock_send_button = new JPanel();
        stock_send_button.setLayout(new GridLayout(1,2));
        stock_send_button.add(message);
        stock_send_button.add(send_button);

    }
    public static void main(String [] args){

    }    
} 
