package io.promova.forkjoincube.porcessors.polish;

import io.promova.forkjoincube.models.logic.Formula;
import io.promova.forkjoincube.porcessors.calculator.operations.IOperation;
import io.promova.forkjoincube.porcessors.calculator.operations.IOperationsMap;
import io.promova.forkjoincube.util.Counter;

import java.util.LinkedList;
import java.util.List;

public class Translator implements ITranslator
{
    private final IOperationsMap operations;

    public Translator(
            IOperationsMap operations
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
        String currentElement = math[counter.getCounter()];
        counter.increment();

        IOperation operation = operations.get(currentElement);


        if (operation == null)
        {
            String paramName = null;
            Double constant = null;
            try
            {
                constant = Double.parseDouble(currentElement);
            } catch (NumberFormatException e)
            {
                paramName = currentElement;
            }
            return new Formula(null, null, constant, paramName);
        }

        List<Formula> list = new LinkedList<>();


        for (int i = 0; i < operation.getNumberOfParams(); i++)
        {
            list.add(crawler(math, counter));
        }

        Formula[] formulas = list.toArray(new Formula[]{});

        return new Formula(operation, formulas, null, null);
    }

}