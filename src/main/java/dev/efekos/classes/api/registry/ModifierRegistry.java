package dev.efekos.classes.api.registry;

import dev.efekos.classes.api.i.IModifier;
import dev.efekos.classes.api.i.IRegistry;
import org.bukkit.NamespacedKey;

import javax.management.openmbean.KeyAlreadyExistsException;
import java.util.HashMap;
import java.util.Map;

/**
 * Main registry used for modifiers. Works as a server service. You can use
 * {@link org.bukkit.plugin.ServicesManager#getRegistration(Class)} to get the service created by Classes
 */
public final class ModifierRegistry implements IRegistry<IModifier> {
    private final Map<NamespacedKey, IModifier> modifier = new HashMap<>();

    /**
     * Returns every modifier registered.
     *
     * @return All the modifiers in a map.
     */
    public Map<NamespacedKey, IModifier> getAll() {
        return modifier;
    }

    @Override
    public NamespacedKey idOf(IModifier object) {
        for (NamespacedKey key : modifier.keySet()) {
            if (modifier.get(key).equals(object)) return key;
        }
        return null;
    }

    @Override
    public <T extends IModifier> T register(NamespacedKey key, T object) {
        if (modifier.containsKey(key))
            throw new KeyAlreadyExistsException("A modifier called " + key.toString() + " already exists.");
        modifier.put(key, object);
        return object;
    }

    @Override
    public IModifier get(NamespacedKey key) {
        return modifier.get(key);
    }
}

