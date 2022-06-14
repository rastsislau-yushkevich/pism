package javax.servlet.http;

import javax.annotation.Resource;
import javax.jms.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "MyServlet", value = "/MyServlet")
public class MyServlet extends HttpServlet {

    @Resource(name="java:comp/DefaultJMSConnectionFactory")
    private ConnectionFactory connectionFactory;

    @Resource(name="java:/jms/queue/Laba7Queue")
    private Destination destination;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String str = request.getParameter("msg");
        try {
            produceMessage(str);
            out.println("Your message is:" +str );
        } catch (JMSException e) {
            e.printStackTrace();
        }


    }

    public void produceMessage(Object message) throws JMSException {
        Connection connection = connectionFactory.createConnection();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        MessageProducer messageProducer = session.createProducer(destination);

        messageProducer.send(createMessage(session, message));

        connection.close();
        session.close();
    }

    private Message createMessage(Session session, Object message) throws JMSException {
        TextMessage textMessage = session.createTextMessage();
        textMessage.setText(message.toString());
        return textMessage;
    }

}
