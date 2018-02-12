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
	
	public static void processMessage(IMessage message, String prefix)
	{
		IUser member = message.getAuthor();
		IChannel textChan = message.getChannel();
		IGuild server = message.getGuild();
		
		String[] respondTo = message.getContent().toLowerCase().replaceFirst(prefix, "").split(" ");
		
		if (respondTo[0].equals("ping"))
		{
			textChan.sendMessage("pong!");
		}
		
		else if(respondTo[0].equals("avatar"))
		{
			if (respondTo.length >= 3)
			{
				respondTo[1] = respondTo[1].replaceAll("[<>@!]", "");
				
				for(char letters = 'A'; letters <= 'Z'; letters++)
				{
                    if(respondTo[1].toUpperCase().indexOf(letters) >= 0)
                    {
                       
                        textChan.sendMessage(respondTo[1] + " Is not a valid user!");
                        return;
                       
                    }
                   
                }
				
				IUser actor = server.getUserByID(Long.parseLong(respondTo[1]));
				
				textChan.sendMessage(actor.mention() + "'s picture: " + actor.getAvatarURL());
				message.delete();
				return;
			}
			
			else
			{
				textChan.sendMessage("Not a good argument.");
			}
		}
	}
	
	
	
	
}
