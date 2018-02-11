package bot.controller;
import java.io.*;
import java.util.Scanner;

public class FileReader 
{
	public static String readConfig()
	{
		String container = "";
		String file = "Config.txt";
		try
		{
			Scanner scanFile = new Scanner(new File(file));
				String row = scanFile.next();
				container = row;
				scanFile.close();
		}
		
		catch (FileNotFoundException error)
		{
			System.out.println("There was an error:" + error.getMessage());
		}
			return container;
	}
}