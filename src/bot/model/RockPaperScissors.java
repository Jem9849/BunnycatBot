package bot.model;

import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import com.Cardinal.CommandPackage.Commands.ICommand;
import com.Cardinal.CommandPackage.Exceptions.MissingArgumentsException;

import sx.blah.discord.handle.impl.events.guild.channel.message.MessageReceivedEvent;
import sx.blah.discord.handle.obj.IMessage;
import sx.blah.discord.handle.obj.IUser;
import sx.blah.discord.util.MessageHistory;
import sx.blah.discord.util.MissingPermissionsException;

public class RockPaperScissors implements ICommand {

	@Override
	public void execute(MessageReceivedEvent event, String[] args)
			throws MissingPermissionsException, MissingArgumentsException 
	{
			//if (args.length == 3)	
		
			IUser user = event.getAuthor();
		
			if (args[0].equals("rps"))
			{
				String [] choice = new String[] {"Rock", "Paper", "Scissors"};
				boolean finished = false;
				int random = 0;
				
				try        
				{
					event.getChannel().sendMessage("Enter either, rock, paper, or scissors.");
				    Thread.sleep(5000);
				} 
				catch(InterruptedException interrupt) 
				{
				    Thread.currentThread().interrupt();
				}
				
				while(finished == false)
				{
					random = (int) (Math.random() * 2);
					//messageBulk = event.getChannel().getMessageHistory(50);
					String [] action = new String [1];
					MessageHistory bulk = event.getChannel().getMessageHistory(10);
					Iterator<IMessage> move = bulk.iterator();
					
					
					while (move.hasNext())
					{
						IMessage msg = (IMessage)move.next();
						
						if (msg.getAuthor() == user)
						{
							if (msg.getContent().toLowerCase() == "rock" || msg.getContent().toLowerCase() == "paper" ||
								msg.getContent().toLowerCase() == "scissors")
							{
								
								if (action[0].isEmpty())
								{
									action[0] = (msg.toString().toLowerCase());
								}
							}
						}
					}
					
					if (action[0].isEmpty())
					{
						System.out.println("Could not find your answer. Command reseted.");
						finished = true;
					}
					
					else
					{
						if (action[0] == "rock" || action[0] == "paper" || action[0] == "scissors")
						{
							if (action[0] == choice[random])
							{
								event.getChannel().sendMessage("Try again. You both tied.");
							}
							
							else if (action[0] == "rock" && choice[random] == "paper")
							{
								event.getChannel().sendMessage("The bot wins using paper.");
								finished = true;
							}
							
							else if (action[0] == "paper" && choice[random] == "rock")
							{
								event.getChannel().sendMessage("You won against the bot's rock.");
								finished = true;
							}
							
							else if (action[0] == "rock" && choice[random] == "scissors")
							{
								event.getChannel().sendMessage("You won against the bot's scissors.");
								finished = true;
							}
							
							else if (action[0] == "scissors" && choice[random] == "rock")
							{
								event.getChannel().sendMessage("You lost against the bot's rock.");
								finished = true;
							}
							
							else if (action[0] == "scissors" && choice[random] == "paper")
							{
								event.getChannel().sendMessage("You won against the bot's paper.");
								finished = true;
							}
							
							else if (action[0] == "paper" && choice[random] == "scissors")
							{
								event.getChannel().sendMessage("You lost against the bot's scissors");
								finished = true;
							}
						}
					}
					
				}
			}
			
			else
			{
				//event.getChannel().sendMessage("You did not enter arguments correctly. Either just say rps or rps <@user>.");
				throw new MissingArgumentsException(getName(), "You did not enter arguments correctly. "
						+ "Either just say rps or rps <@user>.");
			}
				
		}
			
//			else if (tempC.length() > 3)
//			{
//				
//			}
		

	@Override
	public String getDescription() 
	{
		return "Play rock, paper, and scissors. Say rpc to just play with the bot.";
	}

	@Override
	public String getName() 
	{
		return "rps";
	}

}
