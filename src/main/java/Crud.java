package main.java;

import java.util.Date;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Crud {

    SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    public void saveAuthor(String fname, String lname, int age, Date dob,Address address) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            Author author = new Author();
            author.setFirstName(fname);
            author.setLastName(lname);
            author.setAge(age);
            author.setDob(dob);
            author.setAddress(address);
            session.save(author);
            transaction.commit();
            System.out.println("Record inserted successfully");
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

    }

    public void readAuthor()
    {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            List<Author> authors = session.createQuery("from Author").list();
            for(Author a : authors) {
                System.out.println(a.toString());
                System.out.println("Author's address details :" + a.getAddress());
            }

            transaction.commit();

        } catch (HibernateException e) {

            transaction.rollback();

            e.printStackTrace();

        } finally {

            session.close();
            sessionFactory.close();

        }
    }
}
