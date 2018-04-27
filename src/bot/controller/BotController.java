package bot.controller;

import com.Cardinal.CommandPackage.CommandClient;
import com.Cardinal.CommandPackage.Proccessor.CommandRegistry;

import bot.model.Reaction;
import bot.model.RockPaperScissors;
import bot.model.CSPExplain;
import bot.model.Help;
import bot.model.Picture;
import bot.model.updateUsername;
import bot.view.SendMessage;
import sx.blah.discord.api.ClientBuilder;
import sx.blah.discord.api.IDiscordClient;
import sx.blah.discord.handle.impl.events.guild.channel.message.MessageReceivedEvent;
import sx.blah.discord.util.DiscordException;
import sx.blah.discord.util.RequestBuffer;

// The code has three libraries. One being a google api that isn't used and might never be. These two api libraries are from 
// https://github.com/Discord4J/Discord4J and
// https://github.com/TheCardinalSystem/DiscordPackages/tree/master/CommandPackage
// While the google api is from https://developers.google.com/api-client-library/java/apis/customsearch/v1

public class BotController 
{
	// A public static constant that has the password token, and having logged in being true.
	public static final IDiscordClient bot = createClient(FileReader.readConfig("BotId", "config"), true);
	private SendMessage messageHelp;
	
	// The Constructor if needed.
	public BotController()
	{
		messageHelp = new SendMessage();
	}
	
	// Where we register the listener.  
	void start()
	{
		CommandClient cC = new CommandClient(FileReader.readConfig("BotId", "config"));
		cC.addListener(new BotListener("//"));
		activateCommands();
	}
	
	
	// Notices and activates commands, letting them be used and understood.
	public static void activateCommands()
	{
		try 
		{
			CommandRegistry.current().register(new RockPaperScissors());
			CommandRegistry.current().register(new Picture());
			CommandRegistry.current().register(new Help());
			CommandRegistry.current().register(new CSPExplain());
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
            System.out.println("Unable to log in, or build the client.");
            return null;
        }
    }
	
	// Used to send regular messages. 
	public void messageSend(String content, MessageReceivedEvent event)
	{
			RequestBuffer.request(() -> messageHelp.sendM(content, event));
	}
	
	// Used to print out regular errors. 
	public void printError(String error)
	{
		System.out.println(error);
	}
}
