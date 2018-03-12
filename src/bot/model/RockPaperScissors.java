package bot.model;

import java.util.Arrays;

import com.Cardinal.CommandPackage.Commands.ICommand;
import com.Cardinal.CommandPackage.Exceptions.MissingArgumentsException;

import sx.blah.discord.handle.impl.events.guild.channel.message.MessageReceivedEvent;
import sx.blah.discord.util.MissingPermissionsException;

public class RockPaperScissors implements ICommand {

	@Override
	public void execute(MessageReceivedEvent event, String[] args)
			throws MissingPermissionsException, MissingArgumentsException 
	{
		String tempC = Arrays.toString(args);
		
		if (tempC.length() >= 3 && tempC.contains("rps"))
		{
			if (tempC.length() == 3)
			{
				
			}
			
			else if (tempC.length() > 3)
			{
				
			}
		}
		else
		{
			//System.out.println("You did not enter arguments correctly. Either just say rps or rps <@user>.");
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
