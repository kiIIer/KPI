package io.promova.forkjoincube.endpoints;

import io.promova.forkjoincube.models.request.HypercubeRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HypercubeController
{
    @PostMapping("/hypercube")
    public void create(
            @RequestBody HypercubeRequest request
    )
    {
        System.out.println(request);
    }
}
