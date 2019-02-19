package commands;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import star.setting;

public class serversetting extends ListenerAdapter{

	public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
		String[] args = event.getMessage().getContentRaw().split("\\s+");
	if(args[0].equalsIgnoreCase(setting.prefix + "setting")){
		EmbedBuilder eb = new EmbedBuilder();
		eb.addField("º¿ ¼³Á¤", "<:on_1:546706527919144984> <:on_1:546706527919144984>", false);
		 event.getChannel().sendMessage(eb.build()).queue();
	}
	}

}
//<:on_1:546706527919144984> <:off:546706514484920330>