package com.student;

import java.util.*;
import org.json.simple.*;

public class App 
{
    public static void main( String[] args )
    {
        String fileName = "commands.json";
		
		// read coammands
		JSONArray commandJSONArray = JSONFile.readArray(fileName);
		String[] commandArray = getCommandArray(commandJSONArray);
		System.out.println(commandArray);
		
		Random rand = new Random();
		
		Scanner sc = new Scanner(System.in); 
		char choice = ' ';
		
		int lastPerformedIndex = -1, lastUndoneIndex = -1;
		
		do {
			System.out.println("----------------------------------------------------------");
			System.out.println("General Cavazos Commander App");
			System.out.println("----------------------------------------------------------");
			System.out.println("i        Issue a command");
			System.out.println("l        List all the commands");
			System.out.println("u        Undo the last command that was issued");
			System.out.println("r        Redo the last command that was issued");
			System.out.println("q        Quit");
			System.out.println("----------------------------------------------------------");
			System.out.print("Enter a command:");			
			String str = sc.nextLine();    
			choice = str.charAt(0);
			
			if(choice == 'i') {
				int randIndex = rand.nextInt(commandArray.length);
				System.out.println("----- Issuing a random commands from General Cavazos -----");
				System.out.println(commandArray[randIndex]);
				lastPerformedIndex = randIndex;
			} else if(choice == 'l') {
				System.out.println("----- List of all commands -----");
				print(commandArray);
			} else if(choice == 'u') {
				if(lastPerformedIndex == -1)
					System.out.println("No commands performed last!!");
				else {
					System.out.println("----- Undoing the last performed commands from General Cavazos -----");
					System.out.println(commandArray[lastPerformedIndex]);
					lastUndoneIndex = lastPerformedIndex;
					lastPerformedIndex = -1;
				}
			} else if(choice == 'r') {
				if(lastUndoneIndex == -1)
					System.out.println("No commands performed undone!!");
				else {
					System.out.println("----- Redoing the last undone commands from General Cavazos -----");
					System.out.println(commandArray[lastUndoneIndex]);
					lastPerformedIndex = lastUndoneIndex;
					lastUndoneIndex = -1;
				}
			} 
			
		}while(choice != 'q');