import java.swing.*;
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
        

    }
    public static void main(String [] args){

    }    
} 
