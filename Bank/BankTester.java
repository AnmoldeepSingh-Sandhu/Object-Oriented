import java.util.Scanner;

public class BankTester {

    public static void main(String[] args) {
        
        Scanner userInput = new Scanner(System.in);

        Bank ScotiaBank = new Bank();

        int done = 0;

        // This loop will show the user menu until he don't want to exit
        while(done == 0){

            

            System.out.println("\n");
            System.out.println("Enter (N) to Create new bank account.");
            System.out.println("Enter (G) to get the combine balance of all accounts.");
            System.out.println("Enter (D) to deposit money to existing account.");
            System.out.println("Enter (W) to withdraw money from existing account.");
            System.out.println("Enter (C) to count the accounts in the bank whose balance is at least a given value.");
            System.out.println("Enter (F) to find the account in the bank.");
            System.out.println("Enter (L) to get the account with maximum balance.");
            System.out.println("Enter (S) to get the account with minimum balance.");
            System.out.println("Enter (E) to EXIT");



            System.out.print("\nEnter the value from above given menu: ");
            char option = userInput.next().toUpperCase().charAt(0);


            // this will be used to open new account in the bank
            if(option == 'N'){

                try{

                    System.out.print("\nEnter the 4 digit account number to create an account: ");

                    int accountNumber = userInput.nextInt();

                    ScotiaBank.addAccount(new BankAccount(accountNumber));
                    

                }catch(BankAccountException exception){
                    
                    System.out.println(exception);
                }


            // this will be used to get the total balance available in the bank
            }else if(option == 'G'){

                ScotiaBank.getTotalBalance();

                System.out.println("\nTotal Balance: " + ScotiaBank.getTotalBalance());



            // this will be used to deposit money to the specific bank account
            }else if(option == 'D'){

                try{

                    System.out.print("\nEnter the 4 digit account number to deposit the money: ");
                    int accountNumber = userInput.nextInt();


                    System.out.print("\nEnter the amount of money you want to deposit: ");
                    Double amount = userInput.nextDouble();


                    ScotiaBank.deposits(accountNumber, amount);
                    
                    System.out.println("\n$" + amount + " has been credited to your account.");


                }catch(BankException exception){

                    System.out.println(exception);

                }catch(BankAccountException exception){

                    System.out.println(exception);
                }


            // this will be used to withdraw money from the specific bank account
            }else if(option == 'W'){

                double amount = 0;

                try{

                    System.out.print("\nEnter the 4 digit account number to withdraw the money: ");
                    int accountNumber = userInput.nextInt();
                    

                    System.out.print("Enter the amount of money you want to withdraw: ");
                    amount = userInput.nextDouble();


                    ScotiaBank.withdraws(accountNumber, amount);

                    System.out.println("\nYou have withdrawn $" + amount + " from your account.");


                }catch(BankException exception){

                    System.out.println(exception);
                }catch(BankAccountException exception){

                    System.out.println(exception);
                }



            // this will be used to count the number of accounts in the bank with the mininum balance provided by the user.  
            }else if(option == 'C'){

                System.out.print("\nEnter a value to count the number of bank accounts that have equal and higher balance than that value: ");
                Double atLeast = userInput.nextDouble();

                System.out.println("\nNumber of bank accounts with aleast $" + atLeast +" balance: " + ScotiaBank.count(atLeast));



            // this will be used to find the specific bank account in the bank
            }else if(option == 'F'){

                int accountNumber = 0;

                try{

                    System.out.print("\nEnter the the 4 digit account number to find the bank account: ");
                    accountNumber = userInput.nextInt();

                    System.out.println("\nBank account:\n" + ScotiaBank.find(accountNumber));

                }catch(BankException exception){

                    System.out.println("\nThere is no account in the bank with account number = " + accountNumber);
                }

                

            // this will be used to find the bank account with the maximum balance
            }else if(option == 'L'){

                try{

                    ScotiaBank.getMaximum();

                    System.out.println("\nBank account with the largest balance:\n" + ScotiaBank.getMaximum());

                }catch(BankException exception){

                    System.out.println(exception);
                }



            // this will be used to find the bank account with the minimum balance              
            }else if(option == 'S'){

                try{

                    ScotiaBank.getMinimum();
                    System.out.println("\nBank account with the smallest balance:\n" + ScotiaBank.getMinimum());

                }catch(BankException exception){

                    System.out.println(exception);
                }


            // this will be used when user want to exit  
            }else if(option == 'E'){

                done = 1;

                System.out.println("\nThank You");

                // System.out.println(ScotiaBank);


            // this will be used if user enter the value outside the given menu 
            }else{

                System.out.println("\nPlease choose the value from the given menu.");
                
            }


        }

        userInput.close();
        
    }
    
}
