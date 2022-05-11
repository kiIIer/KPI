package io.promova.forkjoincube.endpoints;

import io.promova.forkjoincube.models.logic.Formula;
import io.promova.forkjoincube.models.request.HypercubeRequest;
import io.promova.forkjoincube.porcessors.polish.ITranslator;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HypercubeController
{
    private final ITranslator translator;

    public HypercubeController(ITranslator translator)
    {
        this.translator = translator;
    }

    @PostMapping("/hypercube")
    public void create(
            @RequestBody HypercubeRequest request
    )
    {
    }
}
