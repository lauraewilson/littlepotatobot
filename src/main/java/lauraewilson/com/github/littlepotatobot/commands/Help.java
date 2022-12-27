package lauraewilson.com.github.littlepotatobot.commands;

import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.MessageCreateListener;

import lauraewilson.com.github.littlepotatobot.Main;

public class Help implements MessageCreateListener {
	
	public void onMessageCreate(MessageCreateEvent message) {
		if (message.getMessageContent().equalsIgnoreCase(Main.PREFIX + "help")) {
        	message.getChannel().sendMessage("These are the available commands:\n!choose\n!ping\n!madlibs (not yet functional)");
        }
	}

}
