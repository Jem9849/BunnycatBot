package bot.controller;

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
	
	// Where the program will come to after the runner.  
	void start()
	{
		System.out.println(bot.getApplicationClientID());
		
		EventDispatcher dispatch = bot.getDispatcher();
		dispatch.registerListener(new BotListener());
	}
	
	
	// This takes two parameters, token and logged. These are here to help set up the bot and login.
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
	
	public static void processCommand(IMessage message, String prefix)
	{
		IUser member = message.getAuthor();
		IChannel textChan = message.getChannel();
		IGuild server = message.getGuild();
		
		
		
	}
	
	
}
