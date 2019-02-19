package commands;


import java.util.concurrent.TimeUnit;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.entities.TextChannel;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import star.setting;

public class invite extends ListenerAdapter{
	public void onGuildMessageReceived(GuildMessageReceivedEvent e) {
		String[] message = e.getMessage().getContentRaw().split(" ");
		if(message[0].equalsIgnoreCase(setting.prefix + "invite")) {
			sendErrorMessage(e.getChannel(), e.getMember());
			if (e.getMember().hasPermission(Permission.CREATE_INSTANT_INVITE)) {
			e.getChannel().sendMessage(e.getAuthor().getName()+ " ���� `" + e.getChannel().createInvite().complete().getURL() + "` �̰� ��������ϴ�").queue();
		}else {
			e.getChannel().sendMessage(e.getAuthor().getName()+ " ���� �ʴ븵ũ ������ �����ϴ�.").queue();
		}
}
	}
	public void sendErrorMessage(TextChannel channel, Member member) {
		EmbedBuilder builder = new EmbedBuilder();
		builder.setTitle("����");
		channel.sendMessage(builder.build()).complete().delete().queueAfter(15, TimeUnit.SECONDS);
	}
}
