package commands;


import audioCore.TrackManager;

import com.sedmelluq.discord.lavaplayer.player.AudioPlayer;
import com.sedmelluq.discord.lavaplayer.player.AudioPlayerManager;
import com.sedmelluq.discord.lavaplayer.player.DefaultAudioPlayerManager;
import com.sedmelluq.discord.lavaplayer.source.AudioSourceManagers;
import net.dv8tion.jda.core.entities.*;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import java.util.*;

public class Music extends ListenerAdapter{
 private static final int PLAYLIST_LIMIT = 1000;
 private static Guild guild;
 private static final AudioPlayerManager MANGER = new DefaultAudioPlayerManager();
 private static final Map<Guild, Map.Entry<AudioPlayer, TrackManager>> PLAYERS = new HashMap<>(); 
 
 
 public Music() {
	 AudioSourceManagers.registerRemoteSources(MANGER);
 }

 //private AudioPlayer createPlayer(Guild guild) {
    // AudioPlayer nPlayer = myManager.createPlayer();
    // TrackManager manager = new TrackManager(nPlayer);
    // nPlayer.addListener(manager);
   //  guild.getAudioManager().setSendingHandler(new AudioPlayerSendHandler(nPlayer));
    // players.put(guild.getId(), new AbstractMap.SimpleEntry<>(nPlayer, manager));
//     return nPlayer;
 //}

 
  public boolean called(String[] args, MessageReceivedEvent event) {
	return false;
  }
  public void action(String[] args, MessageReceivedEvent event) {
	  
  }
  public void executed(String[] args, MessageReceivedEvent event) {
	  
  }
  
  public String help() {
	  return null;
  }
}
