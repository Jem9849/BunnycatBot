package bot.controller;

import sx.blah.discord.api.ClientBuilder;
import sx.blah.discord.api.IDiscordClient;
import sx.blah.discord.util.DiscordException;

public class BotController 
{
	public static final IDiscordClient bot = createClient(FileReader.readConfig(), true);
	
	public BotController()
	{
		
	}
	void start()
	{
		System.out.println(bot.getApplicationClientID());
	}
	
	
	
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
