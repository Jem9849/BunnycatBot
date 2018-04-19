package bot.view;

import sx.blah.discord.util.EmbedBuilder;
import sx.blah.discord.util.MissingPermissionsException;
import sx.blah.discord.util.RateLimitException;
import sx.blah.discord.util.RequestBuffer;
import bot.controller.BotController;
//import sx.blah.discord.util.RequestBuffer.RequestFuture;
import sx.blah.discord.handle.impl.events.guild.channel.message.MessageReceivedEvent;
//import sx.blah.discord.handle.obj.IMessage;
import sx.blah.discord.handle.obj.IMessage;

public class SendMessage 
{
	private BotController viewBotControl;
	//private IMessage message;
	
	public SendMessage()
	{
		
	}
	
	public void buildMessage(EmbedBuilder embed, MessageReceivedEvent event)
	{	
		try
		{
			RequestBuffer.request(() -> event.getChannel().sendMessage(embed.build()));
		}
		
		catch (MissingPermissionsException permission)
		{
			viewBotControl.printError(permission.getMessage());
			sendM("The bot does not have the right permissions.", event);
		}
	}
	
	public IMessage sendM(String message, MessageReceivedEvent event)
	{
		try
		{
			IMessage IM = event.getChannel().sendMessage(message);
			
			return IM;
		}
		catch (RateLimitException e)
		{
			System.out.println("RATE LIMIT EXCEEDED.");
			throw e;
		}
	}
}
