public class BankException extends RuntimeException
{
	public BankException(){ }


	/**
	 * this method will be used to get error from the Bank class and show that error to the user
	 * @param message this is the message send by the Bank class for the error
	 */
	public BankException(String message){
		super(message);
	}
}