package com.tasyfan.skeleton.base;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.tasyfan.skeleton.core.Action;
import com.tasyfan.skeleton.core.Engine;
import com.tasyfan.skeleton.core.Game;
import com.tasyfan.skeleton.core.Move;
import com.tasyfan.skeleton.core.Player;

public abstract class BaseEngine implements Engine {

	@Autowired
	private Game game;

	private List<Player> players;

	public void run() {
		registerPlayers();
		game.validatePlayers(players);

		game.beforeInit(players);
		init();
		game.afterInit(players);

		game.beforeStart(players);
		play();
		game.afterEnd(players);
	}

	private void play() {
		while (!game.hasEnded()) {
			game.beforeRound(players);
			for (int i = 0; i < players.size(); i++) {
				Player player = players.get(i);
				game.beforeMove(player);
				Move move = player.move(game.getVisibleState(player));
				if (game.isValidMove(move)) {
					for (Action action : move.getActions()) {
						if (game.isValidAction(action)) {
							game.updateState(action);
						} else {
							// TODO: error, retry or discard
						}
					}
				} else {
					// TODO: error, retry or discard
				}
				game.afterMove(player);
			}
			game.afterRound(players);
		}
	}

	private void init() {
		while (!game.isInitialized()) {
			game.beforeInitRound(players);
			for (int i = 0; i < players.size(); i++) {
				Player player = players.get(i);
				game.beforeInitMove(player);
				Move move = player.initializingMove(game.getVisibleState(player));
				if (game.isValidInitMove(move)) {
					for (Action action : move.getActions()) {
						if (game.isValidInitAction(action)) {
							game.updateState(action);
						} else {
							// TODO: error, retry or discard
						}
					}
				} else {
					// TODO: error, retry or discard
				}
				game.afterInitMove(player);
			}
			game.afterInitRound(players);
		}
	}

	protected abstract void registerPlayers();
}
