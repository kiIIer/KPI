package io.promova.multicube.calculators;

import io.promova.multicube.calculators.operation.IOperation;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class OperationsMap implements Map<String, IOperation>
{
    private Map<String, IOperation> data;

    public OperationsMap()
    {
        this.data = new HashMap<>();
    }

    @Override
    public int size()
    {
        return data.size();
    }

    @Override
    public boolean isEmpty()
    {
        return data.isEmpty();
    }

    @Override
    public boolean containsKey(Object key)
    {
        return data.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value)
    {
        return data.containsValue(value);
    }

    @Override
    public IOperation get(Object key)
    {
        return data.get(key);
    }

    @Override
    public IOperation put(String key, IOperation value)
    {
        return data.put(key, value);
    }

    @Override
    public IOperation remove(Object key)
    {
        return remove(key);
    }

    @Override
    public void putAll(Map<? extends String, ? extends IOperation> m)
    {
        data.putAll(m);
    }

    @Override
    public void clear()
    {
        data.clear();
    }

    @Override
    public Set<String> keySet()
    {
        return data.keySet();
    }

    @Override
    public Collection<IOperation> values()
    {
        return data.values();
    }

    @Override
    public Set<Entry<String, IOperation>> entrySet()
    {
        return data.entrySet();
    }
}
