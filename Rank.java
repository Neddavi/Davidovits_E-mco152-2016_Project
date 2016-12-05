package Project;

public enum Rank 
{
 Ace (1),
 Deuce (2), 
 Three (3), 
 Four (4), 
 Five (5), 
 Six (6), 
 Seven (7), 
 Eight (8), 
 Nine (9),
 Ten (10), 
 Jack (11), 
 Queen (12),
 King (13);
	
private final int cardNumber;

	Rank(int cardNumber)
{
	this.cardNumber= cardNumber;
}
	
	public int getRankValue()
	{
		return cardNumber;
	}
}
