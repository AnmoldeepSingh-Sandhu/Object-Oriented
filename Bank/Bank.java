import java.util.ArrayList;

public class Bank {

    private ArrayList<BankAccount> accounts;

    /**
     * this method will be used to create new bank
     */
    public Bank()
    {
	  
        accounts = new ArrayList<BankAccount>();
    }




    /**
     * this method will be used to add new account in the bank
     * @param a this is a account number of new account 
     */
    public void addAccount(BankAccount a)
    {
        accounts.add(a);
    }




    /**
     * this method will be used to get the total amount of money available in the bank
     * @return this will return the total balance in the bank
     */
    public double getTotalBalance()
    {
        double total = 0;
        for(BankAccount a : accounts)
        {
            total = total + a.getBalance();
        }
        return total;
    }





    /**
     * this method will be used to deposit money in the existing account
     * @param accountNumber this is the account number in which user going to deposit money
     * @param amount this is the amount of money user want to deposit
     */
    public void deposits(int accountNumber, double amount){

        String accNum = "" + accountNumber;

        boolean exist = false;

        if(accNum.length() == 4){

            for(BankAccount a : accounts){

                if(a.getAccountNumber() == accountNumber){

                    a.deposit(amount);
                    exist = true;
                }
            }
        }else{

            throw new BankException("You must enter 4 digit Account Number.");
        }

        if(exist == false){

            throw new BankException("This Account number does not exist. Please check your account number");

        }
   
    }





     /**
     * this method will be used to withdraw money from the existing account
     * @param accountNumber this is the account number from  which user going to withdraw money
     * @param amount this is the amount of money user want to withdraw
     */
    public void withdraws(int accountNumber, double amount){

        String accNum = "" + accountNumber;

        boolean exist = false;

        if(accNum.length() == 4){

            for(BankAccount a : accounts){

                if(a.getAccountNumber() == accountNumber){

                    a.withdraw(amount);
                    exist = true;
                }
            }

        }else{

            throw new BankException("You must enter 4 digit Account Number.");
            
        }

        if(exist == false){

            throw new BankException("This Account number does not exist. Please check your account number");

        }

    }





    /**
     Counts the number of bank accounts whose balance is at least a given value.
     @param atLeast the balance required to count an account
     @return the number of accounts having least the given balance
     */
    public int count(double atLeast)
    {
        int matches = 0;

        for(BankAccount a : accounts)
        {

            if (a.getBalance() >= atLeast)
                matches++;

        }
        return matches;
    }






    /**
     Finds a bank account with a given number.
     @param accountNumber the number to find
     @return the account with the given number, or null if there is no such account
     */
    public BankAccount find(int accountNumber)
    {
        for(BankAccount a : accounts)
        {

            if (a.getAccountNumber() == accountNumber)
                return a;

        }

        throw new BankException("There is no account in the bank with account number = " + accountNumber);
    }





    /**
     Gets the bank account with the largest balance.
     @return the account with the largest balance, or null if the bank has no accounts
     */
    public BankAccount getMaximum()
    {
        if (accounts.size() == 0)
            throw new BankException("There is no account open yet in the bank.");

        BankAccount largest = accounts.get(0);


        for (int i = 1; i < accounts.size(); i++)
        {

            BankAccount a = accounts.get(i);
            if (a.getBalance() > largest.getBalance())
                largest = a;

        }

        return largest;
    }






      /**
     Gets the bank account with the minimum balance.
     @return the account with the minimum balance, or null if the bank has no accounts
     */
    public BankAccount getMinimum()
    {

        if (accounts.size() == 0)
            throw new BankException("There is no account open yet in the bank.");

        BankAccount smallest = accounts.get(0);

        for (int i = 1; i < accounts.size(); i++)
        {

            BankAccount a = accounts.get(i);
            if (a.getBalance() < smallest.getBalance())
                smallest = a;

        }

        return smallest;
    }

    


     // this method will give the string representation 
    public String toString()
    {
        return "Bank " + accounts.toString();
    }

}
