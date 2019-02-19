package commands;

import java.awt.Color;


import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import star.setting;

public class init extends ListenerAdapter{
	public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
		String[] message = event.getMessage().getContentRaw().split(" ");
		if(message[0].equalsIgnoreCase(setting.prefix + "changelog")){
			EmbedBuilder eb = new EmbedBuilder();
			eb.setTitle("changelog", null);
			eb.setColor(Color.red);
			eb.setDescription(setting.init);
			eb.setFooter(event.getMember().getUser().getName(), event.getMember().getUser().getAvatarUrl());
			 event.getChannel().sendMessage(eb.build()).queue();
		}     
	}
}
