package jdbcexample.model;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Table(name = "AWSCONFIG")
@EntityListeners(AuditingEntityListener.class)
public class AwsConfig {
    @Id
    @Column(updatable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank
    private String type;

    @NotBlank
    @JsonProperty("access_key")
    private String accessKey;

    @NotBlank
    @JsonProperty("secret_key")
    private String secretKey;

    @NotBlank
    private String region;

    @NotBlank
    @JsonProperty("instance_type")
    private String instanceType;

    @NotBlank
    @JsonProperty("ssh_username")
    private String sshUsername;

    @NotBlank
    @JsonProperty("ami_name")
    private String amiName;

    //@OneToOne(fetch= FetchType.LAZY)
    //@JoinColumn(name="baseimage_id")
    @OneToOne
    //@PrimaryKeyJoinColumn(name="baseimage_id")
    @JoinColumn(name="baseimage_id")
    private BaseImage baseImage;

    @OneToOne(fetch= FetchType.EAGER, cascade= CascadeType.ALL, mappedBy = "awsconfig")
    private MasterConfig masterConfig;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public BaseImage getBaseImage() {
        return baseImage;
    }

    public void setBaseImage(BaseImage baseimage) {
        this.baseImage = baseimage;
    }

    @JsonIgnore
    public MasterConfig getMasterConfig() {
        return masterConfig;
    }

    public void setMasterConfig(MasterConfig masterconfig) {
        this.masterConfig = masterconfig;
    }

}
