import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
  Scanner scanner = new Scanner(System.in);
        
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

	}

}
