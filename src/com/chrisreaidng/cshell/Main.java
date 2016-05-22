package com.chrisreaidng.cshell;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import com.chrisreaidng.cshell.util.DateUtils;
import com.chrisreaidng.cshell.util.Info;
import com.chrisreaidng.cshell.view.MainView;

/**
 * Main class for cShell
 * Launches the initial process
 */
public class Main {

	/** Input the be used */
	private BufferedReader input;
	
	/** Current directory being used */
	private String dir;
	
	public Main() {
		// set the working directory
		dir = System.getProperty("user.home");
	}
	
	public void init() {
		// init io
		input = new BufferedReader(new InputStreamReader(System.in));
		
		// welcome messages
		System.out.println("Welcome to " + Info.TITLE + ", created by " + Info.AUTHOR);
		System.out.println("The current date is " + DateUtils.getDate() + " and the time " + DateUtils.getTime());
		System.out.println("The current working directory is: " + dir);
		System.out.println("");
		
		try {
			new MainView(this);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Gets the input
	 * @return Gets the input for the program
	 */
	public BufferedReader getInput() {
		return input;
	}
	
	/**
	 * Gets the current working directory
	 * @return directory being used
	 */
	public String getWorkingDirectory() {
		return dir;
	}
	
	public void setWorkingDirectory(String dir) {
		this.dir = dir;
	}
	public static void main(String[] args) {
		new Main().init();
	}
	
}
