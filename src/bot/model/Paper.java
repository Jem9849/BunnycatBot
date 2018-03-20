package bot.model;

import bot.controller.BotController;

import com.Cardinal.CommandPackage.Commands.ICommand;
import com.Cardinal.CommandPackage.Exceptions.MissingArgumentsException;

import sx.blah.discord.handle.impl.events.guild.channel.message.MessageReceivedEvent;
import sx.blah.discord.util.MissingPermissionsException;

public class Paper implements ICommand 
{
	RockPaperScissors gameControl;
	BotController botControl;
	//private boolean running;
	
	public Paper()
	{
		gameControl = new RockPaperScissors();
		botControl = new BotController();
	}

	@Override
	public void execute(MessageReceivedEvent event, String[] args)
			throws MissingPermissionsException, MissingArgumentsException 
	{
		if (args[0].equals("paper"))
		{
			if (RockPaperScissors.running == true)
			{
				if (gameControl.randomChoice() == "rock")
				{
					botControl.messageBuild("You won!", ":newspaper: vs :full_moon:", event);
					RockPaperScissors.running = false;
				}
				
				else if (gameControl.randomChoice() == "paper")
				{
					botControl.messageBuild("You tied.", ":newspaper: vs :newspaper:", event);
				}
				
				else if (gameControl.randomChoice() == "scissors")
				{
					botControl.messageBuild("You lost!", ":scissors: vs :newspaper:", event);
					RockPaperScissors.running = false;
				}
			}

		}
		
		else
		{
			throw new MissingArgumentsException(getName(), "You did not enter arguments correctly. "
					+ "Use the \"//\" prefix, and a choice of rock, paper, or scissors." );
		}

	}

	@Override
	public String getDescription() 
	{
		return "Use paper in the rock, paper, scissors game.";
	}

	@Override
	public String getName() 
	{
		return "paper";
	}

}
