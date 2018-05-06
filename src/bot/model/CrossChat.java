package bot.model;

import com.Cardinal.CommandPackage.Commands.ICommand;
import com.Cardinal.CommandPackage.Exceptions.MissingArgumentsException;

import sx.blah.discord.handle.impl.events.guild.channel.message.MessageReceivedEvent;
import sx.blah.discord.util.MissingPermissionsException;

public class CrossChat implements ICommand {

	@Override
	public void execute(MessageReceivedEvent event, String[] args)
			throws MissingPermissionsException, MissingArgumentsException {
		

	}

	@Override
	public String getDescription() {
		
		return "**" + getName().toUpperCase() + "**"
				+ "\n" + "This command sends a message to another server's channel."
				+ "\n" + "It vvorks by saying //chans (server).";
	}

	@Override
	public String getName() {
		
		return "chans";
	}

}
