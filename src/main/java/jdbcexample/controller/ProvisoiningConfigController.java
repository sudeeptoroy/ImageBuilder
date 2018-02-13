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
@RequestMapping("/provisioning")
public class ProvisoiningConfigController {

    @Autowired
    private ProvisioningConfigRepository provisioningConfigRepository;

    @RequestMapping("/findall")
    public List<ProvisioningConfig> getAllProvosioning() {
        return provisioningConfigRepository.findAll();
    }
}