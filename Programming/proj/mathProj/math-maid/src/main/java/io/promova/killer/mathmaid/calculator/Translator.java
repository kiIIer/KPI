package io.promova.killer.mathmaid.calculator;

import io.promova.killer.mathmaid.calculator.operations.IOperation;
import io.promova.killer.mathmaid.calculator.operations.IOperationProvider;
import io.promova.killer.mathmaid.util.Counter;
import io.promova.killer.mathmaid.util.ICounter;

import java.util.LinkedList;
import java.util.List;

public class Translator implements ITranslator
{
    private final IOperationProvider provider;

    public Translator(
            IOperationProvider provider
    )
    {
        this.provider = provider;
    }

    @Override
    public IFormula translate(String polish)
    {
        ICounter counter = new Counter();
        String[] math = polish.split(" ");
        return crawler(math, counter);
    }

    private IFormula crawler(String[] math, ICounter counter)
    {
        IFormula formula = new Formula();
        String currentElement = math[counter.getCounter()];
        counter.increment();

        IOperation operation = provider.getOperation(currentElement);

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
        List<IFormula> list = new LinkedList<IFormula>();

        for (int i = 0; i < formula.getOperation().getNumberOfParams(); i++)
        {
            list.add(crawler(math, counter));
        }
        formula.setFormulas(list.toArray(new IFormula[]{}));
        return formula;
    }

}
