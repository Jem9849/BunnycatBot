package bot.controller;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

import sx.blah.discord.handle.obj.IChannel;
import sx.blah.discord.handle.obj.IGuild;
import sx.blah.discord.handle.obj.IMessage;
import sx.blah.discord.handle.obj.IUser;

public class CommandControl 
{
	public CommandControl()
	{
		
	}
	
	// This processes the command.
	public static void processCommand(IMessage message, String prefix)
	{
		IUser member = message.getAuthor();
		IChannel textChan = message.getChannel();
		IGuild server = message.getGuild();
			
		String[] splitCommand = message.getContent().split(" ");
			
		if (splitCommand.length > 0 && splitCommand[0].startsWith(prefix))
		{
			List<String> command = new ArrayList<String>(Arrays.asList(splitCommand));
			command.remove(0);
		}
	
	}
		
}
