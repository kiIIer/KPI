package io.promova.tablemath.endpoints;

import io.promova.tablemath.endpoints.tools.FormulaSolver;
import io.promova.tablemath.endpoints.tools.IFormulaSolver;
import io.promova.tablemath.endpoints.tools.IMatrixFormer;
import io.promova.tablemath.endpoints.tools.MatrixFormer;
import jakarta.validation.Valid;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TableMathDIConfig
{
    @Bean
    public IFormulaSolver formulaSolver()
    {
        return new FormulaSolver();
    }

    @Bean
    public IMatrixFormer matrixFormer(@Valid IFormulaSolver formulaSolver)
    {
        return new MatrixFormer(formulaSolver);
    }
}
