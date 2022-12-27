package lauraewilson.com.github.littlepotatobot.commands;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import org.javacord.api.entity.message.Message;
import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.MessageCreateListener;
import lauraewilson.com.github.littlepotatobot.Main;

public class MadLibs implements MessageCreateListener {

	public void onMessageCreate(MessageCreateEvent message) {
		if (message.getMessageContent().equalsIgnoreCase(Main.PREFIX + "madlibs")) {
			// alternative option: drop down list
//			new MessageBuilder()
//		    .setContent("Choose a story!")
//		    .addComponents(
//		        ActionRow.of(SelectMenu.create("options", "Click here to show the options", 1, 1,
//		            Arrays.asList(SelectMenuOption.create("A dog's day at the park.", "You selected \"A dog's day at the park.\"!", "A dog's day at the park."),
//		                SelectMenuOption.create("A cat's adventure.", "You selected \"A cat's adventure.\"!", "A cat's adventure.")))))
//		    .send(message.getChannel());
			Message reply = message.getChannel()
					.sendMessage("Choose a story!\n1. A dog's day at the park.\n2. A cat's adventure.").join();
			reply.addReaction("1️⃣");
			reply.addReaction("2️⃣");

			reply.addReactionAddListener(reaction -> {
				try {
					if (!reaction.requestUser().get().isBot()) {
						if (reaction.getEmoji().equalsEmoji("1️⃣")) {
							reaction.getChannel().sendMessage("You've selected **A dog's day at the park.**");
						} else if (reaction.getEmoji().equalsEmoji("2️⃣")) {
							reaction.getChannel().sendMessage("You've selected **A cat's adventure.**");
						}
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ExecutionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}).removeAfter(5, TimeUnit.MINUTES);
		}
	}
}
