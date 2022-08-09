package edu.neu.coe.huskySort.bst;

import java.util.Set;

/**
 * Interfact to define the behavior of a Binary Search Tree.
 *
 * @param <Key> the key type.
 * @param <Value> the value type.
 */
public interface BST<Key extends Comparable<Key>, Value> {

    /**
     * Get the value corresponding to key.
     *
     * @param key the key whose value is required.
     * @return the value.
     */
    Value get(Key key);

    /**
     * Insert or update the given key-value pair.
     *
     * @param key the key to be inserted/updated.
     * @param value the value to be retrieved by future calls of get(key).
     */
    Value put(Key key, Value value);

    /**
     * @return The set of all keys.
     */
    Set<Key> keySet();

    /**
     * Delete the given key.
     * CONSIDER returning the original value.
     *
     * @param key the key to be deleted.
     */
    void delete(Key key);
}
