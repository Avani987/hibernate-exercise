package main.java;

import java.util.List;
import java.util.Scanner;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Crud {

    SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    public void saveAuthor(String fname, String lname, int age) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            Author author = new Author();
            author.setFirstName(fname);
            author.setLastName(lname);
            author.setAge(age);
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
            for(Author a : authors)
                System.out.println(a.toString());

            transaction.commit();

        } catch (HibernateException e) {

            transaction.rollback();

            e.printStackTrace();

        } finally {

            session.close();

        }
    }

    public void deleteAuthor(int id) {

        Session session = sessionFactory.openSession();
        Transaction transaction=null;
        try {
            transaction=session.beginTransaction();
            Author author=(Author)session.get(Author.class,id);
            session.delete(author);
            System.out.println("Author record deleted!");
            session.getTransaction().commit();

        } catch (HibernateException e) {

            transaction.rollback();

            e.printStackTrace();

        } finally {

            session.close();

        }
    }

    public void updateAuthor(int i) {

        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Author author= (Author)session.get(Author.class,i);
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter the new First Name: ");
            String fn = sc.next();
            System.out.println("Enter the new Last Name: ");
            String ln = sc.next();
            System.out.println("Enter the new Age: ");
            int ag = sc.nextInt();
            author.setAge(ag);
            author.setFirstName(fn);
            author.setLastName(ln);
            session.update(author);
            System.out.println("Author record updated!");
            session.getTransaction().commit();
        } catch (HibernateException e) {

            transaction.rollback();

            e.printStackTrace();

        } finally {

            session.close();

        }
    }
}
