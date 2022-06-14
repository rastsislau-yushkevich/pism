import javax.annotation.Resource;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@MessageDriven(name = "Consumer2",
        activationConfig = {@ActivationConfigProperty(propertyName = "destination", propertyValue = "java:/jms/queue/ExpiryQueue")})
public class Consumer2 implements MessageListener {
    int i;


    @Override
    public void onMessage(Message message) {
        TextMessage textMessage = (TextMessage) message;
        try {
            System.out.println(textMessage.getText());
            ++i;
            System.out.println(i);
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

}