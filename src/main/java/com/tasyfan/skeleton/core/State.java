package com.tasyfan.skeleton.core;

/**
 * Defines game state (eg. state of the board).
 */
public interface State {

	State clone();
	
	void output();
}
