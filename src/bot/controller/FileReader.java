package bot.controller;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class FileReader 
{
	// Method used for reading a file and looking for a specific key.
	public static String readConfig(String key, String file)
	{
		//String container = "";
		
		// Makes a string Array for putting everything from the file into, and also a String called files for location.
		ArrayList<String> fileArray = new ArrayList<String>();
		String files = "";
		
		// This changes the file location depending on what is asked for.
		if (file.toLowerCase() == "config")
		{
			files = "src/Config.txt";
		}
		
		else if (file.toLowerCase() == "properties")
		{
			files = "src/Properties.txt";
		}
		
		// This goes through the entire file with a scanner and puts it into fileArray. Then it closes the scanner.
		try
		{
			Scanner scanFile = new Scanner(new File(files));

			while (scanFile.hasNext())
			{
				String row = scanFile.nextLine();
				
				fileArray.add(row);
			}
			
			scanFile.close();
		}
		
		// This catches an exception when there is no file.
		
		catch (FileNotFoundException error)
		{
			System.out.println("There was an error:" + error.getMessage());
		}
		
		// Returns the key by calling a method to find the key.
		return findKey(fileArray, key);
	}
	
	// This goes through the array of strings and tries to find the key, and then it goes one up and gets the actual key.
	public static String findKey (ArrayList<String> keyList, String key)
	{
		String keyFound = "";
		for (int i = 0; i < keyList.size(); i++)
		{
			if (keyList.get(i).equals(key))
			{
				keyFound = keyList.get(i + 1);
			}
		}
		
		return keyFound;
	}
}