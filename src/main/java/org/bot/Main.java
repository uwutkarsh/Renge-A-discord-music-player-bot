package org.bot;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import io.github.cdimascio.dotenv.Dotenv;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {


    public static void main(String[] args) {
//        String s = "fuck my ass ";
        Dotenv dotenv =Dotenv.load();
      final String Token =   dotenv.get("DISCORD_TOKEN");

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
            String prefix1 = "renge";
            String prefix2=  "ren";
            String content = event.getMessage().getContentRaw(); //this returns me a string

            //so if content  got renge in it go forward or dont
            if (content.toLowerCase().startsWith(prefix1)){
                String command =  "hello";//  content.toLowerCase().substring(5,content.length());
                if (event.getMessage().getContentRaw().equals(command.toLowerCase())){ //passing a string
                    event.getChannel().sendMessage("HELLOW MY :3").queue();
                }

            }
                if (event.getAuthor().isBot()){return;}




            }
    }

