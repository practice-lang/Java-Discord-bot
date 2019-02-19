package commands;

import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import star.setting;
import net.dv8tion.jda.core.EmbedBuilder;
import java.awt.Color;



public class embed extends ListenerAdapter{
		public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
			String[] args = event.getMessage().getContentRaw().split(" ");
		    
		if(args[0].equalsIgnoreCase(setting.prefix + "embed")){
			 if (event.getAuthor().isBot()) return;

		if(!event.getMember().getUser().isBot()) {
			EmbedBuilder eb = new EmbedBuilder();
			eb.setTitle("しし", null);
			eb.setColor(Color.red);
			eb.addField("しし", "しし", false);
			eb.setFooter("緋", event.getMember().getUser().getAvatarUrl());
			//eb.addBlankField(false);
			event.getChannel().sendMessage(eb.build()).queue();
		}	
		}
		}
}
