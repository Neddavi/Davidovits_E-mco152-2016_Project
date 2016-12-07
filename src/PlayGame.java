import java.util.Scanner;

public class PlayGame {

	public static void main(String[]args){		
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("stack 1\t\tstack2\t\tstack3\t\tstack4\t\t\n");
		System.out.println("cards left: ");
			//hardcoding it, but will really call a method to figure out total amount of cards left.
int qtyCards =52;
			//display qty of the cards
			System.out.println(qtyCards);	
		
			int choice = getMenu();
				switch(choice){
			case 1:			
				System.out.println("Indicate which piles to discard top card 1,2,3,4");
				int locationCard1 = keyboard.nextInt();
				int locationCard2 = keyboard.nextInt();
				break;

			case 2:
			System.out.println("indicate the pile with lower rank");
			int cardLowRank = keyboard.nextInt();
			break;
			case 3:
		//call a method to deal out cards
			break;
			}//end switch	
			System.out.println("you have won! congrats:)");
		}//end main 

		public static int getMenu(){
		Scanner keyboard = new Scanner(System.in);
		System.out.println("1. If there are 2 cards with the same rank showing, "
				+ "discard both\n 2. If there are 2 cards of same suit shouing, "
				+ "discard one with lower rank\n 3. Deal 4 new cards");
		int choice = keyboard.nextInt();
		return choice;
		}
		
	}//end class

