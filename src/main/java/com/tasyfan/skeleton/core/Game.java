package com.tasyfan.skeleton.core;

import java.util.List;

/**
 * Defines game rules.
 */
public interface Game {
	
	int getMaxPlayers();
	
	int getMinPlayers();
	
	void validatePlayers(List<Player> players);
	
	void updateState(Action action);

	State getVisibleState(Player player);

	// Initilization phase
	
	boolean isInitialized();

	void beforeInit(List<Player> players);
	
	void beforeInitRound(List<Player> players);
	
	void beforeInitMove(Player player);
	
	boolean isValidInitMove(Move move);
	
	void beforeInitAction(Player player);
	
	boolean isValidInitAction(Action action);
	
	void afterInitAction(Player player);
	
	void afterInitMove(Player player);
	
	void afterInitRound(List<Player> players);

	void afterInit(List<Player> players);
	
	// After initilization phase
	
	boolean hasEnded();

	void beforeStart(List<Player> players);
	
	void beforeRound(List<Player> players);
	
	void beforeMove(Player player);
	
	boolean isValidMove(Move move);
	
	void beforeAction(Player player);
	
	boolean isValidAction(Action action);
	
	void afterAction(Player player);
	
	void afterMove(Player player);
	
	void afterRound(List<Player> players);

	void afterEnd(List<Player> players);
}

