package jdbcexample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/build")
public class BuildDbController {

    @Autowired
    private BuildDbRepository buildDbRepository;

    @GetMapping("/all")
    public List<BuildDb> getAllBuilds() {
        return buildDbRepository.findAll();
    }
}
