package commands;








import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import star.setting;

public class say extends ListenerAdapter{
public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
	String[] args = event.getMessage().getContentRaw().split("\\s+");
    if(args[0].equalsIgnoreCase(setting.prefix + "say")){
    	if (event.getAuthor().getId().equals(setting.owner)) {
    	if(args.length <= 1) {
    		event.getChannel().sendMessage("하고 싶은 말 하세요").queue();
    	}else {
    		String reason = "";
    	    for(int i = 1; i < args.length; i++) {
    	    	reason += args[i] + " ";
    	    }
    	//    Emoji e = EmoteManager.ReactionEmoji("")
    	  //  message.addReaction(e);
    	    
    	    event.getChannel().sendTyping().queue();
    	    event.getChannel().sendMessage(reason).queue();
    	    
        
    	}
    	}else {
    		event.getChannel().sendMessage("당신은 봇을 만들지 않았어요<:ssi:543771731869958154>").queue();
    		return;
    	}  
  }

	
}
 }


//https://ci.dv8tion.net/job/JDA/javadoc/net/dv8tion/jda/core/requests/restaction/RoleAction.html
//https://ci.dv8tion.net/job/JDA/javadoc/net/dv8tion/jda/core/entities/Message.html#editMessage-net.dv8tion.jda.core.entities.Message-