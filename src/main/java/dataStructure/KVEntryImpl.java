package dataStructure;

import java.util.Map;

public class KVEntryImpl<K,V> implements Map.Entry<K,V> {
    private K key;
    private V value;
    public KVEntryImpl(K key, V value)
    {
        this.key =key;
        this.value =value;
    }

    public void setKey(K key)
    {
        this.key =key;
    }

    @Override
    public K getKey() {
        return key;
    }

    @Override
    public V getValue() {
        return value;
    }

    @Override
    public V setValue(V value) {
        this.value =value;
        return null;
    }
}
