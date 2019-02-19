package commands;

import java.awt.Color;
import java.util.List;
import java.util.concurrent.TimeUnit;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import star.setting;

public class clear extends ListenerAdapter {
	public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
		String[] args = event.getMessage().getContentRaw().split("\\s+");
		if(args[0].equalsIgnoreCase(setting.prefix + "clear")){
			 if (event.getMember().hasPermission(Permission.MESSAGE_MANAGE)) {
			if(args.length < 2) {
				//TODO error
          	  EmbedBuilder error = new EmbedBuilder();
          	  error.setColor(Color.red);
          	  error.setTitle("����");
          	  error.setDescription("3~100 ���̷� �Է����ּ���");
    		event.getChannel().sendMessage(error.build()).queue();
			}
			else {
				try {
					List<Message> messages = event.getChannel().getHistory().retrievePast(Integer.parseInt(args[1])).complete();
					event.getChannel().deleteMessages(messages).queue();
					event.getChannel().sendMessage(args[1] + "��ŭ ���� �߽��ϴ�").complete().delete().queueAfter(1, TimeUnit.SECONDS);
				}
				catch (IllegalArgumentException e) {
                      if(e.toString().startsWith("java.lang.IllegalArgumentException: Message retrieval")) {
                    	  //���� �޼��� 
                    	  EmbedBuilder error = new EmbedBuilder();
                    	  error.setColor(Color.red);
                    	  error.setTitle("����");
                    	  error.setDescription("1~100 ���̷� �Է����ּ���");
              			event.getChannel().sendMessage(error.build()).queue();
                      }
                      else { 
                     	  EmbedBuilder error = new EmbedBuilder();
                    	  error.setColor(Color.red);
                    	  error.setTitle("����");
                    	  error.setDescription("3~100���̷� ���ּ���");
              			event.getChannel().sendMessage(error.build()).queue();
                    	  
                      }
                      }
				}

			}else {
				event.getChannel().sendMessage(event.getAuthor().getName()+ " ���� �޼��� ������ �����ϴ�").queue();
			}
		}
	}

}
