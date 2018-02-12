package jdbcexample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/buildDb")
public class BuildDbController {

    @Autowired
    private BuildDbRepository buildDbRepository;
/*
    @Autowired
    RestTemplate restTemplate;
*/
  //  @Value("${operations.restURL}")
   // String serviceURL;

    @GetMapping("/fetch")
    public List<BuildDb> getAllBuilds() {
        return buildDbRepository.findAll();
    }
/*
    @GetMapping("/run/{buildId}")
    public String runABuild(@Pathvariable(value = "buildId") Long bId) {
        BuildDb buildDb = buildDbRepository.findOne(bId);
        if (buildDb == null) {
            return "build not found";
        }

    }

    @Bean
    public RestTemplate rest() {
        return new RestTemplate();
    }
*/
}
