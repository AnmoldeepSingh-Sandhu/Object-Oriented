public class BankAccount {
    private double balance;
    private int accountNumber;


    /**
     * this method will be used to open new bank account
     * @param anAccountNumber this is the account number given by the user
     */
    public BankAccount(int anAccountNumber){

        String accNum = "" + anAccountNumber;

        if(accNum.length() == 4){

            balance = 0;
            accountNumber = anAccountNumber;

        }else{

            throw new BankAccountException("You must enter 4 digit Account Number.");
        }
 
    }



    /**
     * this method will be used to open new bank account with the initial balance
     * @param anAccountNumber this is the account number given by the user
     * @param initialBalance this is the initial balance given by the user 
     */
    public BankAccount(int anAccountNumber, double initialBalance){
        
        if(initialBalance < 0){

            throw new BankAccountException("Your Account balance should not be less than 0.");

        }else{

            balance = initialBalance;
            accountNumber = anAccountNumber;
        }
    }




    /**
     * this method will give back user the balance of him/her account 
     * @return this will return the balance available in the account
     */
    public double getBalance() {

        return balance;
    }



    /**
     * this method will give back user the account number of him/her account 
     * @return this will return the account number of the user account
     */
    
    public int getAccountNumber(){

        return accountNumber;
    }




    /**
     * this method will be used to deposit money in the bank account
     * @param amount this is the amount of money user want to deposit
     */
    public void deposit(double amount){

        if(amount > 0){
            balance += amount;
        }else{
            throw new BankAccountException("\nYour deposited amount should not be less than 0.");
        }
    }




    /**
     * this method will be used to withdraw money from the bank account
     * @param amount this is the amount of money user want to withdraw
     */
    public void withdraw(double amount){

        if(balance < amount){

            throw new BankAccountException("You don't have enough balance in your account to withdraw "+ amount );

        }else if(amount < 1){

            throw new BankAccountException("\nEnter a positive amount to withdraw.");

        }else{
            balance -= amount;
        }
    }



    // this method will give the string representation 
    @Override
    public String toString(){

        return "Account Number: " + accountNumber + "  balance: " + balance;
    }
}
