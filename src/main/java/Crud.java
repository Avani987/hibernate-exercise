package main.java;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Crud {

    SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    public void saveAuthor(String fname, String lname, int age, Date dob) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            Collection<Book> bookCollection= new ArrayList<>();
            Book book1=new Book();
            book1.setBookName("Book 1");
            bookCollection.add(book1);
            Book book2=new Book();
            book2.setBookName("Book 2");
            bookCollection.add(book2);
            Book book3=new Book();
            book3.setBookName("Book 3");
            bookCollection.add(book3);

            session.save(book1);
            session.save(book2);
            session.save(book3);

            Author author = new Author();
            author.setFirstName(fname);
            author.setLastName(lname);
            author.setAge(age);
            author.setDob(dob);
            author.setBook(bookCollection);
            session.save(author);

            transaction.commit();
            System.out.println("Record inserted successfully");
        }
        catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        }
        finally {
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
