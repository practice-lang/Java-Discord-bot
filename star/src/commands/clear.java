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
          	  error.setTitle("에러");
          	  error.setDescription("3~100 사이로 입력해주세요");
    		event.getChannel().sendMessage(error.build()).queue();
			}
			else {
				try {
					List<Message> messages = event.getChannel().getHistory().retrievePast(Integer.parseInt(args[1])).complete();
					event.getChannel().deleteMessages(messages).queue();
					event.getChannel().sendMessage(args[1] + "만큼 삭제 했습니다").complete().delete().queueAfter(1, TimeUnit.SECONDS);
				}
				catch (IllegalArgumentException e) {
                      if(e.toString().startsWith("java.lang.IllegalArgumentException: Message retrieval")) {
                    	  //많은 메세지 
                    	  EmbedBuilder error = new EmbedBuilder();
                    	  error.setColor(Color.red);
                    	  error.setTitle("에러");
                    	  error.setDescription("1~100 사이로 입력해주세요");
              			event.getChannel().sendMessage(error.build()).queue();
                      }
                      else { 
                     	  EmbedBuilder error = new EmbedBuilder();
                    	  error.setColor(Color.red);
                    	  error.setTitle("에러");
                    	  error.setDescription("3~100사이로 해주세요");
              			event.getChannel().sendMessage(error.build()).queue();
                    	  
                      }
                      }
				}

			}else {
				event.getChannel().sendMessage(event.getAuthor().getName()+ " 님은 메세지 권한이 없습니다").queue();
			}
		}
	}

}
