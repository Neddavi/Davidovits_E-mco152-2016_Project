package Project;

import java.util.ArrayList;
import java.util.Random;

public class MockDeck implements IDeck{

ArrayList<Card>cards;
	public MockDeck() {
	//instantiate an empty deck of cards
		cards = new ArrayList<Card>();
	}
	public void addToCards(){
		//adding a random card, just for testing
		cards.add(new Card(Rank.Three,Suit.HEARTS,Color.RED));
		cards.add(new Card(Rank.Five,Suit.SPADES,Color.BLACK));
	}
	public void shuffle(){
		//invoking the random class
	Random shuffle = new Random();
	//holding the number that was just generated
	for(int i =0;i<cards.size();i++){
		//it will only generate 2 numbers, mini of the real shuffle method
	int numGenerated = shuffle.nextInt(2); 
    //holding data at current position
	Card temp = cards.get(i);
	//putting the randomNum into index
	Card t = cards.get(numGenerated);
	cards.set(i,t);
	//putting index card into the random
	//doing a switch
	cards.set(numGenerated,temp);
	}
	}
	public int getSize() {
		return cards.size();
	}
	public ArrayList<Card> getArrayListCards(){
		return this.cards;
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
public static void main(String[]args){
	MockDeck mock = new MockDeck();
	System.out.println(mock.getSize());
}
}
