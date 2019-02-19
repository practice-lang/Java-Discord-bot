package star;

import commands.MyEventListener;
import commands.address;
import commands.botinfo;
import commands.clear;
import commands.embed;
import commands.expSystem;
import commands.help;
import commands.init;
import commands.invite;
import commands.mute;
import commands.online;
import commands.ping;
import commands.sangoon_file;
import commands.say;
import commands.serverlinfo;
import commands.serversetting;
import commands.userinfo;
import net.dv8tion.jda.core.AccountType;

import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.OnlineStatus;
import net.dv8tion.jda.core.entities.Game;
import net.dv8tion.jda.core.hooks.ListenerAdapter;


public class Main extends ListenerAdapter{
	private static JDA jda;
   public static void main(String[] args) throws Exception{
		jda = new JDABuilder(AccountType.BOT)
				.setToken(setting.Token)
				.buildBlocking();	
        jda.getPresence().setStatus(OnlineStatus.IDLE);
        jda.getPresence().setGame(Game.watching(setting.game));
		jda.addEventListener(new MyEventListener());
		jda.addEventListener(new ping());
		jda.addEventListener(new embed());
		jda.addEventListener(new clear());
		jda.addEventListener(new online());
		jda.addEventListener(new sangoon_file());
		jda.addEventListener(new log());
		jda.addEventListener(new help());
		jda.addEventListener(new invite());
		jda.addEventListener(new init());
		jda.addEventListener(new serverlinfo());
		jda.addEventListener(new userinfo());
		jda.addEventListener(new mute());
		jda.addEventListener(new say());
		jda.addEventListener(new botinfo());
		jda.addEventListener(new serversetting());
		jda.addEventListener(new address());
		jda.addEventListener(new expSystem());
		expSystem system = new expSystem();
		system.startTimer();
   }
//if(!event.getMember().getUser().isBot())
	
}//╬Ве╦юс
//C, C++, C#,php,python,java,javascript,html,css 
