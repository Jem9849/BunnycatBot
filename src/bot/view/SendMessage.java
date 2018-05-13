package bot.view;

import sx.blah.discord.api.IDiscordClient;
import sx.blah.discord.handle.impl.events.guild.channel.message.MessageReceivedEvent;
import sx.blah.discord.handle.impl.obj.Guild;
import sx.blah.discord.handle.obj.IChannel;
import sx.blah.discord.handle.obj.IGuild;
import sx.blah.discord.handle.obj.IMessage;

import bot.controller.FileReader;

// This class is used to send messages.
public class SendMessage 
{
	//private FileReader read;
	private String key;
	private IDiscordClient client;
	private IGuild katden;
	private IGuild riftfight;
	private IChannel katchan;
	private IChannel riftchan;
	
	public SendMessage()
	{
		katden = client.getGuildByID(Integer.parseInt(FileReader.readConfig("KatDenID", "config")));
		riftfight = client.getGuildByID(Integer.parseInt(FileReader.readConfig("RiftFightersID", "config")));
		katchan = katden.getChannelByID(Integer.parseInt(FileReader.readConfig("KatDenChanID", "config")));
		riftchan = riftfight.getChannelByID(Integer.parseInt(FileReader.readConfig("RiftFightersChanID", "config")));
	}
	
	public IMessage sendM(String message, MessageReceivedEvent event)
	{
		IMessage IM = event.getChannel().sendMessage(message);
		
		return IM;
	}
	
	public IMessage sendM(String key, String message)
	{
		IMessage IM = null;
		
		if (key.toLowerCase().equals("katden"))
		{
			IM = katchan.sendMessage(message);
		}
		else if (key.toLowerCase().equals("riftfighters"))
		{
			IM = riftchan.sendMessage(message);
		}
		
		return IM;
	}
}
