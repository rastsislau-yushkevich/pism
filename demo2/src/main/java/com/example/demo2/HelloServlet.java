package com.example.demo2;

import java.io.*;
import java.util.List;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private static SessionFactory sessionFactory;


    public void init() {

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        sessionFactory = new Configuration().configure().buildSessionFactory();
        HelloServlet helloServlet = new HelloServlet();

        helloServlet.addPerformance("Han Solo", 1000);
        helloServlet.addPerformance("Uncharted", 2000);

        List performances = helloServlet.listPerformances();

        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        for (int i=0; i< performances.size(); i++) {
            out.println("<h1>" + performances.get(i) + "</h1>");
        }
        out.println("</body></html>");
    }

    public void destroy() {
    }

    public void addPerformance(String name, int price) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();
        Performance performance = new Performance(name, price);
        session.save(performance);
        transaction.commit();
        session.close();
    }

    public List listPerformances() {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();
        List performances = session.createQuery("FROM Performance ").list();

        transaction.commit();
        session.close();
        return performances;
    }

//    public void updatePerformance(int id, String name, int price) {
//        Session session = this.sessionFactory.openSession();
//        Transaction transaction = null;
//
//        transaction = session.beginTransaction();
//        Performance performance = (Performance) session.get(Performance.class, id);
//        performance.setName(name);
//        performance.setPrice(price);
//        session.update(performance);
//        transaction.commit();
//        session.close();
//    }
//
//    public void removePerformance(int id) {
//        Session session = this.sessionFactory.openSession();
//        Transaction transaction = null;
//
//        transaction = session.beginTransaction();
//        Performance performance = (Performance) session.get(Performance.class, id);
//        session.delete(performance);
//        transaction.commit();
//        session.close();
//    }

}