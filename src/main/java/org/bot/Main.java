package org.bot;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import io.github.cdimascio.dotenv.Dotenv;
import net.dv8tion.jda.api.requests.GatewayIntent;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {


    public static void main(String[] args) {
//        String s = "fuck my ass ";
        Dotenv dotenv =Dotenv.load();
      final String Token =   dotenv.get("DISCORD_TOKEN");

        JDA jda = JDABuilder.createDefault(Token).enableIntents(GatewayIntent.MESSAGE_CONTENT).build();

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
    class MessageLister extends ListenerAdapter {

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
//                String channelId =event.getChannel().getId();

                    if (content.toLowerCase().startsWith(prefix1) || content.toLowerCase().startsWith(prefix2)) {

                        // i have my content here
                        if (content.contains("hello")) {
                            event.getChannel().sendMessage("HELLOW MY :3").queue();
                        } else if (content.contains("play")) {
                            event.getChannel().sendMessage("Playing :3").queue();
                        }

                    }




            }

            //we make a funntion

        }
    }