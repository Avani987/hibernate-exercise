package main.java;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class authorMain {

    public static void main(String[] args) throws ParseException {
        Crud crud = new Crud();

        /* Records in database before updation */
        crud.readAuthor();

        /* Update Operation for 4 records */
        String d="20/05/1993";
        Date dob= new SimpleDateFormat("dd/MM/yyyy").parse(d);
        crud.saveAuthor("hij", "xxz", 27,dob);
        d="15/10/1989";
        dob= new SimpleDateFormat("dd/MM/yyyy").parse(d);
        crud.saveAuthor("jkl", "yxy", 42,dob);
        d="9/08/1991";
        dob= new SimpleDateFormat("dd/MM/yyyy").parse(d);
        crud.saveAuthor("lmn", "yzz", 35,dob);
        d="29/03/1991";
        dob= new SimpleDateFormat("dd/MM/yyyy").parse(d);
        crud.saveAuthor("opq", "xzzy", 35,dob);

        /* Read operation after Updation */
        crud.readAuthor();

    }
}
