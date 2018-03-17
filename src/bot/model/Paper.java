package bot.model;

import com.Cardinal.CommandPackage.Commands.ICommand;
import com.Cardinal.CommandPackage.Exceptions.MissingArgumentsException;

import sx.blah.discord.handle.impl.events.guild.channel.message.MessageReceivedEvent;
import sx.blah.discord.util.MissingPermissionsException;

public class Paper implements ICommand 
{
	RockPaperScissors control;
	private boolean running;
	
	public Paper()
	{
		this.control = new RockPaperScissors();
		this.running = control.getRunning();
	}

	@Override
	public void execute(MessageReceivedEvent event, String[] args)
			throws MissingPermissionsException, MissingArgumentsException 
	{
		if (args[0].equals("paper"))
		{
			if (running == true)
			{
				if (control.randomChoice() == "rock")
				{
					event.getChannel().sendMessage("You won against the bot's rock.");
					control.setRunning(false);
				}
				
				else if (control.randomChoice() == "paper")
				{
					event.getChannel().sendMessage("You tied against the bot's paper.");
				}
				
				else if (control.randomChoice() == "scissors")
				{
					event.getChannel().sendMessage("You lost against the bot's scissors.");
					control.setRunning(false);
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
