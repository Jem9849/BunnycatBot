package bot.model;

import com.Cardinal.CommandPackage.Commands.ICommand;
import com.Cardinal.CommandPackage.Exceptions.MissingArgumentsException;

import sx.blah.discord.handle.impl.events.guild.channel.message.MessageReceivedEvent;
import sx.blah.discord.util.MissingPermissionsException;

public class Scissors implements ICommand 
{
	//private boolean running;
	RockPaperScissors control;
	
	public Scissors()
	{
		control = new RockPaperScissors();
	}

	@Override
	public void execute(MessageReceivedEvent event, String[] args)
			throws MissingPermissionsException, MissingArgumentsException 
	{
		if (args[0].equals("scissors"))
		{
			if (RockPaperScissors.running == true)
			{
				if (control.randomChoice() == "rock")
				{
					control.sendM("You lost against the bot's scissors.", event);
					RockPaperScissors.running = false;
				}
				
				else if (control.randomChoice() == "paper")
				{
					control.sendM("You won against the bot's paper.", event);
					RockPaperScissors.running = false;
				}
				
				else if (control.randomChoice() == "scissors")
				{
					control.sendM("You both tied, try again.", event);
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
		// TODO Auto-generated method stub
		return "Used to select scissors when playing rock, paper, scissors.";
	}

	@Override
	public String getName() 
	{
		// TODO Auto-generated method stub
		return "scissors";
	}

}
