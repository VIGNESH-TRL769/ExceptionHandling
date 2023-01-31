package org.example;
import java.util.Scanner;
import java.util.logging.Logger;
class Database {
    static int temp=0;
    static int v=0;
    public static final Logger LOGGER =  Logger.getLogger("InfoLogging");
    static Database dbObject=null;
    private Database() {
    }

    public static Database getInstance()
    {

        if(v == 0)
        {
            LOGGER.info("New Connection");
            dbObject = new Database();
            v=1;
        }
        else
        {

            LOGGER.info("Already Connection Exists");
        }
        return dbObject;
    }

    public static void getConnection()
    {
        temp=1;
        String print="Connected Successfully:"+dbObject;
        LOGGER.info(print);
    }
    public static void newConnection()
    {
        temp=0;
        v=0;
        dbObject=getInstance();
        String print="New Connection Initiziated:"+dbObject;
        LOGGER.info(print);
    }
    public static void viewStatus()
    {
        if(temp==1)
        {
            LOGGER.info("Connection ON");
        }
        else
        {
            LOGGER.info("Connection OFF");
        }
    }
    public  static void closeConnection()
    {
        temp=0;
        v=0;
        String print="Connection closed";
        LOGGER.info(print);
    }

}
class DatabaseConnection {
    public static final Logger LOGGER =  Logger.getLogger("InfoLogging");
    public static void main(String[] args)
    {
        Scanner input=new Scanner(System.in);

        while(true) {
            try {
                LOGGER.info("\n1.Connetion to DataBase\n2.new Connection\n3.Close All Connection\n4.View Status\n5.Exit\nEnter the Choice:");
                int key = input.nextInt();
                int temp = 0;
                Database.getInstance();
                switch (key) {
                    case 1 -> Database.getConnection();
                    case 2 -> Database.newConnection();
                    case 3 -> Database.closeConnection();
                    case 4 -> Database.viewStatus();
                    case 5 -> {
                        LOGGER.info("-----Thank You-----");
                        temp = 1;
                    }
                    default -> LOGGER.info("Please enter Valid Choice");
                }
                if (temp == 1) {
                    break;
                }

            }
            catch (RuntimeException e) {
                String value = "Please Enter Valid Inputs:" + e;
                LOGGER.info(value);
                input.nextLine();
            }
            catch (Exception e) {
                String value = "Please Enter Valid Inputs:" + e;
                LOGGER.info(value);
                input.nextLine();
            }
            catch (Throwable e) {
                String value = "Please Enter Valid Inputs:" + e;
                LOGGER.info(value);
                input.nextLine();
            }
        }

    }
}