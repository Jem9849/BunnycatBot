package bot.model;

import java.util.Iterator;
import bot.controller.FileReader;

import sx.blah.discord.handle.impl.events.guild.channel.message.MessageReceivedEvent;
import sx.blah.discord.handle.impl.obj.Reaction;
import sx.blah.discord.handle.impl.obj.ReactionEmoji;
import sx.blah.discord.handle.obj.IMessage;
import sx.blah.discord.util.MessageHistory;

public class ReactionMe 
{
	MessageHistory messageH;
	Iterator<IMessage> IM;
	ReactionEmoji heartEmoji = ReactionEmoji.of(":heart:");
	
	public ReactionMe(MessageReceivedEvent event)
	{
		messageH = event.getChannel().getMessageHistory(15);
	}
	
	public void giveMeReaction()
	{
		IM = messageH.iterator();
		while (IM.hasNext())
		{
			for (IMessage current : messageH)
			{
				String authorCheck = Long.toString(current.getAuthor().getLongID());
				
				
				if (authorCheck == FileReader.readConfig("DiscordID"))
				{
					current.addReaction(heartEmoji);
				}
			}
		}
		
	}
	
}
