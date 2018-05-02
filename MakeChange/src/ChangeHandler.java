import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Comparator;


/*
 * 
 * ChangeHandler
 * 
 * Purpose: A simple utility class that is able to take in any amount of change (and possibly a list of user-generated coins)
 * and return the smallest amount of coins that make up the given amount. 
 * 
 * Created by: Alexander Sears
 * Creation Date: 05/01/2018
 * 
 */


public final class ChangeHandler {
	
	// store the coins we will use in this coinArray array-list
	private static ArrayList<Coin> coinArray = new ArrayList<Coin>();
	
	/*
	 * makeChange(change) takes in a change amount and prints out how many coins will be needed to create that change amount.
	 * The coins used to make the change within this method are the Quarter, Dime, Nickel and Penny.
	 */
	public static void makeChange(BigDecimal change){
		BigDecimal remainingChange = change;

		// add the basic coins that we will use
		if(coinArray.size() == 0){
			coinArray.add(new Coin("Quarters", new BigDecimal("0.25")));
			coinArray.add(new Coin("Dimes", new BigDecimal("0.10")));
			coinArray.add(new Coin("Nickels", new BigDecimal("0.05")));
			coinArray.add(new Coin("Pennies", new BigDecimal("0.01")));
		}
		
		
		// display the amount of change we are calculating coins for
		System.out.println("-------------------------------------");
		System.out.println("Making change for given amount: "+change.toString()+" (using standard coins)");
		System.out.println("-------------------------------------");
		
		// loop through our coin array and find out how many of each coin should be used to make change
		// we start with the highest value coins first (quarters) and descend down until pennies
		for(int i=0; i<coinArray.size(); i++){
			// grab the coin
			Coin currentCoin = coinArray.get(i);
			// find out how many of this coin type we will need
			BigDecimal currentCoinCount = remainingChange.divide(currentCoin.getValue(), RoundingMode.HALF_UP);
			// set the count field of the coin to the needed amount
			currentCoin.setCount(currentCoinCount.intValue());
			// if the change amount given is evenly divisible by this coin, we are done
			if(remainingChange.remainder(currentCoin.getValue()).compareTo(BigDecimal.ZERO) == 0 ){
				// the remaining change amount is evenly divisible by the current coin, so we are finished
				// display the coins we used, and return out
				displayCoinArrayInfo();
				return;
			// else we need coins of smaller value, so we will do this all again with the next coin
			}else{
				// our remaining change is now whatever is left over after the previous coin calculations
				remainingChange = remainingChange.remainder(currentCoin.getValue());
			}
		}
		// if we get through all the coins without returning out, we need to see a display of what coin we used still
		displayCoinArrayInfo();
		
	}
	
	/*
	 * makeChange(change, extraCoins) takes in a change amount AND an array of extraCoins (user-created coin-objects) then
	 * displays how many coins are needed to produce the given change amount. The coins used are the standard Quarter,
	 * Dime, Nickel, Penny, AND all of the the user-generated coins (which can be of any value).
	 */
	public static void makeChange(BigDecimal change, ArrayList<Coin> extraCoins){
		BigDecimal remainingChange = change;

		if(coinArray.size() == 0){
			coinArray.add(new Coin("Quarters", new BigDecimal("0.25")));
			coinArray.add(new Coin("Dimes", new BigDecimal("0.10")));
			coinArray.add(new Coin("Nickels", new BigDecimal("0.05")));
			coinArray.add(new Coin("Pennies", new BigDecimal("0.01")));
		}
		// here we are adding the user-generated coins to our coin array
		for(Coin extraCoin:extraCoins){
			coinArray.add(extraCoin);
		}
		// because the user-given coins can be any amount, we need to manually sort our coin array in descending order
		// that way we use the biggest coin values first (resulting in the fewest coins used)
		coinArray.sort(Comparator.comparing(Coin::getValue).reversed());
		
		System.out.println("-------------------------------------");
		System.out.println("Making change for given amount: "+change.toString()+" (using extra coins)");
		System.out.println("-------------------------------------");
		
		for(int i=0; i<coinArray.size(); i++){
			Coin currentCoin = coinArray.get(i);
			BigDecimal currentCoinCount = remainingChange.divide(currentCoin.getValue(), RoundingMode.HALF_UP);
			currentCoin.setCount(currentCoinCount.intValue());
			if(remainingChange.remainder(currentCoin.getValue()).compareTo(BigDecimal.ZERO) == 0 ){
				// evenly divisible, we are done
				displayCoinArrayInfo();
				return;
			}else{
				remainingChange = remainingChange.remainder(currentCoin.getValue());
			}
		}
		displayCoinArrayInfo();
		
	}
	
	
	/*
	 * displayCoinArrayInfo() loops through the coin array and prints out how many of each coin we used
	 * as well as the total amount of all coins used to makeChange for the given change amount
	 */
	public static void displayCoinArrayInfo(){
	
		int sum = 0;
		for(Coin coin:coinArray){
			System.out.println(coin.getName()+": "+coin.getCount());
			sum += coin.getCount();
		}
		System.out.println("-------------------------------------");
		System.out.println("Total Coins used: "+sum);
		System.out.println("-------------------------------------");
	}
	
}
