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
					botControl.messageEmbed("You won!", ":newspaper: vs :full_moon:", 
							"You beat them with paper.", event);
					RockPaperScissors.running = false;
				}
				
				else if (gameControl.randomChoice() == "paper")
				{
					botControl.messageEmbed("You tied.", ":newspaper: vs :newspaper:", 
							"You can't beat paper with paper. Silly.", event);
				}
				
				else if (gameControl.randomChoice() == "scissors")
				{
					botControl.messageEmbed("You lost!", ":scissors: vs :newspaper:", 
							"Nice try, bud. Paper does not beat scissors.", event);
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
