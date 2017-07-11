package main.java;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class authorMain {

    public static void main(String[] args) throws ParseException {
        Crud crud = new Crud();
        /* Create Operation for 3 records */
        String d="18/05/1993";
        Date dob= new SimpleDateFormat("dd/MM/yyyy").parse(d);
        crud.saveAuthor("abc", "xxx", 27,dob);
        d="22/10/1992";
        dob= new SimpleDateFormat("dd/MM/yyyy").parse(d);
        crud.saveAuthor("def", "yyy", 42,dob);
        d="3/08/1985";
        dob= new SimpleDateFormat("dd/MM/yyyy").parse(d);
        crud.saveAuthor("ghi", "xzz", 35,dob);

        /* Read operation for records to retrieve records in database */
        crud.readAuthor();

    }
}
