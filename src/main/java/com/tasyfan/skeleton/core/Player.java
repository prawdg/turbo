package com.tasyfan.skeleton.core;

/**
 * Base interface for player implementations.
 */
public interface Player {

	void init(State state);
	
	Move move(State state);

	Move initializingMove(State visibleState);
}
