package aaaProject;

import java.util.Scanner;
import java.io.*;

public class gameMain {

	public static final String displayMenu = ("\nMain Menu" 
	+ "\n1. Rules" 
	+ "\n2. Play Against Computer"
	+ "\n3. Play 2 Player Game" 
	+ "\n4. See High Score" + "\n5. Quit" 
	+ "\nEnter your choice =>");

	private static final Scanner sc = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		AccountManager manager = new AccountManager();
		LogStuff("Game initialized.");
		
		login();
		if (manager.isLoggedIn()) {
			LogStuff("Logged in.");
		}
		loop();
	}

	public static void loop() {	

		System.out.println(displayMenu);
		;
		int selection = sc.nextInt();
		switch (selection) {
		case 1:
			System.out.println("rules\n");
			System.out.println("return to menu?");
			int ch = sc.nextInt();
			if (ch == 1) {
				break;
			}
			return;
		case 2:
			System.out.println("1 player");
			break;
		case 3:
			System.out.println("2player");
			break;
		case 4:
			System.out.println("high score");
			break;
		case 5:
			System.out.println("Exiting game.");
			sc.close();
			return;
		}
		loop();
	}
//	}

	public static void login() {
		AccountManager accountManager = new AccountManager();

		System.out.println("1. Create Account");
		System.out.println("2. Login");
		System.out.println("Enter your choice:");

		int choice = sc.nextInt();
		sc.nextLine();

		switch (choice) {
		case 1:
			System.out.println("Enter username:");
			String newUsername = sc.nextLine();
			System.out.println("Enter password:");
			String newPassword = sc.nextLine();
			accountManager.createUser(newUsername, newPassword);
			break;
		case 2:
			System.out.println("Enter username:");
			String username = sc.nextLine();
			System.out.println("Enter password:");
			String password = sc.nextLine();
			accountManager.loginUser(username, password);
			break;

		default:
			System.out.println("Invalid choice");
			break;
		}
	}

	public static void LogStuff(String data) {
		File log = new File("c:\\temp\\log.txt");

		try (BufferedWriter bw = new BufferedWriter(new FileWriter(log, true))) {
			bw.newLine();
			bw.write(data);
			bw.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}
