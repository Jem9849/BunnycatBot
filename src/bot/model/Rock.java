package bot.model;

import com.Cardinal.CommandPackage.Commands.ICommand;
import com.Cardinal.CommandPackage.Exceptions.MissingArgumentsException;

import sx.blah.discord.handle.impl.events.guild.channel.message.MessageReceivedEvent;
import sx.blah.discord.util.MissingPermissionsException;

public class Rock implements ICommand 
{
	private boolean running;
	RockPaperScissors control;
	
	public Rock()
	{
		this.control = new RockPaperScissors();
		this.running = control.getRunning();
	}

	@Override
	public void execute(MessageReceivedEvent event, String[] args)
			throws MissingPermissionsException, MissingArgumentsException 
	{
		if (args[0].equals("rock"))
		{
			if (running == true)
			{
				if (control.randomChoice() == "rock")
				{
					event.getChannel().sendMessage("You tied against the bot's rock.");
				}
				
				else if (control.randomChoice() == "paper")
				{
					event.getChannel().sendMessage("You lost against the bot's paper.");
					control.setRunning(false);
				}
				
				else if (control.randomChoice() == "scissors")
				{
					event.getChannel().sendMessage("You won against the bot's scissors.");
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
		return "Use rock in the rock, paper, and scissors game.";
	}

	@Override
	public String getName() 
	{
		return "rock";
	}

}
