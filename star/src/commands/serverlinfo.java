package commands;

import java.awt.Color;
import java.util.Arrays;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import star.setting;

public class serverlinfo extends ListenerAdapter{
	public void onGuildMessageReceived(GuildMessageReceivedEvent e) {
		String[] message = e.getMessage().getContentRaw().split(" ");
		if(message[0].equalsIgnoreCase(setting.prefix + "serverinfo")){
			 if (e.getAuthor().isBot()) return;
			String[] members = new String[e.getGuild().getMembers().size()];
			for(int i = 0;i<e.getGuild().getMembers().size();i++){
				members[i] = e.getGuild().getMembers().get(i).getEffectiveName();
			}
			String[] member1s = new String[e.getGuild().getRoles().size()];
			for(int i = 0;i<e.getGuild().getRoles().size();i++){
				member1s[i] = e.getGuild().getRoles().get(i).getName();
			}
			EmbedBuilder eb = new EmbedBuilder();
			eb.setAuthor(e.getGuild().getName());
			eb.setColor(Color.red);
			eb.addField("서버 주인",  e.getGuild().getOwner().getEffectiveName(), true);
			eb.addField("서버 이름",  e.getGuild().getName(), true);
			eb.setThumbnail(e.getGuild().getIconUrl());
			eb.addField("멤버 수", Integer.toString(e.getGuild().getMembers().size()), true);
			eb.addField("역할 수", Integer.toString(e.getGuild().getRoles().size()), true);
			eb.addField("지역", e.getGuild().getRegion().getName(), true);
			eb.addField("서버 아이디", e.getGuild().getId(), true);
			eb.setFooter("JAVA TEST", e.getMember().getUser().getAvatarUrl());
                e.getChannel().sendMessage(eb.build()).queue();
                //EmbedBuilder e2b = new EmbedBuilder();
                //e2b.addField("**멤버**", Arrays.toString(members), true);
            	//e2b.setColor(Color.red);
            	//e.getChannel().sendMessage(e2b.build()).queue();
                EmbedBuilder e1b = new EmbedBuilder();
                e1b.addField("**역할**", Arrays.toString(member1s), true);
            	e1b.setColor(Color.red);
                e.getChannel().sendMessage(e1b.build()).queue();

            }
		}
		
		}

