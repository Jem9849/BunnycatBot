package bot.controller;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class FileReader 
{
	public static String readConfig(String key)
	{
		String container = "";
		ArrayList<String> fileArray = new ArrayList<String>();
		String file = "src/Config.txt";
		
		try
		{
			Scanner scanFile = new Scanner(new File(file));

			while (scanFile.hasNext())
			{
				String row = scanFile.nextLine();
				
				fileArray.add(row);
			}
			
			scanFile.close();
		}
		
		catch (FileNotFoundException error)
		{
			System.out.println("There was an error:" + error.getMessage());
		}
		
		
		for (int i = 0; i < fileArray.size(); i++)
		{
			if (fileArray.get(i) == key)
			{
				container = fileArray.get(i++);
			}
		}
		
		return container;
			//String row = scanFile.nextLine();
				
//				if (scanFile.hasNext())
//				{
//					for (String current : fileArray)
//					{
//						
//					}
//					String row = scanFile.nextLine();
//					row = scanFile.nextLine();
//					container = row;
//					
				
				//row.replaceFirst(key, " ");	
	}
}