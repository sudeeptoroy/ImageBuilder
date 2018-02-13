package jdbcexample.pojo;

import jdbcexample.model.AwsConfig;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Builders {

    private String type;

    @JsonProperty("access_key")
    private String accessKey;

    @JsonProperty("secret_key")
    private String secretKey;

    private String region;

    @JsonProperty("instance_type")
    private String instanceType;

    @JsonProperty("ssh_username")
    private String sshUsername;

    @JsonProperty("ami_name")
    private String amiName;

    @JsonProperty("source_ami")
    private String sourceAmi;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAccessKey() {
        return accessKey;
    }

    public void setAccessKey(String accessKey) {
        this.accessKey = accessKey;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getInstanceType() {
        return instanceType;
    }

    public void setInstanceType(String instanceType) {
        this.instanceType = instanceType;
    }

    public String getSshUsername() {
        return sshUsername;
    }

    public void setSshUsername(String sshUsername) {
        this.sshUsername = sshUsername;
    }

    public String getAmiName() {
        return amiName;
    }

    public void setAmiName(String amiName) {
        this.amiName = amiName;
    }

    public String getSourceAmi() {
        return sourceAmi;
    }

    public void setSourceAmi(String sourceAmi) {
        this.sourceAmi = sourceAmi;
    }
}