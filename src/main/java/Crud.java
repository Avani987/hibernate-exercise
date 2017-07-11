package main.java;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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

    public void saveAuthor() {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            Book book1=new Book();
            book1.setBookName("Book 1");
            Book book2=new Book();
            book2.setBookName("Book 2");
            Book book3=new Book();
            book3.setBookName("Book 3");

            Author author1 = new Author();
            author1.setFirstName("author1");
            author1.setLastName("1");
            author1.setAge(29);
            String d="20/05/1993";
            Date dob= new SimpleDateFormat("dd/MM/yyyy").parse(d);
            author1.setDob(dob);
            author1.getBook().add(book1);
            author1.getBook().add(book2);
            book1.getAuthor().add(author1);
            book2.getAuthor().add(author1);

            Author author2 = new Author();
            author2.setFirstName("author2");
            author2.setLastName("2");
            author2.setAge(25);
            d="12/11/1989";
            dob=new SimpleDateFormat("dd/MM/yyyy").parse(d);
            author2.setDob(dob);
            author2.getBook().add(book3);
            book3.getAuthor().add(author2);

            session.save(author1);
            session.save(author2);
            session.save(book1);
            session.save(book2);
            session.save(book3);

            transaction.commit();
            System.out.println("Record inserted successfully");
        }
        catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } catch (ParseException e) {
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
