package bot.controller;

import com.Cardinal.CommandPackage.Proccessor.EventListener;

// This listens to messages with a specific prefix.
public class BotListener extends EventListener 
{
	public BotListener(String prefix)
	{
		super(prefix);
	}
}
