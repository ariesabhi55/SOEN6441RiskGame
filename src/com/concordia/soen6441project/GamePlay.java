package com.concordia.soen6441project;

import java.util.ArrayList;

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

}
