package commands;


import net.dv8tion.jda.core.OnlineStatus;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import star.setting;

public class online  extends ListenerAdapter{

	public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
		String[] args = event.getMessage().getContentRaw().split(" ");
    
	if(args[0].equalsIgnoreCase(setting.prefix + "online")){
		 if (event.getAuthor().isBot()) return;

		int onli1ne = 0;
		for(int i = 0; i < event.getGuild().getMembers().size(); i++) {
			if(event.getGuild().getMembers().get(i).getOnlineStatus() == OnlineStatus.ONLINE ||event.getGuild().getMembers().get(i).getOnlineStatus() == OnlineStatus.DO_NOT_DISTURB) {
				onli1ne ++;
			}
	}
            event.getChannel().sendMessage("이 서버에는 `" + onli1ne + "`명이 온라인입니다 그리고 멤버 수는 `" + event.getGuild().getMembers().size() + "`명입니다").queue();
	}
		}
}
	
	


