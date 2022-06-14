import java.rmi.Remote;
import java.rmi.RemoteException;

public interface SaySmth extends Remote {
    String firstUpperCase(String lowerCase) throws RemoteException;
}
