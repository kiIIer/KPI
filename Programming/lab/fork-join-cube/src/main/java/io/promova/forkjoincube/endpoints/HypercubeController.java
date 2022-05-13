package io.promova.forkjoincube.endpoints;

import io.promova.forkjoincube.models.logic.CalculateJob;
import io.promova.forkjoincube.models.logic.Dimension;
import io.promova.forkjoincube.models.logic.Formula;
import io.promova.forkjoincube.models.request.HypercubeRequest;
import io.promova.forkjoincube.porcessors.cube.IRecursiveFormerFactory;
import io.promova.forkjoincube.porcessors.cube.RecursiveFormer;
import io.promova.forkjoincube.porcessors.job.IJobCreator;
import io.promova.forkjoincube.porcessors.polish.ITranslator;
import io.promova.forkjoincube.util.APISubError;
import io.promova.forkjoincube.util.InvalidRequestException;
import io.promova.forkjoincube.validators.request.IHypercubeRequestValidator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.ForkJoinPool;

@RestController
public class HypercubeController
{
    private final ITranslator translator;
    private final IJobCreator jobCreator;
    private final IRecursiveFormerFactory recursiveFormerFactory;
    private final IHypercubeRequestValidator requestValidator;

    public HypercubeController(ITranslator translator,
                               IJobCreator jobCreator,
                               IRecursiveFormerFactory recursiveFormerFactory, IHypercubeRequestValidator requestValidator)
    {
        this.translator = translator;
        this.jobCreator = jobCreator;
        this.recursiveFormerFactory = recursiveFormerFactory;
        this.requestValidator = requestValidator;
    }

    @PostMapping("/hypercube")
    public ResponseEntity<Dimension> create(
            @RequestBody HypercubeRequest request
    )
    {
        List<APISubError> errors = requestValidator.validate(request);
        if (errors.size() != 0)
        {
            throw new InvalidRequestException(errors);
        }
        Formula formula = translator.translate(request.polish());
        Dimension dimension = new Dimension();
        List<CalculateJob> jobs = jobCreator.create(request.parameters(), formula, dimension);
        ForkJoinPool commonPool = ForkJoinPool.commonPool();
        RecursiveFormer recursiveFormer = recursiveFormerFactory.create(jobs);
        commonPool.invoke(recursiveFormer);

        return new ResponseEntity<>(dimension, HttpStatus.OK);
    }
}
