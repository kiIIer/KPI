package io.promova.tablemath.endpoints;

import io.promova.tablemath.endpoints.tools.IMatrixFormer;
import io.promova.tablemath.models.Matrix;
import io.promova.tablemath.models.SolveRequestModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.hateoas.EntityModel;


@RestController
public class TableMathController
{
    private final IMatrixFormer matrixFormer;

    public TableMathController(IMatrixFormer matrixFormer)
    {
        this.matrixFormer = matrixFormer;
    }

    @PostMapping
    public ResponseEntity<EntityModel<Matrix>> solve(
            @RequestBody SolveRequestModel request
    )
    {
        Matrix matrix = new Matrix();
        matrixFormer.form(matrix, request.getParamA(), request.getParamB());
        EntityModel<Matrix> entityModel = EntityModel.of(matrix);
        return new ResponseEntity<EntityModel<Matrix>>(HttpStatus.OK, entityModel);
    }
}
