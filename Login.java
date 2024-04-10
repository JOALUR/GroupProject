import java.io.*;
import java.util.*;

class User {
    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}

class AccountManager {
    private List<User> users;
    private final String login_data = "users.txt";

    public AccountManager() {
        this.users = new ArrayList<>();
        loadLoginData();
    }

    private void loadLoginData() {
        try (BufferedReader br = new BufferedReader(new FileReader(login_data))) {
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

    private void saveLoginData(User user) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(login_data, true))) {
            bw.write(user.getUsername() + "," + user.getPassword());
            bw.newLine();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public boolean createUser(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                System.out.println("Username already exists.");
                return false;
            }
        }
        User newLogin = new User(username, password);
        users.add(newLogin);
        saveLoginData(newLogin);
        System.out.println("Account created successfully!");
        return true;
    }

    public boolean loginUser(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                System.out.println("Login successful!");
                return true;
            }
        }
        System.out.println("Invalid username or password!");
        return false;
    }
}
