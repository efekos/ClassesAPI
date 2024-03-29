package dev.efekos.classes.api.registry;

import dev.efekos.classes.api.i.IPerk;
import dev.efekos.classes.api.i.IRegistry;
import org.bukkit.NamespacedKey;

import java.util.HashMap;
import java.util.Map;

/**
 * Main registry used for perks. Works as a server service. You can use
 * {@link org.bukkit.plugin.ServicesManager#getRegistration(Class)} to get the service created by Classes
 */
public final class PerkRegistry implements IRegistry<IPerk> {
    private final Map<NamespacedKey, IPerk> perks = new HashMap<>();

    /**
     * Returns every perk registered.
     *
     * @return All the perks in a map.
     * @since 1.0
     */
    public Map<NamespacedKey, IPerk> getAll() {
        return perks;
    }

    @Override
    public <T extends IPerk> T register(NamespacedKey key, T object) {
        perks.put(key, object);
        return object;
    }

    @Override
    public NamespacedKey idOf(IPerk object) {
        for (NamespacedKey key : perks.keySet()) {
            if (perks.get(key).equals(object)) return key;
        }
        return null;
    }

    @Override
    public IPerk get(NamespacedKey key) {
        return perks.get(key);
    }
}

