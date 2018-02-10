package jdbcexample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ImageDBController {

    @Autowired
    private ImageDBRepository imageDBRepository;

    @GetMapping("/images")
    public List<ImageDb> getAllImages() {
        return imageDBRepository.findAll();
    }
}
