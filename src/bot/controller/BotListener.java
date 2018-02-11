package bot.controller;

import sx.blah.discord.api.events.EventSubscriber;
import sx.blah.discord.handle.impl.events.guild.channel.message.MessageReceivedEvent;

public class BotListener 
{
public static String prefix = new String("/");
	
	@EventSubscriber
	public void messageEvent(MessageReceivedEvent event)
	{
		if (event.getMessage().getContent().toLowerCase().startsWith(prefix))
		{
			BotController.processMessage(event.getMessage(), prefix);
		}
	}
}
