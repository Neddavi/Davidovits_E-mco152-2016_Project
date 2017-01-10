package Project;

import java.util.Stack;

public class MockAcesUp implements IAcesUp {

	private MockDeck theDeck;
	private Stack<Card>[]stacks;
	private int qtyCards;
	public MockAcesUp(){
		theDeck = new MockDeck();
		theDeck.addToCards();
		//theDeck.shuffle();
		//array of the 4 cards, put into one stack
		stacks =(Stack<Card>[])new Stack[4];
		
		//instantiate a stack for each element of stacks[]
		
		qtyCards = theDeck.getSize();
		}
	
	  public boolean isEmpty(){
   	   if (stacks.length == 0)
   		   return true;
   	   else return false;
   	   
      }
      
	  public Stack<Card>[] getStackOfCards(){
		  return stacks;
	  }
	public void addToStack() throws EmptyException{
		/*
		stacks[0] = new Stack<Card>();
		stacks[0].push(theDeck.deal());
		stacks[1] = new Stack<Card>();
		stacks[1].push(theDeck.deal());
		stacks[2] = new Stack<Card>();
		stacks[2].push(theDeck.deal());		
		stacks[3] = new Stack<Card>();
		stacks[3].push(theDeck.deal());
		*/
		for(int i = 0;i<stacks.length;i++){
		stacks[i] = new Stack<Card>();
		//deal out 4 cards
		stacks[i].push(theDeck.deal());
		}

	}
		public void display(){
			System.out.println("stack 1\t\tstack2\t\tstack3\t\tstack4\t\tCards left");
			for(int i = 0;i<stacks.length;i++){
				
		if(!(stacks[i].isEmpty())){					
		System.out.print(stacks[i].peek().getRank()
				+ " " + stacks[i].peek().getSuit() + " \t ");				     
		}//end if
		else{
			System.out.print("-\t\t");
		}
			}//end for
		System.out.println(qtyCards);
		}
		public void discard(int cardLowRank){
		//making sure user entered right stack number
			if(!(cardLowRank > 4 || cardLowRank < 1 || 
					stacks[cardLowRank -1].isEmpty())){
				//making sure user didnt enter an ace to discard
				if(!(stacks[cardLowRank- 1].peek().getRank().getRankValue() == 1)){
			for(int i =0;i<stacks.length;i++){

				//checking if user entered incorrrect data, or tried to cheat, 
			//if he cheated, will just reprint the menu.
				if(!(stacks[i]).isEmpty()){
			//make sure that it doesn't pull the same one as the data he sent in
					if(!(stacks[cardLowRank -1].equals(stacks[i]))){
				
				//make sure that the suits match
						if(stacks[cardLowRank -1].peek().getSuit()
								.equals(stacks[i].peek().getSuit())) {
			//found that it matches suits, 
					//now find the one with the lower rank
							if(stacks[cardLowRank -1].peek().getRank().getRankValue() < 
					stacks[i].peek().getRank().getRankValue()){
				//found the lower one so pop it off
					//System.out.println(stacks[cardLowRank -1].peek());
								stacks[cardLowRank -1].pop();
					
				//decrement it
					qtyCards--;
					break;
				}//end if
			}//end if
				}
		}//end if
			}//end for
				}//end if
		}//end if
		}

		public void move(int cardToMove){
			for(int i = 0;i<stacks.length;i++){
				if(stacks[i].isEmpty()){
					Card tempCard;
					tempCard = stacks[cardToMove -1].peek();
					stacks[cardToMove -1].pop();
					stacks[i].push(tempCard);
					//using the break, to get out of the loop, otherwise will cont to loop
				break;
				}
				}
		}
		public boolean gameWon(){
			if(qtyCards == 0){
				return true;
			}
			else{
				return false;
			}
		}
	public int getQtyCards(){
		return qtyCards;
	}
	public Card getPostion(int positionNum){
		return stacks[positionNum-1].peek();
	}
}

