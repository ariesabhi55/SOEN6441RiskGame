package com.concordia.soen6441project;

import java.util.ArrayList;

public class GamePlay {
	
	Players objplayer;
	
	ArrayList<Players> playersobjlist=new ArrayList<Players>();
	
	public ArrayList<Players> createPlayers(ArrayList<String> players){
		System.out.println(players.size());
		int i=1;
		for (String player : players) {
			System.out.println("in createPlayers"+player);
			objplayer=new Players(player,30,i);
			playersobjlist.add(objplayer);
			i++;
			
		}
		return playersobjlist;
	}

}
