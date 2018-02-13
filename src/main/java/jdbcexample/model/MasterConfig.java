package jdbcexample.model;

import jdbcexample.model.*;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "MASTERCONFIG")
@EntityListeners(AuditingEntityListener.class)
public class MasterConfig {
    @Id
    @Column(updatable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(fetch= FetchType.EAGER)
    @JoinColumn(name="provisioning_id")
    private ProvisioningConfig provisioning;

    @OneToOne(fetch= FetchType.EAGER)
    @JoinColumn(name="awsconfig_id")
    private AwsConfig awsconfig;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ProvisioningConfig getProvisioning() {
        return provisioning;
    }

    public void setProvisioning(ProvisioningConfig provisioning) {
        this.provisioning = provisioning;
    }

    public AwsConfig getAwsconfig() {
        return awsconfig;
    }

    public void setAwsconfig(AwsConfig awsconfig) {
        this.awsconfig = awsconfig;
    }

}
