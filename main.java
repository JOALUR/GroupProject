import java.util.Scanner;
import java.io.*;

public class main {

	public static void main(String[] args) throws IOException {
  Scanner scanner = new Scanner(System.in);

	fileWriter.write("My new data!!");
        int SelectedMenuOpt;
        do {
            DisplayMenu();
            SelectedMenuOpt = scanner.nextInt();
            
            switch (SelectedMenuOpt) {
                case 1:
                    displayRules();
                    break;
                case 2:
                    playAgainstComputer();
                    break;
                case 3:
                    playTwoPlayerGame();
                    break;
                case 4:
                    seeHighScore();
                    break;
                case 5:
                    System.out.println("Exiting game.");
                    break;
                default:
                    System.out.println("Please enter a number between 1 and 5.");
            }
        } while (SelectedMenuOpt != 5);
        
        scanner.close();
    }
public static void displayMenu(){
	    System.out.println("Welcome to the Game Menu");
            System.out.println("1. Rules");
            System.out.println("2. Play Against Computer");
            System.out.println("3. Play 2 Player Game");
            System.out.println("4. See High Score");
            System.out.println("5. Quit");
            System.out.print("Enter your choice: ");

	}
public static void Logger(String data) {
	
	try {
	File inputfile = new File("c:\\temp\\log.txt");
	FileWriter fileWriter = new FileWriter(inputfile, true);
	fileWriter.write("Game initialized.");

          fileWriter.close();
	}
		catch(Exception ex){
			
		}
	
	}
}
