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
@RequestMapping("/rpm")
public class RpmController {

    @Autowired
    private RpmRepository rpmRepository;

    @RequestMapping("/findall")
    public List<Rpm> getAllRpms() {
        return rpmRepository.findAll();
    }

    @PostMapping("/add")
    public Rpm createRpm (@Valid @RequestBody Rpm rpm) {
        return rpmRepository.save(rpm);
    }
}