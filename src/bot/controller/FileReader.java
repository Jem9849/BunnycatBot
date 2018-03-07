package bot.controller;
import java.io.*;
import java.util.Scanner;

public class FileReader 
{
	public static String readConfig(String key)
	{
		String container = "";
		String file = "src/Config.txt";
		try
		{
			Scanner scanFile = new Scanner(new File(file));
			
			//String row = scanFile.nextLine();
				
				if (scanFile.hasNext(key))
				{
					String row = scanFile.nextLine();
					row = scanFile.nextLine();
					container = row;
					
					scanFile.close();
				}
				
				else
				{
					scanFile.close();
				}
				//row.replaceFirst(key, " ");	
		}
				
		catch (FileNotFoundException error)
		{
			System.out.println("There was an error:" + error.getMessage());
		}
		
			return container;
	}
}