package commands;

import java.util.HashMap;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import star.setting;

public class expSystem extends ListenerAdapter{
	HashMap<Member, Integer> playerXp = new HashMap<>();
	HashMap<Member, Integer> playerTimer = new HashMap<>();
	public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
		String[] args = event.getMessage().getContentRaw().split(" ");
		String command = args[0];
		
		if(command.equalsIgnoreCase(setting.prefix + "xp")) {
			event.getChannel().sendMessage("당신은 `" + getPlayerXp(event.getMember()) + "` xp 가지고 있습니다").queue();
		}
      if(canGetXp(event.getMember())) {
         randXp(event.getMember());
         setPlayerTime(event.getMember(), 60);
         
      }
	}
	private int getPlayerXp (Member member) {
		return playerXp.get(member);
	}
	
	private void setPlayerXp (Member member, int num) {
		playerXp.put(member, num);
	}
	
	private int getPlayerTime (Member member) {
		return playerTimer.get(member);
	}
	private void setPlayerTime (Member member, int num) {
		 playerTimer.put(member, num);
	}
	private void randXp (Member member) {
		Random r = new Random();
		if(!playerXp.containsKey(member))
			setPlayerXp(member, 0);
		setPlayerXp(member, getPlayerXp(member) + r.nextInt(25));
	}

	 private boolean canGetXp(Member member) {
		 if(!playerTimer.containsKey(member)) 
			       return true;
		 return false;
	 }
	 public void startTimer() {
		 Timer timer = new Timer();
		 TimerTask task = new TimerTask() {
			 @Override
			 public void run() {
				 for(Member member : playerTimer.keySet()) {
					 setPlayerTime(member, getPlayerTime(member) - 1);
				 }
			 }
		 };
		 timer.schedule(task, 1000, 1000);
	 }
	 
	// private void debug(String text) {
	//	 System.out.println(text);
	// }
}
