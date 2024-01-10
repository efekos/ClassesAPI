package dev.efekos.classes.api.event;

import dev.efekos.classes.api.i.ILevelCriteria;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.checkerframework.checker.nullness.qual.NonNull;

/**
 * An event called by Classes plugin, whenever someone is about to get class exp.
 */
public final class CriteriaCheckEvent extends Event implements Cancellable {
    public static final HandlerList handlers = new HandlerList();

    /**
     * Main player that is about to earn class exp.
     */
    private final Player player;
    /**
     * Criteria that player has.
     */
    private final ILevelCriteria criteria;
    /**
     * Main event that caused this event to be called. Can be any event that is something about a player did, usually {@link org.bukkit.event.player.PlayerEvent}s.
     */
    private final Event mainEvent;


    /**
     * Constructs a new event.
     *
     * @param player    Player that is about to get class exp.
     * @param criteria  Criteria of the class player is in.
     * @param mainEvent Main event that caused this event to be called.
     */
    public CriteriaCheckEvent(Player player, ILevelCriteria criteria, Event mainEvent) {
        this.player = player;
        this.criteria = criteria;
        this.mainEvent = mainEvent;
    }


    /**
     * Constructs a new event.
     *
     * @param isAsync   Is this event going to be asynchronous?
     * @param player    Player that is about to get class exp.
     * @param criteria  Criteria of the class player is in.
     * @param mainEvent Main event that caused this event to be called.
     */
    public CriteriaCheckEvent(boolean isAsync, Player player, ILevelCriteria criteria, Event mainEvent) {
        super(isAsync);
        this.player = player;
        this.criteria = criteria;
        this.mainEvent = mainEvent;
    }

    /**
     * Returns the main player of this event.
     *
     * @return Main player that is about to earn class exp.
     */
    public Player getPlayer() {
        return player;
    }

    private boolean cancelled = false;

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public void setCancelled(boolean b) {
        cancelled = b;
    }

    /**
     * Returns the criteria that player should meet for Class exp.
     *
     * @return Criteria of the class that player is in.
     */
    public ILevelCriteria getCriteria() {
        return criteria;
    }

    /**
     * Returns the main event that caused this event to be called.
     *
     * @return The main event.
     */
    public Event getMainEvent() {
        return mainEvent;
    }

    @NonNull
    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}
