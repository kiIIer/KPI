package io.promova.forkjoincube.validators;


import io.promova.forkjoincube.porcessors.calculator.operations.IOperationsMap;
import io.promova.forkjoincube.validators.params.*;
import io.promova.forkjoincube.validators.polish.IPolishValidator;
import io.promova.forkjoincube.validators.polish.PolishValidator;
import io.promova.forkjoincube.validators.request.HypercubeRequestValidator;
import io.promova.forkjoincube.validators.request.IHypercubeRequestValidator;
import io.promova.forkjoincube.validators.util.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DIValidators
{
    @Bean
    public INotNullValidator notNullValidator()
    {
        return new NotNullValidator();
    }

    @Bean
    public IPositiveValidator positiveValidator()
    {
        return new PositiveValidator();
    }

    @Bean
    public IPolishValidator polishValidator()
    {
        return new PolishValidator(notNullValidator());
    }

    @Bean
    public IStepValidator stepValidator()
    {
        return new StepValidator(notNullValidator(), positiveValidator());
    }

    @Bean
    public ILowBoundValidator lowBoundValidator()
    {
        return new LowBoundValidator(notNullValidator());
    }

    @Bean
    public IHighBoundValidator highBoundValidator()
    {
        return new HighBoundValidator(notNullValidator());
    }

    @Bean
    public IBoundsValidator boundsValidator()
    {
        return new BoundsValidator(highBoundValidator(), lowBoundValidator());
    }

    @Bean
    public INameValidator nameValidator()
    {
        return new NameValidator(notNullValidator());
    }

    @Bean
    public IParamValidator paramValidator()
    {
        return new ParamValidator(notNullValidator(), boundsValidator(), nameValidator(), stepValidator());
    }

    @Bean
    public IParamsValidator paramsValidator()
    {
        return new ParamsValidator(notNullValidator(), paramValidator());
    }

    @Bean
    public IPolishParamsValidator polishParamsValidator(IOperationsMap operationsMap)
    {
        return new PolishParamsValidator(operationsMap);
    }

    @Bean
    public IHypercubeRequestValidator hypercubeRequestValidator(IPolishParamsValidator polishParamsValidator)
    {
        return new HypercubeRequestValidator(notNullValidator(), polishValidator(), paramsValidator(), polishParamsValidator);
    }
}
