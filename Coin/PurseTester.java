/**
  * This class tests the Purse class from the Programming Exercise P7.5
  * Big Java, 4th Edition, Cay Horstmann
  *
*/
public class PurseTester
{
	   /**
	   * Creates a few purses and test the various methods of the class.
	   * All the parameters are 'hardwired' here ... there is no  input from a user.
	   * @param args not used
	   */
	   public static void main(String[] args)
	   {
		      Purse a = new Purse();
		      a.addCoin(new Coin("quarter", 25));
		      a.addCoin(new Coin("Dime", 10));
		      a.addCoin(new Coin("Nickel", 5));
		      a.addCoin(new Coin("penny", 1));     
		      System.out.println("a = " + a);   
		      
		      Purse b = new Purse();    
		      b.addCoin(new Coin("nickel", 5));
		      b.addCoin(new Coin("dime", 10));   
		      b.addCoin(new Coin("dime", 10));      
		      b.addCoin(new Coin("quarter", 25));
		      System.out.println("b = " + b);
		      
		      // at this point we expect a and be to be equal
		      testHasSameCoins(a, b, "a","b", false);
		  
		      Purse c = new Purse();
		      c.addCoin(new Coin("quarter", 25));
		      c.addCoin(new Coin("penny", 1));
		      c.addCoin(new Coin("Nickel", 5));
		      c.addCoin(new Coin("dime", 10));    
		      System.out.println("c = " + c);      
		      
		      Purse d = new Purse();    
		      d.addCoin(new Coin("NICKEL", 5));
		      d.addCoin(new Coin("DIME", 10));   
		      d.addCoin(new Coin("DIME", 10));         
		      d.addCoin(new Coin("QUARTER", 25));       
		      d.addCoin(new Coin("quarter", 25));
		      System.out.println("d = " + d);
		      
		      // c and d are different so we expect as output false
		      testHasSameCoins(c, d, "c", "d", false);
		   
		      
		      // d and d are the same so we expect as output true
		      testHasSameCoins(d, d, "d", "d", true);
		      
		 
		      Purse e = new Purse();
		      System.out.println("e = " + e);
		      
		      // the empty purse and any other purse with coins are different, so expecting false
		      testHasSameCoins(e, d, "e", "d", false);
		      
		      Purse f = null;
		      System.out.println("f = " + f + "\n");

		      // the empty purse and the null reference are not the same
		      System.out.print("Do e and f have the same coins? ");
		      System.out.println(e.hasSameCoins(f) + " and " + "Expected: false \n");


			  Purse g = new Purse();
			  System.out.println("g = " + g + "\n");

		      testHasSameCoins(e, g, "e", "g", false);


			  Purse h = new Purse();
			  h.addCoin(new Coin("NICKEL", 5));
		      h.addCoin(new Coin("DIME", 10));   
		      
			  System.out.println("h = " + h + "\n");
			  System.out.print("Do h and f have the same coins? ");
		      System.out.println(h.hasSameCoins(f) + " and " + "Expected: false \n");

		   
		      // missing ares test for some methods like 
		      //    removeCoin

		      //    getHighestCoinValue
			  System.out.println("\nEquals: " + a.getHighestCoinValue().equals(h.getHighestCoinValue()));
			  System.out.println("\noccurrences: " + b.occurrences(new Coin("dime", 10)));
			  System.out.println("\nremoving: " + b.removeCoin(new Coin("dime", 10)));
			  System.out.println("\nremove: " + b);
			  System.out.println("\nHighnest Value Coin in Purse a is: " + a.getHighestCoinValue());
			  System.out.println("\nHighnest Value Coin in Purse h is: " + h.getHighestCoinValue());
	   }
	   
	   /**
	   * Take two purses and their names and report whether they are the same.
	   * Use the method hasSameCoins when comparing.
	   * @param x purse against which y is compared, x != null
	   * @param y purse against which x is compared, y != null
	   * @param xName name that will be printed for the first parameter
	   * @param yName name that will be printed for the second parameter
	   * @param expectedValue what the result of the comparison should be
	   */
	   public static void testHasSameCoins(Purse x, Purse y, 
	      String xName, String yName, boolean expectedValue)
	   {
		      System.out.println();
		      System.out.print("Do " + xName + " and " + yName + " have the same coins? ");
		      System.out.println(x.hasSameCoins(y) + " and " + y.hasSameCoins(x));
		      System.out.println("Expected: " + expectedValue + " and " + expectedValue + "\n");
	   }
	   
   
}
