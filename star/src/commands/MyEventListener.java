package commands;

import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import star.setting;
public class MyEventListener extends ListenerAdapter{
	public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
		String[] args = event.getMessage().getContentRaw().split(" ");
		
		if(args[0].equalsIgnoreCase(setting.prefix + "¾È³ç")) {
			if(!event.getMember().getUser().isBot()) {
			event.getChannel().sendMessage("¾È³ç" + event.getMember().getUser().getName() + " !").queue();
			}
		}

	}


}
