package dev.efekos.classes.api.i;

import org.bukkit.entity.Player;

/**
 * Main interface for {@link dev.efekos.classes.api.registry.ModifierRegistry}.
 */
public interface IModifier {
    /**
     * Applies whatever this modifier does to the given player. Classes will call this method everytime the player
     * respawns, and when the player joins the class.
     * @param player Player that is in a class with this modifier.
     * @param level Class level of the player. Can be used to boost effects of this modifier.
     * @param value Value that was given to this modifier specifically for the class that player is in. Should be used
     *              as the main value of effects. For example: most of the modifiers added by Classes is an attribute
     *              modifier that just changes an attribute of the player. They use this value parameter instead of
     *              static values.
     */
    void apply(Player player, int level, double value);

    /**
     * Removes all the effects that this modifier has given to the player. Classes will call this method when the player
     * leaved his class.
     * @param player Player that was in a class with this modifier.
     */
    void deapply(Player player);

    /**
     * Returns a description about this modifier, that must follow the rules below.
     * <ul>
     *     <li>Description must be yellow ({@link org.bukkit.ChatColor#YELLOW}) by default.</li>
     * </ul>
     * This description doesn't have to be a static description, or just a string. I can be changed using the level and
     * value parameters.
     * @param level Class level of the player that will see this. If player is not in the class that contains this
     *              modifier, then 0.
     * @param value Value of this modifier in the class that contains this modifier.
     * @return A description for this modifier.
     */
    String getDescription(int level,double value);

    /**
     * Returns true if this modifier would be a positive thing when applied to a player with the level and value given.
     * @param level Class level of the player that will receive this information.
     * @param value Value of this modifier that was given by the class that player is in.
     * @return Whether is this modifier positive.
     */
    boolean isPositive(int level,double value);
}
