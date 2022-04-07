/* permite realizar conexiones y transacciones a través de la red */
import java.net.*;

/* encargado de gestionar las operaciones de entrada/salida */
import java.io.*;

/* este paquete define eventos y detectores de eventos, así como adaptadores de detectores de eventos*/
import java.awt.event.*;

/*importar abstract window Toolkit (kit de herramientas grafico) */
import java.awt.*;

/* importar java swing (biblioteca grafica)*/
import javax.swing.*;

import java.util.logging.*;


public class Server {
    /* Se deben definir los objetos que van a componer la interfaz*/  
    /* Jframe: es utilizado para generar la ventana inicial, la cual será personalizada posteriormente */
    JFrame window_chat = null;
    
    /* Jtextfield: permite ingresar al operador del programa insertar caracteres mediante el teclado*/
    JTextField message = null;
    
    /*JTextArea: un cuadro de texto más grande que el JtextField */
    JTextArea chat_area = null;
    
    /* Jbutton: es un botón que tiene como objetivo interactuar con él para realizar una accion determinada */
    JButton send_button = null;
    
    /*Jscrollpane: barra para desplazarse hacia abajo*/
    JScrollPane scroll = null;
    
    /* Jpanel: es un contenedor de componentes, botones, campos de texto etc...*/
    JPanel stock_chat = null;
    JPanel stock_send_button = null;
    
    /* ServerSocket: Nos permite manipular la conxexion desde el servidor */
    ServerSocket server = null; 
    
    /* Socket: Nos permite implementar la conexión por parte del cliente*/
    Socket client = null;
    
    /* PrintWriter imprime representaciones formateadas de objetos en una secuencia como una salida de texto */
    PrintWriter writer = null;
    
    /* Buffered reader: Lee texto de un flujo de entrada de caracteres, almacenando en búfer los caracteres para proporcionar una lectura eficiente de caracteres*/
    BufferedReader reader = null;
    
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
        window_chat.setLocation(250, 200);
        
    /* campo de texto del mensaje*/
        message = new JTextField(4);
        
    /* titulo del boton enviar*/
        send_button = new JButton("Send");
        
    /* Personalizar fuente de la letra que va contenida en el boton de enviar*/
        send_button.setFont(new Font("Arial", Font.ROMAN_BASELINE, 20));
        
    /* Personalizar color del fondo del boton*/
        send_button.setBackground(Color.lightGray);
        
    /* Tamaño del cuadro blanco donde se reciben los mensajes*/
        chat_area = new JTextArea(10, 12);
        
    /* contenedor de chat */
        stock_chat = new JPanel();
        
    /* personalizacion del contenedor */
        stock_chat.setLayout(new GridLayout(1,1));
        
    /* Añadir la barra de desplazamiento */
        scroll = new JScrollPane(chat_area);
        
    /* añadir al contenedor del chat la barra*/
        stock_chat.add(scroll);
        
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
        window_chat.setSize(300, 235);
        
    /* hacer que no sea posible cambiarle el tamaño a la ventana */
        window_chat.setResizable(false);
        
    /* Cambiar visibilidad de la ventana*/
        window_chat.setVisible(true);
      
        Thread principal = new Thread(new Runnable(){
            public void run(){
            Logger Log = Logger.getLogger(String.valueOf(Server.class));
                try{
                    /* se define el puerto del servidor, uno alto para asegurar que esté libre*/
                server = new ServerSocket(1200);
                Log.info("Servidor iniciado");
                    while(true){
                        /* siempre va a aceptar las conexiones que vengan a este puerto*/
                        client = server.accept();
                        /* metodos para intercambio de mensajes */
                        read();
                        write();
                    }
                }catch(Exception ex){
                    try{
                        Log my_log = new Log("scbr.txt");
                        my_log.logger.setLevel(Level.WARNING);
                        my_log.logger.severe("Puerto ocupado");
                    } catch (SecurityException ex1) {
                        Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex1);
                    } catch (IOException ex1) {
                        Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex1);
                    }
                    
                }         
            }
        });
        principal.start();
    }
    /*Crear metodo para leer los mensajes*/
    public void read(){
        Logger Log1 = Logger.getLogger(String.valueOf(Server.class));
        /*Thread: clase base de Java para definir hilos de ejecución concurrentes dentro de un mismo programa, Son los objetos los que actúan concurrentemente con otros */
        /*Runnable proporciona un método alternativo a la utilización de la clase Thread, Esto ocurre cuando dicha clase, que se desea ejecutar en un hilo independiente deba extender alguna otra clase.*/
        Thread read_thread = new Thread(new Runnable(){
            
            /*public void run () Este método especifica realmente la tarea a realizar*/
            public void run(){
                
       /* Utilizar un Try/Catch porque se trabaja con clases que posiblemente envíen excepciones*/
                try{
           /* Con el objeto client y el metodo GetInputStream obtenemos la entrada de ese socket y asi podemos acceder a los metodos que nos permiten leer lo que nos envían*/
                    reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
           
           /* se utiliza la expresión while true para repetir indefinidamente*/
                        while(true){
                    /* Todo lo que me envíe el cliente le voy a estar leyendo y lo voy a guardar en la variable de tipo str llamada message_received */
                            String message_received = reader.readLine();
                            Log1.info("Mensaje recibido "+ message_received);
                    /* ahora debemos adjuntar el mensaje que nos envían al campo en blanco llamado chat_area, con el append se agrega texto, concatenamos el mensaje recibido al "client say"*/
                            chat_area.append("Client say's: "+ message_received);
                        }
        /* Catch: captura las excepcion y se especifica cual puede ocurrir */  
                }catch(Exception ex){  
                }
                
            }
        });
        /* Un thread se pone a trabajar con el metodo start, en este caso es para que se ponga a funcionar cuaando se llama al metodo read*/
        read_thread.start();
    }
    public void write(){
        Thread write_thread = new Thread(new Runnable(){
            Logger Log2 = Logger.getLogger(String.valueOf(Server.class));
            public void run(){
                try{
                    
            /* El constructor recibe al cliente, que es con quien se comunica y el getoutput obtiene la salida, además, el true nos permite enviar mensajes*/
                    writer = new PrintWriter(client.getOutputStream(), true);
                    
            /* Se hace uso del botón para el envio del mensaje, Se agrega un escucha, en este caso el ActionListener */
                    send_button.addActionListener(new ActionListener(){
                        
                /* Se ejecuta cada vez que se le da al boton enviar */ 
                        public void actionPerformed(ActionEvent e){
                            
                    /* Se obtiene el mensaje que posea esa caja de texto y se guarda en la variable send_mensaje*/
                            String send_message = message.getText();
                            Log2.info("Mensaje enviado "+ send_message);
                            
                    /* Luego de obtenido el mensaje, se envía*/
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
        /* Instancia para que pueda arrancar el constructor de la interfaz*/
        new Server();
        
    }    
} 
