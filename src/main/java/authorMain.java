package main.java;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
public class authorMain {

    public static void main(String[] args) throws ParseException {
        Crud crud = new Crud();
        Address address= new Address();
        address.setStreetNo(24);
        address.setLocation("Keshav Puram");
        address.setState("Delhi");
        String d="20/05/1993";
        Date dob= new SimpleDateFormat("dd/MM/yyyy").parse(d);
        crud.saveAuthor("hij", "xxz", 27,dob,address);
        address.setStreetNo(11);
        address.setLocation("Ashok Vihar");
        address.setState("Delhi");
        d="15/10/1989";
        dob= new SimpleDateFormat("dd/MM/yyyy").parse(d);
        crud.saveAuthor("jkl", "yxy", 42,dob,address);
        address.setStreetNo(18);
        address.setLocation("Kochi");
        address.setState("Kerala");
        d="15/10/1989";
        dob= new SimpleDateFormat("dd/MM/yyyy").parse(d);
        crud.saveAuthor("jkl", "yxy", 42,dob,address);
        crud.readAuthor();

    }
}
