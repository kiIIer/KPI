package io.promova.tablemath.endpoints;

import io.promova.tablemath.endpoints.tools.IMatrixFormer;
import io.promova.tablemath.models.SolveRequestModel;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.hateoas.EntityModel;

import java.util.Collections;
import java.util.List;


@RestController
public class TableMathController
{
    private final IMatrixFormer matrixFormer;

    public TableMathController(IMatrixFormer matrixFormer)
    {
        this.matrixFormer = matrixFormer;
    }

    @PostMapping("/table-math")
    public ResponseEntity<CollectionModel<List<List<Long>>>> solve(
            @RequestBody SolveRequestModel request
    )
    {
        CollectionModel<List<List<Long>>> collectionModel = CollectionModel.of(Collections.singleton(this.matrixFormer.form(request.getParamA(), request.getParamB())));
        return new ResponseEntity<>(collectionModel, HttpStatus.OK);
    }
}
