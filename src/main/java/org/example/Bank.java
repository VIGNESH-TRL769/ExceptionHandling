package org.example;
import java.util.Scanner;
import java.util.logging.Logger;
class BankAccount
{
    public static final Logger LOGGER =  Logger.getLogger("InfoLogging");
    private final String name;
    private final Long accountNumber;
    Double balance=0.0D;
    public BankAccount(String name,Long accountNumber)
    {
        this.name=name;
        this.accountNumber=accountNumber;
    }
    public void getAccountDetails()
    {
        String print="\nHolderName:"+name+"\nAccountNumber:"+accountNumber+"\nBalance:"+balance+"0\n";
        LOGGER.info(print);
    }
    public void deposite(int amount)
    {
        balance+=amount;
        String print="\nDeposite of Amount Rs "+amount+".00 is Successfully\n";
        LOGGER.info(print);
    }
    public void withdraw(int amount)
    {
        if(balance-amount>=100)
        {
            balance-=amount;
            String print="\nWithdraw of Amount Rs:"+amount+".00 is Successfully\n";
            LOGGER.info(print);
        }
        else
            LOGGER.info("\nWithdrawal Limit Above Rs:100");
    }

}


public class Bank  {
    public static final Logger LOGGER =  Logger.getLogger("InfoLogging");
    public static void main(String[] args)
    {
        Scanner input=new Scanner(System.in);
        LOGGER.info("\nEnter the HolderName:");
        String name=input.nextLine();
        LOGGER.info("\nEnter the AccountNumber:");
        long accountNumber=input.nextLong();
        BankAccount bankAccount=new BankAccount(name,accountNumber);

        while(true)
        {
            try {
                LOGGER.info("\n1.deposite\n2.withdraw\n3.balance\n4.Exit\n");
                LOGGER.info("\nEnter the Choice:");
                int value = input.nextInt();
                int temp1 = 0;
                switch (value) {
                    case 1 -> {
                        LOGGER.info("\nEnter the deposite Amount:");
                        int depositeAmount = input.nextInt();
                        bankAccount.deposite(depositeAmount);
                    }
                    case 2 -> {
                        LOGGER.info("\nEnter the withdraw Amount:");
                        int withdrawAmount = input.nextInt();
                        if (bankAccount.balance >= 100)
                            bankAccount.withdraw(withdrawAmount);
                        else {
                            String print = "\nMinimum Balance Should be Rs:100 You having Balance Amount=" + bankAccount.balance + "0 ";
                            LOGGER.info(print);
                        }
                    }
                    case 3 -> bankAccount.getAccountDetails();
                    case 4 -> temp1 = 1;
                    default -> LOGGER.info("\nInvalid Choice Tryagin\n");
                }
                if (temp1 == 1) {
                    LOGGER.info("\n------Thank You------");
                    return;
                }
            }
            catch (Exception e)
            {
                String value="Please Enter Valid Inputs:"+e;
                LOGGER.info(value);
                input.nextLine();
            }
        }

    }
}
