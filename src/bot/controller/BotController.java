package bot.controller;

import com.Cardinal.CommandPackage.CommandClient;

import sx.blah.discord.api.ClientBuilder;
import sx.blah.discord.api.IDiscordClient;
import sx.blah.discord.util.DiscordException;
import sx.blah.discord.handle.obj.*;
import sx.blah.discord.api.events.EventDispatcher;

public class BotController 
{
	// A public static constant that has the password token, and having logged in being true.
	public static final IDiscordClient bot = createClient(FileReader.readConfig(), true);
	
	// The Constructor if needed.
	public BotController()
	{
		
	}
	
	// Where we register the listener.  
	void start()
	{
		CommandClient cC = new CommandClient(FileReader.readConfig());
		cC.addListener(new BotListener("//"));
		activateCommands();
		
		//System.out.println(bot.getApplicationClientID());
		
		// This registers the listener with event dispatcher.
		//EventDispatcher dispatch = bot.getDispatcher();
		//dispatch.registerListener(new BotListener());
	}
	
	// Notices and activates commands, letting them be used and understood.
	public static void activateCommands()
	{
		
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
	
}
