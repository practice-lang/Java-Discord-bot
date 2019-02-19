package commands;



import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import star.setting;

public class address extends ListenerAdapter{
	public void onGuildMessageReceived(GuildMessageReceivedEvent e) {
		String[] message = e.getMessage().getContentRaw().split(" ");
		if(message[0].equalsIgnoreCase(setting.prefix + "회공주소")){
			e.getChannel().sendMessage(""  + e.getGuild().getId() +"/" + e.getGuild().getVoiceChannels()).queue();
		}
		}

}
