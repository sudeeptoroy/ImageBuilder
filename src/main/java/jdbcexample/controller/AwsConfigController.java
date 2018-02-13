package jdbcexample.controller;


import jdbcexample.repository.*;
import jdbcexample.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/aws")
public class AwsConfigController {

    @Autowired
    private AwsConfigRepository awsConfigRepository;

    @RequestMapping("/findall")
    public List<AwsConfig> getAllAwsConfig() {
        return awsConfigRepository.findAll();
    }
}