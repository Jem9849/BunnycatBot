package bot.model;

//import java.util.Arrays;
//import java.util.Iterator;
//import java.util.concurrent.TimeUnit;
//import bot.controller.BotController;

import com.Cardinal.CommandPackage.Commands.ICommand;
import com.Cardinal.CommandPackage.Exceptions.MissingArgumentsException;

import sx.blah.discord.handle.impl.events.guild.channel.message.MessageReceivedEvent;
import sx.blah.discord.handle.obj.IMessage;
//import sx.blah.discord.handle.obj.IMessage;
//import sx.blah.discord.handle.obj.IUser;
//import sx.blah.discord.util.MessageHistory;
import sx.blah.discord.util.MissingPermissionsException;

public class RockPaperScissors implements ICommand 
{
	public static boolean running;
	private String [] choice;
	private int random;
	
	public RockPaperScissors()
	{
		choice = new String[] {"rock", "paper", "scissors"};
		random = 0;
	}

	@Override
	public void execute(MessageReceivedEvent event, String[] args)
			throws MissingPermissionsException, MissingArgumentsException 
	{
		
			if (args[0].equals("rps"))
			{
				running = true;
				sendM("Choose either //rock, //paper, or //scissors.", event);
			}
			
			else
			{
				//event.getChannel().sendMessage("You did not enter arguments correctly. Either just say rps or rps <@user>.");
				throw new MissingArgumentsException(getName(), "You did not enter arguments correctly. "
						+ "Say //rps.");
			}
				
		}
	
	public String randomChoice()
	{
		random = (int) (Math.random() * 2);
		
		return choice[random];
	}
	
	public IMessage sendM(String message, MessageReceivedEvent event)
	{
		IMessage IM = event.getChannel().sendMessage(message);
		
		
		return IM;
	}

	@Override
	public String getDescription() 
	{
		return "Play rock, paper, and scissors. Say rps to just play with the bot.";
	}

	@Override
	public String getName() 
	{
		return "rps";
	}

}
