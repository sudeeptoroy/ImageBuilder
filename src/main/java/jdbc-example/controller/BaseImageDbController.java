package jdbcexample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/base")
public class BaseImageDbController {

    @Autowired
    private BaseImageDbRepository baseImageDbRepository;

    @GetMapping("/all")
    public List<BaseImageDb> getAllImages() {
        return baseImageDbRepository.findAll();
    }
}
