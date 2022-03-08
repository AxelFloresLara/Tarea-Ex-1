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
        /*CREACIONES DE LOS OBJETOS*/
        
        /* Asignación del titulo a la ventana*/
        window_chat = new JFrame("Server");
        message = new JTextField(4);
        /* titulo del boton enviar*/
        send_button = new JButton("Send");
        /* Tamaño del cuadro blanco donde se reciben los mensajes*/
        chat_area = new JTextArea(12, 14);
        /* contenedor */
        stock_chat = new JPanel();
        /* personalizacion del contenedor */
        stock_chat.setLayout(new GridLayout(1,1));
        /* Añadir al contenedor el area del chat */
        stock_chat.add(chat_area);
        /* contenedor2 */
        stock_send_button = new JPanel();
        /* Personalizacion de contenedor2*/
        stock_send_button.setLayout(new GridLayout(1,2));
        /* añadir mensaje */
        stock_send_button.add(message);
        /* añadir boton al contenedor */
        stock_send_button.add(send_button);

    }
    public static void main(String [] args){

    }    
} 
