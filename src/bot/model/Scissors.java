package bot.model;

import com.Cardinal.CommandPackage.Commands.ICommand;
import com.Cardinal.CommandPackage.Exceptions.MissingArgumentsException;

import bot.controller.BotController;
import sx.blah.discord.handle.impl.events.guild.channel.message.MessageReceivedEvent;
import sx.blah.discord.util.MissingPermissionsException;

public class Scissors implements ICommand 
{
	//private boolean running;
	RockPaperScissors gameControl;
	BotController botControl;
	
	public Scissors()
	{
		botControl = new BotController();
		gameControl = new RockPaperScissors();
	}

	@Override
	public void execute(MessageReceivedEvent event, String[] args)
			throws MissingPermissionsException, MissingArgumentsException 
	{
		if (args[0].equals("scissors"))
		{
			if (RockPaperScissors.running == true)
			{
				if (gameControl.randomChoice() == "rock")
				{
					botControl.messageEmbed("You lost!", ":scissors: vs :full_moon:", 
							"Scissors against rock? BAD PLAY!", event);
					RockPaperScissors.running = false;
				}
				
				else if (gameControl.randomChoice() == "paper")
				{
					botControl.messageEmbed("You won!", ":scissors: vs :newspaper:", 
							"You won, congrats. Cut that paper up.", event);
					RockPaperScissors.running = false;
				}
				
				else if (gameControl.randomChoice() == "scissors")
				{
					botControl.messageEmbed("You tied.", ":scissors: vs :scissors:", 
							"Scissors.. against scissors... wow just wow.", event);
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
