package lauraewilson.com.github.littlepotatobot;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;
import org.javacord.api.entity.server.Server;
import org.javacord.api.interaction.SlashCommand;
import org.javacord.api.interaction.SlashCommandOption;

import lauraewilson.com.github.littlepotatobot.commands.Choose;
import lauraewilson.com.github.littlepotatobot.commands.ChooseV2;
import lauraewilson.com.github.littlepotatobot.commands.Help;
import lauraewilson.com.github.littlepotatobot.commands.MadLibs;
import lauraewilson.com.github.littlepotatobot.commands.Ping;

public class Main {
	
	public static final String PREFIX = "!";

	public static void main(String[] args) {
		
		Scanner fileInput;
		
		try {
			fileInput = new Scanner(new File("config.txt"));
		} catch (FileNotFoundException ex) {
			System.out.println("File not found. Error: " + ex.getMessage());
			return;
		}
		
		String token;
		
		if (fileInput.hasNext()) {
			token = fileInput.next();
		}
		else {
			System.out.println("File appears to be empty. Please add the token for your bot.");
			return;
		}
		
		DiscordApi api = new DiscordApiBuilder()
				.setToken(token)
				.setAllNonPrivilegedIntents()
				.login()
				.join();
		
		Server meAndYouServer = api.getServerById(993938521352044604L).get();
		
		api.addListener(new Ping());
		api.addListener(new Help());
		api.addListener(new Choose());
		api.addListener(new MadLibs());
		
		List<SlashCommandOption> chooseOptions = new ArrayList<>();
		
		chooseOptions.add(SlashCommandOption.createStringOption("option1", "First option to choose from", true));
		chooseOptions.add(SlashCommandOption.createStringOption("option2", "Second option to choose from", true));
	
		SlashCommand command = SlashCommand.with("choose", "Randomly chooses between two options", chooseOptions)
				.createForServer(meAndYouServer)
				.join();
		
		api.addSlashCommandCreateListener(new ChooseV2());
		
		// the following have been moved into separate classes, just keeping this here for reference
		/*
		api.addMessageCreateListener(event -> {
            if (event.getMessageContent().equalsIgnoreCase("!help")) {
            	event.getChannel().sendMessage("These are the available commands:\n!choose\n!ping");
            }
        });
		
		api.addMessageCreateListener(event -> {
		    if (event.getMessageContent().equalsIgnoreCase("!ping")) {
		        event.getChannel().sendMessage("Pong!");
		    }
		});
        
        api.addMessageCreateListener(event -> {
            if (event.getMessageContent().toLowerCase().startsWith("!choose")) {
            	String choose = event.getMessageContent();
            	Scanner stringParser = new Scanner(choose);
            	stringParser.next();
            	String itemOne = stringParser.next();
            	stringParser.next();
            	String itemTwo = stringParser.next();
            	int randomNumber = (int)(Math.random() * 10);
                if (randomNumber % 2 == 0) {
                	event.getChannel().sendMessage("I choose... **" + itemOne + "**!");
                }
                else {
                	event.getChannel().sendMessage("I choose... **" + itemTwo + "**!");
                }
                stringParser.close();
            }
        });
        */
        
        System.out.println("The bot is running!");
       
	}

}
