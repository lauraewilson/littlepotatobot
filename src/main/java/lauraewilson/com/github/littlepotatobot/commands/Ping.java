package lauraewilson.com.github.littlepotatobot.commands;

import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.MessageCreateListener;

import lauraewilson.com.github.littlepotatobot.Main;

public class Ping implements MessageCreateListener {
	
	public void onMessageCreate(MessageCreateEvent message) {
		if (message.getMessageContent().equalsIgnoreCase(Main.PREFIX + "ping")) {
	        message.getChannel().sendMessage("Pong!");
	    }
	}

}
