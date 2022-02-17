package io.promova.killer.mathmaid.main;

import io.promova.killer.mathmaid.calculator.operations.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OperationsConfiguration
{
    @Bean
    public Abs abs()
    {
        return new Abs();
    }

    @Bean
    public Acos acos()
    {
        return new Acos();
    }

    @Bean
    public Acot acot()
    {
        return new Acot();
    }

    @Bean
    public Addition addition()
    {
        return new Addition();
    }

    @Bean
    public Asin asin()
    {
        return new Asin();
    }

    @Bean
    public Atan atan()
    {
        return new Atan();
    }

    @Bean
    public Ch ch()
    {
        return new Ch();
    }

    @Bean
    public Cos cos()
    {
        return new Cos();
    }

    @Bean
    public Cot cot()
    {
        return new Cot();
    }

    @Bean
    public Division division()
    {
        return new Division();
    }

    @Bean
    public Exp exp()
    {
        return new Exp();
    }

    @Bean
    public Exponent exponent()
    {
        return new Exponent();
    }

    @Bean
    public Ln ln()
    {
        return new Ln();
    }

    @Bean
    public Multiplication multiplication()
    {
        return new Multiplication();
    }

    @Bean
    public Sh sh()
    {
        return new Sh();
    }

    @Bean
    public Sin sin()
    {
        return new Sin();
    }

    @Bean
    public Sqrt sqrt()
    {
        return new Sqrt();
    }

    @Bean
    public Subtraction subtraction()
    {
        return new Subtraction();
    }

    @Bean
    public Tan tan()
    {
        return new Tan();
    }

    @Bean
    public Th th()
    {
        return new Th();
    }

    @Bean
    public OperationProvider operationProvider()
    {
        return new OperationProvider(
                abs(),
                acos(),
                acot(),
                addition(),
                asin(),
                atan(),
                ch(),
                cos(),
                cot(),
                division(),
                exp(),
                exponent(),
                ln(),
                multiplication(),
                sh(),
                sin(),
                sqrt(),
                subtraction(),
                tan(),
                th()
        );
    }

}
