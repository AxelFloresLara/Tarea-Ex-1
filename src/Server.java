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
        /* Constructor del metodo MakeInterface*/
        MakeInterface();
    }
    /* Metodo para interfaz */
    public void MakeInterface(){
        /*CREACIONES DE LOS OBJETOS*/
        
        /* Asignación del titulo a la ventana*/
        window_chat = new JFrame("Server");
        message = new JTextField(4);
        /* titulo del boton enviar*/
        send_button = new JButton("Send");
        /* Personalizar fuente de la letra que va contenida en el boton de enviar*/
        send_button.setFont(new Font("Serif", Font.ITALIC, 20));
        /* Personalizar color del fondo del boton*/
        send_button.setBackground(Color.gray);
        /* Tamaño del cuadro blanco donde se reciben los mensajes*/
        chat_area = new JTextArea(10, 12);
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
        /* Añadir Layout a la ventana principal (JFrame), para ubicar el stock_chat */
        window_chat.add(stock_chat, BorderLayout.NORTH);
        /* Añadir Layout para ubicar el stock_send_button*/
        window_chat.add(stock_send_button, BorderLayout.SOUTH);
        /* Setear el tamaño de la ventana principal (window_chat) con los parametros (ancho, alto) */
        window_chat.setSize(300, 240);
        /* hacer que no sea posible cambiarle el tamaño a la ventana */
        window_chat.setResizable(false);
        /* Cambiar visibilidad de la ventana*/
        window_chat.setVisible(true);
        
    }
    public static void main(String [] args){
        /* Instancia para que pueda arrancar el constructor de la interfaz*/
        new Server();
        
    }    
} 
