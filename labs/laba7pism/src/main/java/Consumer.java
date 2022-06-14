import javax.annotation.Resource;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.*;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

@MessageDriven(name = "Consumer",
activationConfig = {@ActivationConfigProperty(propertyName = "destination", propertyValue = "java:/jms/queue/Laba7Queue")})
public class Consumer implements MessageListener {

    ObjectOutputStream oos = null;
    String text = null;
    String result = null;
    char ch;

    @Override
    public void onMessage(Message message) {
        TextMessage textMessage = (TextMessage) message;
        try {
            oos = new ObjectOutputStream(new FileOutputStream("/Users/ryu/Desktop/pism/labs/laba7pism/src/main/resources/amount.txt"));
            System.out.println(textMessage.getText());
            text = textMessage.getText();

 //           text+="!";

            for(int i=0; i<text.length();i++) {
                ch = text.charAt(i);
               result = ch+result;
            }

           oos.writeObject(result);
         //   oos.writeObject(text);
            oos.close();
        } catch (JMSException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
