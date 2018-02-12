package jdbcexample.controller;

import jdbcexample.repository.*;
import jdbcexample.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/baseImg")
public class BaseImageController {

    @Autowired
    private BaseImageRepository baseImageRepository;

    @GetMapping("/findall")
    public List<BaseImage> getAllImages() {
        return baseImageRepository.findAll();
    }
}
