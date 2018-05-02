import java.math.BigDecimal;

/*
 * Coin
 * 
 * Purpose: The Coin class is able to create Coin objects. Coin objects have a name, value, and count. A coins name and
 * value are set upon creation, however the count field is set via setCount().
 * 
 * Created by: Alexander Sears
 * Created on: 05/01/2018
 */

public class Coin {
	
	// initialize coin fields
	private String coinName = "";
	private int coinCount = 0;
	private BigDecimal coinValue = new BigDecimal("0.00");
	
	// coin constructor
	public Coin(String name, BigDecimal value){
		this.coinName = name;
		this.coinValue = value;
	}
	
	// get the count field of a coin
	public int getCount(){
		return this.coinCount;
	}
	
	// set the count field of a coin
	public void setCount(int count){
		this.coinCount = count;
	}
	
	// get the name of a coin
	public String getName(){
		return this.coinName;
	}
	
	// get the value of a coin
	public BigDecimal getValue(){
		return this.coinValue;
	}
	
}
