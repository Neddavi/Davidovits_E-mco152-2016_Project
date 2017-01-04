package Project;

import java.util.Scanner;
import java.util.Stack;
public class AcesUp{

public static Deck theDeck;
public static Stack<Card>[]stacks;
public static int qtyCards;

public AcesUp()throws EmptyException{
theDeck = new Deck();
theDeck.shuffle();
//array of the 4 cards, put into one stack
stacks =(Stack<Card>[])new Stack[4];
//instantiate a stack for each element of stacks[]
qtyCards = theDeck.getSize();

for(int i = 0;i<stacks.length;i++){
stacks[i] = new Stack<>();
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
public static void discard(int cardLowRank){
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
			stacks[cardLowRank -1].pop();
		//decrement it
			qtyCards--;
			break;
		}//end if
	}//end if
		}
}//end if
	}//end if
		}//end if
}//end for
}

public static void move(int cardToMove){
	for(int i =0;i<stacks.length;i++){
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
	if(stacks == null && theDeck.isEmpty()){
		//the stack and deck are both empty!winner!
		return true;
	}
	else{
		return false;
	}
}
public static void main(String[] args){
	Scanner keyboard = new Scanner(System.in);

try{
	
	AcesUp game = new AcesUp();
	while(!game.gameWon()){
			game.display();
		int choice = getMenu();
	
	switch(choice){
	
	case 1:
		
	System.out.println("indicate the pile with lower rank");
	int cardLowRank = keyboard.nextInt();
	discard(cardLowRank);
		break;

	case 2:
		try{
		for(int i =0;i<stacks.length;i++){
		//deal out 4 cards
		stacks[i].push(theDeck.deal());
		}//end for
		}//end try
		catch(EmptyException e1){
			System.out.println(e1.getMessage());
		}
	break;
	case 3:
		System.out.println("indicate the card to move");
		int cardToMove = keyboard.nextInt();
		move(cardToMove);
		break;
	}//end switch	
	}//end while loop
System.out.println("you have won! congrats:)");
} 
catch (EmptyException e) {	
	System.out.println(e.getMessage());
}//end catch
}//end main
public static int getMenu(){
Scanner keyboard = new Scanner(System.in);
System.out.println("1. If there are 2 cards of same suit showing, "
		+ "discard one with lower rank\n 2. Deal 4 new cards\n "
		+ "3. move a single card to an EMPTY spot");
int choice = keyboard.nextInt();
return choice;
}
}//end class