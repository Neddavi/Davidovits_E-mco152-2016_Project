package Project;

public class Card 
{
	private Rank rank;
	private Color color;
	private Suit suit;

public Card(Rank rank, Suit suit, Color color)
{
	this.rank= rank;
	this.color=color;
	this.suit=suit;
}

public Rank getRank()
{
	return rank;
}

public Color getColor()
{
	return color;
}

public Suit getSuit()
{
	return suit;
}

public String toString()
{
	StringBuilder string = new StringBuilder();
	
	string.append("Card " + rank +" "+ suit );
	
	return string.toString();
}
}

