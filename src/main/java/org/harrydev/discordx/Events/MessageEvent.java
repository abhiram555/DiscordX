package org.harrydev.discordx.Events;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.TextChannel;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.harrydev.discordx.DiscordX;

import java.awt.*;
import java.util.Objects;

public class MessageEvent implements Listener {
    private static final DiscordX INSTANCE = DiscordX.getInstance();

    FileConfiguration config;
    JDA bot;
    TextChannel textChannel;

    public MessageEvent(JDA jda) {
        this.bot = jda;
        this.config = INSTANCE.getConfig();
        textChannel = jda.getTextChannelById(INSTANCE.getConfig().getLong("chatChannel"));
    }

    @EventHandler
    public void OnPlayerMessage(AsyncPlayerChatEvent event) {
        event.getPlayer();
        event.getMessage();
        textChannel.sendMessage(Objects.requireNonNull(config.getString("discordToMinecraft")).replace("%player%", event.getPlayer().getName()).replace("%message%", event.getMessage())).queue();
    }
}