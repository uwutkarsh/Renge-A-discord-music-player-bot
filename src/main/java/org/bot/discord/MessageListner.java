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

        String prefix_1 = "renge";
        String prefix_2 = "ren";
        //this returns me a string
        if (event.isFromGuild()) {
            String content = event.getMessage().getContentRaw(); //get the message content
            System.out.println(content);   //DEBUG
            StringBuilder contentBuilder = new StringBuilder(content.toLowerCase().trim()); //create a string builder to manipulate the content
            System.out.println(contentBuilder);   //DEBUG
            boolean boolContentCheckFinal_1=contentBuilder.toString().startsWith(prefix_1); //boolean to check if prefix_1 is present
            boolean boolContentCheckFinal_2=contentBuilder.toString().startsWith(prefix_2); //boolean to check if prefix_2 is present

            if (boolContentCheckFinal_1 || boolContentCheckFinal_2) {

                // ill get the member
                Member member = event.getMember(); // got the member
                AudioChannel channel = member.getVoiceState().getChannel(); //get the channel
                if (channel != null){  //determines if the message was from the voice channel or not
                    AudioManager audioManager = event.getGuild().getAudioManager();  //get the audio manager
                      audioManager.openAudioConnection(channel);  //creates the connection to voice channel
                    //extract the message and check for the prefix and pass it to command parser
                  if (boolContentCheckFinal_1){
                      //do the renge thing
                      String command = content.substring(prefix_1.length()); //pass it to command parser while its free from prefix_1
                      System.out.println(command); //DEBUG
                        commandParser(command,event); //call the command parser with the command and event

                  }else if(boolContentCheckFinal_2){
                      //do the ren thing
                      String command = content.substring(prefix_2.length()); //pass it to command parser while its free from prefix_2
                      System.out.println(command); //DEBUG
                      commandParser(command,event);

                  }







//                    if (content.contains("hello")) {
//                        event.getChannel().sendMessage("HELLOW MY :3").queue();
//                    } else if (content.contains("play")) {
//                        event.getChannel().sendMessage("Playing :3").queue();
//                    }

                }








            }




        }



    }
    public static  void commandParser(String command,MessageReceivedEvent event){
        //here it recieves everything after the prefix
         // commands = play/pause
       StringBuilder trimCommand= new StringBuilder(command.trim()); //trim it to remove any leading or trailing spaces
        //can i make switch case right here?
      String playCommand = "play";
      String  pauseCommand= "pause";
        //logic for play
        String commandInterpreter = trimCommand.toString().toLowerCase();  //this had the final command with the link
        if (commandInterpreter.startsWith(playCommand)){
            String link = command.substring(playCommand.length()).strip();
            System.out.println(link);//get the link after the play command
            event.getChannel().sendMessage(link).queue();
            //now this one will get the link with it
            //alright i dont know how to pass the link :P

        return;
        } else if (commandInterpreter.startsWith(pauseCommand)) {
            event.getChannel().sendMessage("pausing pausing hehe").queue();
            return;
        }


        //now i have to parse the info








    }
    public String passLink(String command){  //use it to pass it into the audio player manager to get the links
        command.trim();//trim it //created a new string object too fucker

    return command;
    }


}
