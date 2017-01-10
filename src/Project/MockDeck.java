package Project;

import java.util.ArrayList;
import java.util.Random;

public class MockDeck implements IDeck{

ArrayList<Card>cards;
	public MockDeck() {
	//instantiate an empty deck of cards
		cards = new ArrayList<Card>();
	}
	public MockDeck(MockDeck deck){
		//this.cards = new ArrayList<Card>();
//		this();
		//this.cards = new ArrayList<Card>(deck.getArrayListCards());
		//this.cards = new ArrayList<Card>(deck.getSize());
		//for(int i =0;i<cards.size();i++){
			//cards.add(deck.getCard(i));
		//}
		cards = new ArrayList<Card>(deck.getArrayListCards());
	}
	public void addToCards(){
		//adding a random card, just for testing
		cards.add(new Card(Rank.Three,Suit.HEARTS,Color.RED));
		cards.add(new Card(Rank.Five,Suit.SPADES,Color.BLACK));
		cards.add(new Card(Rank.Six,Suit.DIAMONDS,Color.RED));
		cards.add(new Card(Rank.Eight,Suit.HEARTS,Color.RED));
	}
	public void shuffle(){
	Random shuffle = new Random(System.currentTimeMillis());
	for(int i =0;i<cards.size();i++){
		//it will only generate 4 numbers, mini of the real shuffle method
	int numGenerated = shuffle.nextInt(3); 

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
