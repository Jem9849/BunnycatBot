package bot.controller;

import com.Cardinal.CommandPackage.CommandClient;
import com.Cardinal.CommandPackage.Proccessor.CommandRegistry;

import bot.model.Paper;
import bot.model.Rock;
import bot.model.RockPaperScissors;
import bot.model.Scissors;
import bot.view.SendMessage;
import sx.blah.discord.api.ClientBuilder;
import sx.blah.discord.api.IDiscordClient;
import sx.blah.discord.handle.impl.events.guild.channel.message.MessageReceivedEvent;
import sx.blah.discord.handle.obj.IMessage;
import sx.blah.discord.util.DiscordException;
//import sx.blah.discord.handle.obj.*;
//import sx.blah.discord.api.events.EventDispatcher;

public class BotController 
{
	// A public static constant that has the password token, and having logged in being true.
	public static final IDiscordClient bot = createClient(FileReader.readConfig("BotId"), true);
	private SendMessage messageHelp;
	private RockPaperScissors gameRps;
	
	//public static RockPaperScissors rps;
	
	// The Constructor if needed.
	public BotController()
	{
		//gameRps = new RockPaperScissors();
		messageHelp = new SendMessage();
	}
	
	// Where we register the listener.  
	void start()
	{
		CommandClient cC = new CommandClient(FileReader.readConfig("BotId"));
		cC.addListener(new BotListener("//"));
		activateCommands();
		//RockPaperScissors rps = new RockPaperScissors();
		
		//System.out.println(bot.getApplicationClientID());
		
		// This registers the listener with event dispatcher.
		//EventDispatcher dispatch = bot.getDispatcher();
		//dispatch.registerListener(new BotListener());
	}
	
	// Notices and activates commands, letting them be used and understood.
	public static void activateCommands()
	{
		try 
		{
			CommandRegistry.current().register(new RockPaperScissors());
			CommandRegistry.current().register(new Rock());
			CommandRegistry.current().register(new Paper());
			CommandRegistry.current().register(new Scissors());
		}
		
		catch (DiscordException event)
		{
			event.printStackTrace();
		}
		
	}
	
	
	// This is used to create a client and give it the bot token. Then it trys to log in.
	public static IDiscordClient createClient(String token, boolean logged)
    {
        ClientBuilder buildClient = new ClientBuilder();
        buildClient.withToken(token);
        try
        {
            if (logged)
            {
                return buildClient.login();
            }
            else
            {
                return buildClient.build();
            }
        }
        catch (DiscordException event)
        {
            event.printStackTrace();
            return null;
        }
    }
	
	public void messageEmbed(String title, String content, String appendContent, MessageReceivedEvent event)
	{
		messageHelp.buildMessage(title, content, appendContent, event);
	}
	
	public void messageSend(String content, MessageReceivedEvent event)
	{
		messageHelp.sendM(content, event);
	}
	
//	public String getRpsTitle()
//	{
//		return gameRps.getTitle();
//	}
	
}
