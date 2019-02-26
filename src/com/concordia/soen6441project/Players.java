package com.concordia.soen6441project;

import java.util.HashMap;

public class Players {
	
	private String name;
	private int armies;
	private int turnInCount;
	
    private HashMap<String, Countries> countriesHeld;
    private HashMap<String, Continents> continentsHeld;
	
    public Players(String name, int armies, int turnInCount) {
    	
		this.name = name;
		this.armies = armies;
		this.turnInCount = turnInCount;
		//this.isAI = isAI;
		
		countriesHeld = new HashMap<String, Countries>();
		continentsHeld = new HashMap<String, Continents>();
		
		//hand = new Hand();
		
		//turnInCount = 0;
		System.out.println("Players Created:"+this.name+" "+this.turnInCount);
    }
    
    public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getArmies() {
		return armies;
	}
	public void setArmies(int armies) {
		this.armies = armies;
	}
	public int getTurnInCount() {
		return turnInCount;
	}
	public void setTurnInCount(int turnInCount) {
		this.turnInCount = turnInCount;
	}
	public HashMap<String, Countries> getCountriesHeld() {
		return countriesHeld;
	}
	public void setCountriesHeld(HashMap<String, Countries> countriesHeld) {
		this.countriesHeld = countriesHeld;
	}
	public HashMap<String, Continents> getContinentsHeld() {
		return continentsHeld;
	}
	public void setContinentsHeld(HashMap<String, Continents> continentsHeld) {
		this.continentsHeld = continentsHeld;
	}

}
