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

    @OneToOne(fetch= FetchType.EAGER, cascade= CascadeType.ALL, mappedBy = "masterconfig")
    private ProvisioningConfig provisioningRef;

    @OneToOne(fetch= FetchType.EAGER, cascade= CascadeType.ALL, mappedBy = "masterconfig")
    private AwsConfig awsRef;

    public ProvisioningConfig getProvisioningRef() {
        return provisioningRef;
    }

    public void setProvisioningRef(ProvisioningConfig provisioningRef) {
        this.provisioningRef = provisioningRef;
    }


    public AwsConfig getAwsRef() {
        return awsRef;
    }

    public void setAwsRef(AwsConfig awsRef) {
        this.awsRef = awsRef;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
