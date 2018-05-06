package bot.view;

import sx.blah.discord.handle.impl.events.guild.channel.message.MessageReceivedEvent;
import sx.blah.discord.handle.obj.IChannel;
import sx.blah.discord.handle.obj.IMessage;

import bot.controller.FileReader;

// This class is used to send messages.
public class SendMessage 
{
	private FileReader read;
	private String key;
	
	public SendMessage()
	{
		
	}
	
	public IMessage sendM(String message, MessageReceivedEvent event)
	{
		IMessage IM = event.getChannel().sendMessage(message);
		
		return IM;
	}
	
	public IMessage sendM(String message, MessageReceivedEvent event, )
}
