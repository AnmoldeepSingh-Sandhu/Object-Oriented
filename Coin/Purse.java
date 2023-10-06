import java.util.ArrayList;
// import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
* A purse holds a collection of coins.CPSC 1181 Lab III from  Programming Exercise P7.5  Big Java, 4th Edition, Cay Horstmann
*
*/
public class Purse
{
    	private ArrayList<Coin> listOfCoins;

	   /**
	   * Constructs an empty purse.
	   */

	   public Purse(){

		listOfCoins = new ArrayList<Coin>();

		

	   }
   
   

	   /**
	   * Adds a coin to the purse regardless of whether the <code>coin</code> was in the 
	   * purse  already or not
	   * @param coin the coin to add 
	   */

	   public void addCoin(Coin coin){

		   listOfCoins.add(coin);
		   
	   }
   
   
   
   
	   /**
	   * Removes a coin from the purse that is the same (denomination) as <code>coin</code>
	   * i.e. it removes a coin from the pruse that is  <code>equal</code> to <code>coin</code>.
	   * <p>
	   * precondition: <code>equals</code> has been define for <code>coin</code>
	   * @param coin a coin that matches the one that should be removed from purse
	   * @return true if the matching coin was removed from the purse, false otherwise
	   */

	   	public boolean removeCoin(Coin coin){

			// Create a list to store the indices of coins to remove
			ArrayList<Integer> indicesToRemove = new ArrayList<>();

			boolean remove= false;

			for(int i = 0; i< listOfCoins.size(); i++){

				Coin same = listOfCoins.get(i);

				if((coin.getValue() == same.getValue()) && (coin.getName() == same.getName())){

					// Add the index of the coin to remove to the list
            		indicesToRemove.add(i);
					remove = true;

				}

			}

			// Remove coins from the list in reverse order to avoid shifting indices
			for (int i = indicesToRemove.size() - 1; i >= 0; i--) {
				int indexToRemove = indicesToRemove.get(i);
				listOfCoins.remove(indexToRemove);
			}

			return remove;
	   	}
   
   
   

	   /**
	   * Gives a text representation of the purse.
	   * @return a string in the format "Purse[coin1,coin2,...]"
	   */
	   public String toString()
	   {
	      
	      return "Purse" + listOfCoins.toString();      
		    
	   }
   
	   /**
	   * Counts the number of occurrences of <code>coin</code> in this purse.
	   * <p>
	   * IMPLEMENTATION detail for the lab: 
	   * in order for two coins to be considered equal, their value and their name
	   * must match  but there is a method <code>equals</code> defined inside
	   * of the <code>Coin</code> class already
	   * @param coin the item to match against
	   * @return count the number of times the coin is in purse
	   */

	   public int occurrences(Coin coin){

			int count = 0;

			for(int i = 0; i< listOfCoins.size(); i++){

				Coin same = listOfCoins.get(i);

				if((coin.getValue() == same.getValue()) && (coin.getName() == same.getName())){

					count++;

				}

			}

		
			return count;

		}
  
   
   
   
   
   
   

	   /**
	   * Determines if a purse has the same coins as the <code>otherPurse</code>,
	   * (regardless of order and possible duplicates).
	   * <p>
	   * IMPLEMENTATION detail for the lab: you must use the method <code>this.occurrences</code>
	   * when implementing <code>hasSameCoins</code>
	   * @param otherPurse the other purse with coins
	   * @return true if this and the otherPurse have the same coins, false otherwise
	   */
   
	   public boolean hasSameCoins(Purse otherPurse){


			// int i=0;
			// int count = 0;

			if(otherPurse == null || listOfCoins == null){

				return false;

			}else if(listOfCoins.size() != otherPurse.listOfCoins.size()){
				return false;

			}else{

				// while(i< listOfCoins.size() && i< otherPurse.listOfCoins.size()){

				// 	if(otherPurse.listOfCoins.contains(listOfCoins.get(i))){
						
				// 		count += 1;
				// 	}
				// 	i++;
				// }

				// if(count == listOfCoins.size()){

				// 	return true;

				// }else{
				// 	return false;
				// }

				// Create HashMaps to store coin type and quantity
				Map<String, Integer> thisCoinCount = new HashMap<>();
				Map<String, Integer> otherCoinCount = new HashMap<>();

				// Count coins in this purse
				for (Coin coin : listOfCoins) {
					thisCoinCount.put(coin.getName(), thisCoinCount.getOrDefault(coin.getName(), 0) + 1);
				}

				// Count coins in the other purse
				for (Coin coin : otherPurse.listOfCoins) {
					otherCoinCount.put(coin.getName(), otherCoinCount.getOrDefault(coin.getName(), 0) + 1);
				}

				// Compare coin counts
				return thisCoinCount.equals(otherCoinCount);

				
			}

	   }
   
   
   


  
  
   
	    /**
	   * Gives the highest monetary value of any coin in the purse.
	   * @return the highest coin value of any coin in the purse and 0 if the purse is empty.
	   */ 
	   
	   public Coin getHighestCoinValue(){

			Coin largest = listOfCoins.get(0);

			for(int i = 1; i< listOfCoins.size(); i++){

				Coin coin = listOfCoins.get(i);

				if(coin.getValue() > largest.getValue()){

					largest = coin;

				}

			}
			
			return largest;
	   }
     
	  
}
