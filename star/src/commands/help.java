package commands;



import java.awt.Color;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import star.setting;

public class help extends ListenerAdapter{

	public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
		String[] args = event.getMessage().getContentRaw().split("\\s+");
	if(args[0].equalsIgnoreCase(setting.prefix + "help")){
		 if (event.getAuthor().isBot()) return;
		 event.getAuthor().openPrivateChannel().queue(channel -> {
				EmbedBuilder eb = new EmbedBuilder();
				eb.setTitle("모든 명령어", null);
				eb.setColor(Color.red);
				eb.addField("`산군", "산군이라는 사람을 보는 거임", false);
				eb.addField("`changelog", "업데이트 내역 확인", false);
				eb.addField("`ping", "핑 확인", false);
				eb.addField("`online", "서버 온라인 확인", false);
				eb.addField("`userinfo", "유저 정보 확인", false);
				eb.addField("`serverinfo", "서버 정보 확인", false);
				eb.addField("`invite", "초대링크 만들기", false);
				eb.addField("`embed", "테스트 용", false);
				eb.addField("`clear", "3~100까지 가능합니다", false);
				eb.setFooter("JAVA TEST", event.getMember().getUser().getAvatarUrl());
				//eb.addBlankField(false);
	                channel.sendMessage(eb.build()).queue(); 
	                event.getChannel().sendMessage("DM 확인해주세요").queue();
	            });
	    }       
	
	}
}


