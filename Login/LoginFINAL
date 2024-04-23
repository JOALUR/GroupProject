import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AccountManager {
	 private List<User> users;
	 //file path for storing user login
	 private final String loginDataFile = "C:\\temp\\users.txt";
	 //file path for storing log messages
	 private final String logFile = "C:\\temp\\log.txt";
	 private boolean isLoggedIn = false;
	
    public static void main(String[] args){

    	AccountManager accountManager = new AccountManager();
    	accountManager.Login();
    	
    }
   

    public void Login() {
		
    	Scanner scannerObj = new Scanner(System.in);
    	log("Application started"); 
    	
    	//welcome user and ask them to either login or register
		System.out.println("Welcome");
		System.out.println("1. Login");
		System.out.println("2. Register");
		System.out.print("Choose an option: ");
		int option = scannerObj.nextInt();
		scannerObj.nextLine();
	
		if(option == 1)
		{
			login(scannerObj);
		}
		else if(option == 2)
		{
			register(scannerObj);
		}
		else 
		{
			System.out.println("Invalid option!");
		}
		
		scannerObj.close();

		
	}
    
    private void register(Scanner scannerObj)
    {
    	//user registration
    	System.out.println("Enter username: ");
		String username = scannerObj.nextLine();
		System.out.println("Enter password: ");
		String password = scannerObj.nextLine();
		if(createUser(username, password))
		{
			System.out.println("Registration Complete!");
			//log message for successful registration
			log("User reigistered: " + username);
		}
		else
		{
			System.out.println("Registration failed");
			//log message for failed registration
			log("Failed to register user: " + username);
		}
    	
    }
    
    private void login(Scanner scannerObj)
    {
    	//user login
    	System.out.println("Enter username: ");
		String username = scannerObj.nextLine();
		System.out.println("Enter password: ");
		String password = scannerObj.nextLine();
		if(loginUser(username, password))
		{
			System.out.println("Login Completed!");
			//log message for successful login
			log("User logged in: " + username);
		}
		else
		{
			System.out.println("Login Failed...");
			//log message for failed login
			log("Failed login attempt: " + username);
		}
    }


    public AccountManager() {
        this.users = new ArrayList<>();
        //load user login data
        loadLoginData();
    }

    public boolean createUser(String username, String password) {
    	//creating user
        try {
            User newUser = new User(username, password);
            //save new user data to file
            saveLoginData(newUser);
            users.add(newUser);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean loginUser(String username, String password) {
    	//authenticate user log in
        for(User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                System.out.println("Login successful!");
                isLoggedIn = true;
                return true;
            }
        }
        System.out.println("Invalid username or password");
        return false;
    }

    public boolean isLoggedIn() {
        return isLoggedIn;
    }

    private void loadLoginData() {
    	//loading login data
        try (BufferedReader br = new BufferedReader(new FileReader(loginDataFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                String username = parts[0];
                String password = parts[1];
                users.add(new User(username, password));
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void saveLoginData(User user) throws IOException {
    	//save user login data
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(loginDataFile, true))) {
            bw.write(user.getUsername() + "," + user.getPassword());
            bw.newLine();
        }
    }
    private void log(String message)
    {
    	//log method should write log messages to file named log.txt
    	try(BufferedWriter bw = new BufferedWriter(new FileWriter(logFile, true)))
    	{
    		bw.write(message);
    		bw.newLine();
    	} catch(IOException ex) {
    		ex.printStackTrace();
    	}
    }
}

