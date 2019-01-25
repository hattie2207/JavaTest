import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Player {

	private Scanner userInput = new Scanner(System.in);
	private Scanner levelInput = new Scanner(System.in);
	private String direction, gameLevel; 
	private double distance;
	private int pointX, pointY, randX, randY;
	
	public void play() {

		randomPoint();
		System.out.println("What level of adventure would you like to experience?"
				+ "\nPlease enter \"easy\", \"intermediate\", or \"advance\".");
		getLevel();
		System.out.println("Grey foggy clouds float oppressively close to you,\r\n" + 
				"reflected in the murky grey water which reaches up your shins.\r\n" + 
				"Some black plants barely poke out of the shallow water.\r\n" + 
				"Try \"north\",\"south\",\"east\",or \"west\"\r\n" + 
				"You notice a small watch-like device in your left hand.\r\n" + 
				"It has hands like a watch, but the hands don't seem to tell time.\r\n");	

		totalDistance();
		System.out.print("The dial reads '");
		System.out.printf("%.3f", distance);
		System.out.print("m'\n>");
		playerMove();

	}
	
	private void randomPoint() {

		do {

			randX = ThreadLocalRandom.current().nextInt(-3, 3);
			randY = ThreadLocalRandom.current().nextInt(-3, 3);		

		}while ((randX == 0 || randY == 0));

	}
	
	private void totalDistance() {

		distance = Math.sqrt((Math.pow(randX - pointX, 2)) + (Math.pow(randY - pointY, 2)));		

	}
	
	private void playerMove() {

		if (userInput.hasNextLine()) {

			direction = userInput.nextLine();	
			checkInput(direction);
		}
	}		


	private void checkInput(String direction) {		

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
			magicCompass(direction);			
		}					
		else {
			System.out.println("Invalid move input, please try again.\n>"); 
			playerMove();
		}

	}		
	
	

	
}	


