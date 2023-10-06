public class BankAccountException extends RuntimeException
{
	public BankAccountException(){}

	/**
	 * this method will be used to get error from the BankAccount class and show that error to the user
	 * @param message this is the message send by the BankAccount class for the error
	 */
	public BankAccountException(String message){
		super(message);
	}
}