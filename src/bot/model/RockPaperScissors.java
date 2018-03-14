package bot.model;

import java.util.Arrays;

import com.Cardinal.CommandPackage.Commands.ICommand;
import com.Cardinal.CommandPackage.Exceptions.MissingArgumentsException;

import sx.blah.discord.handle.impl.events.guild.channel.message.MessageReceivedEvent;
import sx.blah.discord.handle.obj.IUser;
import sx.blah.discord.util.MissingPermissionsException;

public class RockPaperScissors implements ICommand {

	@Override
	public void execute(MessageReceivedEvent event, String[] args)
			throws MissingPermissionsException, MissingArgumentsException 
	{
			//if (args.length == 3)	
		
			IUser user = event.getAuthor();
		
			if (args[0].equals("rps"))
			{
				String [] choice = new String[] {"Rock", "Paper", "Scissors"};
				boolean finished = false;
				int random = 0;
				event.getChannel().sendMessage("Enter either, rock, paper, or scissors.");
				
				while(finished == false)
				{
					random = (int) (Math.random() * 2);
					
					if (event.getChannel().getMessageHistory(50).contains(user.getLongID()))
					{
						
					}
					
					if (args[0] == "rock" || args[0] == "paper" || args[0] == "scissors")
					{
						if (args[0] == choice[random])
						{
							event.getChannel().sendMessage("Try again. You both tied.");
						}
						
						else if (args[0] == "rock" && choice[random] == "paper")
						{
							event.getChannel().sendMessage("The bot wins using paper.");
							finished = true;
						}
						
						else if (args[0] == "paper" && choice[random] == "rock")
						{
							event.getChannel().sendMessage("You won against the bot's rock.");
							finished = true;
						}
						
						else if (args[0] == "rock" && choice[random] == "scissors")
						{
							event.getChannel().sendMessage("You won against the bot's scissors.");
							finished = true;
						}
						
						else if (args[0] == "scissors" && choice[random] == "rock")
						{
							event.getChannel().sendMessage("You lost against the bot's rock.");
							finished = true;
						}
						
						else if (args[0] == "scissors" && choice[random] == "paper")
						{
							event.getChannel().sendMessage("You won against the bot's paper.");
							finished = true;
						}
						
						else if (args[0] == "paper" && choice[random] == "scissors")
						{
							event.getChannel().sendMessage("You lost against the bot's scissors");
							finished = true;
						}
					}
				}
				
			}
			
//			else if (tempC.length() > 3)
//			{
//				
//			}
			
			else
			{
			//event.getChannel().sendMessage("You did not enter arguments correctly. Either just say rps or rps <@user>.");
				throw new MissingArgumentsException(getName(), "You did not enter arguments correctly. "
						+ "Either just say rps or rps <@user>.");
			}
	}
		

	@Override
	public String getDescription() 
	{
		return "Play rock, paper, and scissors. Say rpc to just play with the bot.";
	}

	@Override
	public String getName() 
	{
		return "rps";
	}

}
