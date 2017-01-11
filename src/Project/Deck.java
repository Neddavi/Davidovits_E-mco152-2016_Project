package Project;

import java.util.ArrayList;
import java.util.Random;

public class Deck implements IDeck{
	public ArrayList<Card>cards;
	public Rank rank;
	public Suit suit;
	public Color color;

	public Deck(){
	cards = new ArrayList<Card>(51);
	for(int i =0;i< 13;i++){
	cards.add(new Card(rank.values()[i],suit.HEARTS,color.RED));
	cards.add(new Card(rank.values()[i],suit.DIAMONDS,color.RED));
	cards.add(new Card(rank.values()[i],suit.SPADES,color.BLACK));
	cards.add(new Card(rank.values()[i],suit.CLUBS,color.BLACK));
	}
	}
	public void shuffle(){
	Random shuffle = new Random();
	
	for(int i =0;i<cards.size();i++){
	int numGenerated = shuffle.nextInt(51); 
    //holding data at current position
	Card temp = cards.get(i);
	//putting the randomNum into index
	Card t = cards.get(numGenerated);
	cards.set(i,t);
	//putting index card into the random
	cards.set(numGenerated,temp);
	}
	}
	public Card deal()throws EmptyException{
				if(!isEmpty()){
			return cards.remove(cards.size()-1);		
		}
	else{
	throw new EmptyException();
		}	
	}
	public boolean isEmpty(){
	if(cards.size() == 0)
	return true;
	//otherwise
	return false;
	}
	public int getSize(){
		return cards.size();
	}
}