package sdf.assessment.task02;

import java.net.ServerSocket;
import java.net.Socket;

public class Server {

   public static final Integer DEFAULT_PORT = 3000;

   public static void main(String[] args) throws Exception {
      
      final Integer DEFAULT_PORT = 3000;
      final String DEFAULT_SERVER= "localhost";
      int port = 0;
      String serverFile = "";
      switch (args.length) {
         case 0:{
            port = "DEFAULT_PORT";
            serverFIle = DEFAULT_SERVER;
            break;
         }
         case 1:{
            port = Integer.parseInt(args[0]);
            serverFIle = DEFAULT_SERVER;
            break;
         }
         case 2:{
            port = Integer.parseInt(args[1]);
            serverFIle = args[0];
            break;
         }
         default:
            System.err.println("Argument error");
            System.exit(1);
            break;
      }
      ServerSocket server = new ServerSocket(port);
      ClientHandler handler = new ClientHandler(client, server);
      handler.start();
   }
}
