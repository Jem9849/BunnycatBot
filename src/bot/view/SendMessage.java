package bot.view;

import sx.blah.discord.util.EmbedBuilder;
import sx.blah.discord.util.RequestBuffer;
import bot.controller.BotController;
//import sx.blah.discord.util.RequestBuffer.RequestFuture;
import sx.blah.discord.handle.impl.events.guild.channel.message.MessageReceivedEvent;
//import sx.blah.discord.handle.obj.IMessage;
import sx.blah.discord.handle.obj.IMessage;

public class SendMessage 
{
	private EmbedBuilder buildEm; 
	//private BotController viewBotControl;
	//private IMessage message;
	
	public SendMessage()
	{
		//viewBotControl = new BotController();
		buildEm = new EmbedBuilder();
	}
	
	public void buildMessage(String title, String content, String appendContent, MessageReceivedEvent event)
	{	
		//buildEm.appendField(":thinking: Hmm :thinking:", appendContent, true);
		
		buildEm.withAuthorName("BunnyCatBot");
		
		buildEm.withColor(0, 255, 134);
	    buildEm.withDescription(content);
	    buildEm.withTitle(title);
	    buildEm.withTimestamp(event.getMessage().getTimestamp());
	    
		
		RequestBuffer.request(() -> event.getChannel().sendMessage(buildEm.build()));
	}
	
	public IMessage sendM(String message, MessageReceivedEvent event)
	{
		IMessage IM = event.getChannel().sendMessage(message);
		
		
		return IM;
	}
}
