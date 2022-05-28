package io.promova.multicube.calculators;

import io.promova.multicube.calculators.operation.IOperation;
import io.promova.multicube.tools.util.Counter;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Translator implements ITranslator
{
    private final OperationsMap operations;

    public Translator(
            OperationsMap operations
    )
    {
        this.operations = operations;
    }

    @Override
    public Formula translate(String polish)

    {
        Counter counter = new Counter();
        String[] math = polish.split(" ");
        return crawler(math, counter);
    }


    private Formula crawler(String[] math, Counter counter)
    {
        Formula formula = new Formula();
        String currentElement = math[counter.getCounter()];
        counter.increment();

        IOperation operation = operations.get(currentElement);


        if (operation == null)
        {
            try
            {
                formula.setConstant(Double.parseDouble(currentElement));
            } catch (NumberFormatException e)
            {
                formula.setParamName(currentElement);
            }
            return formula;
        }

        formula.setOperation(operation);

        List<Formula> list = new LinkedList<Formula>();


        for (int i = 0; i < formula.getOperation().getNumberOfParams(); i++)
        {
            list.add(crawler(math, counter));
        }

        formula.setFormulas(list.toArray(new Formula[]{}));

        return formula;
    }

}