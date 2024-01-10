package dev.efekos.classes.api.registry;

import dev.efekos.classes.api.i.ILevelCriteria;
import dev.efekos.classes.api.i.IRegistry;
import org.bukkit.NamespacedKey;

import java.util.HashMap;
import java.util.Map;

/**
 * Main registry used for level criterias. Works as a server service. You can use
 * {@link org.bukkit.plugin.ServicesManager#getRegistration(Class)} to get the service created by Classes
 */
public final class LevelCriteriaRegistry implements IRegistry<ILevelCriteria> {
    private final Map<NamespacedKey, ILevelCriteria> perks = new HashMap<>();

    /**
     * Returns every level criteria registered.
     *
     * @return All the level criterias in a map.
     */
    public Map<NamespacedKey, ILevelCriteria> getAll() {
        return perks;
    }

    @Override
    public <T extends ILevelCriteria> T register(NamespacedKey key, T object) {
        perks.put(key, object);
        return object;
    }

    @Override
    public NamespacedKey idOf(ILevelCriteria object) {
        for (NamespacedKey key : perks.keySet()) {
            if (perks.get(key).equals(object)) return key;
        }
        return null;
    }

    @Override
    public ILevelCriteria get(NamespacedKey key) {
        return perks.get(key);
    }
}
