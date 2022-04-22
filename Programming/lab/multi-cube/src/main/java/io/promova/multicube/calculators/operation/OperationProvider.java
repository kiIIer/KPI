package io.promova.multicube.calculators.operation;

import java.util.HashMap;
import java.util.Map;

public class OperationProvider implements IOperationProvider
{
    private final Map<String, IOperation> operations;

    public OperationProvider(
            IAdd add
    )
    {
        operations = new HashMap<>();
        operations.put(add.getSymbol(), add);
    }

    @Override
    public IOperation getOperation(String key)
    {
        return operations.get(key);
    }
}
