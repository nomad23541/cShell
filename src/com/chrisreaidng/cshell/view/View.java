package com.chrisreaidng.cshell.view;

import java.io.BufferedReader;

import com.chrisreaidng.cshell.Main;

/**
 * Extendable view class for all other views
 */
public abstract class View {
	
	/** Reference to the main class */
	protected Main main;
	
	/** Scanner to use */
	protected BufferedReader input;
	
	public View(Main main) {
		this.main = main;
		input = main.getInput();
	}

}
