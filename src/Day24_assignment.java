import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Day24_assignment {
    private static List<Socket> clients = new ArrayList<>(); // list of clients connected to the server

    public static void main(String[] args) {
        System.out.println("Time server is running...");
        try (ServerSocket serverSocket = new ServerSocket(20000)) {
            while (true) {
                System.out.println("Waiting for a new client...");
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected at " + new Date());
                clients.add(clientSocket);
                Thread clientThread = new Thread(new ClientHandler(clientSocket));
                clientThread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // This inner class handles communication with a single client
    private static class ClientHandler implements Runnable {
        private Socket clientSocket;

        public ClientHandler(Socket clientSocket) {
            this.clientSocket = clientSocket;
        }

        @Override
        public void run() {
            try {
                while (true) {
                    // Read input from the client
                    String inputLine;
                    try (var in = clientSocket.getInputStream();
                         var reader = new BufferedReader(new InputStreamReader(in))) {
                        inputLine = reader.readLine();
                    }

                    // Check if the client wants to exit
                    if (inputLine.equalsIgnoreCase("exit")) {
                        System.out.println("Client disconnected at " + new Date());
                        break;
                    }

                    // Send the message to all clients
                    System.out.println("Message received from client: " + inputLine);
                    for (Socket client : clients) {
                        if (client != clientSocket) { // Don't send the message to the same client
                            try (var out = client.getOutputStream()) {
                                out.write(inputLine.getBytes());
                            }
                        } else {
                            try (var out = client.getOutputStream()) {
                                out.write(("You wrote: " + inputLine).getBytes());
                            }
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
