package Project;


import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.*;

public class DeckTesting {

	//private static	ArrayList<Card> cards;
	private static MockDeck theDeck;
	private static MockDeck newDeck;
	@Before
	public void setUp(){
		System.out.println("Before");
		theDeck = new MockDeck();
		newDeck = new MockDeck();
	}
	@Test(expected = EmptyException.class)
	public void DealOnEmptyArrayListThrowsEmptyException() throws EmptyException
	{
		theDeck.deal();
	}
	@Test
	public void ReturnCardWhenDeal() throws EmptyException{
		Card card;
		card =new Card(Rank.Five,Suit.SPADES,Color.BLACK);
		theDeck.addToCards();
		assertEquals(card,theDeck.deal());
	}
	@Test
	public void ReturnTrueIfIsEmpty(){
		System.out.println("Test 2");
			assertTrue(theDeck.isEmpty());
	}	
	@Test
	public void ReturnFalseIfNotEmpty(){
		System.out.println("Test 3");
		theDeck.addToCards();
		assertFalse(theDeck.isEmpty());
	}
	@Test
	public void Return0WhenCallGetSize(){
		assertEquals(0,theDeck.getSize());
	}
	@Test
	public void Return2WhenCallGetSize(){
		theDeck.addToCards();
		assertEquals(2,theDeck.getSize());
	}
	@Test
	public void WillSwitchPlacesAfterShuffle (){
	
	
		newDeck.addToCards();
		theDeck.addToCards();
		System.out.println("new deck " + newDeck.getArrayListCards());
		System.out.println("the deck " + theDeck.getArrayListCards());
		
		assertEquals(theDeck.getArrayListCards(),newDeck.getArrayListCards());
		 /*
		//newDeck.shuffle();
		assertTrue(theDeck.equals(theDeck));
		//assertNotSame(theDeck,newDeck);
		*/
		}
	
	@Test
	public void WillNotSwitchIfNoShuffle(){
		Card notSwitched=new Card(Rank.Three,Suit.HEARTS,Color.RED);
		Card cardSwitched= new Card(Rank.Ten,Suit.HEARTS,Color.RED);
	equals(cardSwitched);
	}
	/*
	@Test
	public void(){
		theDeck.deal();
	}
	*/
}
