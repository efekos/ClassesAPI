package dev.efekos.classes.api.i;

import org.bukkit.event.Event;

/**
 * Main interface used by {@link dev.efekos.classes.api.registry.LevelCriteriaRegistry}.
 */
public interface ILevelCriteria {
    /**
     * Should return true if all the conditions are met in the event given. If returns true, player will earn class exp.
     *
     * @param event Main event that caused this method to be executed, probably through a {@link dev.efekos.classes.api.event.CriteriaCheckEvent}.
     * @return {@code true} if all the conditions are met.
     */
    boolean shouldGiveExp(Event event);
}
