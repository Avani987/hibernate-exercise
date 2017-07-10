package main.java;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class authorMain {

    public static void main(String[] args) {

        Author author= new Author(23,"Avani","Khurana");
        Author author1=new Author(25,"Sara","Jain");
        SessionFactory sessionFactory= new Configuration().configure().buildSessionFactory();
        Session session= sessionFactory.openSession();
        session.beginTransaction();
        session.save(author);
        session.save(author1);
        session.getTransaction().commit();
    }
}
