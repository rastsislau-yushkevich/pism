import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;

public class Server {
    public static void main(String[] args) throws NamingException, RemoteException, MalformedURLException, AlreadyBoundException {
//        Context context = new InitialContext();
//        context.bind("rmi://localhost:1099/SaySmth", new SaySmthImpl());
        Naming.bind("SaySmth", new SaySmthImpl());
    }
}

