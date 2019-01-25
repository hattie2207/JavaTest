import java.util.Scanner;

public class Player {

	Scanner userInput = new Scanner(System.in);
	String direction; 
	float distance; 

	public void play() {

		playerMove();
		magicCompass(direction);

	}

	public void playerMove() {

		if (userInput.hasNext()) {

			if (userInput.hasNextLine()) {
				
				direction = userInput.nextLine();	
				checkInput(direction);
			}
		}		
	}
	
	public void checkInput(String direction) {		
		
		direction = direction.toLowerCase();
		
		switch(direction) {
		
		case "n":
			direction = "north";
			break;
		case "s":
			direction = "south";
			break;
		case "e":
			direction = "east";
			break;
		case "w":
			direction = "west";
			break;
		}
		
		if (direction.equals("north") || direction.equals("south") || direction.equals("east") || direction.equals("west")) {							
			System.out.println("Valid Move");
		}					
		else {
			System.out.println("Invalid input, please try again."); 
			playerMove();
		}
		
	}

	public String magicCompass(String direction) {
		
		

		return "";
	}

}
