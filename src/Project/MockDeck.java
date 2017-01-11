package Project;

import java.util.ArrayList;
import java.util.Random;

public class MockDeck implements IDeck{

ArrayList<Card>cards;
	public MockDeck() {
		cards = new ArrayList<Card>(51);
	}
	//deep copy constructor
	public MockDeck(MockDeck deck){
		cards = new ArrayList<Card>(deck.getArrayListCards());
	}
	public void addToCards(){
			
		for(int i =0;i< 13;i++){
		cards.add(new Card(Rank.values()[i],Suit.HEARTS,Color.RED));
		cards.add(new Card(Rank.values()[i],Suit.DIAMONDS,Color.RED));
		cards.add(new Card(Rank.values()[i],Suit.SPADES,Color.BLACK));
		cards.add(new Card(Rank.values()[i],Suit.CLUBS,Color.BLACK));
		}
	}
	public void shuffle(){
	Random shuffle = new Random(System.currentTimeMillis());
	for(int i =0;i<cards.size();i++){
	int numGenerated = shuffle.nextInt(51); 

	Card temp = cards.get(i);
	Card t = cards.get(numGenerated);
	cards.set(i,t);

	cards.set(numGenerated,temp);
	}

	}

	public int getSize() {
		return cards.size();
	}
	
	public ArrayList<Card> getArrayListCards(){
		return this.cards;
	}

	public Card getCard(int position){
	return this.cards.get(position);
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
}
