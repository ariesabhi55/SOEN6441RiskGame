package com.concordia.soen6441project;

import java.util.ArrayList;
import java.util.HashMap;

import sun.net.www.protocol.http.HttpURLConnection.TunnelState;

public class GamePlay {
	
	Players objplayer;
	
	ArrayList<Players> playersobjlist=new ArrayList<Players>();
	
	public void createPlayers(ArrayList<String> players){
		int i=1;
		int army;
		if(players.size()==2 || players.size()==3)
			army=35;
		else if(players.size()==4)
			army=30;
		else if(players.size()==5)
			army=25;
		else
			army=20;
		for (String player : players) {
			objplayer=new Players(player,army,i);
			playersobjlist.add(objplayer);
			i++;
			
		}
		
	}
	
	public ArrayList<Players> getPlayers(){
		
		return playersobjlist;
	}
	
	public ArrayList<Countries> getHeldCountries(int turnCount,ArrayList<Players> play){
		System.out.println(turnCount);
		ArrayList<Countries> countryHeld=new ArrayList<Countries>();
		System.out.println(play.size());
		for (Players players : play) {
			System.out.println(players.getTurnInCount());
			if(players.getTurnInCount()==turnCount) {
				System.out.println(players.getName());
				for (String countries : players.getCountriesHeld().keySet()) {
					countryHeld.add(players.getCountriesHeld().get(countries));
				}
				//countryHeld.add();
			}
		}
		return countryHeld;
	}

}
