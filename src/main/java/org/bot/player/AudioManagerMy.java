package org.bot.player;

import com.sedmelluq.discord.lavaplayer.player.AudioLoadResultHandler;
import com.sedmelluq.discord.lavaplayer.player.AudioPlayer;
import com.sedmelluq.discord.lavaplayer.player.AudioPlayerManager;
import com.sedmelluq.discord.lavaplayer.player.DefaultAudioPlayerManager;
import com.sedmelluq.discord.lavaplayer.source.AudioSourceManagers;
import com.sedmelluq.discord.lavaplayer.tools.FriendlyException;
import com.sedmelluq.discord.lavaplayer.track.AudioPlaylist;
import com.sedmelluq.discord.lavaplayer.track.AudioTrack;
import net.dv8tion.jda.api.audio.AudioSendHandler;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class AudioManagerMy {

     private static AudioManagerMy INSTANCE;
private static  AudioPlayerManager playerManager = new DefaultAudioPlayerManager();
    static {
        AudioSourceManagers.registerRemoteSources(playerManager);
    }


 public static void doIt(String link , MessageReceivedEvent event){
     AudioPlayer player = playerManager.createPlayer();
     AudioSendHandler handler  = new AudioPlayerHandler(player);
     event.getGuild().getAudioManager().setSendingHandler(handler);
     playerManager.loadItem(link, new AudioLoadResultHandler() {
         @Override
         public void trackLoaded(AudioTrack track) {
             event.getChannel().sendMessage("Now playing:"+ track.getInfo().title).queue();
                player.playTrack(track);

         }

         @Override
         public void playlistLoaded(AudioPlaylist playlist) {

         }

         @Override
         public void noMatches() {

         }

         @Override
         public void loadFailed(FriendlyException exception) {

         }
     });


 }







}
