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
@RequestMapping("/cveDb")
public class CveDbController {

    @Autowired
    private CveDbRepository cveDbRepository;

    @RequestMapping("/all")
    public List<CveDb> getAllCves() {
        return cveDbRepository.findAll();
    }

    @PostMapping("/create")
    public CveDb createCve (@Valid @RequestBody CveDb cve) {
        return cveDbRepository.save(cve);
    }
}