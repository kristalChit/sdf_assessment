package sdf.assessment.task02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class ClientHandler implements Runnable {

   private final socket Clientsocket;
   
   public ClientHandler(Client socket, Socket socket) {
      this.socket = client;
      this.cookie = cookie;
   }

   @Override
   public void run() {
      // entry point of the thread
      System.out.printf("Starting thread...\n");
      try {
         start();
      } catch (Exception ex) {
         ex.printStackTrace();
      }

   }

   public void start() throws Exception {

      InputStream is = socket.getInputStream();
      InputStreamReader isr = new InputStreamReader(is);
      BufferedReader br = new BufferedReader(isr);
      OutputStream os = socket.getOutputStream();
      OutputStreamWriter ows = new OutputStreamWriter(os);
      BufferedWriter bw = new BufferedWriter(ows);

      boolean stop = false;

      while (!stop) {
         String line = br.readLine();
         int count = 1;
         line = line.trim();
         if (line.length() <= 0)
            continue;
         String[] tokens = line.split(" ");

         System.out.printf(">>> '%s'\n", line);
         System.out.println(">>> " + tokens.length);

         switch (tokens[0]) {
            case Constants.COOKIE:
               if (tokens.length > 1)
                  count = Integer.parseInt(tokens[1]);
               cookie.get(count).stream()
                  .map(l -> "%s\n".formatted(l))
                  .forEach(l -> {
                     try { 
                        System.out.println(">>> line = " + l);
                        bw.write(l); 
                        bw.flush();
                     } catch (Exception ex) { }
                  });
                  bw.write("end\n");
                  bw.flush();
               break;

            case Constants.END:
               System.out.println("Bye bye");
               stop = true;
               break;

            default:
               bw.write("end\n");
               bw.flush();
         }

      }

      is.close();
      os.close();
      socket.close();
   }
   
}

// ClientHandler code
import java.net.Socket;
import java.io.*;

public class ClientHandler implements Runnable {
    private Socket clientSocket;

    public ClientHandler(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        try {
            // Handle client requests
            BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);

            // Read client request
            String clientRequest = reader.readLine();

            // Process the request
            if (clientRequest.equals("ORDER_ITEM")) {
                // Pseudo code to order an item with a minimum budget of $10
                String itemName = readItemName();
                double itemPrice = readItemPrice();

                if (itemPrice >= 10.0) {
                    // Process the order
                    processOrder(itemName, itemPrice);
                    writer.println("Order placed successfully!");
                } else {
                    writer.println("Minimum budget not met. Order cannot be processed.");
                }
            }

            // Close the connections
            reader.close();
            writer.close();
            clientSocket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Additional methods for reading item details and processing the order
}