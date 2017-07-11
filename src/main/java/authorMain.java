package main.java;
import java.util.Scanner;

public class authorMain {

    public static void main(String[] args) {
        Crud crud = new Crud();
        /* Create Operation for 3 records */
        crud.saveAuthor("abc", "xxx", 27);
        crud.saveAuthor("def", "yyy", 42);
        crud.saveAuthor("ghi", "xzz", 35);

        /* Read operation for records to retrieve records in database */
        crud.readAuthor();

        /* Delete based on author's id */
        Scanner reader = new Scanner(System.in);
        System.out.println("Enter the id of the Author you want to delete: ");
        int id = reader.nextInt();
        crud.deleteAuthor(id);

        /* Update based on author's id */
        System.out.println("Enter the id of the Author you want to update: ");
        int i = reader.nextInt();
        crud.updateAuthor(i);

    }
}
