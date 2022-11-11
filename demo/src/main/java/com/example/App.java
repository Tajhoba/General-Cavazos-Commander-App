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