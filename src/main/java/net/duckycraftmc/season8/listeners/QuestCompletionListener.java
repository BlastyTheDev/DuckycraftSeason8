package net.duckycraftmc.season8.listeners;

import net.duckycraftmc.season8.Duckycraft;
import net.duckycraftmc.season8.events.QuestCompleteEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class QuestCompletionListener implements Listener {

    private final Duckycraft plugin;

    public QuestCompletionListener(Duckycraft plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onQuestCompleted(QuestCompleteEvent e) {
    }

}
