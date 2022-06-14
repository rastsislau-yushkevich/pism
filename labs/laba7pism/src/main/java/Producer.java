import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.Schedule;
import javax.ejb.Stateless;
import javax.jms.*;

@Stateless
@LocalBean
public class Producer {
//    @Resource(name="java:/Laba7ConnectionFactory")
    @Resource(name="java:comp/DefaultJMSConnectionFactory")
    private ConnectionFactory connectionFactory;

    @Resource(name="java:/jms/queue/Laba7Queue")
    private Destination destination;

    @Resource(name="java:/jms/queue/ExpiryQueue")
    private Destination dest;

    @Schedule(hour = "*", minute = "*", second = "*/5", persistent = false)
    public void produceMessage() throws JMSException {
        Connection connection = connectionFactory.createConnection();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        MessageProducer messageProducer = session.createProducer(destination);
        TextMessage textMessage = session.createTextMessage(" зар как уме ано а ,упялш кижум липуК ");

        messageProducer.send(textMessage);
        System.out.println("-------------------------------------");
        connection.close();
        session.close();
    }

    @Schedule(hour = "*", minute = "*", second = "*/15", persistent = false)
    public void produceMessageToClient() throws JMSException {
        Connection connection2 = connectionFactory.createConnection();
        Session session = connection2.createSession(false, Session.AUTO_ACKNOWLEDGE);
        MessageProducer messageProducer = session.createProducer(dest);
        TextMessage textMessage = session.createTextMessage("Hello MDB CLI 2");

        messageProducer.send(textMessage);
        System.out.println("-------------------------------------");
        connection2.close();
        session.close();
    }

}
