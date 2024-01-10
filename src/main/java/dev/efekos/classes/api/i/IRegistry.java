package dev.efekos.classes.api.i;

import org.bukkit.NamespacedKey;

/**
 * A simple interface for registries. Stores objects using {@link NamespacedKey}s, kinda like a mod.
 *
 * @param <T> Base type of the objects that this registry uses. Objects that extend this type can be stored as well.
 */
public interface IRegistry<T> {
    /**
     * Registers an object with a key to this
     *
     * @param key    Key of the object to register.
     * @param object Object that you want to register.
     * @param <K>    A type that extends or is {@link T}.
     * @return The registered object.
     */
    <K extends T> K register(NamespacedKey key, K object);

    /**
     * Finds an object using the key given.
     *
     * @param key Key of the object you want.
     * @return Object that was found using the key.
     */
    T get(NamespacedKey key);

    /**
     * Searches through the registered objects and finds the key of the object given.
     *
     * @param object An object to find its key.
     * @return A key if found, {@code null} otherwise.
     */
    NamespacedKey idOf(T object);
}
