import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class Day24_assignment_Client {
    public static void main(String[] args) {
        String hostName = "165.246.80.143";
        int portNumber = 20000;

        try (Socket socket = new Socket(hostName, portNumber);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in))) {

            System.out.println("Connected to the server. Type 'exit' to terminate.");

            String userInput;
            while ((userInput = stdIn.readLine()) != null) {
                if (userInput.equals("exit")) {
                    break;
                }
                userInput = userInput + "\n";
                socket.getOutputStream().write(userInput.getBytes());
                String serverResponse = in.readLine();
                System.out.println("Server response: " + serverResponse);
            }

        } catch (UnknownHostException e) {
            System.err.println("Don't know about host " + hostName);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to " + hostName);
            System.exit(1);
        }
    }
}
