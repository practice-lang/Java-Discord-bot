package commands;


import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import star.setting;

public class botinfo extends ListenerAdapter{
	public void onGuildMessageReceived(GuildMessageReceivedEvent e) {
		String[] message = e.getMessage().getContentRaw().split(" ");
		if(message[0].equalsIgnoreCase(setting.prefix + "botinfo")){
		e.getChannel().sendMessage("`" + e.getJDA().getGuilds().size() + "` 서버`" + e.getJDA().getUsers().size() + "` 유저`" + e.getJDA().getTextChannels().size() + "` 채팅 채널`" + e.getJDA().getVoiceChannels().size() + "` 음성채널`" + e.getJDA().getRoles().size() + "` 역할`" + e.getJDA().getEmotes().size() + "` 이모지`" + e.getJDA().getCategories().size() + "` 카테고리").queue();
				}
		}


		

}
