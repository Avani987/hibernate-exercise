package main.java;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class authorMain {

    public static void main(String[] args) throws ParseException {
        Crud crud = new Crud();

        Book b= new Book();
        b.setBookName("ABC");
        String d="20/05/1993";
        Date dob= new SimpleDateFormat("dd/MM/yyyy").parse(d);
        crud.saveAuthor("hij", "xxz", 27,dob,"ABC");

        b=new Book();
        b.setBookName("DEF");
        d="15/10/1989";
        dob= new SimpleDateFormat("dd/MM/yyyy").parse(d);
        crud.saveAuthor("jkl", "yxy", 42,dob,"DEF");

        crud.readAuthor();

    }
}
