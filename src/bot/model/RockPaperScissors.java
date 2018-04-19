package bot.model;

//import java.awt.Color;

//import java.util.Arrays;
//import java.util.Iterator;
//import java.util.concurrent.TimeUnit;
//import bot.controller.BotController;

import com.Cardinal.CommandPackage.Commands.ICommand;
import com.Cardinal.CommandPackage.Exceptions.MissingArgumentsException;

import bot.controller.BotController;
import sx.blah.discord.handle.impl.events.guild.channel.message.MessageReceivedEvent;
//import sx.blah.discord.handle.obj.IMessage;
//import sx.blah.discord.handle.obj.IMessage;
//import sx.blah.discord.handle.obj.IUser;
//import sx.blah.discord.util.MessageHistory;
//import sx.blah.discord.util.EmbedBuilder;
import sx.blah.discord.util.MissingPermissionsException;

public class RockPaperScissors implements ICommand 
{
	//private Color red;
	//private Color blue;
	//private EmbedBuilder embedRPS;
	public static boolean running;
	private String [] choice;
	private int random;
	private BotController botControl;
	private String gameEvent;
	
	public RockPaperScissors()
	{
		//red = Color.RED;
		//blue = Color.blue;
		///embedRPS = new EmbedBuilder();
		choice = new String[] {"rock", "paper", "scissors"};
		botControl = new BotController();
		random = 0;
		gameEvent = "";
	}

	@Override
	public void execute(MessageReceivedEvent event, String[] args)
			throws MissingPermissionsException, MissingArgumentsException 
	{
		//startComplexity
			if (args[0].equals("rps") && args.length < 2)
			{
				if (running == true)
				{
					botControl.messageSend("The game is already running.", event);
				}
				
				else
				{
					botControl.messageSend("Choose either //rps rock, //rps paper, or //rps scissors.", event);
					running = true;
				}
				
				
			}
			
			else if (args.length == 2 && running == true)
			{
				gameEvent = args[1].toLowerCase();
				
				while (running == true && !(gameEvent.isEmpty()))
				{
					switch (gameEvent)
					{
						case "rock":
							rock(event);
							break;
				
						case "paper":
							paper(event);
							break;
				
						case "scissors":
							scissors(event);
							break;
				
						default:
							System.out.println("Something broke.");
							break;
					}
				}
			}
			
			else
			{
				//event.getChannel().sendMessage("You did not enter arguments correctly. Either just say rps or rps <@user>.");
				//throw new MissingArgumentsException(getName() + "You must say //rps or //rps <choice>");
				botControl.messageSend("You must say //rps or //rps <choice>.", event);
			}
			
			//endComplexity
				
	}
	
	
	public int randomChoice()
	{
		random = (int) (Math.random() * 2);
		
		return random;
	}
	
	public void rock(MessageReceivedEvent event)
	{
		if (choice[randomChoice()].equals("rock"))
		{
			botControl.messageSend("You tied. :full_moon: vs :full_moon: Rock does not beat rock.", event);
			gameEvent = "";
		}
		
		else if (choice[randomChoice()].equals("paper"))
		{
			botControl.messageSend("You lost. :full_moon vs :newspaper: Rock does not beat paper.", event);
			RockPaperScissors.running = false;
		}
		
		else if (choice[randomChoice()].equals("scissors"))
		{
			botControl.messageSend("You won. :full_moon: vs :scissors: Nicely done, smash those scissors.", event);
			RockPaperScissors.running = false;
		}
	}
	
	public void paper(MessageReceivedEvent event)
	{
		
		if (choice[randomChoice()].equals("rock"))
		{
			botControl.messageSend("You won. :newspaper: vs :full_moon: You beat them with paper.", event);
			RockPaperScissors.running = false;
		}
		
		else if (choice[randomChoice()].equals("paper"))
		{
			botControl.messageSend("You tied. :newspaper: vs :newspaper: You can't beat paper with paper.", event);
			gameEvent = "";
		}
		
		else if (choice[randomChoice()].equals("scissors"))
		{
			botControl.messageSend("You lost. :newspaper: :scissors: Nice try bud. Paper does not beat scissors.", event);
			RockPaperScissors.running = false;
		}
	}
	
	public void scissors(MessageReceivedEvent event)
	{
		
		if (choice[randomChoice()].equals("rock"))
		{
			botControl.messageSend("You lost. :scissors: vs :full_moon: Scissors against rock? Oh no...", event);
			RockPaperScissors.running = false;
		}
		
		else if (choice[randomChoice()].equals("paper"))
		{
			botControl.messageSend("You won. :scissors: vs :newspaper: Congrats, you cut it.", event);
			RockPaperScissors.running = false;
		}
		
		else if (choice[randomChoice()].equals("scissors"))
		{
			botControl.messageSend("You tied. :scissors: vs :scissors: Sadly, scissors hitting scissors sounds terrible.", event);
			gameEvent = "";
		}
	}
	
	

	@Override
	public String getDescription() 
	{
		return 	"**" + getName().toUpperCase() + "**"
				+ "\n" + "This command lets you play rock, paper, scissors with the bot. To use this command"
				+ "\n" + "you must say \"//rps\" then afterwards you may either choose \"//rps rock\", "
				+ "\n" + "\"//rps paper\", or \"//rps rock\" till the game ends.";
	}

	@Override
	public String getName() 
	{
		return "rps";
	}
	
//	public String getTitle()
//	{
//		return "Rock Paper Scissors";
//	}
	
//	public void buildRPS(String title, String content, String desc, Color colour, MessageReceivedEvent event)
//	{
//		embedRPS.clearFields();
//		
//		embedRPS.withDesc(desc);
//		embedRPS.withColor(colour);
//		embedRPS.appendField(title, content, true);
//		
//		botControl.messageEmbed(embedRPS, event);
//	}

}
