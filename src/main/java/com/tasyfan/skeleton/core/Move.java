package com.tasyfan.skeleton.core;

import java.util.List;

/**
 * Defines a list of actions taken in a single move/turn in the game.
 */
public interface Move {

	List<Action> getActions();
}
