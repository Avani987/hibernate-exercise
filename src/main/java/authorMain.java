package main.java;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class authorMain {

    public static void main(String[] args) throws ParseException {
        Crud crud = new Crud();
        List<Subject> sub_user1=new ArrayList<>();
        List<Subject> sub_user2=new ArrayList<>();
        Subject sub1=new Subject();
        Subject sub2=new Subject();
        Subject sub3=new Subject();

        sub1.setSubName("Physics");
        sub_user1.add(sub1);
        sub2.setSubName("Computers");
        sub_user1.add(sub2);
        sub3.setSubName("Maths");
        sub_user1.add(sub3);
        String d="20/05/1993";
        Date dob= new SimpleDateFormat("dd/MM/yyyy").parse(d);
        crud.saveAuthor("hij", "xxz", 27,dob,sub_user1);

        sub1.setSubName("OS");
        sub_user2.add(sub1);
        sub2.setSubName("Networking");
        sub_user2.add(sub2);
        sub3.setSubName("Computers");
        sub_user2.add(sub3);
        d="15/10/1989";
        dob= new SimpleDateFormat("dd/MM/yyyy").parse(d);
        crud.saveAuthor("jkl", "yxy", 42,dob,sub_user2);

        crud.readAuthor();

    }
}
