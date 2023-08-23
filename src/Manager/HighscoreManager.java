package Manager;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import Model.Score;

public class HighscoreManager {
	private static HighscoreManager instance;
	private ArrayList<Score> scoreList;
	private static final String FILE_NAME = "highscore.txt";
	private File scoreFile;
	
	private HighscoreManager() {
		// TODO Auto-generated constructor stub
		this.scoreFile = new File(FILE_NAME);
		this.scoreList = new ArrayList<>();
		readHighscore();
	}
	
	public static HighscoreManager GetInstance() {
		if(instance == null) {
			instance = new HighscoreManager();
		}
		return instance;
	}
	
	private void readHighscore() {
		try {
			Scanner sc = new Scanner(this.scoreFile);
			while(sc.hasNextLine()) {
				String line = sc.nextLine();
				String[] data = line.split("#",2);
				System.out.println(data[1]);
				Score score = new Score(data[0], Integer.parseInt(data[1]));
				scoreList.add(score);
				Collections.sort(scoreList);
			}
			sc.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void writeHighscore(Score newScore) {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME));
			writer.write(newScore.getRestaurantName()+"#"+newScore.getScore().toString());
			scoreList.add(newScore);
			writer.close();
			Collections.sort(scoreList);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Score>getScore(){
		return this.scoreList;
	}
	
	
	
	
}
