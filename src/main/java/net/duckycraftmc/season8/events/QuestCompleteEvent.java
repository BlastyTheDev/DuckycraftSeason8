package net.duckycraftmc.season8.events;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class QuestCompleteEvent extends Event {

    public QuestCompleteEvent() {
        super();
    }

    public QuestCompleteEvent(boolean isAsync) {
        super(isAsync);
    }

    @Override
    public boolean callEvent() {
        return super.callEvent();
    }

    @Override
    public @NotNull String getEventName() {
        return super.getEventName();
    }

    @Override
    public @NotNull HandlerList getHandlers() {
        return null;
    }

}
