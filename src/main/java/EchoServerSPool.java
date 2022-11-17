import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class EchoServerSPool {
    public static boolean isInt (String myString){
        try {
            @SuppressWarnings("unused")
            int x = Integer.parseInt(myString);
            return true; //String is an Integer
        } catch (NumberFormatException e) {
            return false; //String is not an Integer
        }
    }
    public static void main(String[] args) throws IOException {
        if (args[0].equals("-t") && isInt(args[1])) {
            ServerSocket server = new ServerSocket(Integer.parseInt(args[2]));
            server.setReuseAddress(true);
            String nb = args[1];
            while (true) {
                Socket client = server.accept();
                //System.out.println("Client : " + client.getInetAddress().getHostAddress());
                ClientHandler clientSock = new ClientHandler(client);
                ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(Integer.parseInt(nb));
                executor.execute(clientSock);
            }
        }
        else System.out.println("Incompatible arguments");
    }
}
