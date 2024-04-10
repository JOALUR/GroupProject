import java.util.Scanner;
import java.io.*;

public class gameMain {

	public static void main(String[] args) throws IOException {
  Scanner scanner = new Scanner(System.in);
  AccountManager accountManager = new AccountManager();
  LogStuff("Game initialized.");
 
  login();
  if(accountManager.isLoggedIn()) {
	  System.out.println("11");
  }

  int SelectedMenuOpt;
  while (true) {
	  // after login shit just stops working idk how to fix it -eric
        if(accountManager.isLoggedIn()) {
            displayMenu();
            
                SelectedMenuOpt = scanner.nextInt(); 
                
            switch (SelectedMenuOpt) {
                case 1:
                	System.out.println("rules\n");
                 //   displayRules();
                	break;
                case 2:
                	System.out.println("1 player");
                 //   playAgainstComputer();
                    break;
                case 3:
                	System.out.println("2player");
                   // playTwoPlayerGame();
                    break;
                case 4:
                	System.out.println("high score");
                  //  seeHighScore();
                    break;
                case 5:
                    System.out.println("Exiting game.");
                    break;
                default:
                    System.out.println("Please enter a number between 1 and 5.");
            }
        }
  
        scanner.close();
  }	
 }

public static void displayMenu(){
	System.out.println("Main Menu");
	System.out.println("1. Rules");
	System.out.println("2. Play Against Computer");
	System.out.println("3. Play 2 Player Game");
	System.out.println("4. See High Score");
	System.out.println("5. Quit");
	System.out.print("Enter your choice: ");

	}

public static void login() {
    Scanner scanner = new Scanner(System.in);
    AccountManager accountManager = new AccountManager();

    System.out.println("1. Create Account");
    System.out.println("2. Login");
    System.out.println("Enter your choice:");

    int choice = scanner.nextInt();
    scanner.nextLine();

    switch (choice) {
        case 1:
            System.out.println("Enter username:");
            String newUsername = scanner.nextLine();
            System.out.println("Enter password:");
            String newPassword = scanner.nextLine();
            accountManager.createUser(newUsername, newPassword);
            break;
        case 2:
            System.out.println("Enter username:");
            String username = scanner.nextLine();
            System.out.println("Enter password:");
            String password = scanner.nextLine();
            accountManager.loginUser(username, password);
            scanner.close();
            return;
            
        default:
            System.out.println("Invalid choice");
            break;
    }
    scanner.close();
}

public static void LogStuff(String data) {
	File log = new File("c:\\temp\\log.txt");
	
	try (BufferedWriter bw = new BufferedWriter(new FileWriter(log, true))) {	
		bw.write(data);
        bw.newLine();  
		bw.close();
	}
 	catch(IOException ex){
 	   ex.printStackTrace();
	}
    }
}
