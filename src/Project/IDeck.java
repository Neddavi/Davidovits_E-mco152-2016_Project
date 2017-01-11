package Project;

public interface IDeck{
	
	public void shuffle();
	public int getSize();
	public Card deal() throws EmptyException;
	public boolean isEmpty();
	}
