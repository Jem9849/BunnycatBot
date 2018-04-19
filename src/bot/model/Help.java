package bot.model;

import com.Cardinal.CommandPackage.Commands.ICommand;
import com.Cardinal.CommandPackage.Exceptions.MissingArgumentsException;

import bot.controller.BotController;
import bot.model.*;
import sx.blah.discord.handle.impl.events.guild.channel.message.MessageReceivedEvent;
import sx.blah.discord.util.MissingPermissionsException;
import sx.blah.discord.util.RateLimitException;

public class Help implements ICommand 
{
	private BotController botControl;
	private Picture pic;
	private Reaction react;
	private RockPaperScissors rps;
	private updateUsername update;
	
	public Help()
	{
		pic = new Picture();
		botControl = new BotController();
		react = new Reaction();
		rps = new RockPaperScissors();
		update = new updateUsername();
	}

	@Override
	public void execute(MessageReceivedEvent event, String[] args)
			throws MissingPermissionsException, MissingArgumentsException 
	{
		if (args[0].toLowerCase().equals("help"))
		{
				botControl.messageSend("**" + pic.getName().toUpperCase() + "**", event);
				botControl.messageSend("This command provides some hardcoded images. "
									 + "There are only one image so far, and it is called \"shield\". "
									 + "To use the command say, \"//picture shield\". ", event);
			
				botControl.messageSend("**" + rps.getName().toUpperCase() + "**", event);
				botControl.messageSend("This command lets you play rock, paper, scissors with the bot. To use this command"
									 + " you must say \"//rps\" then afterwards you may either choose \"//rps rock\", "
									 + "\"//rps paper\", or \"//rps rock\" till the game ends.", event);
				
				botControl.messageSend("**" + "Help".toUpperCase() + "**", event);
				botControl.messageSend("This is the command you are currently using. It displays all commands that"
						 			 + " users can use.", event);
		}

	}

	@Override
	public String getDescription() 
	{
		return "returns a list of commands.";
	}

	@Override
	public String getName() 
	{
		
		return "help";
	}

}
