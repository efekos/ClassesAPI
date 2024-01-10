package dev.efekos.classes.api.i;

import org.bukkit.entity.Player;

/**
 * Main interface of {@link dev.efekos.classes.api.registry.PerkRegistry}.
 */
public interface IPerk {
    /**
     * Grants this perk to someone. Classes will call this method everytime player levels up, and when the player joins
     * a class that contains this perk. This method doesn't have to handle the entire perk itself. You can put the
     * players with this perk to somewhere, then use that data to make this perk properly work.
     *
     * @param player Player that is in a class with this perk.
     * @param level  Class level of the player in that class.
     * @since 1.0
     */
    void grant(Player player, int level);

    /**
     * Removes all the effects that {@link #grant(Player, int)} did on the player given. Classes will call this method
     * when the player leaves his class.
     *
     * @param player Player that just leaved his class.
     * @since 1.0
     */
    void degrade(Player player);

    /**
     * Returns a description about this perk, that must follow the rules below.
     * <ul>
     *     <li>Description must be yellow ({@link org.bukkit.ChatColor#YELLOW}) by default.</li>
     * </ul>
     * This description doesn't have to be a static description, or just a string. I can be changed using the level
     * parameter.
     *
     * @param level Class level of the player that will see this. If player is not in the class that contains this
     *              modifier, then 0.
     * @return A description for this perk.
     * @since 1.0
     */
    String getDescription(int level);
}
