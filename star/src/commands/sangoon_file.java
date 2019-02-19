package commands;


import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import star.setting;

public class sangoon_file extends ListenerAdapter{

	public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
		String[] args = event.getMessage().getContentRaw().split(" ");
    
	if(args[0].equalsIgnoreCase(setting.prefix + "»ê±º")){
		 if (event.getAuthor().isBot()) return;
		   event.getChannel().sendMessage("https://cdn.discordapp.com/attachments/543005105281302528/545950788925652993/unknown.png").queue();


	//https://cdn.discordapp.com/attachments/543005105281302528/545950788925652993/unknown.png
	}
	}
}

