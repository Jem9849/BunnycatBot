package bot.model;

import java.util.List;

import com.Cardinal.CommandPackage.Commands.ICommand;
import com.Cardinal.CommandPackage.Exceptions.MissingArgumentsException;

import bot.controller.BotController;
import sx.blah.discord.api.IDiscordClient;
import sx.blah.discord.handle.impl.events.guild.channel.message.MessageReceivedEvent;
import sx.blah.discord.handle.obj.IChannel;
import sx.blah.discord.handle.obj.IGuild;
import sx.blah.discord.util.MissingPermissionsException;

public class CrossChat implements ICommand 
{
	private BotController botControl;
	private IDiscordClient client;
	
	public CrossChat()
	{
		botControl = new BotController();
		client = BotController.bot;
	}

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
				+ "\n" + "It vvorks by saying //chans (server) (msg)."
				+ "\n" + "Right novv there are just riftfighters, and katden for servers.";
	}
	
	public void sendCrossMSG(String place, String[] args)
	{
		String temp;
		temp = "";
		for (int count = 2; count < args.length; count++)
		{
			temp += args[count] + " ";
		}
		
		if (place.equals("katden"))
		{
			botControl.messageSend(grabChannel("Kat Den"), temp);
		}
		
		else if (place.equals("riftfighters"))
		{
			botControl.messageSend(grabChannel("Rift Fighters Community"), temp);
		}
	}
	
	public IChannel grabChannel(String server)
	{
		List<IGuild> guild = client.getGuilds();
		IGuild temp = null;
		IChannel chantemp = null;
		List<IChannel> channels = null;
		
		for (IGuild rightGuild : guild)
		{
			if (rightGuild.getName().equals(server))
			{
				temp = rightGuild;
				channels = temp.getChannels();
			}
		}
		
		
		for (IChannel botphone : channels)
		{
			if (botphone.getName().toLowerCase().equals("botphone"))
			{
				chantemp = botphone;
			}
		}
		
		return chantemp;
	}

	@Override
	public String getName() 
	{
		
		return "chans";
	}

}
