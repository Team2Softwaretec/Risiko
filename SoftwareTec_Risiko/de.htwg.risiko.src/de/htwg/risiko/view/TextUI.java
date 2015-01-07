package de.htwg.risiko.view;

import static java.lang.System.*;
import de.htwg.risiko.controller.IGameEngine;
import de.htwg.risiko.model.CountryI;
import de.htwg.risiko.model.impl.Country;
import de.htwg.risiko.util.observer.Event;
import de.htwg.risiko.util.observer.IObserver;

public class TextUI implements IObserver {

	IGameEngine ge;
	int num = 0;
	CountryI rec;
	char mode = 0;

	public TextUI(IGameEngine controller) {
		ge = controller;
		controller.addObserver(this);
	}

	@Override
	public void update(Event e) {
		printTUI();
	}

	public void printTUI() {
		out.println(ge.getCurrentPlayer().getName());
		out.println(ge.getStatus());
		//out.println(ge.getWorld().toString());
		for (Country c : ge.getWorld().getWorld().keySet()) {
			out.printf("%s: %s %d\n", c.getName(), ge.getOwner(c).getName(), ge.getSoldiers(c));
		}
	}

	public boolean processInputLine(String line) {
		boolean continu = true;

		switch (line) {
		case "q":
			continu = false;
			break;
		case "n":
			ge.createMap();
			ge.startGame();
			break;
		case "a":
			mode = 'a';
			break;
		case "t":
			mode = 't';
			break;
		case "r":
			mode = 'r';
			break;
		case "e":
			ge.endTurn();
			break;
		case "at":
			ge.invade();
			break;
		case "m":
			ge.recruit();
			//ge.changePlayer();
			break;
		case "num":
			mode = 'n';
			break;
		}

		if (mode == 'm') {
			mode = 'n';
			num = Integer.parseInt(line);
		}
		if (mode == 'n') {
			if (num != 0) {
				if(!ge.selectRecruitment(rec, num)) {
					ge.changePlayer();
					mode = '0';
				}
			} else {
				mode = 'm';
			}
		}

		for (CountryI c : ge.getWorld().getWorld().keySet()) {
			if (line.equals(c.getName())) {
				if (mode == 'a') {
					ge.selectAttacker(c);
				} else if (mode == 't') {
					ge.selectTarget(c);
				} else if (mode == 'r') {
					//mode = 'n';
					rec = c;
				}

			}
		}
		return continu;
	}

}
