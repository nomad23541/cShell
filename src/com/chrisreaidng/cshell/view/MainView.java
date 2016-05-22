package com.chrisreaidng.cshell.view;

import java.io.File;
import java.io.IOException;

import com.chrisreaidng.cshell.Main;
import com.chrisreaidng.cshell.util.DateUtils;
import com.chrisreaidng.cshell.util.FileUtils;

/**
 * The Main view, just has a basic command line
 */
public class MainView extends View {
	
	public MainView(Main main) throws IOException {
		super(main);
		
		// line to be read
		String line = "";
		while((line  = input.readLine()) != null && !line.equals("exit")) {
			// split the line to parse commands
			String[] args = line.split(" ");
			
			// print available commands
			if(args[0].equalsIgnoreCase("help")) {
				System.out.println("Available commands: ");
				System.out.println("ls -- List all files in current directory.");
				System.out.println("cd -- Get the current directory.");
				System.out.println("file -- Create/Delete a file.");
				System.out.println("date -- Get the current date/time.");
			}
			
			// get the current date/time
			if(args[0].equalsIgnoreCase("date")) {
				System.out.println(DateUtils.getDate() + " " + DateUtils.getTime());
			}
			
			// list all files in current directory
			if(args[0].equalsIgnoreCase("ls")) {
				System.out.println("Files in: " + main.getWorkingDirectory() + "\n");
				
				for(File f : FileUtils.getFiles(main.getWorkingDirectory())) {
					if(f.isDirectory()) {
						System.out.println("/" + f.getName());
					} else {
						System.out.println(f.getName());	
					}
				}
			}
			
			// print/set current directory
			if(args[0].equalsIgnoreCase("cd")) {
				if(args.length > 1) {
					if(new File(args[1]).exists()) {
						main.setWorkingDirectory(args[1]);
					} else {
						System.out.println("Directory doesn't exist!");
					}
				} else {
					System.out.println(main.getWorkingDirectory());
				}
			}
			
			// delete/create file
			if(args[0].equalsIgnoreCase("file")) {
				if(args.length > 1) {
					if(args[1].equals("create")) {
						boolean success = FileUtils.createFile(main.getWorkingDirectory() + "\\" + args[2]);
						if(success) {
							System.out.println("Created " + args[2]);
						} else {
							System.out.println(args[2] + " couldn't be created!");
						}
					}
					
					if(args[1].equalsIgnoreCase("delete")) {
						boolean success = FileUtils.deleteFile(main.getWorkingDirectory() + "\\" + args[2]);
						if(success) {
							System.out.println("Deleted " + args[2]);
						} else {
							System.out.println(args[2] + " couldn't be deleted!");
						}
					}
				} else {
					System.out.println("file create [name] -- Create a file");
					System.out.println("file delete [name] -- Delete a file");
				}
			}
		}
	}

}
