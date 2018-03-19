package bot.model;

import com.Cardinal.CommandPackage.Commands.ICommand;
import com.Cardinal.CommandPackage.Exceptions.MissingArgumentsException;

import sx.blah.discord.handle.impl.events.guild.channel.message.MessageReceivedEvent;
import sx.blah.discord.util.MissingPermissionsException;

public class Paper implements ICommand 
{
	RockPaperScissors control;
	//private boolean running;
	
	public Paper()
	{
		control = new RockPaperScissors();
	}

	@Override
	public void execute(MessageReceivedEvent event, String[] args)
			throws MissingPermissionsException, MissingArgumentsException 
	{
		if (args[0].equals("paper"))
		{
			if (RockPaperScissors.running == true)
			{
				if (control.randomChoice() == "rock")
				{
					control.sendM("You won against the bot's rock.", event);
					RockPaperScissors.running = false;
				}
				
				else if (control.randomChoice() == "paper")
				{
					control.sendM("You tied against the bot's paper.", event);
				}
				
				else if (control.randomChoice() == "scissors")
				{
					control.sendM("You lost against the bot's scissors.", event);
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
