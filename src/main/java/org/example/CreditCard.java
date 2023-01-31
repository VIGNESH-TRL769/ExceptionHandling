package org.example;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Logger;
class CreditCardClone
{
    String name;
    long cardNumber;
    String expirationDate;
    CreditCardClone(String name,long cardNumber,String expirationDate)
    {
        this.name=name;
        this.cardNumber=cardNumber;
        this.expirationDate=expirationDate;
    }
    CreditCardClone(CreditCardClone object)
    {
        name=object.name;
        cardNumber=object.cardNumber;
        expirationDate= object.expirationDate;
    }
    Boolean checkNumber(long newCardNumber)
    {
        return cardNumber==newCardNumber;
    }

}
public class CreditCard
{
    public static final Logger LOGGER =  Logger.getLogger("InfoLogging");
    public static void main(String[] args)
    {
        Scanner input=new Scanner(System.in);
        try {
            LOGGER.info("Enetr the HolderName:");
            String name = input.nextLine();
            LOGGER.info("Enetr the CardNumber:");
            long cardNumber = input.nextLong();
            LOGGER.info("Enetr the ExpirationDate:");
            String expirationDate = input.next();
            CreditCardClone CreditCardClone = new CreditCardClone(name, cardNumber, expirationDate);
            CreditCardClone cloneCreditCardClone = new CreditCardClone(CreditCardClone);
            LOGGER.info("Enetr the NewCardNumber:");
            long newCardNumber = input.nextLong();
            String checkNumber = String.valueOf(CreditCardClone.checkNumber(newCardNumber));
            if (checkNumber.equals("true"))
                LOGGER.info("Cardnumber is equal");
            else {
                LOGGER.info("Cardnumber is not equal");
                cloneCreditCardClone.cardNumber = newCardNumber;
            }
            String oldcard = "Original Details:Holder Name:" + name + " Card Number:" + cardNumber + " Experied Date:" + expirationDate;
            String newCard = "Cloned Details:Holder Name:" + cloneCreditCardClone.name + " Card Number:" + cloneCreditCardClone.cardNumber + " Experied Date:" + cloneCreditCardClone.expirationDate;
            LOGGER.info(oldcard);
            LOGGER.info(newCard);
        }
        catch (InputMismatchException e)
        {
            String value="Please Enter Valid Inputs:"+e;
            LOGGER.info(value);
            input.nextLine();
        }
        catch (RuntimeException e)
        {
            String value="Please Enter Valid Inputs:"+e;
            LOGGER.info(value);
            input.nextLine();
        }
        catch (Exception e)
        {
            String value="Please Enter Valid Inputs:"+e;
            LOGGER.info(value);
            input.nextLine();
        }
        catch (Throwable e)
        {
            String value="Please Enter Valid Numbers:"+e;
            LOGGER.info(value);
            input.nextLine();
        }
        finally {
            LOGGER.info("----Thank You----");
        }

    }
}