package commands;


import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import star.setting;

public class botinfo extends ListenerAdapter{
	public void onGuildMessageReceived(GuildMessageReceivedEvent e) {
		String[] message = e.getMessage().getContentRaw().split(" ");
		if(message[0].equalsIgnoreCase(setting.prefix + "botinfo")){
		e.getChannel().sendMessage("`" + e.getJDA().getGuilds().size() + "` ����`" + e.getJDA().getUsers().size() + "` ����`" + e.getJDA().getTextChannels().size() + "` ä�� ä��`" + e.getJDA().getVoiceChannels().size() + "` ����ä��`" + e.getJDA().getRoles().size() + "` ����`" + e.getJDA().getEmotes().size() + "` �̸���`" + e.getJDA().getCategories().size() + "` ī�װ�").queue();
				}
		}


		

}
