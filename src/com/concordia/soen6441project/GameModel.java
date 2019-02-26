package com.concordia.soen6441project;

import java.io.*;
import java.util.ArrayList;

public class GameModel {
	
	private boolean isLoaded;
	private BoardSetup board = new BoardSetup();
	private GamePlay game=new GamePlay();
	private StringBuilder stringBuilder;
	private String line;
	private BufferedReader reader;
	//private String input;
	private ArrayList<String> countriesArray;
	private String[] para;
	private String[] lines;
	private ArrayList<String> adjacenciesArray=new ArrayList<String>();
	private ArrayList<String> continentsArray=new ArrayList<String>();
	
	
	
public boolean initializeGame(String input) {
		
		isLoaded = false;
		/*this.playerNames = playerNames;
		this.playerTypes = playerTypes;*/
		//board = new BoardSetup();
		
		
			System.out.println("Input from input file" +  ": " + input);
			// Splits the text in the file into an array
			para = input.split("]");
			lines=para[3].split("\n");
	
			//creating adjacency arrayList
			for (int i=1;i<lines.length;i++) {
				adjacenciesArray.add(lines[i]);
				
			}
			System.out.println("Loading board...");
			
			//Adding countries to countries Array List
			countriesArray=new ArrayList<String>();
			for (String adjacent : adjacenciesArray) {
				System.out.println(adjacent);
				String[] countries=adjacent.split(",");
				for (String country : countries) {
					System.out.println(country);
					countriesArray.add(country);
					break;
				}
				
			}
			
			
			lines=para[2].split("\n");
			for(int i=1;i<lines.length-1;i++) {
				continentsArray.add(lines[i]);
			}
			
			/*// Reads continents file
			reader = new BufferedReader(new FileReader(continentsFile));
			stringBuilder = new StringBuilder();
			
			while((line = reader.readLine()) != null) {
				stringBuilder.append(line);
			}
			input = stringBuilder.toString();
			System.out.println("Input from " + continentsFile + ": " + input);
			
			continentsArray = input.split("\t");*/
			
			// Creates game board object
			isLoaded = board.loadBoard(countriesArray, adjacenciesArray,continentsArray);
		
		return isLoaded;
}
public ArrayList<String> getContinents(){
	 
	 return board.getContinents();
}

public ArrayList<String> getMembers(String continentName){
	 
		return board.getMembers(continentName);
}

public ArrayList<String> getadjacent(String countryName){
	
		return board.getadjacent(countryName);
	 
}
public ArrayList<String> readDirectory() {
	String path="C:\\Map";
	ArrayList<String> files=new ArrayList<String>();
	File folder=new File(path);
	File[] listOfFiles=folder.listFiles();
	for (File file : listOfFiles) {
		if(file.getName().endsWith(".txt")||file.getName().endsWith(".TXT")) {
			files.add(file.getName());
		}
	}
	return files;
}

//public void createPlayers(ArrayList<String> players) {
	
//}

public void createPlayers(ArrayList<String> players){
	System.out.println("IngameModel:createPlayers");
	 game.createPlayers(players);
}
}