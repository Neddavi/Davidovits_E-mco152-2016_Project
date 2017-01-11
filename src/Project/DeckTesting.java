package Project;

import static org.junit.Assert.*;
import org.junit.*;

public class DeckTesting {

	private static MockDeck theDeck;
	private MockDeck copyDeck;
	@Before
	public void setUp(){
		System.out.println("Before");
		theDeck = new MockDeck();	
	}
	
	@Test(expected = EmptyException.class)
	public void DealOnEmptyDeckOfCardsThrowsEmptyException() throws EmptyException
	{
		theDeck.deal();
	}
	@Test
	public void ReturnTopCardWhenDeal() throws EmptyException{
		theDeck.addToCards();
		assertEquals(theDeck.getCard(theDeck.getSize()-1),theDeck.deal());
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
	public void Return0WhenCallGetSizeOnEmptyArray(){
		assertEquals(0,theDeck.getSize());
	}
	@Test
	public void Return52WhenCallGetSize(){
		theDeck.addToCards();
		assertEquals(52,theDeck.getSize());
	}
	@Test
	public void WillSwitchPlacesAfterShuffle (){
		theDeck.addToCards();
		 copyDeck = new MockDeck(theDeck);
		//first ensure that the decks equal eachother before the shuffle
		assertEquals(theDeck.getArrayListCards(),copyDeck.getArrayListCards());
		theDeck.shuffle();
		assertNotEquals(theDeck.getArrayListCards(),copyDeck.getArrayListCards());
		}
	
	@Test
	public void WillNotSwitchIfNoShuffle(){
	theDeck.addToCards();
	copyDeck = new MockDeck(theDeck);
	assertEquals(theDeck.getArrayListCards(),copyDeck.getArrayListCards());
	
	}
	
}
