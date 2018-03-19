package bot.model;

import com.Cardinal.CommandPackage.Commands.ICommand;
import com.Cardinal.CommandPackage.Exceptions.MissingArgumentsException;

import sx.blah.discord.handle.impl.events.guild.channel.message.MessageReceivedEvent;
import sx.blah.discord.util.MissingPermissionsException;

public class Rock implements ICommand 
{
	RockPaperScissors control;
	//private boolean running;
	
	public Rock()
	{
		control = new RockPaperScissors();
	}

	@Override
	public void execute(MessageReceivedEvent event, String[] args)
			throws MissingPermissionsException, MissingArgumentsException 
	{	
		//System.out.println("My value is, " + RockPaperScissors.running);
		if (args[0].equals("rock"))
		{
			if (RockPaperScissors.running == true)
			{
				if (control.randomChoice().equals("rock"))				
				{
					control.sendM("You tied against the bot's rock.", event); //("You tied against the bot's rock.");
				}
				
				else if (control.randomChoice().equals("paper"))
				{
					control.sendM("You lost against the bot's paper.", event);
					RockPaperScissors.running = false;
				}
				
				else if (control.randomChoice().equals("scissors"))
				{
					control.sendM("You won against the bot's scissors.", event);
					RockPaperScissors.running = false;
				}
				
				else 
				{
					System.out.println(control.randomChoice());
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
