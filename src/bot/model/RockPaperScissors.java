package bot.model;

import com.Cardinal.CommandPackage.Commands.ICommand;
import com.Cardinal.CommandPackage.Exceptions.MissingArgumentsException;

import sx.blah.discord.handle.impl.events.guild.channel.message.MessageReceivedEvent;
import sx.blah.discord.util.MissingPermissionsException;

public class RockPaperScissors implements ICommand {

	@Override
	public void execute(MessageReceivedEvent event, String[] args)
			throws MissingPermissionsException, MissingArgumentsException 
	{
		

	}

	@Override
	public String getDescription() 
	{
		return "Play rock, paper, and scissors.";
	}

	@Override
	public String getName() 
	{
		
		return "rpc";
	}

}
