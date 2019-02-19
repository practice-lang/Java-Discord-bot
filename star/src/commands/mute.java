package commands;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import net.dv8tion.jda.core.entities.Role;


import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.entities.TextChannel;

import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import star.setting;

public class mute extends ListenerAdapter{
	public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
		String[] args = event.getMessage().getContentRaw().split("\\s+");
	if(args[0].equalsIgnoreCase(setting.prefix + "mute")){
	
		if (event.getMember().hasPermission(Permission.ADMINISTRATOR)) {

	  if(args.length <= 1) {
		  sendErrorMessage(event.getChannel(), event.getMember());
	  }else {
		  Member target = event.getMessage().getMentionedMembers().get(0);
		
		  Role muted = event.getGuild().getRolesByName("Muted", true).get(0);
		  
		  event.getGuild().getController().addRolesToMember(target, muted).queue();
		  if(args.length <= 2) {
			  sendErrorMessage(event.getChannel(), event.getMember());
		  }
		  if(args.length >= 3) {
			  String reason = "";
			  for(int i = 2; i < args.length; i++) {
				  reason += args[i] + " ";
			  }
			 log(target, event.getMember(), reason, event.getChannel());
		  }else {
			 log(target, event.getMember(), "", event.getChannel());
		  }
	  }
	}else {
		event.getChannel().sendMessage(event.getAuthor().getName()+ " 님은 관리자 권한이 없습니다.").queue();
	}
	}
   }
	public void sendErrorMessage(TextChannel channel, Member member) {
		EmbedBuilder builder = new EmbedBuilder();
		builder.setTitle("에러");
		channel.sendMessage(builder.build()).complete().delete().queueAfter(15, TimeUnit.SECONDS);
	}
	
	
	public void log(Member muted, Member muter, String reason, TextChannel channel) {
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		SimpleDateFormat stf = new SimpleDateFormat("HH:mm:ss");
		Date date = new Date(System.currentTimeMillis());
		EmbedBuilder builder1 = new EmbedBuilder();
		builder1.setTitle("뮤트");
		builder1.addField("뮤트 된 유저", muted.getAsMention(), false);
		builder1.addField("뮤트한 유저", muter.getAsMention(), false);
		builder1.addField("데이터", sdf.format(date), false);
		builder1.addField("뮤트된 시각", stf.format(date), false);
		channel.sendMessage(builder1.build()).queue();
	}

}
