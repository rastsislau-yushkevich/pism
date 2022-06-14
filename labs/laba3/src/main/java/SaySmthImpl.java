import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SaySmthImpl extends UnicastRemoteObject implements SaySmth {
    protected SaySmthImpl() throws RemoteException {
    }

    @Override
    public String firstUpperCase(String lowerCase) {
        Matcher mth = Pattern.compile("^\\w|\\W\\w").matcher(lowerCase);
        while (mth.find()) {
            lowerCase = lowerCase.replaceFirst(mth.group(), mth.group().toUpperCase());
        }
        return lowerCase;
    }
}
