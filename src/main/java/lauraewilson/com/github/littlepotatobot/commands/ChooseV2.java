package lauraewilson.com.github.littlepotatobot.commands;

import java.util.Optional;
import org.javacord.api.event.interaction.SlashCommandCreateEvent;
import org.javacord.api.listener.interaction.SlashCommandCreateListener;

public class ChooseV2 implements SlashCommandCreateListener {

	@Override
	// alternative option: "choose" command using slash commands
	public void onSlashCommandCreate(SlashCommandCreateEvent event) {
		if (event.getSlashCommandInteraction().getCommandName().equalsIgnoreCase("choose") ) {
			Optional<String> optionOne = event.getSlashCommandInteraction().getOptionStringRepresentationValueByName("option1");
			Optional<String> optionTwo = event.getSlashCommandInteraction().getOptionStringRepresentationValueByName("option2");
			int randomNumber = (int)(Math.random() * 10);
            if (randomNumber % 2 == 0) {
            	event.getInteraction().createImmediateResponder().setContent("I choose... **" + optionOne.get() + "**!").respond();
            }
            else {
            	event.getInteraction().createImmediateResponder().setContent("I choose... **" + optionTwo.get() + "**!").respond();
            }

		}
		
	}

}
