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

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;

@RestController
@RequestMapping("/build")
public class BuildController {

    @Autowired
    AwsConfigRepository awsConfigRepository;

    @Autowired
    ProvisioningConfigRepository provisioningConfigRepository;

    @Autowired
    MasterConfigRepository masterConfigRepository;

    @Autowired
    BaseImageRepository baseImageRepository;

    @GetMapping("/run")
    public @ResponseBody Packer runBuild(@RequestParam("id") long id ) throws Exception {
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

        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File("/tmp/packer_1234.json"), packer);

        return packer;

    }

    @GetMapping("/getAll")
    public @ResponseBody List<OldBuild> getAllBuild() {
        List<MasterConfig> masterConfig = masterConfigRepository.findAll();

        List<OldBuild> oldBuildList = new ArrayList<OldBuild>();



        for(MasterConfig master : masterConfig){

            OldBuild oldBuild = new OldBuild();
            oldBuild.setId(master.getId());
            oldBuild.setName(master.getAwsconfig().getAmiName());

            oldBuildList.add(oldBuild);
        }

        return oldBuildList;

    }

    @GetMapping("/getImageName")
    public @ResponseBody List<BaseImageName> getImageName() {
        List<BaseImage> baseImageList = baseImageRepository.findAll();

        List<BaseImageName> baseImageNameList = new ArrayList<BaseImageName>();



        for(BaseImage baseImage : baseImageList){

            BaseImageName baseImageName = new BaseImageName();
            baseImageName.setName(baseImage.getName());
            baseImageNameList.add(baseImageName);
        }

        return baseImageNameList;
    }

    @PostMapping("/saveBuildCfg")
    public String saveBuildConfig(@RequestBody List<ConfigSaveData> saveConfig) {

        ProvisioningConfig provisioningConfig = new ProvisioningConfig();
        provisioningConfig.setType("shell");
        provisioningConfig.setInline(saveConfig.get(1).getValue());

        provisioningConfig = provisioningConfigRepository.save(provisioningConfig);

        System.out.println(saveConfig.get(0).getValue());
        BaseImage baseImage = baseImageRepository.findByName(saveConfig.get(0).getValue());

        System.out.println(baseImage);
        AwsConfig awsConfig = new AwsConfig();
        awsConfig.setType("amazon-ebs");
        awsConfig.setAccessKey("aws_access_key");
        awsConfig.setSecretKey("aws_secret_key");
        awsConfig.setRegion("us-west-1");
        awsConfig.setInstanceType("t2.micro");
        awsConfig.setSshUsername("ubuntu");
        awsConfig.setAmiName("TODO");
        awsConfig.setBaseImage(baseImage);

        awsConfig = awsConfigRepository.save(awsConfig);

        MasterConfig masterConfig = new MasterConfig();
        masterConfig.setAwsconfig(awsConfig);
        masterConfig.setProvisioning(provisioningConfig);

        masterConfigRepository.save(masterConfig);

        return "index";
    }
}
