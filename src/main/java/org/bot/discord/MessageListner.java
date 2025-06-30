package org.bot.discord;

import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.channel.middleman.AudioChannel;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.managers.AudioManager;

public class MessageListner  extends ListenerAdapter {
    @Override
    public void onButtonInteraction(ButtonInteractionEvent event) {
        super.onButtonInteraction(event);
    }
    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if (event.getAuthor().isBot()) {
            return;
        }

        String prefix1 = "renge";
        String prefix2 = "ren";
        //this returns me a string
        if (event.isFromGuild()) {
            String content = event.getMessage().getContentRaw();


            if (content.toLowerCase().startsWith(prefix1) || content.toLowerCase().startsWith(prefix2)) {

                // ill get the memember
                Member member = event.getMember(); // got the member
                AudioChannel channel = member.getVoiceState().getChannel(); //get the channel
                if (channel != null){  //determines if the message was from the voice channel or not
                    AudioManager audioManager = event.getGuild().getAudioManager();  //get the audio manager

                    audioManager.openAudioConnection(channel);  //creates the connection to voice channel
                    if (content.contains("hello")) {
                        event.getChannel().sendMessage("HELLOW MY :3").queue();
                    } else if (content.contains("play")) {
                        event.getChannel().sendMessage("Playing :3").queue();
                    }

                }








            }




        }

        //we make a funntion

    }


}
