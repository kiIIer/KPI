package io.promova.multicube.tools.validators;

import io.promova.multicube.calculators.OperationsMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DIValidators
{
    @Bean
    public INullValidator nullValidator()
    {
        return new NullValidator();
    }

    @Bean
    public IMatchingOperandsValidator matchingOperandsValidator(
            OperationsMap map
    )
    {
        return new MatchingOperandsValidator(map);
    }

    @Bean
    public IPolishValidator polishValidator(
            INullValidator nullValidator,
            IMatchingOperandsValidator matchingOperandsValidator
    )
    {
        return new PolishValidator(nullValidator, matchingOperandsValidator);
    }

    @Bean
    public IBoundsValidator boundsValidator()
    {
        return new BoundsValidator();
    }

    @Bean
    public IGreaterThanZeroValidator greaterThanZeroValidator()
    {
        return new GreaterThanZeroValidator();
    }

    @Bean
    public IZeroValidator zeroValidator()
    {
        return new ZeroValidator();
    }

    @Bean
    public IStepValidator stepValidator(
            INullValidator nullValidator,
            IZeroValidator zeroValidator
    )
    {
        return new StepValidator(
                nullValidator,
                zeroValidator
        );
    }

    @Bean
    public IParameterValidator parameterValidator(
            INullValidator nullValidator,
            IBoundsValidator boundsValidator,
            INameValidator nameValidator,
            IStepValidator stepValidator
    )
    {
        return new ParameterValidator(
                nullValidator,
                boundsValidator,
                nameValidator,
                stepValidator
        );
    }

    @Bean
    public IParametersValidator parametersValidator(
            INullValidator nullValidator,
            IParameterValidator parameterValidator
    )
    {
        return new ParametersValidator(
                nullValidator,
                parameterValidator);
    }

    @Bean
    public IHypercubeRequestValidator hypercubeRequestValidator(
            INullValidator nullValidator,
            IParametersValidator parametersValidator,
            IHaveAllDataValidator haveAllDataValidator,
            IPolishValidator polishValidator
    )
    {
        return new HypercubeRequestValidator(
                nullValidator,
                parametersValidator,
                haveAllDataValidator,
                polishValidator
        );
    }

    @Bean
    public IReservedNameValidator reservedNameValidator(OperationsMap map)
    {
        return new ReservedNameValidator(map);
    }

    @Bean
    public INameValidator nameValidator(
            INullValidator nullValidator,
            IReservedNameValidator reservedNameValidator
    )
    {
        return new NameValidator(
                nullValidator,
                reservedNameValidator
        );
    }

    @Bean
    public IHaveAllDataValidator haveAllDataValidator(
            OperationsMap map
    )
    {
        return new HaveAllDataValidator(map);
    }
}
