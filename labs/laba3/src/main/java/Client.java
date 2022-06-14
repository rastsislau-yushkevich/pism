import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException, NamingException, AlreadyBoundException, NotBoundException {
//        Context context = new InitialContext();
//        context.bind("rmi://localhost:1099/SaySmth", new SaySmthImpl());
        System.out.println("Enter the line you want to edit:");
        Scanner scanner = new Scanner(System.in);
        String before = scanner.nextLine();
        SaySmth saySmth = (SaySmth) Naming.lookup("SaySmth");
        String result = saySmth.firstUpperCase(before);
        System.out.println(result);
    }
}
