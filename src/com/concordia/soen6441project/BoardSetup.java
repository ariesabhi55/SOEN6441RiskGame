package com.concordia.soen6441project;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class BoardSetup {
	
	private int i;
	private int j;
	
	private boolean isLoaded;
	private boolean isAdjacent;
	
	private String name;
	private String message;
	
	private String[] continentsArray;
	private String[] adjacenciesArray;
	
	private ArrayList<Countries> countriesList;
	private ArrayList<Countries> adjacenciesList;
	private ArrayList<Countries> memberCountries;
	//private ArrayList<Countries> unoccupied;
	private ArrayList<Continents> continentsList;
	private ArrayList<String> continentNames;
	private HashMap<String, Countries> countriesMap;
    private HashMap<String, Continents> continentsMap;
    private HashMap<String, Integer> continentsMap1=new HashMap<String, Integer>();
	
	public boolean loadBoard(ArrayList<String> countriesArray, ArrayList<String> adjacenciesFileArray,ArrayList<String> continentsFileArray) {
			for (String string : continentsFileArray) {
				System.out.println(string);
			}
			isLoaded = false;
		
			countriesMap = new HashMap<String, Countries>();
			continentsMap = new HashMap<String, Continents>();
			
			// Populates countriesMap
			for (i = 0; i < countriesArray.size(); i++) {
			
				countriesMap.put(countriesArray.get(i), new Countries(countriesArray.get(i)));
				//System.out.println("new Country created");
			}
			
			countriesList = new ArrayList<Countries>(countriesMap.values());
			//System.out.println(countriesList);
			
			for (i = 0; i < continentsFileArray.size(); i++) {
				continentsArray=continentsFileArray.get(i).split("=");
				//continentNames.add(continentsFileArray[])
				System.out.println(continentsArray[0]);
				System.out.println(continentsArray[1]);
				continentsMap1.put(continentsArray[0],Integer.parseInt(continentsArray[1]));
			}
			// Populates country adjacencies
			for (i = 0; i < adjacenciesFileArray.size(); i++) {
			
				System.out.println("Building new adjacenciesArray with " + adjacenciesFileArray.get(i) + "...");	
				
				// Splits each line into the individual country names
				adjacenciesArray = adjacenciesFileArray.get(i).split(",");
				
				System.out.println("Building new adjacenciesList...");
				
				adjacenciesList = new ArrayList<Countries>();
				
				// Creates a list of countries adjacent to the country in index 0
				for (j = 2; j < adjacenciesArray.length; j++) {
				
					System.out.println("Adding to adjacenciesList: " + adjacenciesArray[j]);
					
					adjacenciesList.add(countriesMap.get(adjacenciesArray[j]));
				
				}
				
				// Adds the adjacencies to the country
				countriesMap.get(adjacenciesArray[0]).addAdjacencies(adjacenciesList);
			}
			//populate continents
			continentNames=new ArrayList<String>();
			for (i = 0; i < adjacenciesFileArray.size(); i++) {
				adjacenciesArray= adjacenciesFileArray.get(i).split(",");
				if(!continentNames.contains(adjacenciesArray[1])) {
					continentNames.add(adjacenciesArray[1]);
				}	
			}
			if(continentNames.size()!=continentsMap1.size()) {
				message="Error!!.Incorrect number of continents";
				System.out.println(message);
				return false;
			}
			else {
				for (String continent : continentNames) {
						if(!continentsMap1.containsKey(continent)) {
							message="Error! Incorrect continent Names";
							System.out.println(message);
							return false;
						}
					
				}
			}
			
			//System.out.println(message);//Use messagecontext to share message.
			for (String continent : continentNames) {
				memberCountries = new ArrayList<Countries>();
				for (i = 0; i < adjacenciesFileArray.size(); i++) {
					adjacenciesArray= adjacenciesFileArray.get(i).split(",");
					if(continent.equals(adjacenciesArray[1])) {
						memberCountries.add(countriesMap.get(adjacenciesArray[0]));
					}
				}
				for (Countries country : memberCountries) {
					System.out.println("Member Countries for "+continent+":"+country.getName());
				}
				//System.out.println("Member Countries for "+continent+":"+);
				//bonusArmies=continentsMap1.get(continent);				
				continentsMap.put(continent, new Continents(continent, continentsMap1.get(continent), memberCountries));
			}
			
			
			
			
			// Sets isLoaded to true if successful
			if(isConnected(countriesMap,countriesList)) {
				System.out.println("Connected Graph");
				isLoaded = true;
			}
			else
			{
				System.out.println("This is not a connected graph");
			}
			return isLoaded;
		}
	 
	 public boolean isConnected(HashMap<String,Countries> countryMap, ArrayList<Countries> countryList) {
		 int flag=0;
		 ArrayList<Countries> visited=new ArrayList<Countries>();
		 
			 if(!visited.contains(countryList.get(0))) {
				 DFS(countryList.get(0),visited);
			 }
			
		
		 for (Countries countries : countryList) {
			if(visited.contains(countries)) {
				flag=1;
			}
			else {
				flag=0;
				break;
			}
		}
		 if(flag==1)
			 return true;
		 else
			 return false;
		 
	 }
	 public void DFS(Countries country,ArrayList<Countries> visited) {
		 visited.add(country);
		 for (Countries countries : visited) {
			System.out.println(countries.getName());
		}
		 for (Countries countries : country.getAdjacencies()) {
			 if(!visited.contains(countries))
			 DFS(countries,visited); 
		}
	 }
	 
	 public ArrayList<String> getContinents(){
		 for (String string : continentNames) {
			System.out.println(string);
		}
		 return continentNames;
	 }
	 
	 public ArrayList<String> getMembers(String continentName){
		 ArrayList<Countries> members=continentsMap.get(continentName).getMemberCountries();
		 ArrayList<String> memberName=new ArrayList<String>();
		 for (Countries country : members) {
			 memberName.add(country.getName());
		}
			return memberName;
	 }
	 
	 public ArrayList<String> getadjacent(String countryName){
		 ArrayList<Countries> adjacent=countriesMap.get(countryName).getAdjacencies();
		 ArrayList<String> adjacentName=new ArrayList<String>();
		 for (Countries country : adjacent) {
			 adjacentName.add(country.getName());
		}
			return adjacentName;
		 
	 }
	 public ArrayList<Countries> getCountries(){
		 //int i;
		 return countriesList;
	 }

}
