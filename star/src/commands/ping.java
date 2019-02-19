package commands;


import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import star.setting;

public class ping extends ListenerAdapter{
		public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
			String[] args = event.getMessage().getContentRaw().split(" ");
	    
		if(args[0].equalsIgnoreCase(setting.prefix + "핑")){
			
		if(!event.getMember().getUser().isBot()) {
		event.getChannel().sendMessage("핑은 `" + event.getJDA().getPing() + "ms` 입니다!").queue();
		}
		}
		}
}
