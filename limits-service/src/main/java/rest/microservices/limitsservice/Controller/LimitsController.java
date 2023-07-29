package rest.microservices.limitsservice.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import rest.microservices.limitsservice.bean.Limits;
import rest.microservices.limitsservice.configuration.Configuration;

@RestController
public class LimitsController {

    @Autowired
    private Configuration configuration;

    @GetMapping("/limits")
    public Limits getLimits(){
        return new Limits(configuration.getMin(), configuration.getMax());
    }
}
