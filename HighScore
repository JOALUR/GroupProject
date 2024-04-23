import java.util.Arrays;
import java.io.*;
import java.util.Scanner;

public class Highscore {

	//max number of high scores displayed
	private static final int Max_High_Scores = 5;
	
	//high scores in an array, can put users high scores in here
	private static int[] highscores;
	
	//file path for storing highscores to highscores.txt
	private static final String highscoreFile = "highscores.txt"; 
	
	public static void main(String[] args) {
		
		/*
		 * The way I made this code was to ask the user to enter their highscores
		 * have't figured out how we'll transfer the users scores from hangman score
		 * or how we'll score it but we'll use this as a baseline to get highscores 
		 * in the display box. I tested it out and the highscores save even if we run 
		 * the code again. Therefor it should also be saving to the highscores.txt file.
		 * I put in a bunch of sample highscores to test it out.
		 */
		
		//load high scores from file
		LoadHighScores();
		//display highscores box
		DisplayBoxWithHighScores();
		
		Scanner scannerObj = new Scanner(System.in);
		System.out.print("Enter your score: ");
		int userScore = scannerObj.nextInt();
		//update high score with users scores
		UpdateHighScores(userScore);
		//display updated scores
		DisplayHighScore(1);
		
		scannerObj.close();
		
	}	
	//display box of asterisks with highscores
	private static void DisplayBoxWithHighScores()
	{
		//code for displayed highscore in box of asteriks, tried messing around with it and making it bigger or smaller
		//depending on how the score is finished we would need to adjust it but this should be good for now and with t
		//he sample high scores
	
		int width = 25;
		int height = 8;
		
		System.out.println(repeat('*', width));
		for(int i = 1; i < height; i++)
		{
			if(i == height/2)
			{
				//display highscores in middle of box
				int start = (width - 13) /2;
				DisplayHighScore(start);
			}
			else
			{
				System.out.println('*' + repeat(' ', width - 2) + '*');
			}
		}
		System.out.println(repeat('*', width));
		
	}
	
	//display highscores in box of asterisks
	private static void DisplayHighScore(int start) {
	    int end = start + 12;
	    String HighScoreTitle = " High Scores:  ";
	    StringBuilder line = new StringBuilder("*");
	    for (int i = 1; i < start; i++) {
	        line.append(' ');
	    }
	    line.append(HighScoreTitle);
	    for (int i = end + 1; i < 22; i++) {
	        line.append(' ');
	    }
	    line.append('*');
	    System.out.println(line);

	    for (int i = 0; i < Math.min(highscores.length, Max_High_Scores); i++) {
	        line = new StringBuilder("*");
	        for (int j = 1; j < start; j++) {
	            line.append(' ');
	        }
	        line.append((i + 1) + ".  " + highscores[i]);
	        int ScoreLength = String.valueOf(highscores[i]).length() + -2;
	        int RemainingSpaces = end - (start + ScoreLength);
	        // Adjusted loop iteration
	        for (int j = 0; j < RemainingSpaces; j++) { 
	            line.append(' ');
	        }
	        line.append('*');
	        System.out.println(line);
	    }
	}

		
	
	//repeat a character a specific number of times
	private static String repeat(char ch, int count)
	{
		char[] buf = new char[count];
		Arrays.fill(buf, ch);
		return new String(buf);
	}
	//load highscores from files
	private static void LoadHighScores() {
        try {
            File file = new File(highscoreFile);
            if (!file.exists()) {
            	//creating file if it doesn't exist
                file.createNewFile();
            }
            BufferedReader br = new BufferedReader(new FileReader(file));
            highscores = new int[Max_High_Scores];
            for (int i = 0; i < Max_High_Scores; i++) {
                String line = br.readLine();
                if (line != null) {
                    highscores[i] = Integer.parseInt(line.trim());
                } else {
                    break;
                }
            }
            // Close the reader after reading
            br.close(); 
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	//saving highscores to file
	private static void saveHighScores() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(highscoreFile))) {
            for (int score : highscores) {
                bw.write(Integer.toString(score));
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	//update highscores with users high scores
	private static void UpdateHighScores(int userScore)
	{
		for(int i = 0; i < Max_High_Scores; i++)
		{
			if(userScore > highscores[i])
			{
				int temp = highscores[i];
				highscores[i] = userScore;
				userScore = temp;
			}
		}
		//save updated highscores to file
		saveHighScores();
		
	}

}
