package bot.view;

import sx.blah.discord.handle.impl.events.guild.channel.message.MessageReceivedEvent;
import sx.blah.discord.handle.obj.IMessage;

// This class is used to send messages.
public class SendMessage 
{
	
	public SendMessage()
	{
		
	}
	
	public IMessage sendM(String message, MessageReceivedEvent event)
	{
		IMessage IM = event.getChannel().sendMessage(message);
		
		return IM;
	}
}
