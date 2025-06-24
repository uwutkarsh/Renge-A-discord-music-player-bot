package org.bot;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    private  static final String Token ="";
    public static void main(String[] args) {
//        String s = "fuck my ass ";
        JDA jda = JDABuilder.createDefault(Token).build();
        try {
            jda.awaitReady();
            System.out.println("Bot is connected ");
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);

        }
        jda.addEventListener(new MessageLister());
//        System.out.println("dont fuck with me  :3");

        // to see how IntelliJ IDEA suggests fixing it.



        }

    }
    class MessageLister extends ListenerAdapter{
        @Override
        public void onButtonInteraction(ButtonInteractionEvent event) {
            super.onButtonInteraction(event);
        }

        public  void onMessageReceived(MessageReceivedEvent event){
                if (event.getAuthor().isBot()){return;}
                if (event.getMessage().getContentRaw().equals("!ping")){
                    event.getChannel().sendMessage("Pong").queue();
                }



            }
    }

