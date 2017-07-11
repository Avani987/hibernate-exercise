package main.java;
import java.text.ParseException;

public class authorMain {

    public static void main(String[] args) throws ParseException {
        Crud crud = new Crud();
        crud.saveAuthor();
        crud.readAuthor();

    }
}
