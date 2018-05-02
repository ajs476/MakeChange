import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

public class Main {
	
	/*
	 * Main driver class for ChangeHandler
	 * 
	 * Purpose: Uses the makeChange() function of the ChangeHandler class
	 * 
	 * Created by: Alexander Sears
	 * Created on: 05/01/2018
	 */

	public static void main(String[] args) {
		
		// call makeChange with the standard coins (quarter, dime, nickel, penny)
		ChangeHandler.makeChange(new BigDecimal("4.50").setScale(2, RoundingMode.HALF_UP));
		
		// create some made-up coins to use in makeChange
		ArrayList<Coin> extraCoins = new ArrayList<Coin>();
		extraCoins.add(new Coin("Septims", new BigDecimal("55.00")));
		extraCoins.add(new Coin("BottleCaps", new BigDecimal("0.40")));
		extraCoins.add(new Coin("Rupees", new BigDecimal("0.17")));
		extraCoins.add(new Coin("SchruteBucks", new BigDecimal("0.06")));
		extraCoins.add(new Coin("Gil", new BigDecimal("0.02")));
		
		// call makeChange with 'extra' coins created by user (any name, any value)
		ChangeHandler.makeChange(new BigDecimal("4.50").setScale(2, RoundingMode.HALF_UP), extraCoins);
		
		
		
	}

}
