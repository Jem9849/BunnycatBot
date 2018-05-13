package bot.model;

import com.Cardinal.CommandPackage.Commands.ICommand;
import com.Cardinal.CommandPackage.Exceptions.MissingArgumentsException;

import bot.controller.BotController;
import sx.blah.discord.handle.impl.events.guild.channel.message.MessageReceivedEvent;
import sx.blah.discord.util.MissingPermissionsException;


// This class is suppose to print out help messages for USER commands.
public class Help implements ICommand 
{
	private BotController botControl;
	private Picture pic;
	private RockPaperScissors rps;
	private CrossChat chat;
	
	public Help()
	{
		pic = new Picture();
		botControl = new BotController();
		rps = new RockPaperScissors();
		chat = new CrossChat();
	}

	@Override
	public void execute(MessageReceivedEvent event, String[] args)
	{
		if (args[0].toLowerCase().equals("help"))
		{
				botControl.messageSend(pic.getDescription(), event);
				botControl.messageSend(rps.getDescription(), event);
				botControl.messageSend(chat.getDescription(), event);
				botControl.messageSend(getDescription(), event);
				
		}

	}

	@Override
	public String getDescription() 
	{
		return "**" + getName().toUpperCase() + "**"
				+ "\n" + "This is the command you are currently using. It displays all commands that"
				+ "\n" + "users can use.";
	}

	@Override
	public String getName() 
	{
		
		return "help";
	}

}
