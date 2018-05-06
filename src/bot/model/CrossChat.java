package bot.model;

import com.Cardinal.CommandPackage.Commands.ICommand;
import com.Cardinal.CommandPackage.Exceptions.MissingArgumentsException;

import sx.blah.discord.handle.impl.events.guild.channel.message.MessageReceivedEvent;
import sx.blah.discord.util.MissingPermissionsException;

public class CrossChat implements ICommand 
{

	@Override
	public void execute(MessageReceivedEvent event, String[] args)
			throws MissingPermissionsException, MissingArgumentsException 
	{
		if (args[0].toLowerCase().equals("chans"))
		{
			if (args[1].toLowerCase().equals("katden"))
			{
				sendCrossMSG("katden");
			}
			
			else if (args[1].toLowerCase().equals("riftfighters"))
			{
				sendCrossMSG("riftfighters");
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
	
	public void sendCrossMSG(String place)
	{
		if (place.equals("katden"))
		{
			
		}
		
		else if (place.equals("riftfighters"))
		{
			
		}
	}

	@Override
	public String getName() 
	{
		
		return "chans";
	}

}
