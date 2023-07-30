package rest.mircroservices.currencyexchangeservice;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CircuitBreakerController {

    private Logger logger = LoggerFactory.getLogger(CircuitBreakerController.class);

    @GetMapping("/sample-api")
   // @Retry(name = "sample-api", fallbackMethod = "defaultResponse")
    //@CircuitBreaker(name = "default", fallbackMethod = "defaultResponse")
    //@RateLimiter(name="default")
    //10s -> 1000 calls to sample api
    @Bulkhead(name ="sample-api")
    public String sampleApi(){

        logger.info("Sample Api call received");
//        ResponseEntity<String> forEntity = new RestTemplate().getForEntity("http://localhost:8080/some-dummy-url", String.class);
//        return forEntity.getBody();

        return "sample-api";
    }

    // Since it should be throwable so we use Exception
    public String defaultResponse(Exception ex){
        return "fallback-response";
    }

}
