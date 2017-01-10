package Project;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Stack;

import org.junit.*;

public class AcesUpTesting {

	//instantiate a stackarrayList
//	private static	ArrayList<Card> cards;
//	public MockDeck theDeck;
	//public Stack<Card>[]stacks;
	private MockAcesUp acesUp;
	private Stack<Card>[]stacks;
 
	@Before
	public void setUp()throws EmptyException{
		System.out.println("Before");
		acesUp = new MockAcesUp();
		stacks =(Stack<Card>[])new Stack[4];
	}
	
	@Test
	public void ReturnTrueIfStackArrayIsEmpty(){
		stacks[0].isEmpty();
	//acesUp.getStackOfCards().getPostion(0).isEmpty();
	}
	/*
	@Test
	public void ReturnFalseIfNotEmpty() throws EmptyException{
		acesUp.addToStack();
		stacks[0].isEmpty();
	}
	*/
	@Test
	public void discardAndMoveCardToThatPosition() throws EmptyException{
		acesUp.addToStack();
		acesUp.discard(4);
		System.out.println("discarded");
		acesUp.move(1);
		System.out.println("moved");
		//assertEquals(acesUp.getPostion(1),"[]");
		assertNull(acesUp.getPostion(1));
	}
	@Test
	public void discardCard() throws EmptyException{
		acesUp.addToStack();
System.out.println(acesUp.getPostion(1));
System.out.println(acesUp.getPostion(2));
System.out.println(acesUp.getPostion(3));
System.out.println(acesUp.getPostion(4));

		acesUp.discard(4);
	//	acesUp.move(3);
		assertNull(acesUp.getPostion(4));
		}
	
/*
@Test
public void testToDiscardCard() throws EmptyException
{
	AcesUp aces=new AcesUp();
	Stack<Card> stacks=new Stack<Card>();
	
	
	int cardLowerRank=1;// example of stack to remove card
	aces.discard(cardLowerRank);
}
*/
/*
	@Test
	public void MoveOverToLastPostion(){
		Card card1 = new Card(Rank.Three,Suit.HEARTS,Color.RED);
		Card card2 = new Card(Rank.Four,Suit.CLUBS,Color.BLACK);
		Card card3 = new Card(Rank.Five,Suit.SPADES,Color.BLACK);
		Card card4 = new Card(Rank.Six,Suit.HEARTS,Color.RED);
	
	cards.add(0,card1);
	cards.add(1, card2);
	cards.add(2, null);
	cards.add(3, card4);
	
		stacks =(Stack<Card>[])new Stack[4];
//System.out.println("hi");
//System.out.println(stacks[0].peek());
stacks[0].push(card1);
System.out.println(stacks[0].peek());
stacks[1].push(card2);
stacks[3].push(card3);
stacks[4].push(card4);
	
assertTrue(stacks[1].equals(card2));
	//assertTrue(cards.get(2).equals(null));

//aces.move(1);
//assertTrue(cards.get(3).equals(card2));
	}
	
/*
	@Test
	public void testGameWonMethod() throws EmptyException
	{
	    AcesUp aces= new AcesUp();
	    Deck thedeck = new Deck();
	    //Stack<Card>[]stacks = new Stack<Card>[4]();
	boolean game;
	boolean val=true;
	boolean val2=false;   
	game=aces.gameWon();
	if(stacks==null && thedeck.isEmpty())
	    {
	   
	    assertEquals(val,game);
	   
	    }

	    assertEquals(val2,game);

	}
	*/
}
