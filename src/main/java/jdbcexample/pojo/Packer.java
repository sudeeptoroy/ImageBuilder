package jdbcexample.pojo;

import java.util.List;
import jdbcexample.pojo.Builders;
import jdbcexample.model.ProvisioningConfig;

public class Packer {

    private List<Builders> builders;

    private List<ProvisionerDTO> provisioners;

    public List<Builders> getBuilders() {
        return builders;
    }

    public void setBuilders(List<Builders> builders) {
        this.builders = builders;
    }

    public List<ProvisionerDTO> getProvisioners() {
        return provisioners;
    }

    public void setProvisioners(List<ProvisionerDTO> provisioners) {
        this.provisioners = provisioners;
    }
}