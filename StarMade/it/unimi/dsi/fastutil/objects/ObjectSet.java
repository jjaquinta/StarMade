package it.unimi.dsi.fastutil.objects;

import java.util.Set;

public abstract interface ObjectSet<K> extends ObjectCollection<K>, Set<K>
{
  public abstract ObjectIterator<K> iterator();

  public abstract boolean remove(Object paramObject);
}

/* Location:           C:\Users\Raul\Desktop\StarMade\StarMade.jar
 * Qualified Name:     it.unimi.dsi.fastutil.objects.ObjectSet
 * JD-Core Version:    0.6.2
 */