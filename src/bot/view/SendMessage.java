package bot.view;

import sx.blah.discord.util.EmbedBuilder;
import sx.blah.discord.util.RequestBuffer;
//import sx.blah.discord.util.RequestBuffer.RequestFuture;
import sx.blah.discord.handle.impl.events.guild.channel.message.MessageReceivedEvent;
//import sx.blah.discord.handle.obj.IMessage;

public class SendMessage 
{
	private EmbedBuilder buildEm = new EmbedBuilder();
	//private IMessage message;
	
	public SendMessage()
	{
		
	}
	
	public void buildMessage(String title, String content, MessageReceivedEvent event)
	{
		buildEm.appendField(title, content, true);
		buildEm.withAuthorName("BunnyCatBot");
		buildEm.withColor(0, 255, 134);
		
		RequestBuffer.request(() -> event.getChannel().sendMessage(buildEm.build()));
	}
}
