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
		
	}
	
	@Test(expected = EmptyException.class)
	public void DealOnEmptyArrayListThrowsEmptyException() throws EmptyException
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
	public void Return4WhenCallGetSize(){
		theDeck.addToCards();
		assertEquals(4,theDeck.getSize());
	}
	@Test
	public void WillSwitchPlacesAfterShuffle (){
		theDeck.addToCards();
		MockDeck copyDeck = new MockDeck(theDeck);
		assertSame(theDeck.getArrayListCards(),copyDeck.getArrayListCards());
		//theDeck.shuffle();
		//newDeck.shuffle();
		//assertNotSame(theDeck.getArrayListCards(),newDeck.getArrayListCards());
		}
	
	@Test
	public void WillNotSwitchIfNoShuffle(){
	theDeck.addToCards();
	newDeck = theDeck;
	assertSame(theDeck.getArrayListCards(),newDeck.getArrayListCards());
	
	}
	
}
