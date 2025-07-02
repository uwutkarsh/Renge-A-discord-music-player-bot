package org.bot.main;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.JDA;
import io.github.cdimascio.dotenv.Dotenv;
import net.dv8tion.jda.api.requests.GatewayIntent;
import org.bot.discord.MessageListner;


public class Main {


    public static void main(String[] args) {

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
        jda.addEventListener(new MessageListner());




        }

    }
