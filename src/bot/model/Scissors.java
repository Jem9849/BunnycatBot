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
					event.getChannel().sendMessage("You lost against the bot's scissors.");
					RockPaperScissors.running = false;
				}
				
				else if (control.randomChoice() == "paper")
				{
					event.getChannel().sendMessage("You won against the bot's paper.");
					RockPaperScissors.running = false;
				}
				
				else if (control.randomChoice() == "scissors")
				{
					event.getChannel().sendMessage("You both tied, try again.");
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
