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