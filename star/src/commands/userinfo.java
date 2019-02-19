package commands;


import java.awt.Color;
import java.time.format.DateTimeFormatter;

import language.en_us;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import star.setting;

public class userinfo extends ListenerAdapter{
	public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
		String[] arg = event.getMessage().getContentRaw().split(" ");
		if(arg[0].equalsIgnoreCase(setting.prefix + "userinfo")){

			DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			EmbedBuilder eb = new EmbedBuilder();
			eb.setTitle(en_us.userinfo1, null);
			eb.setColor(Color.red);
			eb.addField(en_us.userinfo2, event.getAuthor().getName(), true);
			eb.addField("아이디", event.getAuthor().getId(), true);
			eb.addField("맨션", event.getAuthor().getAsMention(), true);
			eb.addField("태그", event.getAuthor().getDiscriminator(), true);
			eb.addField("아바타 아이디", event.getAuthor().getAvatarId(), true);
			eb.addField("일반 아바타 아이디", event.getAuthor().getDefaultAvatarId(), true);
			eb.addField("아바타 URL", "[클랙해보세요 에베베베]("+ event.getAuthor().getAvatarUrl() + ")", true);
			eb.addField("만든 시각", event.getAuthor().getCreationTime().format(fmt), true);
			eb.setThumbnail(event.getMember().getUser().getAvatarUrl());
			eb.setFooter("JAVA TEST", event.getMember().getUser().getAvatarUrl());
                event.getChannel().sendMessage(eb.build()).queue(); 
			
		}
		}
}
