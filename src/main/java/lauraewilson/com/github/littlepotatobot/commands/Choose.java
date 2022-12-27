package lauraewilson.com.github.littlepotatobot.commands;

import java.util.Scanner;

import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.MessageCreateListener;

import lauraewilson.com.github.littlepotatobot.Main;

public class Choose implements MessageCreateListener {
	
	public void onMessageCreate(MessageCreateEvent message) {
		if (message.getMessageContent().toLowerCase().startsWith(Main.PREFIX + "choose")) {
        	String choose = message.getMessageContent();
        	Scanner stringParser = new Scanner(choose);
        	stringParser.next();
        	String itemOne = stringParser.next();
        	stringParser.next();
        	String itemTwo = stringParser.next();
        	int randomNumber = (int)(Math.random() * 10);
            if (randomNumber % 2 == 0) {
            	message.getChannel().sendMessage("I choose... **" + itemOne + "**!");
            }
            else {
            	message.getChannel().sendMessage("I choose... **" + itemTwo + "**!");
            }
            stringParser.close();
        }
	}

}
