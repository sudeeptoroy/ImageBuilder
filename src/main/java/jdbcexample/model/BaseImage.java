package jdbcexample.model;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "BASEIMAGE")
@EntityListeners(AuditingEntityListener.class)
public class BaseImage {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank
    @Column(unique = true)
    private String name;

    @NotBlank
    private String awsImageUrl;

    @NotBlank
    private String googleImageUrl;

    @NotBlank
    private String digitalImageUrl;

    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdAt;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date updatedAt;

    @OneToOne(fetch= FetchType.EAGER, cascade= CascadeType.ALL, mappedBy = "baseimage")
    private AwsConfig awsconfig;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAwsImageUrl() {
        return awsImageUrl;
    }

    public void setAwsImageUrl(String awsImageUrl) {
        this.awsImageUrl = awsImageUrl;
    }

    public String getGoogleImageUrl() {
        return googleImageUrl;
    }

    public void setGoogleImageUrl(String googleImageUrl) {
        this.googleImageUrl = googleImageUrl;
    }

    public String getDigitalImageUrl() {
        return digitalImageUrl;
    }

    public void setDigitalImageUrl(String digitalImageUrl) {
        this.digitalImageUrl = digitalImageUrl;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public AwsConfig getAwsconfig() {
        return awsconfig;
    }

    public void setAwsconfig(AwsConfig awsconfig) {
        this.awsconfig = awsconfig;
    }

}