package it.unimi.dsi.fastutil.objects;

import java.util.Map;
import java.util.Map.Entry;

public abstract interface Object2ObjectMap<K, V> extends Object2ObjectFunction<K, V>, Map<K, V>
{
  public abstract ObjectSet<Map.Entry<K, V>> entrySet();

  public abstract ObjectSet<Entry<K, V>> object2ObjectEntrySet();

  public abstract ObjectSet<K> keySet();

  public abstract ObjectCollection<V> values();

  public static abstract interface Entry<K, V> extends Map.Entry<K, V>
  {
  }

  public static abstract interface FastEntrySet<K, V> extends ObjectSet<Object2ObjectMap.Entry<K, V>>
  {
    public abstract ObjectIterator<Object2ObjectMap.Entry<K, V>> fastIterator();
  }
}

/* Location:           C:\Users\Raul\Desktop\StarMade\StarMade.jar
 * Qualified Name:     it.unimi.dsi.fastutil.objects.Object2ObjectMap
 * JD-Core Version:    0.6.2
 */