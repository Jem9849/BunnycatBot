package bot.model;

import com.Cardinal.CommandPackage.Commands.ICommand;
import com.Cardinal.CommandPackage.Exceptions.MissingArgumentsException;

import bot.controller.BotController;
import sx.blah.discord.handle.impl.events.guild.channel.message.MessageReceivedEvent;
import sx.blah.discord.util.MissingPermissionsException;

public class Shield implements ICommand 
{
	private BotController botControl;
	
	public Shield()
	{
		botControl = new BotController();
	}

	@Override
	public void execute(MessageReceivedEvent event, String[] args)
			throws MissingPermissionsException, MissingArgumentsException 
	{
		if (args[0].equals("shield"))
		{
			botControl.messageSend("https://lh3.googleusercontent.com/-Cm5o99Hc_2k/WhnenIiMhVI/AAAAAAAAS-s/m3_x74TPDoQWgaHMRSAVdVfDTUYW6mrTACJoC/w506-h750/image%252520%252866%2529.jpg", event);
		}
	}

	@Override
	public String getDescription() 
	{	
		return "Blocks everything with a single image.";
	}

	@Override
	public String getName() 
	{
		
		return "shield";
	}

}
