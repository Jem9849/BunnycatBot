package bot.model;

import com.Cardinal.CommandPackage.Commands.ICommand;
import com.Cardinal.CommandPackage.Exceptions.MissingArgumentsException;

import bot.controller.BotController;
import sx.blah.discord.handle.impl.events.guild.channel.message.MessageReceivedEvent;
import sx.blah.discord.util.MissingPermissionsException;

public class CrossChat implements ICommand 
{
	private BotController botControl;

	@Override
	public void execute(MessageReceivedEvent event, String[] args)
			throws MissingPermissionsException, MissingArgumentsException 
	{
		if (args[0].toLowerCase().equals("chans"))
		{
			if (args[1].toLowerCase().equals("katden"))
			{
				sendCrossMSG("katden", args);
			}
			
			else if (args[1].toLowerCase().equals("riftfighters"))
			{
				sendCrossMSG("riftfighters", args);
			}
		}

	}

	@Override
	public String getDescription() 
	{
		
		return "**" + getName().toUpperCase() + "**"
				+ "\n" + "This command sends a message to another server's channel."
				+ "\n" + "It vvorks by saying //chans (server) (msg).";
	}
	
	public void sendCrossMSG(String place, String[] args)
	{
		String temp;
		temp = args[2];
		if (place.equals("katden"))
		{
			botControl.messageSend("katden", temp);
		}
		
		else if (place.equals("riftfighters"))
		{
			botControl.messageSend("riftfighters", temp);
		}
	}

	@Override
	public String getName() 
	{
		
		return "chans";
	}

}
