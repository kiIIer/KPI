package io.promova.killer.mathmaid.result;

import com.sun.net.httpserver.Headers;
import io.promova.killer.mathmaid.calculator.IFormula;
import io.promova.killer.mathmaid.calculator.ITranslator;
import io.promova.killer.mathmaid.result.exceptions.FormulaNotFoundException;
import io.promova.killer.mathmaid.rep.IResultRepository;
import io.promova.killer.mathmaid.rep.FormulaEntity;
import io.promova.killer.mathmaid.result.request.ResultRequestParams;
import io.promova.killer.mathmaid.result.responce.FormulaDTO;
import io.promova.killer.mathmaid.util.IFormulaConverter;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@RestController
public class ResultController
{
    private final ITranslator translator;
    private final IResultRepository repositorydb;
    private final IFormulaConverter converter;

    public ResultController(
            ITranslator translator,
            IResultRepository repositorydb,
            IFormulaConverter converter
    )
    {
        this.translator = translator;
        this.repositorydb = repositorydb;
        this.converter = converter;
    }

    @PostMapping(value = "/formulas/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Result calculateResult(@RequestBody @Valid ResultRequestParams params, @PathVariable long id)
    {
        Optional<FormulaEntity> fromDb = repositorydb.findById(id);

        if (fromDb.isEmpty())
        {
            throw new FormulaNotFoundException(id);
        }

        String polish = fromDb.get().getPolish();

        IFormula formula = translator.translate(polish);

        return new Result(formula.compute(params.getMap()));
    }


    @GetMapping(value = "/formulas/{id}")
    public FormulaDTO one(@PathVariable long id)
    {
        Optional<FormulaEntity> fromDb = repositorydb.findById(id);

        if (fromDb.isEmpty())
        {
            throw new FormulaNotFoundException(id);
        }
        FormulaEntity entity = fromDb.get();

        return this.converter.convert(entity);
    }

    @GetMapping(value = "/formulas")
    public List<FormulaDTO> all()
    {
        List<FormulaEntity> entities = repositorydb.findAll();
        List<FormulaDTO> dtos = new ArrayList<>();
        entities.forEach(entity -> dtos.add(converter.convert(entity)));
        return dtos;
    }
}
