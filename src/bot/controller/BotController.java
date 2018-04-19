package bot.controller;

import com.Cardinal.CommandPackage.CommandClient;
import com.Cardinal.CommandPackage.Proccessor.CommandRegistry;

import bot.model.Reaction;
import bot.model.RockPaperScissors;
import bot.model.Help;
import bot.model.Picture;
import bot.model.updateUsername;
import bot.view.SendMessage;
import sx.blah.discord.api.ClientBuilder;
import sx.blah.discord.api.IDiscordClient;
import sx.blah.discord.handle.impl.events.guild.channel.message.MessageReceivedEvent;
//import sx.blah.discord.handle.obj.IMessage;
import sx.blah.discord.util.DiscordException;
import sx.blah.discord.util.EmbedBuilder;
//import sx.blah.discord.handle.obj.*;
//import sx.blah.discord.api.events.EventDispatcher;
import sx.blah.discord.util.RateLimitException;

// The code uses two apis and also has a google api that isn't used yet. These two apis are from 
// https://github.com/Discord4J/Discord4J and
// https://github.com/TheCardinalSystem/DiscordPackages/tree/master/CommandPackage

public class BotController 
{
	// A public static constant that has the password token, and having logged in being true.
	public static final IDiscordClient bot = createClient(FileReader.readConfig("BotId", "config"), true);
	private SendMessage messageHelp;
	//private RockPaperScissors gameRps;
	//private ReactionMe reaction;
	
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
		CommandClient cC = new CommandClient(FileReader.readConfig("BotId", "config"));
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
			CommandRegistry.current().register(new Picture());
			CommandRegistry.current().register(new Help());
			//CommandRegistry.current().register(new Scissors());
			CommandRegistry.current().register(new Reaction());
			CommandRegistry.current().register(new updateUsername());
		}
		// Catches the possibility of there being no command or things going wrong.
		catch (DiscordException event)
		{
			System.out.println("Someone entered a wrong command, or it didn't work." + event.getMessage());
		}
		
	}
	
	
	// This is used to create a client and give it the bot token. Then it trys to log in.
	public static IDiscordClient createClient(String token, boolean logged)
    {
        ClientBuilder buildClient = new ClientBuilder();
        buildClient.withToken(token);
        buildClient.withRecommendedShardCount();
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
	
	// Used to build embedded messages.
//	public void messageEmbed(EmbedBuilder build, MessageReceivedEvent event)
//	{
//		messageHelp.buildMessage(build, event);
//	}
	
	// Used to send regular messages. 
	public void messageSend(String content, MessageReceivedEvent event)
	{
		try
		{
		messageHelp.sendM(content, event);
		}
		catch (RateLimitException e)
		{
			System.out.println("RATE LIMIT EXCEEDED.");
			throw e;
		}
	}
	
	// Used to print out regular errors. 
	public void printError(String error)
	{
		System.out.println(error);
	}
	
//	public static IDiscordClient getBot()
//	{
//		return bot;
//	}
	
//	public String getRpsTitle()
//	{
//		return gameRps.getTitle();
//	}
	
}
