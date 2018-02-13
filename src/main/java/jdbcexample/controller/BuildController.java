package jdbcexample.controller;

import jdbcexample.repository.*;
import jdbcexample.model.*;
import jdbcexample.pojo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

@RestController
@RequestMapping("/build")
public class BuildController {

    @Autowired
    AwsConfigRepository awsConfigRepository;

    @Autowired
    ProvisioningConfigRepository provisioningConfigRepository;

    @GetMapping("/run")
    public @ResponseBody Packer runBuild() {
        long id = 1;
        AwsConfig awsConfig = awsConfigRepository.findOne(id);
        System.out.println(awsConfig);

        Builders awsBuild = new Builders();
        awsBuild.setType(awsConfig.getType());
        awsBuild.setAccessKey(awsConfig.getAccessKey());
        awsBuild.setSecretKey(awsConfig.getSecretKey());
        awsBuild.setRegion(awsConfig.getRegion());
        awsBuild.setInstanceType(awsConfig.getInstanceType());
        awsBuild.setSourceAmi(awsConfig.getBaseImage().getAwsImageUrl());
        awsBuild.setSshUsername(awsConfig.getSshUsername());
        awsBuild.setAmiName(awsConfig.getAmiName());

        List<Builders> builders = new ArrayList<Builders>();
        builders.add(awsBuild);

        ProvisioningConfig provisioningConfig = provisioningConfigRepository.findOne(id);
        ProvisionerDTO provisionerDTO = new ProvisionerDTO();
        provisionerDTO.setType(provisioningConfig.getType());
        provisionerDTO.setInline(Arrays.asList(provisioningConfig.getInline().split(",")));
        List<ProvisionerDTO> provisioners = new ArrayList<ProvisionerDTO>();

        provisioners.add(provisionerDTO);

        Packer packer = new Packer();
        packer.setBuilders(builders);
        packer.setProvisioners(provisioners);

        return packer;

    }
}
