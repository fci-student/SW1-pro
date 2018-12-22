package com.company;
import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

public class Main {

    static Scanner in = new Scanner(System.in);
    static int id_item = 1;
    static int id_user = 0;


    //*********************Class for users
    static class user{
        String fname , lname , email , password ;
        Vector <Integer> id = new Vector<>();
        int iduser;

        user(String fname , String lname , String email , String password){
            this.fname = fname;
            this.lname = lname;
            this.email = email;
            this.password = password;
            this.iduser = id_user;
        }
    }
    static Vector <user> users = new Vector<>();


    //*********************Class for items
    static class item{
        String kind;
        String Date;
        String color;
        String place;
        int id;

        item(String kind , String Date , String color , String place , int id) {
            this.id = id;
            this.color = color;
            this.Date = Date;
            this.kind = kind;
            this.place = place;
        }
    }
    static Vector <item> items = new Vector<>();




    //*********************Function to generate email
    static String generate_email(String fname , String lname )
    {
        String e = fname+lname+"@LookIt.com";
        Random r = new Random();
        int result = r.nextInt(100-10) + 10;

        for (int i=0 ; i<users.size() ; i++)
        {
            if (!users.get(i).email.equals(e))
                continue;
            else
                e = fname+lname+result+"@LookIt.com";
        }
        return e;
    }




    //****************Function of search
    public static void search(){
        System.out.println("\nKind\tDate\t\t\tColur\tPlace\tID");

        for (int j=0 ; j<items.size() ; j++)
             System.out.println(items.get(j).kind + "\t\t" + items.get(j).Date + "\t\t" + items.get(j).color + "\t\t" + items.get(j).place + "\t\t" + items.get(j).id + "\n");

        System.out.println("Filter by : [1-Kind 2-Date 3-place]");
        String x="" , s;
        x = in.nextLine();

        if (x.equals("1")) {
            System.out.println("Enter Sort");
            s = in.nextLine();
            for (int j = 0; j < items.size(); j++) {
                if (items.get(j).kind.equals(s)) {
                    System.out.println(items.get(j).kind + "\t\t" + items.get(j).Date + "\t\t" + items.get(j).color + "\t\t" + items.get(j).place + "\t\t" + items.get(j).id + "\n");
                }
            }
        }
        else if (x.equals("2")) {
            System.out.println("Enter Date in Format 'DD/MM/YYYY'");
            s = in.nextLine();
            for (int j = 0; j < items.size(); j++) {
                if (items.get(j).Date.equals(s)) {
                    System.out.println(items.get(j).kind + "\t\t" + items.get(j).Date + "\t\t" + items.get(j).color + "\t\t" + items.get(j).place + "\t\t" + items.get(j).id + "\n");
                }
            }
        }
        else if (x.equals("3")) {
            System.out.println("Enter where do you lost");
            s = in.nextLine();
            for (int j = 0; j < items.size(); j++) {
                if (items.get(j).kind.equals(s)) {
                    System.out.println(items.get(j).kind + "\t\t" + items.get(j).Date + "\t\t" + items.get(j).color + "\t\t" + items.get(j).place + "\t\t" + items.get(j).id + "\n");
                }
            }
        }
        else
            System.out.println("No Results \n");

    };




    //****************Function of post
    public static void post(int x){
        String sort , date , place , color ;

        System.out.println("Enter Kind of lost thing [wallet(w) - watch(wa) - phone(p)]");
        sort = in.nextLine();

        System.out.println("Enter Date of found");
        date = in.nextLine();

        System.out.println("Enter Colour of Item");
        color = in.nextLine();

        System.out.println("Enter The place where you found Item");
        place = in.nextLine();

         item i = new item(sort , date , color , place , id_item);

        items.add(i);
        users.get(x).id.add(id_item);

        id_item++;
        System.out.println("Item Added Successfully\n");

    };



    //********************access data
    public static void into_applecation(int num)
    {
        String x;
        while (true)
        {
            System.out.println("1-Search \n2-post \n3-show my found items \n4-Log out" );
            x = in.nextLine();

            if (x.equals("1"))
                search();

            else if (x.equals("2"))
                post(num);

            else if (x.equals("3")) {
                System.out.println("\nKind\tDate\t\t\tColur\tPlace\tID");
                for (int i = 0; i < users.get(num).id.size(); i++) {
                    for (int j=0 ; j<items.size() ; j++)
                    {
                        if (users.get(num).id.get(i) == items.get(j).id)
                        {
                            System.out.println(items.get(j).kind + "\t\t" + items.get(j).Date + "\t\t" + items.get(j).color + "\t\t" + items.get(j).place + "\t\t" + items.get(j).id + "\n");
                        }
                    }
                }
            }

            else if (x.equals("4"))
            {
                System.out.println("you Logged out Successfully");
                break;
            }
            else
                System.out.println("out of bound");
        }
    }




    //*********************sign up form
    public static void signup(){

        String fname , lname , email = "", password;

        System.out.println("Enter first name : ");
        fname = in.nextLine();

        System.out.println("Enter last name : ");
        lname = in.nextLine();

        System.out.println("Enter password : ");
        password = in.nextLine();

        email = generate_email(fname , lname);

        user u = new user(fname , lname , email , password);
        users.add(u);

        System.out.println("**********************************************");
        System.out.println("        Welcom : " + u.fname);
        System.out.println(" Your Email is : " + u.email);
        System.out.println("**********************************************");

        into_applecation(u.iduser);
        id_user++;
    }




    //*********************Log in form
    static void log_in()
    {
        String email , password;
        System.out.println("Enter email : ");
        email = in.nextLine();

        System.out.println("Enter password : ");
        password = in.nextLine();

        for (int i=0 ; i<users.size() ; i++)
        {
            if (users.get(i).email.equals(email) && users.get(i).password.equals(password))
            {
                System.out.println("**********************************************");
                System.out.println("        Welcom : " + users.get(i).fname);
                System.out.println(" Your Email is : " + users.get(i).email);
                System.out.println("**********************************************");

                into_applecation(users.get(i).iduser);
            }
            else
                System.out.println("Sorry , you are not on the System");
        }

    }

    static void implement()
    {
        while (true)
        {
            String x;
            System.out.println("1-Sign Up \n2-Log in \n3-Close The Applecation");
            x = in.nextLine();

            if (x.equals("1"))
                signup();
            else if (x.equals("2"))
                log_in();
            else if (x.equals("3"))
                break;
            else
                System.out.println("Please Choose Correctly");
        }
    }

    public static void main(String[] args) {
        implement();
     }
}
