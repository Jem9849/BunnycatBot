package bot.model;

import com.Cardinal.CommandPackage.Commands.ICommand;
import com.Cardinal.CommandPackage.Exceptions.MissingArgumentsException;

import bot.controller.BotController;
import sx.blah.discord.handle.impl.events.guild.channel.message.MessageReceivedEvent;
import sx.blah.discord.util.MissingPermissionsException;

public class Rock implements ICommand 
{
	RockPaperScissors gameControl;
	BotController botControl;
	//private boolean running;
	
	public Rock()
	{
		botControl = new BotController();
		gameControl = new RockPaperScissors();
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
				if (gameControl.randomChoice().equals("rock"))				
				{
					botControl.messageEmbed("You tied.", ":full_moon: vs :full_moon:", 
							"Rock does not beat rock.", event);
				}
				
				else if (gameControl.randomChoice().equals("paper"))
				{
					botControl.messageEmbed("You lost!", ":full_moon: vs :newspaper:", 
							"No victory for poor choices. Rock does not beat paper.", event);
					RockPaperScissors.running = false;
				}
				
				else if (gameControl.randomChoice().equals("scissors"))
				{
					botControl.messageEmbed("You won!", ":full_moon: vs :scissors:", 
							"Nicely one, smash those scissors.", event);
					RockPaperScissors.running = false;
				}
				
//				else 
//				{
//					//System.out.println(gameControl.randomChoice());
//				}
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
