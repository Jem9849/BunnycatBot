package bot.model;

import com.Cardinal.CommandPackage.Commands.ICommand;
import com.Cardinal.CommandPackage.Exceptions.MissingArgumentsException;

import bot.controller.BotController;
import sx.blah.discord.handle.impl.events.guild.channel.message.MessageReceivedEvent;
import sx.blah.discord.util.MissingPermissionsException;

// This is a class made to print out the CSP project explanation.
public class CSPExplain implements ICommand 
{
	private BotController botControl;
	
	public CSPExplain()
	{
		botControl = new BotController();
	}

	@Override
	public void execute(MessageReceivedEvent event, String[] args)
	{
		if (args[0].toLowerCase().equals("csp"))
		{
				botControl.messageSend("This is a discord bot written in Java that is suppose to do many things like play games,"
						+ " posts pictures, and post reactions. Today I'm going to show one of the games."
						+ " This is the rock, paper, scissors command. It has the bot play this game with you."
						+ " It works by using the prefix \"//\" prefix with the command rps. After the initial command,"
						+ " you would say the command and a action with the prefix.", event);
		}

	}

	@Override
	public String getDescription() 
	{
		return "**" + getName().toUpperCase() + "**"
				+ "\n" + "This command displays my CSP project explanation.";
	}

	@Override
	public String getName() 
	{
		
		return "csp";
	}

}
